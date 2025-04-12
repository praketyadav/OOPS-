import java.util.*;

abstract class Account {
    protected String accountNumber;
    protected String holderName;
    protected double balance;

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    
    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name  : " + holderName);
        System.out.println("Balance      : $" + balance);
    }
}

interface InterestBearing {
    void addInterest();
}

class SavingsAccount extends Account implements InterestBearing {
    private double interestRate = 0.03; // 3%

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " successfully.");
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " successfully.");
        }
    }

    public void addInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest of $" + interest + " added.");
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit = 500;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " successfully.");
    }

    public void withdraw(double amount) {
        if (amount > balance + overdraftLimit) {
            System.out.println("Overdraft limit exceeded!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " successfully.");
        }
    }
}

public class BankSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Bank Account System ---");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Display Account Info");
            System.out.println("6. Add Interest (Savings Only)");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> createAccount(true);
                case 2 -> createAccount(false);
                case 3 -> deposit();
                case 4 -> withdraw();
                case 5 -> displayAccount();
                case 6 -> applyInterest();
                case 7 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }

    private static void createAccount(boolean isSavings) {
        System.out.print("Enter account number: ");
        String accNo = scanner.next();
        System.out.print("Enter holder name: ");
        scanner.nextLine(); // clear buffer
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit: ");
        double deposit = scanner.nextDouble();

        Account acc = isSavings
            ? new SavingsAccount(accNo, name, deposit)
            : new CurrentAccount(accNo, name, deposit);

        accounts.put(accNo, acc);
        System.out.println((isSavings ? "Savings" : "Current") + " account created.");
    }

    private static void deposit() {
        Account acc = getAccount();
        if (acc != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            acc.deposit(amount);
        }
    }

    private static void withdraw() {
        Account acc = getAccount();
        if (acc != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            acc.withdraw(amount);
        }
    }

    private static void displayAccount() {
        Account acc = getAccount();
        if (acc != null) {
            acc.displayInfo();
        }
    }

    private static void applyInterest() {
        Account acc = getAccount();
        if (acc instanceof InterestBearing) {
            ((InterestBearing) acc).addInterest();
        } else {
            System.out.println("This account type does not earn interest.");
        }
    }

    private static Account getAccount() {
        System.out.print("Enter account number: ");
        String accNo = scanner.next();
        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found.");
        }
        return acc;
    }
}
