package com.pluralsight;

import java.util.Scanner;

public class maincalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("====== Financial calculator ======");
        System.out.println("*** Mortgage calculator ***");
        System.out.println("*** Future value calculator ***");
        System.out.println("*** Present value ***");
        System.out.print("please choose one of the options 1/2/3: ");
        int option = scan.nextInt();

        System.out.println("----------------------------------");

        if (option == 1) {
            System.out.println("## mortgage calculator ##");

            System.out.print("principal: ");
            double principal = scan.nextDouble();

            System.out.print("interest rate: ");
            double interestRate = scan.nextDouble();

            System.out.print(("loan length in years: "));
            int years = scan.nextInt();

            double monthly = mortgageMonthly(principal, interestRate, years);

            int numberOfMonths = years * 12;
            double totalInterest = monthly * numberOfMonths - principal;
            double totalPayment = monthly * numberOfMonths;

            System.out.printf("Monthly payment $: %.2f%n" +
                    "Total interest $: %.2f%n" +
                    "Total payment $: %.2f%n", monthly, totalInterest, totalPayment);

        } else if (option == 2) {
            System.out.println("## future value ##");

            System.out.print("your deposit: ");
            double deposit = scan.nextDouble();

            System.out.print("interest rate: ");
            double rate = scan.nextDouble();

            System.out.print("number of years: ");
            int years = scan.nextInt();

            double endingBalance = futureValue(deposit, rate, years);
            double ernedInterest = endingBalance - deposit;

            System.out.printf("Future value $:  %.2f%n" +
                    "Total interest $: %.2f%n", endingBalance, ernedInterest);


        } else if (option == 3) {
            System.out.println("## present value ##");

            System.out.print("monthly payout: ");
            double pmt = scan.nextDouble();

            System.out.print("expected rate: ");
            double rate = scan.nextDouble();

            System.out.print("years to pay: ");
            int years = scan.nextInt();

            double presentValue = annuityPV(pmt, rate, years);
            System.out.printf("Present value: $ %.2f%n", presentValue);

        } else {
            System.out.println("Option invalid. Restart.");
        }
        scan.close();
    }

        static double mortgageMonthly(double principal, double annualRatePercent, int years){
            double monthlyRate = (annualRatePercent / 100) / 12;
            int numberOfMonths = years * 12;
            if (monthlyRate == 0.0)
                return principal / numberOfMonths;
            double pow = Math.pow(1 + monthlyRate, numberOfMonths);
            return principal * (monthlyRate * pow) / (pow - 1);
        }
        static  double futureValue(double deposit, double rate, int years){
            final int days = 365;
            double dailyRate = (rate / 100) / days;
            int totalDays = years * days;
            return deposit * Math.pow(1 + dailyRate, totalDays);
        }
        static double annuityPV(double pmt, double rate, int years){
            double monthly = (rate / 100) / 12;
            int  numberOfMonths = years * 12;
            if (monthly == 0.0) return pmt * numberOfMonths;
            return pmt * (1 - Math.pow(1 + monthly, - numberOfMonths)) / monthly;
        }



    }


