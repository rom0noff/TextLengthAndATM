package com.example.ATMBankomat.service;

import com.example.ATMBankomat.exceptionHandlng.CardTypeNotMatch;
import com.example.ATMBankomat.model.Card;

public interface ServiceCard {

    void moneyTransfer(Card insert) throws CardTypeNotMatch;

    boolean checkPin(Card card);
    void cardBalance(Card card);
    void viewHistory();
}
