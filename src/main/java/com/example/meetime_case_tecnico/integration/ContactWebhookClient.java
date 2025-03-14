package com.example.meetime_case_tecnico.integration;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "contact-webhook",url = "${auth.contact.url}",configuration = IntegrationConfig.class)
public interface ContactWebhookClient {

}
