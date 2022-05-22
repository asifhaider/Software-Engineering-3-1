package Employees;

import Bank.Bank;

public class Cashier extends Employee{
    public Cashier(Bank bank, String name) {
        bank.getAllEmployees().put(name, this);
        this.employeeName = name;
    }

    @Override
    public void approve(Bank bank) {
        System.out.println("You don't have permission for this operation");
    }

    @Override
    public void seeInternalFund(Bank bank) {
        System.out.println("You don't have permission for this operation");
    }

    @Override
    public void changeInterestRate(Bank bank, String type, double rate) {
        System.out.println("You don't have permission for this operation");
    }
}
