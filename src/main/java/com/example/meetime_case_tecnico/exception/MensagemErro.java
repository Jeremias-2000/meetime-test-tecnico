package com.example.meetime_case_tecnico.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MensagemErro {

    ERRO_SERVIDOR("INFRA-1","ERRO_SERVIDOR","Ops houve um erro no serviço devido indisponibilidade por favor tentar mais tarde");

    private final String codigo;
    private final String mensagem;
    private final String descricao;


    public String convertValue(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Houve um erro na conversao mensagem erro");
        }
    }
}
