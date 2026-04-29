package model;

public class SavingsAccount extends Account {
    public SavingsAccount(String holderName, double balance) {
        super(holderName, balance);
    }

    private static final double MIN_BALANCE = 1000;

    @Override
    public WithdrawStatus canWithDraw(double amount) {
        if (getBalance() - amount < MIN_BALANCE) {
            return WithdrawStatus.MIN_BALANCE_VIOLATION;
        }

        return WithdrawStatus.SUCCESS;
    }

}
