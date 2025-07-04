// BankManagement class

import java.util.HashMap;
import java.util.Scanner;


class BankManagement 
{
    private HashMap<String, BankAccount> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void createAccount() 
    {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();

        if (accounts.containsKey(accNo)) 
        {
            System.out.println("Account with this number already exists.");
        } 
        else 
        {
            BankAccount account = new BankAccount(accNo, name);
            accounts.put(accNo, account);
            System.out.println("Account created successfully.");
        }
    }

    public BankAccount getAccount(String accNo) 
    {
        return accounts.get(accNo);
    }
}
