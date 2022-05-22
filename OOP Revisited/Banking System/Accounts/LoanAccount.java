package Accounts;

import Bank.Bank;
import Bank.LoanRequest;


public class LoanAccount extends Account{

    public LoanAccount(Bank bank, String holderName, double amount){
        this.holderName = holderName;
        this.totalBalance = amount;
        this.loanTaken = amount;
        this.yearCount = 0;
        this.maxLoanAmountLeft = Double.MAX_VALUE;

        bank.setInternalFund(bank.getInternalFund() - amount);

        // account creation message
        System.out.println("Loan account for " + this.holderName + " created; ");
        // initial loan request
        // bank.getLoanQueue().add(this.requestLoan(amount));
    }

    @Override
    public void deposit(Bank bank, double amount) {
        if(this.loanTaken == 0){
            System.out.println("No loan has been taken yet!");
        } else if(this.loanTaken - amount < 0){
            System.out.println("The loan amount is " + this.loanTaken + "$");
        } else{
            this.loanTaken -= amount;
            this.totalBalance -= amount;
            bank.setInternalFund(bank.getInternalFund() + amount);
            System.out.println("Loan amount of " + amount + "$ paid. Remaining loan is " + this.loanTaken + "$");
        }
    }

    @Override
    public void withdraw(Bank bank, double amount) {
        System.out.println("You can't withdraw anything from a loan account!");
    }

    @Override
    public void updateBalanceLoan(Bank bank) {
        this.loanTaken += this.loanTaken*bank.getLoanInterestRate();
        this.totalBalance = this.loanTaken;
    }

    @Override
    public LoanRequest<Account> requestLoan(double amount) {
        if(amount > this.loanTaken*0.05 && this.loanTaken>0){
            System.out.println("You can apply for upto additional 5% of current loan amount!");
            return null;
        } else {
            LoanRequest<Account> request = new LoanRequest<Account>(this, amount);
            System.out.println("Loan request successful, sent for approval");
            return request;
        }
    }
}