package com.example.meetime_case_tecnico.controller;

import com.example.meetime_case_tecnico.exception.IntegrationErrorDto;
import com.example.meetime_case_tecnico.integration.dto.AuthTokenResponse;
import com.example.meetime_case_tecnico.service.OauthService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
@Tag(name = "Login",description = "Destina-se ao gerenciamento de acesso dos usuários")
public class LoginController {

    @Autowired
    private OauthService oauthService;

    @PostMapping("/oauth/authorize")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "sucesso"),
            @ApiResponse(responseCode = "400",description = "erro de negocio",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "500",description = "erro de sistema",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
    })
    public ResponseEntity<AuthTokenResponse> getAuthUrl(@RequestParam(value = "client_id") String clientId, @RequestParam(value = "scope",required = false) String scope,
                                                        @RequestParam("redirect_uri") String redirectUri, @RequestParam(value = "state",required = false) String state){
        return ResponseEntity.ok(oauthService.getAuth(clientId, scope, redirectUri, state));
    }

    @GetMapping("/oauth-callback")
    public ResponseEntity<String> getAuthCallback(){
        return null;
    }
}
