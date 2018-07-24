
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josef
 */
public class Menu {
    //instance variable
    Scanner keyboard = new Scanner(System.in);
    Bank bank = new Bank();
    boolean exit;
    
public static void main(String[] args) {
        // TODO code application logic here
    Menu menu = new Menu();
    menu.runMenu();
    }
    
public void runMenu(){
    printHeader();
        while(! exit){
            printMenu();
            int choice = getInput();
            performAction(choice);
            
            
        }
}

    private void printHeader() {
        System.out.println(".............................");
        System.out.println("    Welcome to Loso's        ");
        System.out.println("    Awesome bank app         ");
        System.out.println(".............................");
    }

    private void printMenu() {
        System.out.println("Please make a selection: ");
        System.out.println("1) Create a new account");
        System.out.println("2) Make a deposit");
        System.out.println("3) Make a withdrawal");
        System.out.println("4) List account balance");
        System.out.println("0) exit");
        
    }

    private int getInput() {
        int choice = -1;
            do{
                System.out.print("Enter your choice :");
        try {
            choice = Integer.parseInt(keyboard.nextLine());
        }
        
        catch(NumberFormatException e){
            System.out.println("Invalid Selection, enter numbers only");
    }
        if (choice < 0 || choice  > 4 ){
          System.out.println("Choice outside the range, please choose again");
        }
      }while (choice < 0 || choice  > 4 );
            return choice;
            
    }
    

    private void performAction(int choice) {
        switch(choice) {
            case 0:
                    System.out.println("Thank you for using our application.");
                    System.exit(0);
                    break;
                
            case 1:
                 createAnAccount();
                break;
            case 2:
                 makeADeposit();
                break;
            case 3:
                makeAWithdrawal();
                break;
            case 4:
                listBalances();
                break;
            default:
                    System.out.println("Uknown error has occured.");
        
      }   
    }

    private void createAnAccount() {
        String firstName,lastName,nIDnumber,accountType = "";
        double initialDeposit = 0;
        boolean valid = false;
        while (!valid){
            System.out.print("Please enter an account type.(checking/savings) :");
            accountType = keyboard.nextLine();
            if (accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("savings")){ 
            
           valid = true;
           
            }
            else{
             System.out.println("Invalid account type selected. Please enter checking or savings)");

            }
        }
           System.out.print("Please enter your first name:");
           firstName = keyboard.nextLine();
           System.out.print("Please enter your last name:");
           lastName = keyboard.nextLine();
           System.out.print("Please enter your national Id number:");
           nIDnumber = keyboard.nextLine();
           valid = false;
           while(!valid ){
            System.out.print("Please enter your initial deposit:");
            try {
                initialDeposit = Double.parseDouble(keyboard.nextLine());
            
            }
           catch(NumberFormatException e){
           System.out.print("Deposit must be a number.");
           }
           if(accountType.equalsIgnoreCase("checking")){
               if(initialDeposit < 500){
               System.out.println("Checking accounts require a minimum of ksh500 to open.");
               }
               else {
               valid = true;
               
               }
           }
           else if(accountType.equalsIgnoreCase("savings")){
               if(initialDeposit < 1000){
               System.out.println("Checking accounts require a minimum of ksh1000 to open."); 
           
           }
               else { 
                    valid = true;   
                      }
               
           }
       }
        // we can create an account now:
           Account account;
           if(accountType.equalsIgnoreCase("checking")){
               account = new Checking(initialDeposit);
           }else {
               account = new Savings(initialDeposit); 

           }
           Customer customer = new  Customer(firstName, lastName, nIDnumber,account);
           bank.addCustomer(customer);
    }
        

    
    
    private void makeADeposit() {
        int account = selectAccount();
        if(account >= 0 ){
        System.out.print("How much would you like to deposit: ");
        double amount = 0;
        try {
            amount= Double.parseDouble(keyboard.nextLine());
            
        }
        catch (NumberFormatException e){
            amount = 0;
        }
        bank.getCustomer(account).getAccount().deposit(amount);
    }
   }
    private void makeAWithdrawal() {
        int account = selectAccount();
        if(account >= 0 ){
        System.out.print("How much would you like to withdraw: ");
        double amount = 0;
        try {
            amount= Double.parseDouble(keyboard.nextLine());
            
        }
        catch (NumberFormatException e){
            amount = 0;
        }
        bank.getCustomer(account).getAccount().withdraw(amount);
    }

    }

    private void listBalances() {
        int account = selectAccount();
        if(account >= 0 ){
        
        System.out.println(bank.getCustomer(account).getAccount());
        } 
    }

    private int selectAccount() {
        ArrayList<Customer> customers = bank.getCustomers();
        if (customers.size() <=0 ){
        System.out.println("No customers at your bank ");
        return -1;
        }
        System.out.println("Select an account: ");
        for(int i = 0; i < customers.size() ; i++ )
            System.out.println((i+1) + ")" + customers.get(i).basicInfo());
           
    int account = 0;
    System.out.print("Please enter your selection: ");
    try {
            account= Integer.parseInt(keyboard.nextLine()) -1;
            
        }
        catch (NumberFormatException e){
            account = -1;
        }
        if (account < 0 || account > customers.size()){
            System.out.print("Invalid account selected .");
            account = -1;
        }
        return account;
    }   
}


