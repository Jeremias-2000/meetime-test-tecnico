package com.example.meetime_case_tecnico.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
@Tag(name = "Contato",description = "Gerenciamento dos contatos crm")
public class ContatoController {

    @SecurityRequirement(name = "bearerAuth")
    public String criarContato(){
        return "";
    }
}
