package com.example.meetime_case_tecnico.integration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthTokenRequest(
        @JsonProperty("grant_type")
        String grantType,
        String code,
        @JsonProperty("client_id")
        String clientId,
        @JsonProperty("client_secret")
        String clientSecret
) {
}
