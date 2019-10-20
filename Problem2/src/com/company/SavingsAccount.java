package com.company;

public class SavingsAccount {
    private static double annualInterestRate = 0;
    private double savingsBalance = 0;

    public SavingsAccount(double balance) {
        savingsBalance = balance;
    }

    public SavingsAccount() {
        this(0.0);
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public double calculateMonthlyInterest() {
        this.savingsBalance = ((annualInterestRate * savingsBalance) / 12) + savingsBalance;
        return this.savingsBalance;
    }

    public static void modifyInterestRate (double value) {
        annualInterestRate = value;
    }
}
