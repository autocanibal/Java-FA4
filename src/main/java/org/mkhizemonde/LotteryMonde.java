package org.mkhizemonde;

// Import statements
import java.util.Scanner;
import java.util.Random;

public class LotteryMonde {

    public static void main(String[] args) {
        // Call the playLotteryGame method
        playLotteryGame();
    }

    private static void playLotteryGame() {
        Random random = new Random(); // Create random object
        Scanner scanner = new Scanner(System.in); // Create scanner object

        // Generate three random numbers between 0 and 9
        int digit1 = random.nextInt(10);
        int digit2 = random.nextInt(10);
        int digit3 = random.nextInt(10);

        // Prompt the user & Display the results
        System.out.println("Welcome to the Lottery Game! Lets begin!");
        System.out.print("\nEnter your first guess (between 0 and 9): ");
        int guess1 = readGuess(scanner);
        System.out.print("Enter your second guess (between 0 and 9): ");
        int guess2 = readGuess(scanner);
        System.out.print("Enter your third and final guess (between 0 and 9): ");
        int guess3 = readGuess(scanner);

        System.out.println("\nLottery Result: " + digit1 + " " + digit2 + " " + digit3);

        int winnings = calculateWinnings(guess1, guess2, guess3, digit1, digit2, digit3);

        System.out.println("Your guesses: " + guess1 + " " +  guess2 + " " +  guess3);
        System.out.println("Winnings: $" + winnings);

        // Loop to ask the user to play again
        boolean play  = true;

        while (play) {
            System.out.print("\nDo you want to play again? (y/n): ");
            String playAgain = scanner.next();

            if (playAgain.equalsIgnoreCase("y")) {
                System.out.println();
                play = false;
                playLotteryGame();
            }
            else if (playAgain.equalsIgnoreCase("n")) {
                System.out.println("\nThank you for playing. Have a good day!");
                play = false;
            }
            else {
                System.out.println("Incorrect Input! Please choose y/n");
                play = true;
            }
        }
    }

    // Validate the users guesses
    private static int readGuess(Scanner scanner) {
        while (true) {
            try {
                int guess = scanner.nextInt();

                if (guess < 0 || guess > 9) {
                    System.out.print("Invalid guess. Enter a number between 0 and 9: ");
                }
                else {
                    return guess;
                }
            } catch (Exception e) {
                System.out.print("Invalid input. Enter a number between 0 and 9: ");
                scanner.next(); // Clear the input buffer
            }
        }
    }

    private static int calculateWinnings(int guess1, int guess2, int guess3, int digit1, int digit2, int digit3) {
        int winnings = 0;

        String guess = String.format("%d%d%d",guess1, guess2, guess3);
        String winningCombo = String.format("%d%d%d",digit1, digit2, digit3);

        // Simplest case: guess is exactly winning combination
        if (guess.equals(winningCombo)) {
            winnings = 1000000;
        }
        else {
            int matching = 0;

            //Iterate over the characters of the guess. Increment for each one found in the winning combination
            for (int i=0; i < guess.length(); i++) {
                //If winning combination contains this character
                if (winningCombo.contains( guess.charAt(i) + "")) {
                matching++;

                //Remove the character from the winnning combination to avoid duplication issues
                int slicePoint = winningCombo.indexOf(guess.charAt(i));
                winningCombo = winningCombo.substring( 0, slicePoint) + winningCombo.substring(slicePoint + 1);
                }
            }

        //Return winnings based on number of matches
            switch (matching) {
                case 0:
                   winnings = 0;
                   break;
                case 1:
                   winnings = 10;
                   break;
                case 2:
                   winnings = 100;
                   break;
                case 3:
                   winnings = 1000;
                   break;
            }
        }
        return winnings;
    }
}

