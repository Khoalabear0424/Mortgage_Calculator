package com.khoaproject;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int principal = 0;ª
        double interestRate = 0;
        int period = 0;

        principal = (int) readNumber("Principle", 1000, 1000000);
        interestRate = (int) readNumber("Interest Rate", 1, 30);
        period = (int) readNumber("Period", 1, 30);

        double mortgage = calculateMortgage(principal, interestRate, period);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage : " + mortgageFormatted);
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true){
            System.out.print(prompt + ":");
            value = scanner.nextInt();

            if(value >= min && value <= max) break;
            System.out.println("Please enter a value between "+ min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(int principal, double interestRate, int period) {
        final byte MONTHS_IN_YEARS = 12;
        final byte PERCENT = 100;

        double monthlyInterest = interestRate / PERCENT / MONTHS_IN_YEARS;
        int numberOfPayments = period * MONTHS_IN_YEARS;

        return principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
                                ((Math.pow(1 + monthlyInterest, numberOfPayments)) - 1));
    }
}

/*
Principal double
Annual Interest Rate double
Period (years) int

Mortgage
 */