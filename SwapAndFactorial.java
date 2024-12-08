import java.util.Scanner;

public class SwapAndFactorial {
    // Method to swap two numbers without using a third variable
    public static void swap(int a, int b) {
        System.out.println("Before swapping: a = " + a + ", b = " + b);
        // Swapping logic
        a = a + b; // a now contains the sum of both
        b = a - b; // b is now the original value of a
        a = a - b; // a is now the original value of b
        System.out.println("After swapping: a = " + a + ", b = " + b);
    }

    // Method to calculate factorial
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input for swapping
        System.out.print("Enter first number (a): ");
        int a = scanner.nextInt();
        System.out.print("Enter second number (b): ");
        int b = scanner.nextInt();
        // Perform swapping
        swap(a, b);
        // Input for factorial calculation
        System.out.print("Enter a number to calculate factorial: ");
        int number = scanner.nextInt();
        // Calculate and print factorial
        int fact = factorial(number);
        System.out.println("Factorial of " + number + " is: " + fact);
        scanner.close();
    }
}