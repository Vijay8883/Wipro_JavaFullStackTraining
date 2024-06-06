  
package DAY23Assignments;
class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized method to deposit money
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", Balance: " + balance);
    }

    // Synchronized method to withdraw money
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", Balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal of: " + amount);
        }
    }

    // Getter method for balance
    public synchronized int getBalance() {
        return balance;
    }
}

public class AccountThreadSimulator {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance of 1000

        // Deposit thread
        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                account.deposit(100);
            }
        });

        // Withdrawal thread
        Thread withdrawalThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                account.withdraw(50);
            }
        });

        depositThread.start();
        withdrawalThread.start();

        try {
            depositThread.join();
            withdrawalThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}