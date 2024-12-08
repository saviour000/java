import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp extends JFrame implements ActionListener {
    // Components
    private JTextField display;
    private double operand1, operand2, result;
    private String operator;

    public CalculatorApp() {
        // Set frame properties
        setTitle("Calculator");
        setLayout(new BorderLayout());
        setSize(400, 500); // Set size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display field
        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4)); // 5 rows, 4 columns

        // Button labels
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C" // Add 'C' button for clearing
        };

        // Create and add buttons
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        // Add the button panel to the frame
        add(buttonPanel, BorderLayout.CENTER);
    }

    // Action event handler for button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Handle numbers and decimal point
        if (command.matches("[0-9.]")) {
            display.setText(display.getText() + command);
        }
        // Handle clear command
        else if (command.equals("C")) {
            display.setText("");
            operand1 = operand2 = result = 0;
            operator = null;
        }
        // Handle arithmetic operations
        else if (command.equals("=")) {
            if (operator != null && !display.getText().isEmpty()) {
                operand2 = Double.parseDouble(display.getText());
                switch (operator) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        if (operand2 != 0) {
                            result = operand1 / operand2;
                        } else {
                            display.setText("Error");
                            return;
                        }
                        break;
                }
                display.setText(String.valueOf(result));
                operand1 = result; // Store result for future calculations
                operator = null; // Reset operator after calculation
            }
        }
        // Handle operator inputs
        else {
            if (!display.getText().isEmpty()) {
                operand1 = Double.parseDouble(display.getText());
                operator = command;
                display.setText(""); // Clear display for next input
            }
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        // Create the frame and set it visible
        CalculatorApp calculator = new CalculatorApp();
        calculator.setVisible(true);
    }
}
