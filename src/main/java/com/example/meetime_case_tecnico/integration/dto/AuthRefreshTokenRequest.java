package com.example.meetime_case_tecnico.integration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthRefreshTokenRequest(
        @JsonProperty("grant_type")
        String grantType,
        @JsonProperty("refresh_token")
        String refreshToken,
        @JsonProperty("client_id")
        String clientId,
        @JsonProperty("client_secret")
        String clientSecret
) {
}
