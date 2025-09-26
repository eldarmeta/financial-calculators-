package com.pluralsight;

import java.util.Scanner;

public class maincalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("====== Financial Calculators ======");
        System.out.println("1) Mortgage (monthly & total interest)");
        System.out.println("2) Future Value (CD, daily compounding)");
        System.out.print("Choose option (1/2): ");
        int option = scan.nextInt();

        if (option == 1) {
            System.out.println("--- Mortgage ---");
            System.out.print("Principal: ");
            double principal = scan.nextDouble();
            System.out.print("Annual interest rate %: ");
            double annualRatePercent = scan.nextDouble();
            System.out.print("Years: ");
            int years = scan.nextInt();

            double monthly = mortgageMonthly(principal, annualRatePercent, years);

            int numberOfMonth = years * 12;
            double totalInterest = monthly * numberOfMonth - principal;
            double totalPayment  = monthly * numberOfMonth;

            System.out.printf("Monthly payment: %.2f%nTotal interest:  %.2f%nTotal payment:   %.2f%n",
                    monthly, totalInterest, totalPayment);

        } else if (option == 2) {
            System.out.println("--- Future Value (CD, daily) ---");
            System.out.print("Deposit: ");
            double deposit = scan.nextDouble();
            System.out.print("Annual interest rate %: ");
            double annualRatePercent = scan.nextDouble();
            System.out.print("Years: ");
            int years = scan.nextInt();

            double fv = cdFutureValueDaily(deposit, annualRatePercent, years);

            double interest = fv - deposit;

            System.out.printf("Future value:   %.2f%n Total interest: %.2f%n",
                    fv, interest);

        } else {
            System.out.println("Option invalid. Restart.");
        }

        scan.close();
    }
    static double mortgageMonthly(double principal, double annualRatePercent, int years) {
        double monthlyRate = (annualRatePercent / 100) / 12;
        int numberOfMonth = years * 12;
        if (monthlyRate == 0.0) return principal / numberOfMonth;
        double pow = Math.pow(1 + monthlyRate, numberOfMonth);
        return principal * (monthlyRate * pow) / (pow - 1);
    }

    static double cdFutureValueDaily(double deposit, double annualRatePercent, int years) {
        final int DAYS = 365;
        double dailyRate = (annualRatePercent / 100.0) / DAYS;
        int totalDays = years * DAYS;
        return deposit * Math.pow(1 + dailyRate, totalDays);
    }
}
