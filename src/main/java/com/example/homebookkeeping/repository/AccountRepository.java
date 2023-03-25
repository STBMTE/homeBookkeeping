package com.example.homebookkeeping.repository;

import com.example.homebookkeeping.model.AccountModel;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountModel, Long> {
}
