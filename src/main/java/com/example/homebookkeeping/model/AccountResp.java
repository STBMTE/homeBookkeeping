package com.example.homebookkeeping.model;

public class AccountResp {
    private Double Ammount;

    public AccountResp(){

    }

    public AccountResp(Double ammount){
        Ammount = ammount;
    }

    public double getAmmount() {
        return Ammount;
    }

    public void setAmmount(double ammount) {
        Ammount = ammount;
    }
}
