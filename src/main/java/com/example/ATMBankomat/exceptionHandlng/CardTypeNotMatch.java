package com.example.ATMBankomat.exceptionHandlng;

import com.example.ATMBankomat.model.enume.CardType;

public class CardTypeNotMatch extends Throwable{

    private CardType recevr;
    private CardType deleviry;

    public CardTypeNotMatch(CardType cardType, CardType cardType1){

        System.out.println("Karta toifasi to'g'ri kelmadi.");

    }

    public CardType getRecevr() {
        return recevr;
    }

    public void setRecevr(CardType recevr) {
        this.recevr = recevr;
    }

    public CardType getDeleviry() {
        return deleviry;
    }

    public void setDeleviry(CardType deleviry) {
        this.deleviry = deleviry;
    }
}
