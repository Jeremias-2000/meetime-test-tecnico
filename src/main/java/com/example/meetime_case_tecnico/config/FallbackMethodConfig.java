package com.example.meetime_case_tecnico.config;

import com.example.meetime_case_tecnico.exception.MeetimeException;
import com.example.meetime_case_tecnico.exception.MensagemErro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FallbackMethodConfig {

    public MeetimeException fallbackWebhookActivity(Throwable throwable) throws MeetimeException {
        StackTraceElement[] stackTrace = throwable.getStackTrace();

        var methodName = stackTrace.length > 0 ? stackTrace[0].getMethodName():"Unknown";

        log.error("Erro ao chamar {}: {}", methodName,throwable.getMessage(), throwable);
        throw new MeetimeException(MensagemErro.ERRO_INTEGRACAO);
    }
}
