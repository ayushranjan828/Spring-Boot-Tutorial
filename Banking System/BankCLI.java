

import java.util.Scanner;


public class BankCLI 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        BankManagement bank = new BankManagement();
        BankAccount currentAccount = null;

        while (true) 
        {
            System.out.println("\n------ BANK SYSTEM MENU ------");
            System.out.println("1. Create Account");
            System.out.println("2. Login to Account");
            System.out.println("3. Exit");
            System.out.print("Choose Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) 
            {
                case 1:
                    bank.createAccount();
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    String accNo = scanner.nextLine();
                    currentAccount = bank.getAccount(accNo);
                    if (currentAccount != null) 
                    {
                        userMenu(scanner, currentAccount);
                    } 
                    else 
                    {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the bank system.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void userMenu(Scanner scanner, BankAccount account) 
    {
        while (true) 
        {
            System.out.println("\n--- Welcome " + account.getName() + " ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Create Fixed Deposit");
            System.out.println("4. Show Account Details");
            System.out.println("5. Logout");
            System.out.print("Choose Option: ");
            int option = scanner.nextInt();

            switch (option) 
            {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    account.deposit(scanner.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    account.withdraw(scanner.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter amount for FD: ");
                    account.createFD(scanner.nextDouble());
                    break;
                case 4:
                    account.showDetails();
                    break;
                case 5:
                    System.out.println("Logged out.\n");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
