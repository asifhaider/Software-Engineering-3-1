import Bank.Bank;
import Employees.Cashier;
import Employees.Employee;
import Employees.ManagingDirector;
import Employees.Officer;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // program initialization
        Bank exampleBank = new Bank();  // bank created
        Employee MD = new ManagingDirector(exampleBank, "MD");
        Employee S1 = new Officer(exampleBank, "S1");
        Employee S2 = new Officer(exampleBank, "S2");
        Employee C1 = new Cashier(exampleBank, "C1");
        Employee C2 = new Cashier(exampleBank, "C2");
        Employee C3 = new Cashier(exampleBank, "C3");
        Employee C4 = new Cashier(exampleBank, "C4");
        Employee C5 = new Cashier(exampleBank, "C5");
        System.out.println("Bank Created; MD, S1, S2, C1, C2, C3, C4, C5 created");

        // taking input in loop
        Scanner scn = new Scanner(System.in);
        while(scn.hasNextLine()) {
            String str = scn.nextLine();
            String[] input = str.split(" ");
            if (input[0].equalsIgnoreCase("exit"))
                break;

            // checks for all possible valid keywords
            switch (input[0].toLowerCase()) {
                case "create":
                    try{
                        if(exampleBank.getActiveUserType() != null){
                            System.out.println("Close the account before proceeding!");
                        }
                        else if (input[2].equalsIgnoreCase("student") || input[2].equalsIgnoreCase("savings") || input[2].equalsIgnoreCase("fixed-deposit") || input[2].equalsIgnoreCase("loan" )) {
                            exampleBank.registerAccount(input[1], input[2], input[3]);
                        } else {
                            System.out.println("Provide correct account type!");
                        }
                    } catch (Exception e){
                        System.out.println("Invalid keyword sequence!");
                    }
                    break;
                case "deposit":
                    try{
                        if(exampleBank.getActiveUserType() == null){
                            System.out.println("Open user account before proceeding!");
                        }
                        else if(exampleBank.getActiveUserType().equalsIgnoreCase("user")){
                            exampleBank.getAllAccounts().get(exampleBank.getActiveUser()).deposit(exampleBank, Double.parseDouble(input[1]));
                        }
                        else {
                            System.out.println("You don't have permission for this operation");
                        }}
                        catch (Exception e){
                        System.out.println("Invalid keyword sequence!");
                    }
                    break;
                case "withdraw":
                    try{
                        if(exampleBank.getActiveUserType() == null){
                            System.out.println("Open user account before proceeding!");
                        }
                    else if(exampleBank.getActiveUserType().equalsIgnoreCase("user")){
                        exampleBank.getAllAccounts().get(exampleBank.getActiveUser()).withdraw(exampleBank, Double.parseDouble(input[1]));
                    }else {
                        System.out.println("You don't have permission for this operation");
                    }} catch (ArrayIndexOutOfBoundsException a){
                        System.out.println("Invalid keyword sequence!");
                    }
                    break;
                case "query":
                    try{
                        if(exampleBank.getActiveUserType() == null){
                            System.out.println("Open user account before proceeding!");
                        }
                    else if(exampleBank.getActiveUserType().equalsIgnoreCase("user")){
                        exampleBank.getAllAccounts().get(exampleBank.getActiveUser()).checkBalanceLoan();
                    }} catch (Exception e){
                        System.out.println("Invalid keyword sequence!");
                    }
                    break;
                case "request":
                    try{
                        if(exampleBank.getActiveUserType() == null){
                            System.out.println("Open user account before proceeding!");
                        }
                    else if(exampleBank.getActiveUserType().equalsIgnoreCase("user")){
                        exampleBank.getLoanQueue().add(exampleBank.getAllAccounts().get(exampleBank.getActiveUser()).requestLoan(Double.parseDouble(input[1])));
                    } else {
                        System.out.println("You don't have permission for this operation");
                    }} catch (Exception e){
                        System.out.println("Invalid keyword sequence!");
                    }
                    break;
                case "close":
                    try {
                        try {
                            if (exampleBank.getActiveUserType().equalsIgnoreCase("employee")) {
                                System.out.println("Operations for " + exampleBank.getActiveUser() + " closed");
                            } else
                                System.out.println("Transaction closed for " + exampleBank.getActiveUser());

                        } catch (NullPointerException n) {
                            System.out.println("No active account to operate on!");
                        }
                        // these might be needed to be handled from giving errors
                        exampleBank.setActiveUser(null);
                        exampleBank.setActiveUserType(null);
                    } catch (Exception e){
                        System.out.println("Invalid keyword sequence!");
                    }
                    break;
                case "open":
                    try{
                        if(exampleBank.getActiveUserType() != null){
                            System.out.println("Close the account before proceeding!");
                        }
                    else if(! (exampleBank.getAllEmployees().containsKey(input[1]) || exampleBank.getAllAccounts().containsKey(input[1]))){
                        System.out.println("This user doesn't exist!");
                    } else {
                        exampleBank.setActiveUser(input[1]);
                        if (exampleBank.getAllEmployees().containsKey(input[1])){
                            exampleBank.setActiveUserType(exampleBank.getAllEmployees().get(input[1]).getEmployeeType());
                        } else{
                            exampleBank.setActiveUserType(exampleBank.getAllAccounts().get(input[1]).getAccountType());
                        }
                        exampleBank.activationStatus();
                    }}catch (Exception e){
                        System.out.println("Invalid keyword sequence!");
                    }
                    break;
                case "approve":
                    try{
                        if(exampleBank.getActiveUserType() == null){
                            System.out.println("Open employee account before proceeding!");
                        }
                    else if(input[1].equalsIgnoreCase("loan")){
                        if(exampleBank.getActiveUserType().equalsIgnoreCase("employee")){
                            exampleBank.getAllEmployees().get(exampleBank.getActiveUser()).approve(exampleBank);
                        } else {
                            System.out.println("You don't have permission for this operation");
                        }
                    } else {
                        System.out.println("Wrong keywords given. Try again!");
                    }} catch (Exception e){
                        System.out.println("Invalid keyword sequence!");
                    }
                    break;
                case "change":
                    try {
                        if(exampleBank.getActiveUserType() == null){
                            System.out.println("Open employee account before proceeding!");
                        }
                        else if (exampleBank.getActiveUserType().equalsIgnoreCase("employee")) {
                            exampleBank.getAllEmployees().get(exampleBank.getActiveUser()).changeInterestRate(exampleBank, input[1], Double.parseDouble(input[2]));
                        } else
                            System.out.println("You don't have permission for this operation");
                    } catch (Exception e){
                        System.out.println("Invalid keyword sequence!");
                    }
                    break;
                case "lookup":
                    try {
                        if(exampleBank.getActiveUserType() == null){
                            System.out.println("Open employee account before proceeding!");
                        }
                        else if (exampleBank.getActiveUserType().equalsIgnoreCase("employee")) {
                            exampleBank.getAllEmployees().get(exampleBank.getActiveUser()).lookup(exampleBank, input[1]);
                        } else
                            System.out.println("You don't have permission for this operation");
                    } catch (Exception e){
                        System.out.println("Invalid keyword sequence!");
                    }
                    break;
                case "see":
                    try {
                        if(exampleBank.getActiveUserType() == null){
                            System.out.println("Open employee account before proceeding!");
                        }
                        else if (exampleBank.getActiveUserType().equalsIgnoreCase("employee")) {
                            exampleBank.getAllEmployees().get(exampleBank.getActiveUser()).seeInternalFund(exampleBank);
                        } else
                            System.out.println("You don't have permission for this operation");

                    } catch (Exception e){
                        System.out.println("Invalid keyword sequence!");
                    }
                    break;
                case "inc":
                    try {
                        if(exampleBank.getActiveUserType() != null){
                            System.out.println("Close the account before proceeding!");
                        }else
                            exampleBank.incrementYear();
                    }catch (Exception e){
                        System.out.println("Invalid keyword sequence!");
                    }
                    break;
                default:
                    System.out.println("Invalid keyword!");
            }
        }
    }
}
