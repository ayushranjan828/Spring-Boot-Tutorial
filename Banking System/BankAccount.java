import java.util.*;

class BankAccount 
{
    private String accountNumber;
    private String name;
    private double balance;
    private double fixedDeposit;

    public BankAccount(String accountNumber, String name) 
    {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = 0.0;
        this.fixedDeposit = 0.0;
    }

    public String getAccountNumber() 
    {
        return accountNumber;
    }

    public String getName() 
    {
        return name;
    }

    public void deposit(double amount)
     {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Deposited Rs." + amount);
        } 
        else 
        {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Withdrawn Rs." + amount);
        } 
        else 
        {
            System.out.println("Invalid or insufficient balance.");
        }
    }

    public void createFD(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            fixedDeposit += amount;
            System.out.println("Fixed Deposit created: Rs." + amount);
        } 
        else 
        {
            System.out.println("Invalid FD amount.");
        }
    }

    public double getAvailableBalance() 
    {
        return balance;
    }

    public double getTotalBalanceIncludingFD() 
    {
        return balance + fixedDeposit;
    }

    public void showDetails() 
    {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Available Balance: Rs." + balance);
        System.out.println("Fixed Deposit: Rs." + fixedDeposit);
        System.out.println("Total Balance: Rs." + getTotalBalanceIncludingFD());
    }
}
