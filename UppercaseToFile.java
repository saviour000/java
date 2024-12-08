// 1 code

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UppercaseToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Open a FileWriter to write to a file (output.txt)
            FileWriter writer = new FileWriter("output.txt", true); // 'true' allows appending to the file
            String input;
            System.out.println("Enter strings to convert to uppercase (type 'exit' to stop):");
            // Keep accepting strings until 'exit' is entered
            while (true) {
                System.out.print("Enter a string: ");
                input = scanner.nextLine();
                // Check for exit condition
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                // Convert the string to uppercase and write to the file
                writer.write(input.toUpperCase() + "\n");
            }
            // Close the file writer
            writer.close();
            System.out.println("Strings have been written to output.txt.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
