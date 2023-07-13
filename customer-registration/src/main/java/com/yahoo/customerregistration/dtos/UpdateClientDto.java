package com.yahoo.customerregistration.dtos;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record UpdateClientDto(
        @NotNull
        Long id,
        String name,
        String email,
        LocalDate birthDate,
        RegisterAdressDto adress) {
}
