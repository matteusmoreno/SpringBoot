package com.yahoo.customerregistration.dtos;

import com.yahoo.customerregistration.domain.client.Client;

public record ListClientDto(Long id, String name, String email) {

    public ListClientDto(Client client) {
        this(client.getId(), client.getName(), client.getEmail());
    }

}
