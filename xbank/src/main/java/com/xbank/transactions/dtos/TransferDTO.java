package com.xbank.transactions.dtos;

import jakarta.validation.constraints.NotNull;

public record TransferDTO(
        @NotNull
        Long sendAccount,
        @NotNull
        Long receiveAccount,
        @NotNull
        Double amount
) {
}
