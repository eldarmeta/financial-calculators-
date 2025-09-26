package com.pluralsight;

import java.util.Scanner;

public class calculator1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====== Mortgage calculator ======");

        System.out.print("Please enter your principal: ");
        double principal = scanner.nextDouble();
        System.out.println("---------------------------");
        System.out.print("Please enter your interest rate %: ");
        double interestRate = scanner.nextDouble();
        System.out.println("---------------------------");
        System.out.print("Please enter your loan length years: ");
        int years = scanner.nextInt();
        int numberOfMonth = years * 12;

        double monthlyRate = (interestRate / 100) / 12;
        double monthlyPayments = principal * (monthlyRate * Math.pow(1 + monthlyRate, numberOfMonth))
                / (Math.pow(1 + monthlyRate, numberOfMonth) - 1);
        double totalInterest = (monthlyPayments * numberOfMonth) - principal;
        double totalPayments = monthlyPayments * numberOfMonth;

        System.out.printf("Your monthly payment is: %.2f\n", monthlyPayments);
        System.out.printf("Your total interest is: %.2f\n", totalInterest);
        System.out.printf("Your total payments is: %.2f\n", totalPayments);


        scanner.close();
    }
}
