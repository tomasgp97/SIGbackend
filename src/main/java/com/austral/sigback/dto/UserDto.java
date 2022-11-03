package com.austral.sigback.dto;

public class UserDto {
    private final String email;
    private final String password;

    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return password;
    }
}
