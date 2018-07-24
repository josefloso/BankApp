/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josef
 */
public class Customer {
    private final String firstName;
    private final String lastName;
    private final String nIDnumber;
    private final Account account;

    Customer(String firstName, String lastName, String nIDnumber, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nIDnumber= nIDnumber ;
        this.account = account;
    }
    @Override
    public String toString(){

    return "\n Customer information" + "\n" +
            "First name " + firstName + "\n" +
            "Last name " + lastName + "\n" + 
            "National ID number " + nIDnumber +
            account;
    }
    public String basicInfo(){
    return  " First name " + firstName +
            " Last name " + lastName + 
            " National ID number " + nIDnumber +
            " Account number:" + account.getAccountNumber();
}
    
    Account getAccount(){
        return account;
    }
}
