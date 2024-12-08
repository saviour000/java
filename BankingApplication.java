class JointAccount {
    private double balance;

    public JointAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized method to deposit money
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited: $" + amount);
            System.out.println("New Balance after deposit: $" + balance);
            notify(); // Notify any waiting threads
        } else {
            System.out.println("Invalid deposit amount by " + Thread.currentThread().getName());
        }
    }

    // Synchronized method to withdraw money
    public synchronized void withdraw(double amount) {
        while (amount > balance) {
            System.out.println(
                    Thread.currentThread().getName() + " tried to withdraw: $" + amount + " (Insufficient balance)");
            try {
                wait(); // Wait until enough balance is available
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        if (amount > 0) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: $" + amount);
            System.out.println("New Balance after withdrawal: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount by " + Thread.currentThread().getName());
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Runnable for performing deposit tasks
class DepositTask implements Runnable {
    private JointAccount account;
    private double amount;

    public DepositTask(JointAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.deposit(amount);
    }
}

// Runnable for performing withdrawal tasks
class WithdrawalTask implements Runnable {
    private JointAccount account;
    private double amount;

    public WithdrawalTask(JointAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}

public class BankingApplication {
    public static void main(String[] args) {
        JointAccount jointAccount = new JointAccount(1000); // Starting balance of $1000
        // Create deposit and withdrawal tasks
        Thread depositThread1 = new Thread(new DepositTask(jointAccount, 500), "Deposit Thread-1");
        Thread withdrawThread1 = new Thread(new WithdrawalTask(jointAccount, 700), "Withdraw Thread-1");
        Thread withdrawThread2 = new Thread(new WithdrawalTask(jointAccount, 900), "Withdraw Thread-2");
        Thread depositThread2 = new Thread(new DepositTask(jointAccount, 300), "Deposit Thread-2");
        // Start the threads
        depositThread1.start();
        withdrawThread1.start();
        withdrawThread2.start();
        depositThread2.start();
    }
}