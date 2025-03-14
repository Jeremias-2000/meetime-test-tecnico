package com.example.meetime_case_tecnico.controller;

import com.example.meetime_case_tecnico.exception.IntegrationErrorDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.ListSignatureEventDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.SignatureEventResponseDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.WebhookSignatureDto;
import com.example.meetime_case_tecnico.service.WebhookService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
@Tag(name = "Webhook",description = "Gerencia ações dentro do webhook")
public class WebhookController {

    @Autowired
    private WebhookService webhookService;


    @PostMapping("/event/subscription/{appId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "sucesso"),
            @ApiResponse(responseCode = "400",description = "erro de negocio",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "401",description = "erro de permissao",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "403",description = "erro de permissao",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "404",description = "rota não encontrada",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "429",description = "rate limite excedido",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "500",description = "erro de sistema",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
    })
    public ResponseEntity<SignatureEventResponseDto> registerEventSignature (String appId, WebhookSignatureDto dto){
        return new ResponseEntity<>(webhookService.registerEventSignature(appId, dto),HttpStatus.CREATED);
    }

    @GetMapping("/event/list/subscription/{appId}")
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
            @ApiResponse(responseCode = "429",description = "rate limite excedido",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "500",description = "erro de sistema",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
    })
    public ResponseEntity<ListSignatureEventDto> listenSubscriptionEvents(@PathVariable("appId") String appId){

        return ResponseEntity.ok(webhookService.listenSubscriptionEvents(appId));
    }

    @GetMapping("/event/subscription/{appId}/{subscriptionId}")
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
            @ApiResponse(responseCode = "429",description = "rate limite excedido",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "500",description = "erro de sistema",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
    })
    public ResponseEntity<SignatureEventResponseDto> listenSignatureEvent(@PathVariable("appId") String appId,
                                                   @PathVariable("subscriptionId") String subscriptionId){
        return ResponseEntity.ok(webhookService.listenSubscriptionEvent(appId,subscriptionId));
    }

}
