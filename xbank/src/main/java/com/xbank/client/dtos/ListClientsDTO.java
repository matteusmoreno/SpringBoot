package com.xbank.client.dtos;

import com.xbank.adress.Adress;
import com.xbank.client.domain.Client;

public record ListClientsDTO(
        Long id,
        String name,
        Integer age,
        Adress adress,
        String email
) {
    public ListClientsDTO(Client client) {
        this(client.getId(), client.getName(), client.getAge(), client.getAdress(), client.getEmail());
    }
}
