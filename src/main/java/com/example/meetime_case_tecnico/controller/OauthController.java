package com.example.meetime_case_tecnico.controller;

import com.example.meetime_case_tecnico.integration.dto.AuthResponse;
import com.example.meetime_case_tecnico.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class OauthController {

    @Autowired
    private OauthService oauthService;

    @PostMapping("/oauth/authorize")
    public ResponseEntity<AuthResponse> getAuthUrl(@RequestParam(value = "client_id") String clientId, @RequestParam(value = "scope",required = false) String scope,
                                                   @RequestParam("redirect_uri") String redirectUri, @RequestParam(value = "state",required = false) String state){
        return ResponseEntity.ok(oauthService.getAuth(clientId, scope, redirectUri, state));
    }

    @GetMapping("/oauth-callback")
    public ResponseEntity<String> getAuthCallback(){
        return null;
    }
}
