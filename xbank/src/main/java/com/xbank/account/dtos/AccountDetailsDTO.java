package com.xbank.account.dtos;

import com.xbank.account.domain.Account;
import com.xbank.client.dtos.ClientDetailsDTO;

public record AccountDetailsDTO(
        Long id,
        String agency,
        String numberAccount,
        ClientDetailsDTO client,
        Double balance,
        Boolean status
) {
    public AccountDetailsDTO(Account account) {
        this(account.getId(), account.getAgency(), account.getNumberAccount(),
                new ClientDetailsDTO(account.getClient()), account.getBalance(),
                account.getStatus());
    }
}
