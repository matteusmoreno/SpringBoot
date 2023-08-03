package com.xbank.client.dtos;

import com.xbank.adress.Adress;
import com.xbank.client.domain.Client;

public record ClientDetailsDTO(
        Long id,
        String name,
        String birthDate,
        Integer age,
        Adress adress,
        String phone,
        String email,
        String cpf,
        Boolean status
) {
    public ClientDetailsDTO(Client client) {
        this(client.getId(), client.getName(), client.getBirthDate(),
                client.getAge(), client.getAdress(), client.getPhone(),
                client.getEmail(), client.getCpf(),client.getStatus());
    }

}
