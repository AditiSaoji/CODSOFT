import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Rs." + amount + " successfully.");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn Rs." + amount + " successfully.");
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to ATM. Choose an option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void executeOption(int option) {
        switch (option) {
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Visit Again!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to withdraw:");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        account.withdraw(amount);
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to deposit:");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        account.deposit(amount);
    }

    public void checkBalance() {
        System.out.println("Your current balance is: Rs." + account.getBalance());
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000); 
        ATM atm = new ATM(bankAccount);
        Scanner sc = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            int option = sc.nextInt();
            atm.executeOption(option);
        }
    }
}