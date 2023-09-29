package com.practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String userInput = "", userInputLowerCase = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Japanese alphabet practice program.");

        while (!userInput.equals("hiragana") && !userInput.equals("katakana") && !userInput.equals("kanji")) {
            System.out.print("Which test would you like to take? (hiragana, katakana, //kanji): ");
            userInput = scanner.nextLine();
            userInputLowerCase = userInput.toLowerCase();
            if (userInputLowerCase.equals("hiragana" ))
                HiraganaTest.hiraganaTest();
            else if (userInputLowerCase.equals("katakana"))
                KatakanaTest.katakanaTest();
            else if (userInputLowerCase.equals("kanji"))
                System.out.println("This feature is a WIP and is currently unavailable.");
            else
                System.out.println("The program did not recognise your input. Please try again.");
        }
    }
}