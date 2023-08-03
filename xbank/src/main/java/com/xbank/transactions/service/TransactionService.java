package com.xbank.transactions.service;

import com.xbank.account.domain.Account;
import com.xbank.account.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final AccountRepository accountRepository;

    public TransactionService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferAmount(Long sendAccountId, Long receiveAccountId, Double amount) {
        Account sendAccount = accountRepository.findById(sendAccountId)
                .orElseThrow(() -> new RuntimeException("Conta de envio não encontrada"));

        Account receiveAccount = accountRepository.findById(receiveAccountId)
                .orElseThrow(() -> new RuntimeException("Conta de recebimento não encontrada"));

        if (sendAccount.getBalance() >= amount) {
            sendAccount.setBalance(sendAccount.getBalance() - amount);
            receiveAccount.setBalance(receiveAccount.getBalance() + amount);

        } else {
            throw new RuntimeException("Saldo insuficiente para realizar a transferência");
        }
    }

    @Transactional
    public void deposit(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        account.setBalance(account.getBalance() + amount);
        // Salvar as alterações no banco de dados
        accountRepository.save(account);
    }

    @Transactional
    public void withdraw(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            // Salvar as alterações no banco de dados
            accountRepository.save(account);
        } else {
            throw new RuntimeException("Saldo insuficiente para realizar o saque");
        }
    }
}
