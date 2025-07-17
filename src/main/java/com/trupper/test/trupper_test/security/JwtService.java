package com.trupper.test.trupper_test.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private final String SECRET_KEY = "S2PXf/ddabZDUhCyV9D5xtyjxL1uFOdNt9m0t431ez4sBJCjZrOM7XXXIoHZTobVBMTEUyi13dMGdJ08FmdjU891kSgqwFplkEzJHyZpatiYtM+keuVrq/bbqlfx/+Baq5oQ+1tVVHN8U5dIF+q0M3z8fIoZ9z357hCzp15b5DFoggv0sfDmc1ax+J2GyH1kXKcPWfdzlzIq4X8O+pay5uNpff5zsVSVWHhCrwAuGzgPajnfcupn7d6of7MwemLfuEI2Jzs2hBNOCCRLo33eWWETIlTFJ4Ent75NNofbg728Wa5S4aZRIjXewwhCWYc3mQRegxKphPgnvYl5J//Q+rT62Dh9nd7ITAAXcsHHq+8=\n";

    public String extractUserEmail(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }

    private <T> T extractClaim(String jwt, Function<Claims, T> claimsTFunction) {
        final Claims claims = extractAllClaims(jwt);
        return claimsTFunction.apply(claims);
    }

    public String generatedToken(Map<String, Object> claims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInkey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generatedToken(UserDetails userDetails) {
        return generatedToken(new HashMap<>(), userDetails);
    }

    private Claims extractAllClaims(String jwt) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInkey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();

    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String useremail = extractUserEmail(token);
        return useremail.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extraExpiration(token).before(new Date());
    }

    private Date extraExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Key getSignInkey() {
        var keybytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keybytes);
    }
}
