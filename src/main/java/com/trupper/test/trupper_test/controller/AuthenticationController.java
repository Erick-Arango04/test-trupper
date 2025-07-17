package com.trupper.test.trupper_test.controller;


import com.trupper.test.trupper_test.dto.RespuestaGeneralTDO;
import com.trupper.test.trupper_test.dto.security.AuthenticateRequestTDO;
import com.trupper.test.trupper_test.dto.security.RegisterRequestTDO;
import com.trupper.test.trupper_test.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth/v1/trupper/")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("register")
    public ResponseEntity<RespuestaGeneralTDO> register(@RequestBody RegisterRequestTDO registerRequestTDO){
        return this.authenticationService.register(registerRequestTDO);
    }

    @PostMapping("authenticate")
    public ResponseEntity<RespuestaGeneralTDO> register(@RequestBody AuthenticateRequestTDO registerRequest){
        return this.authenticationService.authenticate(registerRequest);
    }


}
