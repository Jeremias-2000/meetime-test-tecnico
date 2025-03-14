package com.example.meetime_case_tecnico.integration;

import com.example.meetime_case_tecnico.integration.dto.AuthResponse;
import com.example.meetime_case_tecnico.integration.dto.OauthCallbackResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hubspot",url = "${hubspot.auth.url}",configuration = IntegrationConfig.class)
public interface OauthHubSpotClient {

    //    https://authorization-server.com/auth
//            ?response_type=code
// &client_id=29352915982374239857
//            &redirect_uri=https%3A%2F%2Fexample-app.com%2Fcallback
// &scope=create+delete
// &state=xcoiv98y2kd22vusuye3kch

    @PostMapping
    AuthResponse getAuth(@RequestParam(value = "client_id") String clientId,
                         @RequestParam(value = "scope",required = false) String scope,
                         @RequestParam("redirect_uri") String redirectUri,
                         @RequestParam(value = "state",required = false) String state);



//    https://example-app.com/redirect
//            ?code=g0ZGZmNjVmOWIjNTk2NTk4ZTYyZGI3
// &state=xcoiv98y2kd22vusuye3kch
    @GetMapping("/oauth-callback")
    OauthCallbackResponse getAuthCallback();

}
