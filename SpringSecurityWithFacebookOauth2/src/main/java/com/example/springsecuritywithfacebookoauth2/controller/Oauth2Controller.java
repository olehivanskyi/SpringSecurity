package com.example.springsecuritywithfacebookoauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/oauth2")
public class Oauth2Controller {
    private static final String YOUR_FACEBOOK_USER_NUMBER = "Your facebook user number: ";

    @GetMapping("/info")
    private String getUserIdentificationNumber(Principal principal) {
        return YOUR_FACEBOOK_USER_NUMBER + principal.getName();
    }
}
