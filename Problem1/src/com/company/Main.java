package com.company;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main{
    private static int firstNumber = 0;
    private static int secondNumber = 0;
    private static int problemType = 0;

    private static String generateQuestion(int level) {
        SecureRandom random = new SecureRandom();
        boolean solvable = false;

        if (problemType == 5) {
            problemType = random.nextInt(3) + 1;
        }

        while (!solvable) {
            if (level == 1) {
                firstNumber = random.nextInt(9) + 1;
                secondNumber = random.nextInt(9) + 1;
            } else if (level == 2) {
                firstNumber = random.nextInt(99) + 1;
                secondNumber = random.nextInt(99) + 1;
            } else if (level == 3) {
                firstNumber = random.nextInt(999) + 1;
                secondNumber = random.nextInt(999) + 1;
            } else if (level == 4) {
                firstNumber = random.nextInt(9999) + 1;
                secondNumber = random.nextInt(9999) + 1;
            }

            solvable = true;

            if ((problemType == 4) && (firstNumber % secondNumber != 0)) {
                solvable = false;
            }
            if ((problemType == 3) && (firstNumber < secondNumber)) {
                solvable = false;
            }
        }

        if (problemType == 1) {
            return String.format("How much is %d plus %d?", firstNumber, secondNumber);
        } else if (problemType == 2) {
            return String.format("How much is %d times %d?", firstNumber, secondNumber);
        } else if (problemType == 3) {
            return String.format("How much is %d minus %d?", firstNumber, secondNumber);
        } else  {
            return String.format("How much is %d divided by %d?", firstNumber, secondNumber);
        }
    }

    private static boolean verifyAnswer(double input) {
        if (problemType == 1) {
            return Double.compare(input, (double) (firstNumber + secondNumber)) == 0;
        } else if (problemType == 2) {
            return Double.compare(input, (double) (firstNumber * secondNumber)) == 0;
        } else if (problemType == 3) {
            return Double.compare(input, (double) (firstNumber - secondNumber)) == 0;
        } else {
            return Double.compare(input, ((double) firstNumber / (double) secondNumber)) == 0;
        }
    }

    private static String correctAnswerResponse() {
        SecureRandom random = new SecureRandom();
        int randomNumber = random.nextInt(3) + 1;
        String response;

        switch (randomNumber) {
            case 1:
                response = "Very good!";
                break;
            case 2:
                response = "Excellent!";
                break;
            case 3:
                response = "Nice work!";
                break;
            default:
                response = "Keep up the good work!";
                break;
        }

        return response;
    }

    private static String wrongAnswerResponse() {
        SecureRandom random = new SecureRandom();
        int randomNumber = random.nextInt(3) + 1;
        String response;

        switch (randomNumber) {
            case 1:
                response = "That is incorrect.";
                break;
            case 2:
                response = "Wrong. Better luck next time.";
                break;
            case 3:
                response = "No, but don’t give up!";
                break;
            default:
                response = "No. Try another question.";
                break;
        }

        return response;
    }

    private static int determineLevelOfDifficulty() {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Select Difficulty Level:");
        System.out.println("========================");
        System.out.println("Enter '1' for Level 1: One digit values");
        System.out.println("Enter '2' for Level 2: Two digit values");
        System.out.println("Enter '3' for Level 3: Three digit values");
        System.out.println("Enter '4' for Level 4: Four digit values");

        return scnr.nextInt();
    }

    private static int determineProblemType() {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Select Problem Type:");
        System.out.println("====================");
        System.out.println("Enter '1' for Addition");
        System.out.println("Enter '2' for Multiplication");
        System.out.println("Enter '3' for Subtraction");
        System.out.println("Enter '4' for Division");
        System.out.println("Enter '5' for All Problem Types");

        return scnr.nextInt();
    }

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        int numberOfCorrect = 0;
        int difficultyLevel = 0;

        double input = 0.0;
        String question = "";
        boolean quit = false;

        System.out.println("Hello! My name is CAI! Please select a difficulty level from the following:");
        System.out.println();

        while (!quit) {
            difficultyLevel = determineLevelOfDifficulty();
            System.out.println();
            problemType = determineProblemType();

            System.out.println();
            System.out.println("Level " + difficultyLevel + ":");

            for (int i = 0; i < 10; i++) {
                question = generateQuestion(difficultyLevel);
                System.out.println("Question " + (i + 1) + ": " + question);

                input = scnr.nextDouble();

                if (verifyAnswer(input)) {
                    System.out.println(correctAnswerResponse());
                    numberOfCorrect++;
                } else {
                    System.out.println(wrongAnswerResponse());
                }
                System.out.println();
            }

            System.out.println("Total correct responses: " + numberOfCorrect);
            System.out.println("Total incorrect responses: " + (10 - numberOfCorrect));

            if (numberOfCorrect <= 7) {
                System.out.println("Please ask your teacher for extra help.");
            } else {
                System.out.println("Congratulations, you are ready to go to the next level!");
            }
            System.out.println();
            numberOfCorrect = 0;

            System.out.println("Do you wish to begin a new session?");
            System.out.println("Enter 'y' to continue or 'q' to quit.");

            if (scnr.next().charAt(0) == 'q') {
                quit = true;
            }
            System.out.println();
        }
    }

}
