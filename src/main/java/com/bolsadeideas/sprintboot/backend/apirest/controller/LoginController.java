package com.bolsadeideas.sprintboot.backend.apirest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.sprintboot.backend.apirest.models.ApplicationUser;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
public class LoginController {
    
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public String Create(@RequestBody ApplicationUser ApplicationUser) {
      return ApplicationUser.toString();
    }
}
