package com.practice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HiraganaTest {
    public static void hiraganaTest() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        String hiraganaChar = "", romajiHiraganaChar = "";
        int upperbound = 70, lineNumber;
        double correctScore = 0.0, incorrectScore = 0.0;

        System.out.println("When you answer the question correctly, a point will be added to the total average. " +
                "Get your average score as high as you can!");
        for (int repeat = 0; repeat < 10; repeat++) {
            try {
                FileReader readHiraganafile = new FileReader("C:\\Users\\Kevin\\IdeaProjects\\Practice" +
                        "\\out\\production\\Practice\\com\\practice\\hiraganaChart.txt");
                FileReader readRomajiHiraganafile = new FileReader("C:\\Users\\Kevin\\IdeaProjects\\Practice" +
                        "\\out\\production\\Practice\\com\\practice\\romaji.txt");

                BufferedReader readhiraganabuffer = new BufferedReader(readHiraganafile);
                BufferedReader readRomajihiraganabuffer = new BufferedReader(readRomajiHiraganafile);
                int randomInt = rand.nextInt(upperbound);
                for (lineNumber = 1; lineNumber < 71; lineNumber++) {
                    if (lineNumber == randomInt) {
                        romajiHiraganaChar = readRomajihiraganabuffer.readLine();
                    } else
                        readRomajihiraganabuffer.readLine();
                }

                for (lineNumber = 1; lineNumber < 71; lineNumber++) {
                    if (lineNumber == randomInt) {
                        hiraganaChar = readhiraganabuffer.readLine();
                    } else
                        readhiraganabuffer.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            incorrectScore++;
            double scoreAverage = correctScore / incorrectScore;

            System.out.println("Hiragana character: " + hiraganaChar);
            System.out.print("Romaji answer: ");
            String romajiHiraganaAnswer = scanner.nextLine();
            if (!romajiHiraganaAnswer.equals(romajiHiraganaChar)) {
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
    }
}