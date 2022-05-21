package com.example.ATMBankomat;

import com.example.ATMBankomat.exceptionHandlng.CardTypeNotMatch;
import com.example.ATMBankomat.model.Card;
import com.example.ATMBankomat.model.WorkerClass;

import java.util.Scanner;

import static com.example.ATMBankomat.model.WorkerClass.checkID;

public class MainATM {


    public static void main(String[] args) throws CardTypeNotMatch {

        Scanner scanner = new Scanner(System.in);
        Card card = new Card();
        while (true) {
        System.out.println("Karta raqamingizni kiriting.  Misol | 1234 1234 1234 1234");
        Card insert = checkID(scanner.nextLine());

            WorkerClass workerClass = new WorkerClass();
            workerClass.worker(insert);
        }

    }

}
