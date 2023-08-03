package com.xbank.adress;


import com.xbank.infra.ViaCepErrorException;
import org.springframework.stereotype.Service;

@Service
public class AdressService {

    private final ViaCepClient viaCepClient;

    public AdressService(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    public Adress getAdressByZip(String cep) {
        Adress adress = viaCepClient.buscarEnderecoPorCep(cep);

        if (adress == null || adress.getLocalidade() == null) {
            throw new ViaCepErrorException("CEP não encontrado ou inválido."); // mensagem amigável cep inválido
        }

        return adress;
    }

    public Adress setAdressByZip(Adress adress) {
        String cep = adress.getCep();
        Adress addressResponse = viaCepClient.buscarEnderecoPorCep(cep);

        if (addressResponse == null || addressResponse.getLocalidade() == null) {
            throw new ViaCepErrorException("CEP não encontrado ou inválido."); // mensagem amigável cep inválidox'
        }

        adress.setLogradouro(addressResponse.getLogradouro());
        adress.setLocalidade(addressResponse.getLocalidade());
        adress.setBairro(addressResponse.getBairro());
        adress.setUf(addressResponse.getUf());
        return adress;
    }
}
