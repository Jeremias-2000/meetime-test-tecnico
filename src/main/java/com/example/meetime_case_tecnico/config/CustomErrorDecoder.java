package com.example.meetime_case_tecnico.config;

import com.example.meetime_case_tecnico.exception.MeetimeException;
import com.example.meetime_case_tecnico.exception.MensagemErro;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        var status = response.status();
        var details = "";
        try {
            if (response.body() != null) {
                details = new String(response.body().asInputStream().readAllBytes());
            }
        } catch (IOException e) {
            log.error("Erro ao ler resposta Feign", e);
        }
        log.error("Erro na integração {} - Status: {}, Detalhes: {}", methodKey, status, details);
        return switch (status) {
            case 400 -> new MeetimeException(MensagemErro.ERRO_INTEGRACAO);
            case 401, 403 -> new MeetimeException(MensagemErro.ERRO_AUTORIZACAO);
            case 429 -> new MeetimeException(MensagemErro.TAXA_REQUEST_EXCEDIDA);
            case 404 -> new MeetimeException(MensagemErro.ERRO_ROTA_NAO_ENCONTRADA);
            case 500 -> new MeetimeException(MensagemErro.ERRO_SERVIDOR);
            default -> defaultErrorDecoder.decode(methodKey, response);
        };
    }
}
