package org.mkhizemonde;

import java.util.Random;
import java.util.Scanner;

public class LotteryMonde {
    public static void main(String[] args) {
      System.out.println("Welcome,Halo,Sawubona,Molo,Unjani, to the Lottery Game!");

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            Random random = new Random();
            int[] lotteryNumbers = new int[3];

            // Generate three random numbers between 0 and 9
            for (int i = 0; i < 3; i++) {
                lotteryNumbers[i] = random.nextInt(10);
            }

            // Read user's guesses with error handling
            int[] userGuesses = new int[3];
            System.out.print("Enter your three guesses (separated by spaces): ");
            for (int i = 0; i < 3; i++) {
                try {
                    userGuesses[i] = scanner.nextInt();
                    if (userGuesses[i] < 0 || userGuesses[i] > 9) {
                        throw new Exception("Invalid input! Guesses must be between 0 and 9.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }

            // Compare the user's guesses with the lottery numbers
            int numCorrectGuesses = 0;
            for (int i = 0; i < 3; i++) {
                if (userGuesses[i] == lotteryNumbers[i]) {
                    numCorrectGuesses++;
                }
            }

            // Calculate the amount of money won
            int winnings = 0;
            if (numCorrectGuesses == 0) {
                winnings = 0;
            } else if (numCorrectGuesses == 1) {
                winnings = 10;
            } else if (numCorrectGuesses == 2) {
                winnings = 100;
            } else if (numCorrectGuesses == 3) {
                winnings = 1000;
            }

            // Display the results
            System.out.println("Lottery numbers: " + lotteryNumbers[0] + " " + lotteryNumbers[1] + " " + lotteryNumbers[2]);
            System.out.println("Your guesses: " + userGuesses[0] + " " + userGuesses[1] + " " + userGuesses[2]);
            System.out.println("Number of correct guesses: " + numCorrectGuesses);
            System.out.println("Amount of money won: $" + winnings);

            // Ask the user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();

            if (playAgainInput.equalsIgnoreCase("no")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing the Lottery Game!");
    }
}
