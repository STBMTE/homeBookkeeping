package com.example.homebookkeeping.service;

import com.example.homebookkeeping.model.TransactionModel;
import com.example.homebookkeeping.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Optional<TransactionModel> getById(Long id) {
        return transactionRepository.findById(id);
    }

    public Iterable<TransactionModel> getTransaction(){
        return transactionRepository.findAll();
    }

    public boolean createTransaction(TransactionModel transaction) {
        transactionRepository.save(transaction);
        return true;
    }

    public boolean deleteTransactionById(Long id) {
        try {
            transactionRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    public boolean editTransaction(Long id, Optional<String> commentTransaction){
        var transaction = getById(id).get();
        transaction.setDescription(commentTransaction.get());
        transactionRepository.save(transaction);
        return true;
    }
}
