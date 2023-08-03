package com.xbank.client.domain;

import com.xbank.adress.Adress;
import com.xbank.client.dtos.RegisterClientDTO;
import com.xbank.client.dtos.UpdateClientDTO;
import com.xbank.date.DateService;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity(name = "Client")
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id")
public class Client {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String birthDate;
    private Integer age;
    @Embedded
    private Adress adress;
    private String phone;
    private String email;
    private String cpf;
    private Boolean status;

    public Client(RegisterClientDTO data) {
        this.name = data.name();
        this.birthDate = data.birthDate();
        this.age = data.age();
        this.adress = new Adress(data.adress());
        this.phone = data.phone();
        this.email = data.email();
        this.cpf = data.cpf();
        this.status = true;
    }
    public void updateClient(UpdateClientDTO data) {

        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.birthDate() != null) {
            this.birthDate = data.birthDate();
        }
        if (data.phone() != null) {
            this.phone = data.phone();
        }
        if (data.email() != null) {
            this.email = data.email();
        }

    }

    public void desactiveClient() {
        this.status = false;
    }

    public void activeClient() {
        this.status = true;
    }
}
