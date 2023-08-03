package com.xbank.account.controller;

import com.xbank.account.domain.Account;
import com.xbank.account.dtos.AccountDetailsDTO;
import com.xbank.account.dtos.ListAllAccounts;
import com.xbank.account.dtos.RegisterAccountDTO;
import com.xbank.account.repository.AccountRepository;
import com.xbank.client.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("account")
public class AccountController {

    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public AccountController(AccountRepository accountRepository, ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity registerAccount(@RequestBody @Valid RegisterAccountDTO data, UriComponentsBuilder uriBuilder) {
        var account = new Account(data, clientRepository);

        accountRepository.save(account);

        var uri = uriBuilder.path("/account/{id}").buildAndExpand(account.getId()).toUri();

        return ResponseEntity.created(uri).body(account);
    }

    @GetMapping
    public ResponseEntity<Page<ListAllAccounts>> listAcconts(@PageableDefault(size = 10, sort = {"numberAccount"})Pageable pagination) {
        var page = accountRepository.findAllByStatusTrue(pagination).map(ListAllAccounts::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity accountDetails(@PathVariable Long id) {
        var account = accountRepository.getReferenceById(id);

        return ResponseEntity.ok(new AccountDetailsDTO(account));
    }

    @DeleteMapping("/desactivate/{id}")
    @Transactional
    public ResponseEntity desactivateAccount(@PathVariable Long id) {
        var account = accountRepository.getReferenceById(id);
        account.desactivateAccount();

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/active/{id}")
    @Transactional
    public ResponseEntity activateAccount(@PathVariable Long id) {
        var account = accountRepository.getReferenceById(id);
        account.activateAccount();

        return ResponseEntity.ok().body(new AccountDetailsDTO(account));
    }
}

