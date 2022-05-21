package com.example.ATMBankomat.service;

import com.example.ATMBankomat.exceptionHandlng.CardTypeNotMatch;
import com.example.ATMBankomat.exceptionHandlng.NotEnoughMoney;
import com.example.ATMBankomat.model.Card;
import com.example.ATMBankomat.model.enume.CardType;

import java.util.ArrayList;
import java.util.Scanner;

import static com.example.ATMBankomat.model.WorkerClass.cards;

public class ServiceImpelement implements ServiceCard{


    ArrayList<Card> arrayList = new ArrayList<>();

    @Override
    public void moneyTransfer(Card deleviry) throws CardTypeNotMatch {

        Scanner scanner = new Scanner(System.in);
        String blok = "", kart="";
        System.out.println("O'tkazmoqchi bo'lgan karta ID ni yozing : ");
        String id = scanner.nextLine();

        for (int i = 0; i < cards.length; i++) {

                if (cards[i].getId().equals(id)) {
                    Card recevr = cards[i];
                    if (cards[i].isCondition()) {
                        if (deleviry.getCardType().getCurrency().equals(recevr.getCardType().getCurrency())) {
                            System.out.println("Qancha o'tkazmoqchisiz : ");
                            double recevrSum = scanner.nextDouble();
                            double summa = recevr.getBalance();
                            if((deleviry.getBalance() - (recevrSum * 0.01)) >= recevrSum) {
                                summa += recevrSum;
                                recevr.setBalance(summa);
                                System.out.println("Muvoffaqiyatli.");
                                deleviry.setBalance(deleviry.getBalance() - recevrSum - recevrSum * 0.01);  //****
                            }else {
                                try{
                                 throw new NotEnoughMoney(deleviry.getBalance());
                                }catch (NotEnoughMoney notEnoughMoney){
                                    System.out.println("Exception : " + notEnoughMoney);
                                }
                            }
                            blok = "";
                            kart = "";
                            arrayList.add(deleviry);
                            arrayList.add(recevr);
                            return;
                        }else {
                            System.out.println("Exception : ");
                           throw new CardTypeNotMatch(deleviry.getCardType(), recevr.getCardType());
                        }

                    } else {
                        blok = "Siz pul o'tkazmoqchi bo'lgan karta bloklangan.";
                        kart = "";
                    }
                } else {
                    kart = "Unday ID li karta mavjud emas.";
                    blok = "";
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

    @Override
    public void viewHistory() {
        System.out.println(arrayList);
    }
}
