package model;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Account {
    private final String holderName;
    private final int accNumber;
    private static int accNumCounter = 1000;
    private double balance;

    // Constructor
    public Account(String holderName, double balance) {
        this.holderName = holderName;
        this.balance = balance;

        this.accNumber = accNumCounter++;
    }

    // deposit method
    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
         return false;
    }

    // withdraw method
    public WithdrawStatus withdraw(double amount) {
        if (amount <= 0) {
            return WithdrawStatus.MIN_BALANCE_VIOLATION;
        }

        WithdrawStatus status = canWithDraw(amount);

        if (status == WithdrawStatus.SUCCESS) {
            this.balance -= amount;
        }

        return status;
    }

    // canWithDraw method
    protected abstract WithdrawStatus canWithDraw(double amount);

    // displayDetails method
    public void displayDetails() {
        NumberFormat indianCurrency = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String balanceInRupees = indianCurrency.format(this.balance);
        System.out.printf("Holder Name: %s | Account Number: %d | Balance: %s %n", this.holderName, this.accNumber, balanceInRupees);
    }

    // getter for balance
    public double getBalance() {
        return balance;
    }

    // getter for account number
    public int getAccNumber() {
        return accNumber;
    }

    // getter for holder name
    public String getHolderName() {
        return holderName;
    }
}
