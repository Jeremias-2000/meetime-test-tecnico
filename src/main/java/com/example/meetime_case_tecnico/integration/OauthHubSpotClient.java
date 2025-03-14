package com.example.meetime_case_tecnico.integration;

import com.example.meetime_case_tecnico.config.FeignConfig;
import com.example.meetime_case_tecnico.integration.dto.auth.AuthRefreshTokenRequest;
import com.example.meetime_case_tecnico.integration.dto.auth.AuthTokenResponse;
import com.example.meetime_case_tecnico.integration.dto.auth.OauthCallbackResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hubspot",url = "${auth.hubspot.url}",configuration = FeignConfig.class)
public interface OauthHubSpotClient {

    @PostMapping("/oauth/v1/token")
    AuthTokenResponse getAuth(@RequestParam(value = "client_id") String clientId,
                              @RequestParam(value = "scope",required = false) String scope,
                              @RequestParam("redirect_uri") String redirectUri,
                              @RequestParam(value = "state",required = false) String state);

    @PostMapping("/oauth/v1/token")
    AuthTokenResponse getAuthRefreshToken(@RequestBody AuthRefreshTokenRequest request);

    @GetMapping("/redirect")
    OauthCallbackResponse getAuthCallback(@RequestParam("code") String code,@RequestParam("state") String state);

}
