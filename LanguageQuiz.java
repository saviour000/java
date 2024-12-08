import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LanguageQuiz extends JFrame implements ActionListener {
    private JRadioButton cPlusPlusButton, javaButton, pascalButton;
    private ButtonGroup buttonGroup;
    private JLabel resultLabel;

    public LanguageQuiz() {
        // Set up the frame
        setTitle("OOP Language Quiz");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Create the question label
        JLabel questionLabel = new JLabel("Which of the following is NOT an OOP language?");
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(questionLabel, BorderLayout.NORTH);
        // Create the radio buttons
        cPlusPlusButton = new JRadioButton("C++");
        javaButton = new JRadioButton("Java");
        pascalButton = new JRadioButton("Pascal");
        // Group the radio buttons
        buttonGroup = new ButtonGroup();
        buttonGroup.add(cPlusPlusButton);
        buttonGroup.add(javaButton);
        buttonGroup.add(pascalButton);
        // Add the buttons to a panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(cPlusPlusButton);
        buttonPanel.add(javaButton);
        buttonPanel.add(pascalButton);
        add(buttonPanel, BorderLayout.CENTER);
        // Add action listeners to the buttons
        cPlusPlusButton.addActionListener(this);
        javaButton.addActionListener(this);
        pascalButton.addActionListener(this);
        // Create the result label
        resultLabel = new JLabel("", SwingConstants.CENTER);
        add(resultLabel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "";
        if (e.getSource() == cPlusPlusButton) {
            message = "Incorrect! C++ is an OOP language.";
        } else if (e.getSource() == javaButton) {
            message = "Incorrect! Java is an OOP language.";
        } else if (e.getSource() == pascalButton) {
            message = "Correct! Pascal is not an OOP language.";
        }
        resultLabel.setText(message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LanguageQuiz quiz = new LanguageQuiz();
            quiz.setVisible(true);
        });
    }
}