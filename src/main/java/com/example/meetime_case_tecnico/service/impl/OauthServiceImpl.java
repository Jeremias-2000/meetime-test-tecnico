package com.example.meetime_case_tecnico.service.impl;

import com.example.meetime_case_tecnico.integration.OauthHubSpotClient;
import com.example.meetime_case_tecnico.integration.dto.auth.AuthRefreshTokenRequest;
import com.example.meetime_case_tecnico.integration.dto.auth.AuthTokenResponse;
import com.example.meetime_case_tecnico.integration.dto.auth.OauthCallbackResponse;
import com.example.meetime_case_tecnico.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OauthServiceImpl implements OauthService {

    @Autowired
    private OauthHubSpotClient oauthHubSpotClient;

    @Override
    public AuthTokenResponse getAuth(String clientId, String scope,
                                     String redirectUri, String state) {

        return oauthHubSpotClient.getAuth(clientId, scope, redirectUri, state);
    }

    @Override
    public AuthTokenResponse getAuthRefreshToken(AuthRefreshTokenRequest request) {
        return oauthHubSpotClient.getAuthRefreshToken(request);
    }

    @Override
    public OauthCallbackResponse getAuthCallback(String code,String state) {
        return oauthHubSpotClient.getAuthCallback(code, state);
    }
}
