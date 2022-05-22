package Accounts;

import Bank.Bank;

public class SavingsAccount extends Account{
    public SavingsAccount(String holderName, double amount)
    {
        this.holderName = holderName;
        this.totalBalance = amount;
        this.maxLoanAmountLeft = 10000;
        this.loanTaken = 0;
        this.yearCount = 0;

        // account creation message
        System.out.println("Savings account for " + this.holderName + " Created; initial balance " + this.totalBalance + "$");
    }

    @Override
    public void withdraw(Bank bank, double amount) {
        if (this.totalBalance - amount < 1000){
            System.out.println("Account must contain 1000$ at least; current balance: " + this.totalBalance + "$");
        } else
            super.withdraw(bank, amount);
    }

    @Override
    public void updateBalanceLoan(Bank bank) {
        this.totalBalance += this.totalBalance*bank.getSavingsInterestRate();
        this.totalBalance -= this.loanTaken*bank.getLoanInterestRate();
        this.totalBalance -= bank.getServiceCharge();
        if(this.totalBalance < 0)
            this.totalBalance = 0;
    }
}
