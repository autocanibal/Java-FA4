package org.mkhizemonde;

// Import statements
import java.util.Scanner;
import java.util.InputMismatchException;

public class ExamEntranceCalculator {
    // Declare constants
    private static final double ASSESSMENT_WEIGHT = 16.66;
    private static final double PASS_MARK = 30.0;

    public static void main(String[] args) {
        boolean isRunning = true;

        // Main program loop
        while(isRunning)
        {
            // Create scanner object
            Scanner scanner = new Scanner(System.in);

            // Prompt user for the name of the module
            System.out.print("Please enter the name of the module: ");
            String moduleName = scanner.nextLine();

            // Prompt user for the formative marks
            double fa1Mark = getValidMark(scanner, "\nPlease enter the mark for Formative Assessment 1 (out of 100): ");
            double fa2Mark = getValidMark(scanner, "Please enter the mark for Formative Assessment 2 (out of 100): ");
            double fa3Mark = getValidMark(scanner, "Please enter the mark for Formative Assessment 3 (out of 100): ");

            // Calculations for all the marks
            double fa1Weight = fa1Mark / 100.0 * ASSESSMENT_WEIGHT;
            double fa2Weight = fa2Mark / 100.0 * ASSESSMENT_WEIGHT;
            double fa3Weight = fa3Mark / 100.0 * ASSESSMENT_WEIGHT;

            double semesterMark = fa1Weight + fa2Weight + fa3Weight;

            // Convert the semesterMark to two decimal places
            String formattedSemesterMark = String.format("%.2f", semesterMark);

            // Display the results
            System.out.println("\nModule: " + moduleName);
            System.out.println("Semester Mark: " + formattedSemesterMark);

            if (semesterMark >= PASS_MARK) {
                System.out.println("\nCongratulations, you have qualified to write an exam!");
            } else {
                System.out.println("\nYou did not meet the qualifying criteria, you have failed your module!");
            }

            boolean loop = true;

            // Loop to not end the program unless user says so
            while (loop){
                // Create scanner object
                Scanner input = new Scanner(System.in);

                // Prompt the user if they would like to calculate another module mark
                System.out.println("\nWould you like to calculate another module mark? (y/n)");

                char yesOrNo = input.next().charAt(0);
                if (yesOrNo == 'y') {
                    System.out.print("\n");
                    isRunning = true; // Continues main loop
                    loop = false; // Ends current loop
                }
                else if (yesOrNo == 'n') {
                    System.out.println("\nThank you for using the exam entrance calculator! ");
                    isRunning = false; // Ends main loop
                    loop = false; // Ends current loop
                }
                else {
                    System.out.println("\nIncorrect input. Please choose y/n! ");
                    loop = true; // Continues current loop
                }
            }
        }
    }

    // Helper method to validate the mark input (Validation)
    private static double getValidMark(Scanner scanner, String prompt) {
        // Declare variables
        double mark = 0;
        boolean validInput = false;

        // Continue prompting until a valid mark is entered
        do {
            try {
                System.out.print(prompt);
                mark = scanner.nextDouble();

                // Check if the mark is within the valid range of 0 to 100
                if (mark >= 0 && mark <= 100) {
                    validInput = true;
                }
                else {
                    System.out.println("\nInvalid mark. Please enter a number between 0 and 100!");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid number!");
                scanner.nextLine(); // Clear the input buffer
            }
        } while (!validInput);

        return mark;
    }
}

