package com.yahoo.customerregistration.dtos;

import com.yahoo.customerregistration.domain.adress.Adress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegisterClientDto(
        @NotBlank
        String name,
        @NotNull
        LocalDate birthDate,
        @Valid
        RegisterAdressDto adress,
        @NotBlank @Email
        String email) {
}
