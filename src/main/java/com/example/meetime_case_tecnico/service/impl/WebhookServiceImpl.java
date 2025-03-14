package com.example.meetime_case_tecnico.service.impl;

import com.example.meetime_case_tecnico.config.FallbackMethodConfig;
import com.example.meetime_case_tecnico.exception.MeetimeException;
import com.example.meetime_case_tecnico.exception.MensagemErro;
import com.example.meetime_case_tecnico.integration.WebhookClient;
import com.example.meetime_case_tecnico.integration.dto.webhook.ListSignatureEventDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.SignatureEventResponseDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.WebhookSignatureDto;
import com.example.meetime_case_tecnico.service.WebhookService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WebhookServiceImpl implements WebhookService {

    @Value("${auth.hubspot.api-key}")
    private String apiKey;

    @Autowired
    private WebhookClient webhookClient;

    @Autowired
    private FallbackMethodConfig fallbackMethodConfig;

    @Override
    @CircuitBreaker(name = "registerEventSignature",fallbackMethod = "fallbackWebhookActivity")
    public SignatureEventResponseDto registerEventSignature(String appId, WebhookSignatureDto dto) {
        return webhookClient.registerEventSignature(appId,dto,apiKey);
    }

    @Override
    @CircuitBreaker(name = "listenSubscriptionEvents",fallbackMethod = "fallbackWebhookActivity")
    public ListSignatureEventDto listenSubscriptionEvents(String appId) {
        return webhookClient.listenSubscriptionEvents(appId,apiKey);
    }

    @Override
    @CircuitBreaker(name = "listenSubscriptionEvents",fallbackMethod = "fallbackWebhookActivity")
    public SignatureEventResponseDto listenSubscriptionEvent(String appId, String subscriptionId) {
        return webhookClient.listenSignatureEvent(appId,subscriptionId,apiKey);
    }

}
