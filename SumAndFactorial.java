class SumThread extends Thread {
    private int number;
    private int sum = 0;

    public SumThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= number; i++) {
            sum += i;
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds to simulate delay
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Sum of numbers up to " + number + " is: " + sum);
    }
}

class FactorialThread extends Thread {
    private int number;
    private long factorial = 1;

    public FactorialThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= number; i++) {
            factorial *= i;
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds to simulate delay
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}

public class SumAndFactorial {
    public static void main(String[] args) {
        int number = 5; // Example number for calculation
        // Create and start threads
        SumThread sumThread = new SumThread(number);
        FactorialThread factorialThread = new FactorialThread(number);
        sumThread.start();
        factorialThread.start();
        try {
            // Wait for both threads to finish
            sumThread.join();
            factorialThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Calculations completed.");
    }
}