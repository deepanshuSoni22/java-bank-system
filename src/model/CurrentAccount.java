package model;

public class CurrentAccount extends Account {

    public CurrentAccount(String holderName, double balance) {
        super(holderName, balance);
    }

    private static final double MIN_OVERDRAFT = -5000;

    @Override
    public WithdrawStatus canWithDraw(double amount) {
        if (getBalance() - amount < MIN_OVERDRAFT) {
            return WithdrawStatus.MIN_BALANCE_VIOLATION;
        }

        return WithdrawStatus.SUCCESS;
    }


}
