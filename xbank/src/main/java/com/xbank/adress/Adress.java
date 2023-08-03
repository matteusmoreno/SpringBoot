package com.xbank.adress;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Adress {

    private String logradouro;
    private String bairro;
    private String cep;
    private String localidade;
    private String uf;

    public Adress(AdressDTO data) {
        this.logradouro = data.logradouro();
        this.bairro = data.bairro();
        this.cep = data.cep();
        this.localidade = data.localidade();
        this.uf = data.uf();
    }
}
