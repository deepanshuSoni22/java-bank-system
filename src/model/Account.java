package model;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Account {
    private final String holderName;
    private final int accNumber;
    private static int accNumCounter = 1000;
    private double balance;

    public Account(String holderName, int balance) {
        this.holderName = holderName;
        this.balance = balance;

        this.accNumber = accNumCounter++;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
         return false;
    }

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

    protected abstract WithdrawStatus canWithDraw(double amount);

    public void displayDetails() {
        NumberFormat indianCurrency = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String balanceInRupees = indianCurrency.format(this.balance);
        System.out.printf("Holder Name: %s | Account Number: %d | Balance: %s %n", this.holderName, this.accNumber, balanceInRupees);
    }

    public double getBalance() {
        return balance;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public String getHolderName() {
        return holderName;
    }
}
