package com.example.homebookkeeping.controller;

import com.example.homebookkeeping.model.AccountModel;
import com.example.homebookkeeping.model.AccountResp;
import com.example.homebookkeeping.model.TransactionModel;
import com.example.homebookkeeping.model.TransactionResp;
import com.example.homebookkeeping.service.AccountService;
import com.example.homebookkeeping.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/homebokkeeping")
public class RESTController {
    private final AccountService accountService;
    private final TransactionService transactionService;

    public RESTController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @GetMapping("/account")
    private Iterable<AccountModel> list() {
        return accountService.getAllAccount();
    }

    @GetMapping("/account/{id}")
    private Optional<AccountModel> getById(@PathVariable("id") Long id) {
        return accountService.getById(id);
    }

    @DeleteMapping("/account/{id}")
    private void deletea(@PathVariable("id") Long id) {
        accountService.deleteAccountById(id);
    }

    @PatchMapping("/account/{id}")
    private void update(@PathVariable("id") Long id, @RequestBody AccountResp response) {
        accountService.getById(id).get().setAmmount(response.getAmmount());
    }

    @PostMapping("/account")
    private boolean addAccount(@RequestBody TransactionResp response){
        accountService.createAccountFromUser(response.getAmmount());
        return true;
    }


    @GetMapping("/transaction")
    private Iterable<TransactionModel> lists(){
        return transactionService.getTransaction();
    }

    @GetMapping("/account/{id}/transaction/{id1}")
    private Optional<TransactionModel> getByIds(@PathVariable("id1") Long id) {
        return transactionService.getById(id);
    }

    @DeleteMapping("/account/{id}/transaction/{id1}")
    private void delete(@PathVariable("id1") Long id) {
        transactionService.deleteTransactionById(id);
    }

    @PatchMapping("/account/{id}/transaction/{id1}")
    private void updatet(@PathVariable("id1") Long id, @RequestBody TransactionResp response) {
        transactionService.deleteTransactionById(id);
    }

    @PostMapping("/account/{id}/transaction")
    private boolean addTransaction(@PathVariable("id") Long id, @RequestBody TransactionResp response){
            return transactionService.createTransaction(new TransactionModel(response.getDescription(),
                    response.getAmmount(), id));
    }
}
