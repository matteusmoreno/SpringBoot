package com.xbank.client.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdateClientDTO(
        @NotNull
        Long id,
        String name,
        @Pattern(regexp = "\\d{2}\\/\\d{2}\\/\\d{4}")
        String birthDate,
        @Pattern(regexp = "\\d{11}")
        String phone,
        @Email
        String email
) {
}
