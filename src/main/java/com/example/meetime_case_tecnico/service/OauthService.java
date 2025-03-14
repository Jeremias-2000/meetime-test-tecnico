package com.example.meetime_case_tecnico.service;

import com.example.meetime_case_tecnico.integration.dto.AuthTokenResponse;
import com.example.meetime_case_tecnico.integration.dto.OauthCallbackResponse;

public interface OauthService {

    AuthTokenResponse getAuth(String clientId, String scope,
                              String redirectUri, String state);

    OauthCallbackResponse getAuthCallback();
}
