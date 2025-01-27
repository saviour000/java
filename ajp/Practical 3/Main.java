import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Main {

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/java?useSSL=false";
    private static final String DB_USERNAME = "root"; // Default username in XAMPP MySQL
    private static final String DB_PASSWORD = "";     // Default password is empty in XAMPP MySQL

    public static void main(String[] args) {
        // Start the registration form
        showRegistrationForm();
    }

    // Function to show the registration form
    private static void showRegistrationForm() {
        JFrame frame = new JFrame("User Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2));

        // Name
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        // Birthdate
        JLabel birthdateLabel = new JLabel("Birthdate (YYYY-MM-DD):");
        JTextField birthdateField = new JTextField();

        // Email
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        // Phone number
        JLabel phoneLabel = new JLabel("Phone No:");
        JTextField phoneField = new JTextField();

        // Submit Button
        JButton submitButton = new JButton("Submit");

        // Show user data Button
        JButton showUserDataButton = new JButton("Show User Data");

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(birthdateLabel);
        frame.add(birthdateField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(phoneLabel);
        frame.add(phoneField);
        frame.add(submitButton);
        frame.add(showUserDataButton);

        // Action listener for the submit button
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String birthdate = birthdateField.getText();
            String email = emailField.getText();
            String phoneNo = phoneField.getText();

            if (name.isEmpty() || birthdate.isEmpty() || email.isEmpty() || phoneNo.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields!");
            } else {
                // Insert user data into the database
                insertUserData(name, birthdate, email, phoneNo);
                JOptionPane.showMessageDialog(frame, "User registered successfully!");
                // Show the user data form after registration
                showUserDataForm();
                frame.dispose(); // Close the registration form
            }
        });

        // Action listener for showing user data form
        showUserDataButton.addActionListener(e -> {
            showUserDataForm();
            frame.dispose(); // Close the registration form
        });

        frame.setVisible(true);
    }

    // Function to insert user data into the database
    private static void insertUserData(String name, String birthdate, String email, String phoneNo) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String insertSQL = "INSERT INTO users (name, birthdate, email, phone_no) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, name);
            pstmt.setString(2, birthdate);
            pstmt.setString(3, email);
            pstmt.setString(4, phoneNo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Function to show the user data form (table displaying data)
    private static void showUserDataForm() {
        JFrame frame = new JFrame("User Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Table to display user data
        String[] columnNames = {"Name", "Birthdate", "Email", "Phone No"};
        Object[][] data = fetchUserData();
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        // Back Button
        JButton backButton = new JButton("Back to Registration");
        backButton.addActionListener(e -> {
            showRegistrationForm();
            frame.dispose(); // Close the user data form
        });

        frame.add(backButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    // Function to fetch user data from the database
// Function to fetch user data from the database
    private static Object[][] fetchUserData() {
        Object[][] data = new Object[0][0]; // Default to empty data if an error occurs
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String selectSQL = "SELECT name, birthdate, email, phone_no FROM users";

            // Create the statement with TYPE_SCROLL_INSENSITIVE to allow rs.last() and rs.beforeFirst()
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(selectSQL);

            // Check if ResultSet contains data
            if (!rs.next()) {
                System.out.println("No user data found in the database.");
                return data;  // Return empty data if no records found
            }

            // Reset cursor and calculate the row count
            rs.last(); // Move the cursor to the last row to get the row count
            int rowCount = rs.getRow();  // Get the number of rows
            rs.beforeFirst();  // Reset cursor to the beginning

            // Prepare data for the table
            data = new Object[rowCount][4];
            int row = 0;
            while (rs.next()) {
                data[row][0] = rs.getString("name");
                data[row][1] = rs.getString("birthdate");
                data[row][2] = rs.getString("email");
                data[row][3] = rs.getString("phone_no");
                row++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }



    // Function to create the database table (if not already created)
    private static void createDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255), " +
                    "birthdate DATE, " +
                    "email VARCHAR(255), " +
                    "phone_no VARCHAR(15))";
            Statement stmt = conn.createStatement();
            stmt.execute(createTableSQL);
            System.out.println("Table created or already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Static block to create the database and table if necessary
    static {
        createDatabase(); // Ensure table exists at the start
    }
}
