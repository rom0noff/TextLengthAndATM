package com.example.textLength;

import com.example.textLength.service.MaxLengthImplement;

import java.util.Scanner;

public class MainText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaxLengthImplement maxLengthImplement = new MaxLengthImplement();
        System.out.println("Text Enter : ");
        maxLengthImplement.maxLength();
    }
}
