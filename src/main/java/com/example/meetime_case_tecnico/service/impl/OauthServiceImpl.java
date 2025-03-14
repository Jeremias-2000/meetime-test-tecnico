package com.example.meetime_case_tecnico.service.impl;

import com.example.meetime_case_tecnico.integration.dto.AuthResponse;
import com.example.meetime_case_tecnico.integration.dto.OauthCallbackResponse;
import com.example.meetime_case_tecnico.integration.IntegrationConfig;
import com.example.meetime_case_tecnico.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OauthServiceImpl implements OauthService {

    @Autowired
    private IntegrationConfig oauthHubSpot;

    @Override
    public AuthResponse getAuth(String clientId,String scope,
                                String redirectUri,String state) {

        return oauthHubSpot.getAuth(clientId, scope, redirectUri, state);
    }

    @Override
    public OauthCallbackResponse getAuthCallback() {
        return null;
    }
}
