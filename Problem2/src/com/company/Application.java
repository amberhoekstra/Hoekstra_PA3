package com.company;

public class Application {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        System.out.println("Testing 4% annual interest for next 12 months.");
        SavingsAccount.modifyInterestRate(0.04);
        saver1.setSavingsBalance(2000.0);
        saver2.setSavingsBalance(3000.0);

        System.out.println();
        System.out.println("           Saver 1   Saver 2");
        System.out.println("----------------------------");

        for (int i = 0; i < 12; i++) {
            System.out.print("Month " + (i + 1) + ":  $");
            System.out.printf("%.2f", saver1.calculateMonthlyInterest());
            System.out.print("  $");
            System.out.printf("%.2f\n", saver2.calculateMonthlyInterest());
        }

        System.out.println();
        System.out.println();
        System.out.println("Testing 5% annual interest for next month.");

        SavingsAccount.modifyInterestRate(0.05);
        saver1.setSavingsBalance(2000.0);
        saver2.setSavingsBalance(3000.0);

        System.out.println();
        System.out.println("           Saver 1   Saver 2");
        System.out.println("----------------------------");

        System.out.print("Next month: $");
        System.out.printf("%.2f", saver1.calculateMonthlyInterest());
        System.out.print("  $");
        System.out.printf("%.2f\n", saver2.calculateMonthlyInterest());

    }
}
