package com.xbank.client.dtos;

import com.xbank.adress.AdressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegisterClientDTO(
        @NotBlank
        String name,
        @NotBlank
        @Pattern(regexp = "\\d{2}\\/\\d{2}\\/\\d{4}")
        String birthDate,
        Integer age,
        @Valid
        AdressDTO adress,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String phone,
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        String cpf
) {
}
