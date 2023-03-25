package com.example.homebookkeeping.model;

public class TransactionResp {
    private String Description;
    private Double Ammount;

    public TransactionResp(){

    }

    public TransactionResp(String description, Double ammount){
        this.Description = description;
        this.Ammount = ammount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getAmmount() {
        return Ammount;
    }

    public void setAmmount(Double ammount) {
        Ammount = ammount;
    }
}
