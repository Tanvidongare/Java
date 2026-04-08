import java.io.*;
import java.util.*;

// User-defined Exceptions
class MinimumBalanceException extends Exception {
    MinimumBalanceException(String msg) {
        super(msg);
    }
}

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class InvalidCIDException extends Exception {
    InvalidCIDException(String msg) {
        super(msg);
    }
}

class NegativeAmountException extends Exception {
    NegativeAmountException(String msg) {
        super(msg);
    }
}

// Customer Class
class Customer {
    int cid;
    String cname;
    double amount;

    Customer(int cid, String cname, double amount) {
        this.cid = cid;
        this.cname = cname;
        this.amount = amount;
    }

    public String toString() {
        return cid + " " + cname + " " + amount;
    }
}

public class BankingSystem {
    static ArrayList<Customer> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Create Account
    static void createAccount() {
        try {
            System.out.print("Enter CID (1-20): ");
            int cid = sc.nextInt();
            if (cid < 1 || cid > 20)
                throw new InvalidCIDException("CID must be between 1 and 20");

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();
            if (amt < 0)
                throw new NegativeAmountException("Amount must be positive");

            if (amt < 1000)
                throw new MinimumBalanceException("Minimum balance is 1000");

            list.add(new Customer(cid, name, amt));
            System.out.println("Account Created Successfully");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Withdraw
    static void withdraw() {
        try {
            System.out.print("Enter CID: ");
            int cid = sc.nextInt();

            Customer c = null;
            for (Customer cust : list) {
                if (cust.cid == cid) {
                    c = cust;
                    break;
                }
            }

            if (c == null) {
                System.out.println("Customer not found");
                return;
            }

            System.out.print("Enter Withdraw Amount: ");
            double wamt = sc.nextDouble();

            if (wamt < 0)
                throw new NegativeAmountException("Amount must be positive");

            if (wamt > c.amount)
                throw new InsufficientBalanceException("Insufficient balance");

            c.amount -= wamt;
            System.out.println("Withdrawal successful");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Display
    static void display() {
        for (Customer c : list) {
            System.out.println(c);
        }
    }

    // Save to File
    static void saveToFile() {
        try {
            FileWriter fw = new FileWriter("customers.txt");
            for (Customer c : list) {
                fw.write(c.toString() + "\n");
            }
            fw.close();
            System.out.println("Data saved to file");

        } catch (IOException e) {
            System.out.println("File Error");
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1. Create Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Display");
            System.out.println("4. Save to File");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    saveToFile();
                    break;
                case 5:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }
}