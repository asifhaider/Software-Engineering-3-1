package Accounts;

import Bank.Bank;

public class FixedDepositAccount extends Account{

    public FixedDepositAccount(String holderName, double amount){
        this.holderName = holderName;
        this.totalBalance = amount;
        this.maxLoanAmountLeft = 100000;
        this.loanTaken = 0;
        this.yearCount = 0;

        // account creation message
        System.out.println("Fixed Deposit account for " + this.holderName + " Created; initial balance " + this.totalBalance + "$");
    }

    @Override
    public void deposit(Bank bank, double amount) {
        if (amount < 50000){
            System.out.println("The deposit amount must not be less than 50,000$");
        }else
            super.deposit(bank, amount);
    }

    @Override
    public void withdraw(Bank bank, double amount) {
        if(this.yearCount == 0){
            System.out.println("Withdrawal not possible, you have not reached one year maturity period");
        } else{
            super.withdraw(bank, amount);
            // this.yearCount = 0;
        }
    }

    @Override
    public void updateBalanceLoan(Bank bank) {
        this.totalBalance += this.totalBalance*bank.getFixedDepositInterestRate();
        this.totalBalance -= this.loanTaken*bank.getLoanInterestRate();
        this.totalBalance -= bank.getServiceCharge();
        if(this.totalBalance < 0)
            this.totalBalance = 0;
    }
}
