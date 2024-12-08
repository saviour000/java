import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListToArrayExample {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        // Add elements to the ArrayList
        System.out.println("Enter numbers to add to the ArrayList (type 'done' to finish):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int number = Integer.parseInt(input);
                arrayList.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
            }
        }
        // Convert ArrayList to an array
        Integer[] array = arrayList.toArray(new Integer[0]);
        // Display contents and calculate sum
        int sum = 0;
        System.out.print("Array contents: ");
        for (int num : array) {
            System.out.print(num + " ");
            sum += num;
        }
        System.out.println("\nSum of elements: " + sum);
        scanner.close();
    }
}