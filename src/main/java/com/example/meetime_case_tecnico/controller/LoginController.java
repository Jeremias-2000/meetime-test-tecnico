package com.example.meetime_case_tecnico.controller;

import com.example.meetime_case_tecnico.exception.IntegrationErrorDto;
import com.example.meetime_case_tecnico.integration.dto.auth.AuthRefreshTokenRequest;
import com.example.meetime_case_tecnico.integration.dto.auth.AuthTokenResponse;
import com.example.meetime_case_tecnico.integration.dto.auth.OauthCallbackResponse;
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
            @ApiResponse(responseCode = "404",description = "rota não encontrada",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "500",description = "erro de sistema",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
    })
    public ResponseEntity<AuthTokenResponse> getAuthUrl(@RequestParam(value = "client_id") String clientId, @RequestParam(value = "scope",required = false) String scope,
                                                        @RequestParam("redirect_uri") String redirectUri, @RequestParam(value = "state",required = false) String state){
        return ResponseEntity.ok(oauthService.getAuth(clientId, scope, redirectUri, state));
    }

    @PostMapping("/refresh-token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "sucesso"),
            @ApiResponse(responseCode = "400",description = "erro de negocio",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "401",description = "erro de negocio",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "404",description = "rota não encontrada",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "403",description = "erro de negocio",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "500",description = "erro de sistema",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
    })
    public ResponseEntity<AuthTokenResponse> getAuthRefreshToken(@RequestBody AuthRefreshTokenRequest request){
        return ResponseEntity.ok(oauthService.getAuthRefreshToken(request));
    }

    @GetMapping("/oauth-callback")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "sucesso"),
            @ApiResponse(responseCode = "400",description = "erro de negocio",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "401",description = "erro de negocio",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "404",description = "rota não encontrada",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "403",description = "erro de negocio",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
            @ApiResponse(responseCode = "500",description = "erro de sistema",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = IntegrationErrorDto.class))),
    })
    public ResponseEntity<OauthCallbackResponse> getAuthCallback(@RequestParam("code") String code, @RequestParam("state") String state){
        return ResponseEntity.ok(oauthService.getAuthCallback(code, state));
    }
}
