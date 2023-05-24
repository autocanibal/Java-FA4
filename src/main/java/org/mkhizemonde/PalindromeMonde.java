package org.mkhizemonde;

// Import scanner object
import java.util.Scanner;

public class PalindromeMonde {

    public static void main(String[] args) {

        boolean isRunning = true;

        // Program loop
        while(isRunning)
        {
            // Create the scanner object
            Scanner scanner = new Scanner(System.in);

            // Prompt the user for integer input
            System.out.println("Please give the input number to check palindrome:");

            // Declare variables
            long number = 0;
            boolean isValidInput = false;

            // While loop for validation
            while (!isValidInput) {
                // Try catch block if the user does not enter an integer value
                try {
                    String input = scanner.nextLine();
                    if (input.isEmpty()) {
                        System.out.println("No input detected. Please enter an integer:");
                        continue;
                    }
                    number = Long.parseLong(input);
                    isValidInput = true;
                }
                catch (NumberFormatException e) {
                    System.out.println("\nInvalid input! Please enter an integer:");
                }
            }

            // Display the results
            System.out.println("\nInput By User: " + number);
            System.out.println("Reverse number: " + reverseNumber(number));

            if (isPalindrome(number)) {
                System.out.println("\n" + number + " is a Palindrome Number.");
            }
            else {
                System.out.println("\n" + number + " is not a Palindrome Number.");
            }

            boolean loop = true;

            // Loop to not end the program unless user says so
            while (loop){
                Scanner input = new Scanner(System.in);

                // Prompt user to continue or not
                System.out.println("\nWould you like to check another palindrome? (y/n):");

                char yesOrNo = input.next().charAt(0);
                if (yesOrNo == 'y') {
                    System.out.print("\n");
                    isRunning = true; // Continues main loop
                    loop = false; // Ends current loop
                }
                else if (yesOrNo == 'n') {
                    System.out.println("\nThank you for using the Palindrome checker! ");
                    isRunning = false; // Ends main loop
                    loop = false; // Ends current loop
                }
                else {
                    System.out.print("\nIncorrect input. Please choose (y/n)!");
                    loop = true; // Continues current loop
                }
            }
        }
    }

    // Method that verifies if the input is a palindrome or not
    private static boolean isPalindrome(long number) {
        return number == reverseNumber(number);
    }

    // Method that checks if the reverse string is equal to the original string
    private static long reverseNumber(long number) {
        long reversedNumber = 0;

        while (number != 0) {
            long remainder = number % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            number /= 10;
        }
        return reversedNumber;
    }
}
