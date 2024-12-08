import java.util.Scanner;

public class DivisionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Prompt user to enter two integers
            System.out.print("Enter the first integer: ");
            String input1 = scanner.nextLine();
            System.out.print("Enter the second integer: ");
            String input2 = scanner.nextLine();
            // Convert the inputs to integers
            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);
            // Perform the division
            int result = num1 / num2;
            // Display the result
            System.out.println("Result: " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Not enough input arguments.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter valid integers.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception e) {
            System.out.println("Error: An unexpected exception occurred.");
        } finally {
            scanner.close();
        }
    }
}