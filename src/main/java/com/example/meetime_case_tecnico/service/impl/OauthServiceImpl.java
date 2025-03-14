package com.example.meetime_case_tecnico.service.impl;

import com.example.meetime_case_tecnico.integration.dto.AuthTokenResponse;
import com.example.meetime_case_tecnico.integration.dto.OauthCallbackResponse;
import com.example.meetime_case_tecnico.service.OauthService;
import org.springframework.stereotype.Service;

@Service
public class OauthServiceImpl implements OauthService {

    @Override
    public AuthTokenResponse getAuth(String clientId, String scope,
                                     String redirectUri, String state) {

        //return oauthHubSpot.getAuth(clientId, scope, redirectUri, state);
        return null;
    }

    @Override
    public OauthCallbackResponse getAuthCallback() {
        return null;
    }
}
