package com.example.meetime_case_tecnico.integration.dto.webhook;

public record WebhookSignatureDto(
        String objectTypeId,
        String propertyName,
        Boolean active,
        String eventType
) {
}
