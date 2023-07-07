package com.insta.instagram.controller;

import com.insta.instagram.exceptions.UserException;
import com.insta.instagram.model.User;
import com.insta.instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping("signup")
    public ResponseEntity<User> registerUserHandler(@RequestBody User user) throws UserException {

        User createduser = userService.registerUser(user);

        return new ResponseEntity<User>(createduser, HttpStatus.OK);
    }

}
