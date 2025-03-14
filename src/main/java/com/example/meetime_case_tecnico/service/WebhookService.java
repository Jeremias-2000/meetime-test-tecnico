package com.example.meetime_case_tecnico.service;

import com.example.meetime_case_tecnico.integration.dto.webhook.ListSignatureEventDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.SignatureEventResponseDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.WebhookSignatureDto;

public interface WebhookService {
    SignatureEventResponseDto registerEventSignature (String appId, WebhookSignatureDto dto,
                                 String apikey);

    ListSignatureEventDto listenSubscriptionEvents(String appId, String apikey);

    SignatureEventResponseDto listenSignatureEvent(String appId,
                                                   String subscriptionId,
                                                   String apikey);
}
