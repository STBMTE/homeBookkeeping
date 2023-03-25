package com.example.homebookkeeping.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Account")
public class AccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AccountId;
    private Double Ammount;

    public AccountModel(){

    }

    public AccountModel(Double ammount){
        this.Ammount = ammount;
    }

    public Long getAccountId() {
        return AccountId;
    }

    public Double getAmmount() {
        return Ammount;
    }

    public void setAmmount(Double ammount) {
        Ammount = ammount;
    }
}
