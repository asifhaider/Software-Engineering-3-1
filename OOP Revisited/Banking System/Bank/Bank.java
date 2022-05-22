package Bank;

import Accounts.*;
import Employees.Employee;

import java.util.*;

public class Bank {

    private double internalFund;
    private int yearCount;
    private double loanInterestRate;
    private double serviceCharge;

    // savings, student, fixed deposit
    private double savingsInterestRate;
    private double studentInterestRate;
    private double fixedDepositInterestRate;


    public double getLoanInterestRate() {
        return loanInterestRate;
    }
    public double getServiceCharge() {
        return serviceCharge;
    }
    public double getInternalFund() {
        return internalFund;
    }
    public void setInternalFund(double internalFund) {
        this.internalFund = internalFund;
    }
    public double getSavingsInterestRate() {
        return savingsInterestRate;
    }
    public void setSavingsInterestRate(double savingsInterestRate) {
        this.savingsInterestRate = savingsInterestRate;
    }
    public double getStudentInterestRate() {
        return studentInterestRate;
    }
    public void setStudentInterestRate(double studentInterestRate) {
        this.studentInterestRate = studentInterestRate;
    }
    public double getFixedDepositInterestRate() {
        return fixedDepositInterestRate;
    }
    public void setFixedDepositInterestRate(double fixedDepositInterestRate) {
        this.fixedDepositInterestRate = fixedDepositInterestRate;
    }

    // tracks all employees
    private HashMap<String, Employee> allEmployees;
    public HashMap<String, Employee> getAllEmployees() {
        return allEmployees;
    }

    // tracks all account
    private HashMap<String, Account> allAccounts;
    public HashMap<String, Account> getAllAccounts() {
        return allAccounts;
    }
    
    // tracks current active account info
    private String activeUser;
    private String activeUserType;

    public String getActiveUser() {
        return activeUser;
    }
    public String getActiveUserType() {
        return activeUserType;
    }
    public void setActiveUser(String activeUser) {
        this.activeUser = activeUser;
    }
    public void setActiveUserType(String activeUserType) {
        this.activeUserType = activeUserType;
    }

    // tracks loan request and approval
    private LinkedList<LoanRequest> loanQueue;
    public LinkedList getLoanQueue() {
        return loanQueue;
    }

    // instantiated only once in the program run
    public Bank() {
        this.internalFund = 1000000;
        this.yearCount = 0;
        this.loanInterestRate = 0.1;
        this.savingsInterestRate = 0.1;
        this.studentInterestRate = 0.05;
        this.fixedDepositInterestRate = 0.15;
        this.serviceCharge = 500;

        this.allEmployees = new HashMap<String, Employee>();
        this.allAccounts = new HashMap<String, Account>();
        this.loanQueue = new LinkedList<LoanRequest>();
    }

    // checks if account already exists, if not, registers a new account with given credentials
    public void registerAccount(String name, String type, String amount) {
        if (allAccounts.containsKey(name)) {
            System.out.println("Account already exists with this username! Try something else.");
        } else {
            if (type.equalsIgnoreCase("student")) {
                Account account = new StudentAccount(name, Double.parseDouble(amount));
                this.allAccounts.put(name, account);
                this.activeUser = name;
                this.activeUserType = "user";
            } else if (type.equalsIgnoreCase("savings")){
                Account account = new SavingsAccount(name, Double.parseDouble(amount));
                this.allAccounts.put(name, account);
                this.activeUser = name;
                this.activeUserType = "user";
            } else if (type.equalsIgnoreCase("fixed-deposit")){
                if (Double.parseDouble(amount) < 100000){
                    System.out.println("Account creation needs at least 100,000$ to be deposited initially!");
                } else {
                    Account account = new FixedDepositAccount(name, Double.parseDouble(amount));
                    this.allAccounts.put(name, account);
                    this.activeUser = name;
                    this.activeUserType = "user";
                }
            } else if (type.equalsIgnoreCase("loan")){
                Account account = new LoanAccount(this, name, Double.parseDouble(amount));
                this.allAccounts.put(name, account);
                this.activeUserType = "user";
                this.activeUser = name;
            }
        }
    }

    // iterating the whole loan queue
    public void approveAllLoan() {
        while(loanQueue.size()>0){
            LoanRequest<Account> loanRequest = this.loanQueue.pop();
            try{
                System.out.println("Loan for " + loanRequest.getRequester().getHolderName() + " approved");
                loanRequest.getRequester().setLoanTaken(loanRequest.getLoanAmount());
                loanRequest.getRequester().setMaxLoanAmountLeft(loanRequest.getLoanAmount());
                this.internalFund -= loanRequest.getLoanAmount();
            } catch (NullPointerException n){
                continue;
            }
        }
    }

    // changing the interest rates
    public void changeInterestRates(String type, double rate){
        if(type.equalsIgnoreCase("student")){
            this.studentInterestRate = rate;
            System.out.println("Interest rate changed successfully!");
        } else if (type.equalsIgnoreCase("savings")){
            this.savingsInterestRate = rate;
            System.out.println("Interest rate changed successfully!");
        } else if (type.equalsIgnoreCase("fixed-deposit")){
            this.fixedDepositInterestRate = rate;
            System.out.println("Interest rate changed successfully!");
        } else {
            System.out.println("This type of account doesn't exist");
        }
    }

    public void activationStatus() {
        if (this.getActiveUserType().equalsIgnoreCase("employee")){
            System.out.print(this.activeUser + " active");
            if(this.loanQueue.size()>0){
                System.out.println(", there are loan approvals pending");
            } else{
                System.out.println();
            }
        } else {
            System.out.println("Welcome back, " + this.getActiveUser());
        }
    }

    public void incrementYear(){
        this.allAccounts.forEach((k, v)->
                v.updateBalanceLoan(this));
        this.allAccounts.forEach((k, v)->
                v.setYearCount(v.getYearCount()+1));
        System.out.println("1 year passed");
    }
}