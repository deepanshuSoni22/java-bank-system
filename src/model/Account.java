package model;

public abstract class Account {
    private String holderName;
    private int accNumber;
    private final static int accNumCounter = 1000;
    private double balance;

    public Account(String holderName, int balance) {
        this.holderName = holderName;
        this.balance = balance;

        this.accNumber = accNumCounter++;
    }

    public boolean deposit(double) {

    }
}
