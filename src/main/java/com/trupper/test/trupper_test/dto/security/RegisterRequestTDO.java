package com.trupper.test.trupper_test.dto.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestTDO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
