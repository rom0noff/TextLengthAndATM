package com.example.ATMBankomat.service;

import com.example.ATMBankomat.model.Card;

public interface ServiceCard {
    void moneyTransfer(Card card);
    boolean checkPin(Card card);
    void cardBalance(Card card);
}
