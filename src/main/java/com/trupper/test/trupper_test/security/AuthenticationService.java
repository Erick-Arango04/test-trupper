package com.trupper.test.trupper_test.security;


import com.trupper.test.trupper_test.dto.RespuestaGeneralTDO;
import com.trupper.test.trupper_test.dto.security.AuthenticateRequestTDO;
import com.trupper.test.trupper_test.dto.security.RegisterRequestTDO;
import com.trupper.test.trupper_test.entity.security.Role;
import com.trupper.test.trupper_test.entity.security.User;
import com.trupper.test.trupper_test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public ResponseEntity<RespuestaGeneralTDO> register(RegisterRequestTDO registerRequestTDO) {

        var user = User.builder()
                .lastName(registerRequestTDO.getLastName())
                .email(registerRequestTDO.getEmail())
                .password(passwordEncoder.encode(registerRequestTDO.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        var response = new RespuestaGeneralTDO(
                HttpStatus.OK.value(), "Operación Exitosa", "El usuario ha sido creado");


        return ResponseEntity.ok(response);
    }

    public ResponseEntity<RespuestaGeneralTDO> authenticate(AuthenticateRequestTDO request) {

        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken
                        (request.getEmail(), request.getPassword()));

        var user = this.userRepository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken = jwtService.generatedToken(user);

        var response = new RespuestaGeneralTDO(
                HttpStatus.OK.value(), "Operación Exitosa", jwtToken);

        return ResponseEntity.ok(response);

    }
}
