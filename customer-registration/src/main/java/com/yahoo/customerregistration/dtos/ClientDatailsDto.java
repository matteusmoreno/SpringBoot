package com.yahoo.customerregistration.dtos;

import com.yahoo.customerregistration.domain.adress.Adress;
import com.yahoo.customerregistration.domain.client.Client;

import java.time.LocalDate;

public record ClientDatailsDto(Long id, String name, String email, LocalDate birthDate, Adress adress, Boolean status) {

    public ClientDatailsDto(Client client) {
        this(client.getId(), client.getName(), client.getEmail(), client.getBirthDate(), client.getAdress(), client.getStatus());
    }
}
