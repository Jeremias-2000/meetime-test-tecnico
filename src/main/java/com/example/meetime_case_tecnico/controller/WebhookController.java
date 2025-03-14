package com.example.meetime_case_tecnico.controller;

import com.example.meetime_case_tecnico.integration.dto.webhook.ListSignatureEventDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.SignatureEventResponseDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.WebhookSignatureDto;
import com.example.meetime_case_tecnico.service.WebhookService;
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
    public ResponseEntity<SignatureEventResponseDto> registerEventSignature (String appId, WebhookSignatureDto dto,
                                                                            String apikey){
        return new ResponseEntity<>(webhookService.registerEventSignature(appId, dto, apikey),HttpStatus.CREATED);
    }

    @GetMapping("/event/list/subscription/{appId}")
    public ResponseEntity<ListSignatureEventDto> listenSubscriptionEvents(@PathVariable("appId") String appId){

        return ResponseEntity.ok(webhookService.listenSubscriptionEvents(appId));
    }

    @GetMapping("/event/subscription/{appId}/{subscriptionId}")
    public ResponseEntity<SignatureEventResponseDto> listenSignatureEvent(@PathVariable("appId") String appId,
                                                   @PathVariable("subscriptionId") String subscriptionId){
        return ResponseEntity.ok(webhookService.listenSubscriptionEvent(appId,subscriptionId));
    }

}
