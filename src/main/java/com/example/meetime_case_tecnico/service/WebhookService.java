package com.example.meetime_case_tecnico.service;

import com.example.meetime_case_tecnico.integration.dto.webhook.ListSignatureEventDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.SignatureEventResponseDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.WebhookSignatureDto;

public interface WebhookService {
    SignatureEventResponseDto registerEventSignature (String appId, WebhookSignatureDto dto);

    //api key nao ficar passando de uma lado para outro e sim guardado em um env
    ListSignatureEventDto listenSubscriptionEvents(String appId);

    SignatureEventResponseDto listenSubscriptionEvent(String appId,
                                                   String subscriptionId);
}
