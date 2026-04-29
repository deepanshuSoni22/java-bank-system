package service;

import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;
import model.WithdrawStatus;

import java.util.HashMap;
import java.util.Map;

public class BankService {
    private Map<Integer, Account> map;

    // CONSTRUCTOR
    public BankService() {
        map = new HashMap<>();
    }

    // CREATE CURRENT ACCOUNT
    public boolean createCurrentAccount(String holderName, double balance) {
        if (holderName == null || holderName.isBlank() || balance < 0) {
            return false;
        }

        CurrentAccount account = new CurrentAccount(holderName, balance);
        map.put(account.getAccNumber(), account);
        return true;
    }

    // CREATE SAVINGS ACCOUNT
    public boolean createSavingsAccount(String holderName, double balance) {
        if (holderName == null || holderName.isBlank() || balance < 0) {
            return false;
        }

        SavingsAccount account = new SavingsAccount(holderName, balance);
        map.put(account.getAccNumber(), account);
        return true;
    }

    // WITHDRAW
    public WithdrawStatus withdraw(int accountNumber, double amount) {
        Account account = map.get(accountNumber);

        if (account == null) {
            return WithdrawStatus.ACCOUNT_NOT_FOUND;
        }

        return account.withdraw(amount);
    }

    // DEPOSIT
    public boolean deposit(int accountNumber, double amount) {
        Account account = map.get(accountNumber);
        if (account == null) {
            return false;
        }

        return account.deposit(amount);
    }

    // FIND ACCOUNT BY NUMBER
    public Account findAccByAccNumber(int accountNumber) {
        return map.get(accountNumber);
    }

    // DISPLAY ACCOUNT DETAILS
    public void accountDetails(int accountNumber) {
        Account account = map.get(accountNumber);

        if (account != null) {
            account.displayDetails();
        } else {
            System.out.println("Account does not exists!");
        }
    }



}
