package com.example.homebookkeeping.repository;

import com.example.homebookkeeping.model.TransactionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionModel, Long> {
}
