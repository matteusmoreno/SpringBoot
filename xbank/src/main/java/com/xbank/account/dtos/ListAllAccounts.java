package com.xbank.account.dtos;

import com.xbank.account.domain.Account;
import com.xbank.client.dtos.ClientDetailsDTO;
import com.xbank.client.dtos.ListClientsDTO;

public record ListAllAccounts(
        String agency,
        String numberAccount,
        ClientDetailsDTO client
) {
    public ListAllAccounts(Account account) {
        this(account.getAgency(), account.getNumberAccount(), new ClientDetailsDTO(account.getClient()));
    }
}
