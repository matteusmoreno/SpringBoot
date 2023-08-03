package com.xbank.transactions.dtos;

import jakarta.validation.constraints.NotNull;

public record DepositDTO(
        @NotNull
        Long accountId,
        @NotNull
        Double amount
) {
}