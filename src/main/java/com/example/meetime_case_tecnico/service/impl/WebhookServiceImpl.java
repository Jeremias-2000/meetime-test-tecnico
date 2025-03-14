package com.example.meetime_case_tecnico.service.impl;

import com.example.meetime_case_tecnico.integration.dto.webhook.ListSignatureEventDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.SignatureEventResponseDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.WebhookSignatureDto;
import com.example.meetime_case_tecnico.service.WebhookService;
import org.springframework.stereotype.Service;

@Service
public class WebhookServiceImpl implements WebhookService {

    // pegar chave apikey do env

    @Override
    public SignatureEventResponseDto registerEventSignature(String appId, WebhookSignatureDto dto, String apikey) {
        return null;
    }

    @Override
    public ListSignatureEventDto listenSubscriptionEvents(String appId) {
        return null;
    }

    @Override
    public SignatureEventResponseDto listenSubscriptionEvent(String appId, String subscriptionId) {
        return null;
    }
}
