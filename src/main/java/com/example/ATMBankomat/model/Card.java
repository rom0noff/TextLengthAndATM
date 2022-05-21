package com.example.ATMBankomat.model;

import com.example.ATMBankomat.model.enume.CardType;

public class Card {
    private String id;
    private int pin;
    private String owner;
    private double balance;
    private boolean condition;

    private CardType cardType;



    public Card(String id, String owner, double balance, int pin, boolean condition, CardType cardType) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.pin = pin;
        this.condition = condition;
        this.cardType = cardType;
    }
    public Card(){

    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                ", cardType=" + cardType +
                '}';
    }
}
