package com.example.meetime_case_tecnico.integration;

import com.example.meetime_case_tecnico.config.FeignConfig;
import com.example.meetime_case_tecnico.integration.dto.webhook.ListSignatureEventDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.SignatureEventResponseDto;
import com.example.meetime_case_tecnico.integration.dto.webhook.WebhookSignatureDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "webhook",url = "${auth.hubspot.url}/webhooks",configuration = FeignConfig.class)
public interface WebhookClient {

    @PostMapping("/v3/{appId}/subscriptions")
    SignatureEventResponseDto registerEventSignature (@PathVariable("appId") String appId, @RequestBody WebhookSignatureDto dto,
                                                      @RequestHeader("api-key") String apikey);

    @GetMapping("/v3/{appId}/subscriptions")
    ListSignatureEventDto listenSubscriptionEvents(@PathVariable("appId") String appId
                                , @RequestHeader("api-key") String apikey);

    @GetMapping("/v3/{appId}/subscriptions/{subscriptionId}")
    SignatureEventResponseDto listenSignatureEvent(@PathVariable("appId") String appId,
                                @PathVariable("subscriptionId") String subscriptionId,
                                @RequestHeader("api-key") String apikey);

}
