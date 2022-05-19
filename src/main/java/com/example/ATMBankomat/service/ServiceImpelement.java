package com.example.ATMBankomat.service;

import com.example.ATMBankomat.model.Card;
import com.example.ATMBankomat.model.enume.CardType;

import java.util.Scanner;

import static com.example.ATMBankomat.model.WorkerClass.cards;

public class ServiceImpelement implements ServiceCard{

    static CardType cardType1 = CardType.UZCARD;
    static CardType cardType2 = CardType.HUMO;
    static CardType cardType3 = CardType.VISA;
    static CardType cardType4 = CardType.UNIONPAY;

    static CardType[] cardTypes = {cardType1, cardType2, cardType3, cardType4};
    @Override
    public void moneyTransfer(Card card) {

        Scanner scanner = new Scanner(System.in);
        String blok = "", kart="";
        System.out.println("O'tkazmoqchi bo'lgan karta ID ni yozing : ");
        String id = scanner.nextLine();
        for (int i = 0; i < cards.length; i++) {
            if(cards[i].getId().equals(id)){
                if(cards[i].isCondition()){
                    System.out.println("Qancha o'tkazmoqchisiz : ");
                    double moneyInsert = scanner.nextDouble();
                    double summa = cards[i].getBalance();
                    summa += moneyInsert;
                    cards[i].setBalance(summa);
                    System.out.println(summa);
                    card.setBalance(card.getBalance()-moneyInsert);  //****
                    blok = ""; kart="";
                    return;
                }else {
                    blok = "Siz pul o'tkazmoqchi bo'lgan karta bloklangan.";
                   kart="";
                }
            }else {
                kart = "Unday ID li karta mavjud emas.";
                blok ="";
            }
        }
        System.out.println(blok + " " + kart);

    }

    @Override
    public boolean checkPin(Card card) {
        Scanner scanner = new Scanner(System.in);
        boolean shart = true;
        for (int i = 0; i < 3; i++) {
            System.out.println("Karta parolini yozing : ");
            int pin = scanner.nextInt();
            if(card.getPin() == pin){
                return shart;
            }
            else {
                if(i == 2){
                    System.out.println("Kartangiz bloklandi 15 daqiqadan keyin qayta urinib ko'ring.");
                    card.setCondition(false);
                    shart = false;
                    return shart;
                }
                System.err.println("Parolingiz xato.");
                System.out.println();
            }
        }
        return shart;
    }

    @Override
    public void cardBalance(Card card) {
        System.out.println(card.getBalance());
    }
}
