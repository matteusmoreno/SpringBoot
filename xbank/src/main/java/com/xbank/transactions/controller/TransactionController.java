package com.xbank.transactions.controller;

import com.xbank.transactions.dtos.DepositDTO;
import com.xbank.transactions.dtos.TransferDTO;
import com.xbank.transactions.dtos.WithdrawDTO;
import com.xbank.transactions.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transfer")
    @Transactional
    public ResponseEntity transferAmount(@RequestBody @Valid TransferDTO data) {
        transactionService.transferAmount(data.sendAccount(), data.receiveAccount(), data.amount());
        return ResponseEntity.ok("Transferência realizada com sucesso!");
    }

    @PostMapping("/deposit")
    @Transactional
    public ResponseEntity deposit(@RequestBody @Valid DepositDTO data) {
        transactionService.deposit(data.accountId(), data.amount());
        return ResponseEntity.ok("Depósito realizado com sucesso!");
    }

    @PostMapping("/withdraw")
    @Transactional
    public ResponseEntity withdraw(@RequestBody @Valid WithdrawDTO data) {
        transactionService.withdraw(data.accountId(), data.amount());
        return ResponseEntity.ok("Saque realizado com sucesso!");
    }
}

