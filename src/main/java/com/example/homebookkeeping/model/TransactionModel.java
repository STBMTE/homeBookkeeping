package com.example.homebookkeeping.model;

import com.example.homebookkeeping.repository.AccountRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class TransactionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String description;
    private Double amount;
    private Long AccountId;

    public TransactionModel(String description, Double amount, Long accountId){
        this.date = LocalDate.now();
        this.description = description;
        this.amount = amount;
        this.AccountId = accountId;
    }

    public TransactionModel() {
    }

    public Long getId() {
        return id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getAccountId() {
        return AccountId;
    }

    public void setAccountId(Long accountId) {
        AccountId = accountId;
    }
}
