package com.yahoo.customerregistration.controller;

import com.yahoo.customerregistration.domain.client.Client;
import com.yahoo.customerregistration.dtos.ClientDatailsDto;
import com.yahoo.customerregistration.dtos.ListClientDto;
import com.yahoo.customerregistration.dtos.RegisterClientDto;
import com.yahoo.customerregistration.dtos.UpdateClientDto;
import com.yahoo.customerregistration.repository.ClientRepository;
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
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registerClient(@RequestBody @Valid RegisterClientDto data, UriComponentsBuilder uriBuilder) {
        var client = new Client(data);
        repository.save(client);

        var uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();

        return ResponseEntity.created(uri).body(new ClientDatailsDto(client));
    }

    @GetMapping
    public ResponseEntity<Page<ListClientDto>> listar(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page = repository.findAllByStatusTrue(pagination).map(ListClientDto::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detailClient (@PathVariable Long id) {
        var client = repository.getReferenceById(id);

        return ResponseEntity.ok(new ClientDatailsDto(client));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateClient (@RequestBody @Valid UpdateClientDto data) {
        var client = repository.getReferenceById(data.id());
        client.updateDataClient(data);

        return ResponseEntity.ok(new ClientDatailsDto(client));
    }

    @DeleteMapping("/desactivate/{id}")
    @Transactional
    public ResponseEntity inactiveClient(@PathVariable Long id) {
        var client = repository.getReferenceById(id);
        client.inactiveThisClient();

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/activate/{id}")
    @Transactional
    public ResponseEntity desactiveClient(@PathVariable Long id) {
        var client = repository.getReferenceById(id);
        client.activateThisClient();

        return ResponseEntity.noContent().build();
    }



}
