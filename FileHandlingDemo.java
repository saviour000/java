import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class FileHandlingDemo {
    // Method to write user input strings in uppercase to a file
    public static void writeUppercaseToFile(String filename) {
        try (Scanner scanner = new Scanner(System.in);
                FileWriter writer = new FileWriter(filename)) {
            System.out.println("Enter strings to store in file (type 'exit' to stop):");
            while (true) {
                String input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                writer.write(input.toUpperCase() + System.lineSeparator());
            }
            System.out.println("Strings written in uppercase to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to write a double value and date to a file
    public static void writeDoubleAndDateToFile(String filename, double value) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            Date date = new Date();
            writer.write("Double Value: " + value + System.lineSeparator());
            writer.write("Date of Execution: " + date.toString() + System.lineSeparator());
            System.out.println("Double value and date written to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to delete a file or directory
    public static void deleteFileOrDirectory(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        f.delete();
                    }
                }
            }
            if (file.delete()) {
                System.out.println("File/Directory deleted successfully: " + path);
            } else {
                System.out.println("Failed to delete file/directory: " + path);
            }
        } else {
            System.out.println("File/Directory does not exist: " + path);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Task 1: Write uppercase strings to file
        System.out.print("Enter the filename to store uppercase strings: ");
        String upperFilename = scanner.nextLine();
        writeUppercaseToFile(upperFilename);

        // Task 2: Write double and date to file
        System.out.print("Enter the filename to store double value and date: ");
        String doubleFilename = scanner.nextLine();
        System.out.print("Enter a double value to write to the file: ");
        double value = scanner.nextDouble();
        scanner.nextLine();
        writeDoubleAndDateToFile(doubleFilename, value);

        // Task 3: Delete a file or directory
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the path of the file/directory to delete: ");
        String deletePath = scanner.nextLine();
        deleteFileOrDirectory(deletePath);
        scanner.close();
    }
}