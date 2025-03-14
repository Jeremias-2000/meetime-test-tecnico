package com.example.meetime_case_tecnico.exception;

public class MeetimeException extends Exception{

    public MeetimeException(MensagemErro mensagem){
        super(mensagem.convertValue());
    }

}
