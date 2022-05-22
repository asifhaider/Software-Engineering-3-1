package Accounts;

import Bank.Bank;

public class StudentAccount extends Account {

    public StudentAccount(String holderName, double amount) {
        this.holderName = holderName;
        this.totalBalance = amount;
        this.maxLoanAmountLeft = 1000;
        this.loanTaken = 0;
        this.yearCount = 0;

        // account creation message
        System.out.println("Student account for " + this.holderName + " Created; initial balance " + this.totalBalance + "$");
    }



    @Override
    public void withdraw(Bank bank, double amount) {
        if(amount>10000){
            System.out.println("Invalid transaction; current balance " + this.totalBalance + "$");
        }
        else{
            super.withdraw(bank, amount);
        }
    }

    @Override
    public void updateBalanceLoan(Bank bank) {
        this.totalBalance += this.totalBalance*bank.getStudentInterestRate();
        this.totalBalance -= this.loanTaken*bank.getLoanInterestRate();
        this.totalBalance -= bank.getServiceCharge();
        if(this.totalBalance < 0)
            this.totalBalance = 0;
    }
}