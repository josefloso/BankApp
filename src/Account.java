/**
 *
 * @author Josef
 */
public class Account {
    private double balance = 0;
    private double interest = 0.02;
    private int accountNumber;
    private static int numberOfAccounts = 1000001;
    
    Account(){
    
        accountNumber = numberOfAccounts++;
    
    }
    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the interest
     */
    public double getInterest() {
        return interest * 100;
    }

    /**
     * @param interest the interest to set
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }

    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    public void withdraw (double amount) {
     if(amount + 500 > balance){
         System.out.println("You have insufficient funds");
         return;
     }
        balance -= amount + 500;
        checkInterest(0);
        System.out.println("You have withdrawn" + amount + "shillings and incurred a fee of ksh 500");
        System.out.println("You now hava a balance of :" + balance );
    }   
    
    public void deposit (double amount) {
        if(amount <= 0){
         System.out.println("You cannot deposit negative money");
         return;
     }
    checkInterest(amount);
        amount = amount + amount * interest;
        balance += amount;
        System.out.println("You have deposited" + amount + "shillings with an interest rate of " + (interest * 100) + "%");
        System.out.println("You now hava a balance of :" + balance );
        
    }  
    
    public void checkInterest(double amount){
     if(balance + amount > 1000){
         interest = 0.05;         
     }
     
     else{
         interest = 0.02;
     }
    }
    
}
