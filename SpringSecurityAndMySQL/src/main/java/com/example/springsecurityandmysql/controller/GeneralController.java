package com.example.springsecurityandmysql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {
    private static final String APPLICATION_VERSION = "Application v1.0";

    @GetMapping
    private String getInformationAboutService() {
        return APPLICATION_VERSION;
    }
}
