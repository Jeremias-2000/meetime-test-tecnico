package com.example.meetime_case_tecnico.integration.dto.webhook;

import java.time.Instant;

public record SignatureEventResponseDto(
        Instant createdAt,
        String propertyName,
        Boolean active,
        String eventType,
        String id,
        Instant updatedAt
) {


}
