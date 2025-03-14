package com.example.meetime_case_tecnico.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MensagemErro {

    ERRO_SERVIDOR("INFRA-1","ERRO_SERVIDOR","Ops houve um erro no serviço devido indisponibilidade por favor tentar mais tarde"),
    ERRO_INTEGRACAO("INFRA-2","ERRO_INTEGRACAO" , "Houve um erro ao realizar request na integracao"),
    ERRO_AUTORIZACAO("INFRA-3","ERRO_AUTORIZACAO" , "Há um erro de autorização na chamada"),
    ERRO_ROTA_NAO_ENCONTRADA("INFRA-4", "ERRO_ROTA_NAO_ENCONTRADA", "Rota não encontrada");

    private final String codigo;
    private final String mensagem;
    private final String descricao;


    public String convertValue(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(new MensagemErroDTO(this.codigo, this.mensagem, this.descricao));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Houve um erro na conversao mensagem erro");
        }
    }

    public record MensagemErroDTO(String codigo, String mensagem, String descricao) {
    }
}
