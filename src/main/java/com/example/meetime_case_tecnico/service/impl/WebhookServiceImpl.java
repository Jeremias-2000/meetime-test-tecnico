package com.example.meetime_case_tecnico.service.impl;

import com.example.meetime_case_tecnico.integration.WebhookClient;
import com.example.meetime_case_tecnico.integration.dto.webhook.ListSignatureEventDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.SignatureEventResponseDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.WebhookSignatureDto;
import com.example.meetime_case_tecnico.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WebhookServiceImpl implements WebhookService {

    @Value("${auth.hubspot.api-key}")
    private String apiKey;

    @Autowired
    private WebhookClient webhookClient;

    @Override
    public SignatureEventResponseDto registerEventSignature(String appId, WebhookSignatureDto dto) {
        return webhookClient.registerEventSignature(appId,dto,apiKey);
    }

    @Override
    public ListSignatureEventDto listenSubscriptionEvents(String appId) {
        return webhookClient.listenSubscriptionEvents(appId,apiKey);
    }

    @Override
    public SignatureEventResponseDto listenSubscriptionEvent(String appId, String subscriptionId) {
        return webhookClient.listenSignatureEvent(appId,subscriptionId,apiKey);
    }
}
