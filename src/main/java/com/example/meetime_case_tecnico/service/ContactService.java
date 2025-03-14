package com.example.meetime_case_tecnico.service;


import com.example.meetime_case_tecnico.integration.dto.contact.CreateContactWrapperDto;

public interface ContactService {
    void createContactCrm(CreateContactWrapperDto dto, String authorization);
}
