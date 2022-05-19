package com.example.ATMBankomat.model;


import com.example.ATMBankomat.service.ServiceImpelement;

import java.util.Scanner;

public class WorkerClass {

    static Card card = new Card("8600 1234 1234 1234", "Sherjonov Jahongir", 1000, 1234, false);
    static Card card1 = new Card("9860 1234 1234 1234", "Sherjonov Zohidjon", 1000, 1234, true);
    static Card card2 = new Card("6242 1234 1234 1234", "Ozodov Doniyor", 1000, 1234, true);
    static Card card3 = new Card("4000 1234 1234 1234", "Aminov Abror", 1000, 1111, false);

    public static Card[] cards = {card, card1,card2,card3};

    public void worker(Card insert) {
        boolean shart =true;

            Scanner scanner = new Scanner(System.in);
            ServiceImpelement serviceImpelement = new ServiceImpelement();
            if (insert != null) {
                if (serviceImpelement.checkPin(insert)) {
                    while (shart) {
                    System.out.println("=========MENU==========");
                    System.out.println("1. Kartadan Kartaga pul o'tkazish.");
                    System.out.println("2. Karta mablag'ini ko'rish.");
                    System.out.println("3. Chiqish.");
                    switch (scanner.nextInt()) {

                        case 1: {
                            serviceImpelement.moneyTransfer(insert);
                            break;
                        }
                        case 2 : {
                            serviceImpelement.cardBalance(insert);
                            break;
                        }
                        case 3 : {
                           shart = false;
                           break;
                        }
                        default: {
                            System.err.println("ERROR NUMBER !!!");
                            break;
                        }
                    }
                }
            }
        }
    }


    public static Card checkID(String id) {
        Card cardIn = card;
        String idKarta = "";
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].getId().equals(id)) {
                idKarta = "";
                if (cards[i].isCondition()) {
                    cardIn = card;
                    return cardIn;
                } else {
                    System.out.println("Karta bloklangan");
                    return null;
                }
            } else {
                idKarta = "Karta ID xato.";
                cardIn = null;
            }
        }
        System.out.println(idKarta);
        return cardIn;
    }
}


