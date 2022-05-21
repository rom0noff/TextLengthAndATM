package com.example.ATMBankomat.model;


import com.example.ATMBankomat.exceptionHandlng.CardTypeNotMatch;
import com.example.ATMBankomat.model.enume.CardType;
import com.example.ATMBankomat.service.ServiceImpelement;

import java.util.Scanner;

public class WorkerClass {

    static Card card = new Card("8600 1234 1234 1234", "Sherjonov Jahongir", 1000, 1234, true, CardType.UZCARD);
    static Card card1 = new Card("9860 1234 1234 1234", "Sherjonov Zohidjon", 1000, 1234, true, CardType.HUMO);
    static Card card2 = new Card("6242 1234 1234 1234", "Ozodov Doniyor", 1000, 1234, true, CardType.VISA);
    static Card card3 = new Card("4000 1234 1234 1234", "Aminov Abror", 1000, 1111, false, CardType.UNIONPAY);
    static Card card4 = new Card("8600 1234 1234 1111", "Sherjonov Jahongir", 2000, 1234, true, CardType.UZCARD);

    public static Card[] cards = {card, card1,card2,card3,card4};

    public void worker(Card insert) throws CardTypeNotMatch {
        boolean shart =true;

            Scanner scanner = new Scanner(System.in);
            ServiceImpelement serviceImpelement = new ServiceImpelement();
            if (insert != null) {
                if (serviceImpelement.checkPin(insert)) {
                    Card deleviry = insert;

                    while (shart) {
                    System.out.println("=========MENU==========");
                    System.out.println("1. Kartadan Kartaga pul o'tkazish.");
                    System.out.println("2. Karta mablag'ini ko'rish.");
                    System.out.println("3. Karta tarixini ko'rish.");
                    System.out.println("4. Chiqish.");
                    switch (scanner.nextInt()) {

                        case 1: {
                            serviceImpelement.moneyTransfer(deleviry);
                            break;
                        }
                        case 2 : {
                            serviceImpelement.cardBalance(deleviry);
                            break;
                        }
                        case 3 : {
                            serviceImpelement.viewHistory();
                            break;
                        }
                        case 4 : {
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


