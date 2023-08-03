package com.xbank.transactions.dtos;

import jakarta.validation.constraints.NotNull;

public record WithdrawDTO(
        @NotNull
        Long accountId,
        @NotNull
        Double amount
) {
}
