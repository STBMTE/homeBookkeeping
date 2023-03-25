package com.example.homebookkeeping.service;

import com.example.homebookkeeping.model.AccountModel;
import com.example.homebookkeeping.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Iterable<AccountModel> getAllAccount(){
        return accountRepository.findAll();
    }

    public Optional<AccountModel> getById(Long id){
        return accountRepository.findById(id);
    }

    public boolean createAccountFromUser(Double ammount){
        accountRepository.save(new AccountModel(ammount));
        return true;
    }

    public boolean editAccount(Long accountId, Double ammount){
        AccountModel accountModel = accountRepository.findById(accountId).get();
        accountModel.setAmmount(accountModel.getAmmount() + ammount);
        return true;
    }

    public boolean deleteAccountById(Long id) {
        try {
            accountRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
