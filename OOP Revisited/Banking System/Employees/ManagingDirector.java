package Employees;

import Bank.Bank;

public class ManagingDirector extends Employee{
    public ManagingDirector(Bank bank, String name) {
        bank.getAllEmployees().put(name, this);
        this.employeeName = name;
    }

    @Override
    public void approve(Bank bank) {
        bank.approveAllLoan();
    }

    @Override
    public void changeInterestRate(Bank bank, String type, double rate){
       bank.changeInterestRates(type, rate/100);
    }

    @Override
    public void seeInternalFund(Bank bank) {
        System.out.println("The bank has now a total fund of " + bank.getInternalFund() + "$");
    }
}