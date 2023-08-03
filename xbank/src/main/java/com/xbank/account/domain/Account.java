package com.xbank.account.domain;

import com.xbank.account.dtos.RegisterAccountDTO;
import com.xbank.client.domain.Client;
import com.xbank.client.repository.ClientRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Account")
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String agency;
    private String numberAccount;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private Double balance;
    private Boolean status;

    public Account(RegisterAccountDTO data, ClientRepository clientRepository) {
        this.agency = data.agency();
        this.numberAccount = data.numberAccount();
        this.balance = 0.0;
        this.status = true;

        // Buscar o cliente pelo ID recebido e atribuí-lo à conta
        Client client = clientRepository.findById(data.clientId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        this.client = client;
    }

    public void desactivateAccount() {
        this.status = false;
    }

    public void activateAccount() {
        this.status = true;
    }
}

