package com.example.meetime_case_tecnico.integration;

import com.example.meetime_case_tecnico.config.FeignConfig;
import com.example.meetime_case_tecnico.integration.dto.contact.CreateContactWrapperDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "contact",url = "${auth.contact.url}/crm",configuration = FeignConfig.class)
public interface ContactWebhookClient {

    @PostMapping("/v3/objects/contacts")
    void createContactCrm(@RequestBody CreateContactWrapperDto dto,@RequestHeader("api-key") String apikey
            ,@RequestHeader("Authorization") String authorization);
}
