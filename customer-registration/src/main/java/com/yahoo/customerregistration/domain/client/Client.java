package com.yahoo.customerregistration.domain.client;

import com.yahoo.customerregistration.domain.adress.Adress;
import com.yahoo.customerregistration.dtos.RegisterClientDto;
import com.yahoo.customerregistration.dtos.UpdateClientDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;
    @Embedded
    private Adress adress;
    private String email;
    private Boolean status;

    public Client(RegisterClientDto data) {
        this.name = data.name();
        this.birthDate = data.birthDate();
        this.adress = new Adress(data.adress());
        this.email = data.email();
        this.status = true;
    }

    public void updateDataClient(UpdateClientDto data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.birthDate() != null) {
            this.birthDate = data.birthDate();
        }
        if (data.email() != null) {
            this.email = data.email();
        }
        if (data.adress() != null) {
            this.adress.updateAdressData(data.adress());
        }
    }

    public void inactiveThisClient() {
        this.status = false;
    }

    public void activateThisClient() {
        this.status = true;
    }
}
