package com.example.meetime_case_tecnico.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @SecurityRequirement(name = "bearerAuth")
    public String createContact(){
        return "";
    }
}
