package com.example.meetime_case_tecnico.service.impl;

import com.example.meetime_case_tecnico.config.FallbackMethodConfig;
import com.example.meetime_case_tecnico.integration.ContactCrmClient;
import com.example.meetime_case_tecnico.integration.dto.contact.CreateContactWrapperDto;
import com.example.meetime_case_tecnico.service.ContactService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Value("${auth.hubspot.api-key}")
    private String apiKey;

    @Autowired
    private ContactCrmClient contactCrmClient;

    @Autowired
    private FallbackMethodConfig fallbackMethodConfig;

    @Override
    @CircuitBreaker(name = "createContactCrm",fallbackMethod = "fallbackWebhookActivity")
    public void createContactCrm(CreateContactWrapperDto dto, String authorization) {
        contactCrmClient.createContactCrm(dto,apiKey,authorization);
    }
}
