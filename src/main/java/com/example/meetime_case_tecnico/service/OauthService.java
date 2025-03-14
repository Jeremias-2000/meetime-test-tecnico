package com.example.meetime_case_tecnico.service;

import com.example.meetime_case_tecnico.integration.dto.auth.AuthRefreshTokenRequest;
import com.example.meetime_case_tecnico.integration.dto.auth.AuthTokenResponse;
import com.example.meetime_case_tecnico.integration.dto.auth.OauthCallbackResponse;

public interface OauthService {

    AuthTokenResponse getAuth(String clientId, String scope,
                              String redirectUri, String state);

    AuthTokenResponse getAuthRefreshToken(AuthRefreshTokenRequest request);

    OauthCallbackResponse getAuthCallback(String code,String state);
}
