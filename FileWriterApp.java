import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileWriterApp extends JFrame implements ActionListener {
    private JTextField fileNameField;
    private JTextArea textArea;
    private JButton saveButton;

    public FileWriterApp() {
        // Set up the frame
        setTitle("Text Area to File");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Top panel for file name input
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel("File Name: "), BorderLayout.WEST);
        fileNameField = new JTextField();
        topPanel.add(fileNameField, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);
        // Text area for content input
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        // Bottom panel for save button
        JPanel bottomPanel = new JPanel();
        saveButton = new JButton("Save to File");
        saveButton.addActionListener(this);
        bottomPanel.add(saveButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String fileName = fileNameField.getText().trim();
            String content = textArea.getText();
            if (fileName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a file name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(content);
                JOptionPane.showMessageDialog(this, "File saved successfully.", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FileWriterApp app = new FileWriterApp();
            app.setVisible(true);
        });
    }
}