package com.example.meetime_case_tecnico.controller;

import com.example.meetime_case_tecnico.exception.IntegrationErrorDto;
import com.example.meetime_case_tecnico.integration.dto.contact.CreateContactWrapperDto;
import com.example.meetime_case_tecnico.service.ContactService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
@Tag(name = "Contato",description = "Gerenciamento dos contatos crm")
public class ContatoController {

    @Autowired
    private ContactService contactService;

    @SecurityRequirement(name = "bearerAuth")
    @PostMapping("/create")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "sucesso"),
            @ApiResponse(responseCode = "400",description = "erro de negocio",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "401",description = "erro de permissao",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "403",description = "erro de permissao",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "404",description = "rota não encontrada",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "500",description = "erro de sistema",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
    })
    public ResponseEntity<Void> createContact(@RequestBody CreateContactWrapperDto dto, @RequestHeader("Authorization") String authorization){
        contactService.createContactCrm(dto,authorization);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
