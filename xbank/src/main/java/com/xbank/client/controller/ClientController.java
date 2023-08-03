package com.xbank.client.controller;

import com.xbank.adress.AdressService;
import com.xbank.client.domain.Client;
import com.xbank.client.dtos.ClientDetailsDTO;
import com.xbank.client.dtos.ListClientsDTO;
import com.xbank.client.dtos.RegisterClientDTO;
import com.xbank.client.dtos.UpdateClientDTO;
import com.xbank.client.repository.ClientRepository;
import com.xbank.date.DateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("client")
public class ClientController {

    private final ClientRepository repository;
    private final AdressService adressService;
    private final DateService dateService;

    @Autowired
    public ClientController(ClientRepository repository, AdressService adressService, DateService dateService) {
        this.repository = repository;
        this.adressService = adressService;
        this.dateService = dateService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity registerClient(@RequestBody @Valid RegisterClientDTO data, UriComponentsBuilder uriBuilder) {
        var client = new Client(data);

        var age = dateService.calculateAge(client.getBirthDate());
        client.setAge(age);

        adressService.setAdressByZip(client.getAdress());
        repository.save(client);

        var uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();

        return ResponseEntity.created(uri).body(new ClientDetailsDTO(client));

    }

    @GetMapping
    public ResponseEntity<Page<ListClientsDTO>>listClients(@PageableDefault(size = 10, sort = {"name"})Pageable pagination) {
        var page = repository.findAllByStatusTrue(pagination).map(ListClientsDTO::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity clientDetails(@PathVariable Long id) {
        var client = repository.getReferenceById(id);

        return ResponseEntity.ok(new ClientDetailsDTO(client));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateCliente(@RequestBody @Valid UpdateClientDTO data) {
        var client = repository.getReferenceById(data.id());
        client.updateClient(data);

        return ResponseEntity.ok().body(new ClientDetailsDTO(client));
    }

    @DeleteMapping("/desactivate/{id}")
    @Transactional
    public ResponseEntity desactivateClient(@PathVariable Long id) {
        var client = repository.getReferenceById(id);
        client.desactiveClient();

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/activate/{id}")
    @Transactional
    public ResponseEntity ctivateClient(@PathVariable Long id) {
        var client = repository.getReferenceById(id);
        client.activeClient();

        return ResponseEntity.ok().body(new ClientDetailsDTO(client));
    }
}
