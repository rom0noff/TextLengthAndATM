package com.example.textLength.service;

import java.util.Scanner;

public class MaxLengthImplement implements MaxLength {
    @Override
    public void maxLength() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int sum = 0;
        String[] text2 = text.split(" ");
        for (int i = 0; i < text2.length; i++) {
            if(text2[i].trim().length() == 0){

            }else {
                sum += text2[i].trim().length();
            }

        }
        if(sum == 0){
            System.out.println("NoTextExseption");
        }
        System.out.println(sum);


    }
}
