package com.xbank.date;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class DateService {

    public Integer calculateAge(String birthDate) {
        // Define o formato da data de entrada
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Converte a string em LocalDate utilizando o formato definido
        LocalDate dataNasc = LocalDate.parse(birthDate, formatoData);

        // Obtém a data atual
        LocalDate dataAtual = LocalDate.now();

        // Calcula a diferença em anos entre as datas utilizando o método Period.between()
        return Period.between(dataNasc, dataAtual).getYears();

    }
}
