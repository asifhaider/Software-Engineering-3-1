package Accounts;

import Bank.Bank;
import Bank.LoanRequest;

public abstract class Account {

    protected String holderName;
    protected final String accountType = "user";

    protected double totalBalance;
    protected double loanTaken;
    protected double maxLoanAmountLeft;
    protected int yearCount;

    public int getYearCount() {
        return yearCount;
    }

    public void setYearCount(int yearCount) {
        this.yearCount = yearCount;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setLoanTaken(double loanTaken) {
        this.loanTaken += loanTaken;
        this.totalBalance += loanTaken;
    }

    public void setMaxLoanAmountLeft(double amount) {
        this.maxLoanAmountLeft -= amount;
    }

    // pays back the loan first if exists
    public void deposit(Bank bank, double amount){
        if(this.loanTaken > 0){
            if (this.loanTaken <= amount){
                amount = amount - this.loanTaken;
                this.loanTaken = 0;
            } else{
                this.loanTaken -= amount;
                amount = 0;
            }
        }
        this.totalBalance += amount;
        System.out.print(amount + "$ deposited; ");
        this.checkBalanceLoan();
        bank.setInternalFund(bank.getInternalFund() + amount);
    }

    public void withdraw(Bank bank, double amount){
        if(totalBalance-amount < 0)
        {
            System.out.println("Invalid transaction; current balance: " + this.totalBalance + "$");
        } else {
            totalBalance -= amount;
            bank.setInternalFund(bank.getInternalFund() - amount);
            System.out.println(amount + "$ withdrawn; current balance " + this.totalBalance + "$");
        }
    }

    public LoanRequest<Account> requestLoan(double amount){
        if(this.maxLoanAmountLeft - amount < 0){
            System.out.println("Loan request failed. Allowed amount of loan request left is " + this.maxLoanAmountLeft + "$");
            return null;
        } else{
            LoanRequest<Account> request = new LoanRequest<Account>(this, amount);
            System.out.println("Loan request successful, sent for approval");
            return request;
        }
    };

    public void checkBalanceLoan(){
        System.out.print("Current balance " + this.totalBalance + "$");
        if(this.loanTaken > 0){
            System.out.println(", loan " + this.loanTaken + "$");
        } else
            System.out.println();
    }

    public abstract void updateBalanceLoan(Bank bank);
}
