package com.practice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class KatakanaTest {
    public static void katakanaTest() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        String katakanaChar = "", romajiKatakanaChar = "";
        int upperbound = 70, lineNumber, userQuestionNum;
        double correctScore = 0.0, incorrectScore = 0.0, scoreAverage = 0.0;

        System.out.print("How many questions would you like to practice?: ");
        userQuestionNum = scanner.nextInt();

        System.out.println("Get the romaji correct and get +1 to score. Get your average score as high as you can!");
        for (int repeat = 0; repeat < userQuestionNum; repeat++) {
            try {
                FileReader readKatakanafile = new FileReader("C:\\Users\\Kevin\\IdeaProjects\\Practice" +
                        "\\out\\production\\Practice\\com\\practice\\katakanaChart.txt");
                FileReader readRomajiKatakanafile = new FileReader("C:\\Users\\Kevin\\IdeaProjects\\Practice" +
                        "\\out\\production\\Practice\\com\\practice\\romaji.txt");

                BufferedReader readkatakanabuffer = new BufferedReader(readKatakanafile);
                BufferedReader readRomajikatakanabuffer = new BufferedReader(readRomajiKatakanafile);
                int randomInt = rand.nextInt(upperbound);
                for (lineNumber = 1; lineNumber < 71; lineNumber++) {
                    if (lineNumber == randomInt) {
                        romajiKatakanaChar = readRomajikatakanabuffer.readLine();
                    } else
                        readRomajikatakanabuffer.readLine();
                }

                for (lineNumber = 1; lineNumber < 71; lineNumber++) {
                    if (lineNumber == randomInt) {
                        katakanaChar = readkatakanabuffer.readLine();
                    } else
                        readkatakanabuffer.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            incorrectScore++;
            scoreAverage = correctScore / incorrectScore;

            System.out.println("Katakana character: " + katakanaChar);
            System.out.print("Romaji answer: ");
            String romajiKatakanaAnswer = scanner.nextLine();
            if (!romajiKatakanaAnswer.equals(romajiKatakanaChar)) {
                System.out.println("Incorrect..");
                System.out.println("Correct: " + correctScore);
                System.out.println("Incorrect: " + incorrectScore);
                System.out.println("Score average: " + scoreAverage);
                System.out.println("");

            } else {
                System.out.println("Correct!");
                correctScore++;
                incorrectScore--;
                System.out.println("Correct: " + correctScore);
                System.out.println("Incorrect: " + incorrectScore);
                scoreAverage++;
                System.out.println("Score average: " + scoreAverage);
                System.out.println("");
            }
        }

        System.out.println("Test complete!");
        System.out.println("Your average score was " + scoreAverage);
        if (!(scoreAverage >= 1))
            System.out.println("Try getting an average score of 1 or more on your next go.");
        else
            System.out.println("Excellent score average!");
    }
}