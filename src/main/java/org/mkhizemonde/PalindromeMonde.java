package org.mkhizemonde;

import java.util.Scanner;

public class PalindromeMonde {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please give the input number to check palindrome:");

        int number = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.out.println("No input detected. Please enter an integer.");
                    continue;
                }
                number = Integer.parseInt(input);
                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }

        System.out.println("Input By User: " + number);
        System.out.println("Reverse number: " + reverseNumber(number));

        if (isPalindrome(number)) {
            System.out.println(number + " is a Palindrome Number");
        } else {
            System.out.println(number + " is not a Palindrome Number");
        }
    }

    private static boolean isPalindrome(int number) {
        return number == reverseNumber(number);
    }

    private static int reverseNumber(int number) {
        int reversedNumber = 0;

        while (number != 0) {
            int remainder = number % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            number /= 10;
        }

        return reversedNumber;
    }
}