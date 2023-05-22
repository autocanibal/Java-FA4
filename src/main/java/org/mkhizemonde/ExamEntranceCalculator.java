package org.mkhizemonde;

import java.util.Scanner;

public class ExamEntranceCalculator {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);


        System.out.println("Please enter the name of the module: ");
        String moduleName=scan.next();

        System.out.println("Please enter the mark for Formative Assessment 1 (out of 100): ");
        double formative1= scan.nextDouble();

        System.out.println("Please enter the mark for Formative Assessment 2 (out of 100): ");
        double formative2= scan.nextDouble();

        System.out.println("Please enter the mark for Formative Assessment 3 (out of 100): ");
        double formative3= scan.nextDouble();

        double fa1=formative1/100*16.66;
        double fa2= formative2/100*16.66;
        double fa3= formative3/100*16.66;

        double finalMark=fa1+fa2+fa3;

        if(finalMark>=30){
            System.out.println("Congratulations you have qualified to write an exam ");
        }else{
            System.out.println("You did not meet the qualifying criteria, you have failed your module ");
        }

    }
}
