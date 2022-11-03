package com.austral.sigback.controller;

import com.austral.sigback.dto.UserDto;
import com.austral.sigback.model.User;
import com.austral.sigback.service.UserService;
import com.austral.sigback.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User saved = this.userService.saveUser(user);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Role> login(@RequestBody UserDto userDto) {
        User loggedIn = this.userService.login(userDto);
        return new ResponseEntity<>(loggedIn.getRole(), HttpStatus.OK);
    }

}
