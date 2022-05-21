package com.example.ATMBankomat.exceptionHandlng;

import com.example.ATMBankomat.model.enume.CardType;

public class NotEnoughMoney extends Exception{

    double sum;

    public NotEnoughMoney(double sum){
        System.out.println("Mablag' yetarli emas.");
    }
}
