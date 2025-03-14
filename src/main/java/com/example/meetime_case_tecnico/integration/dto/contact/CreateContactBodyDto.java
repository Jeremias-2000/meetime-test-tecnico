package com.example.meetime_case_tecnico.integration.dto.contact;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateContactBodyDto(
        @Email
        String email,
        @NotBlank
        @JsonProperty("firstname")
        String firstName,
        @NotBlank
        @JsonProperty("lastname")
        String lastName,
        String website,
        String company,
        @NotBlank
        String phone
) {
}
