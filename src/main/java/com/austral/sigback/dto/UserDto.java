package com.austral.sigback.dto;

import javax.validation.constraints.Email;

public class UserDto {

    @Email
    private String email;
}
