package Employees;

import Bank.Bank;

public abstract class Employee {
    protected String employeeName;
    protected final String employeeType = "employee";

    public String getEmployeeType() {
        return employeeType;
    }

    public void lookup(Bank bank, String name){
        if(!bank.getAllAccounts().containsKey(name)){
            System.out.println("This account doesn't exist!");
        } else {
            System.out.println(name + "'s current balance " + bank.getAllAccounts().get(name).getTotalBalance() + "$");
        }
    }

    public abstract void approve(Bank bank);
    public abstract void changeInterestRate(Bank bank, String name, double rate);
    public abstract void seeInternalFund(Bank bank);
}
