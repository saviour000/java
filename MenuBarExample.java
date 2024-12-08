import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarExample extends JFrame {
    public MenuBarExample() {
        setTitle("Menu Bar Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        // File Menu
        JMenu fileMenu = new JMenu("File");
        // File menu items
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem closeItem = new JMenuItem("Close");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save As");
        JMenuItem printItem = new JMenuItem("Print");
        // Adding items to File menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(closeItem);
        fileMenu.addSeparator(); // Separator
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator(); // Another Separator
        fileMenu.add(printItem);
        // Add File menu to the menu bar
        menuBar.add(fileMenu);
        // Edit Menu
        JMenu editMenu = new JMenu("Edit");
        // Radio button menu items for Edit menu
        JRadioButtonMenuItem lineItem = new JRadioButtonMenuItem("Line");
        JRadioButtonMenuItem rectangleItem = new JRadioButtonMenuItem("Rectangle");
        JRadioButtonMenuItem circleItem = new JRadioButtonMenuItem("Circle");
        // Group radio buttons so only one can be selected at a time
        ButtonGroup shapesGroup = new ButtonGroup();
        shapesGroup.add(lineItem);
        shapesGroup.add(rectangleItem);
        shapesGroup.add(circleItem);
        // Add radio button items to Edit menu
        editMenu.add(lineItem);
        editMenu.add(rectangleItem);
        editMenu.add(circleItem);
        editMenu.addSeparator(); // Separator
        // Checkbox menu items for colors
        JCheckBoxMenuItem redItem = new JCheckBoxMenuItem("Red");
        JCheckBoxMenuItem greenItem = new JCheckBoxMenuItem("Green");
        JCheckBoxMenuItem blueItem = new JCheckBoxMenuItem("Blue");
        // Add checkbox items to Edit menu
        editMenu.add(redItem);
        editMenu.add(greenItem);
        editMenu.add(blueItem);
        // Add Edit menu to the menu bar
        menuBar.add(editMenu);
        // Set the menu bar for the frame
        setJMenuBar(menuBar);
        // Action listeners for menu items
        newItem.addActionListener(new MenuActionListener("New selected"));
        openItem.addActionListener(new MenuActionListener("Open selected"));
        closeItem.addActionListener(new MenuActionListener("Close selected"));
        saveItem.addActionListener(new MenuActionListener("Save selected"));
        saveAsItem.addActionListener(new MenuActionListener("Save As selected"));
        printItem.addActionListener(new MenuActionListener("Print selected"));
        lineItem.addActionListener(new MenuActionListener("Line selected"));
        rectangleItem.addActionListener(new MenuActionListener("Rectangle selected"));
        circleItem.addActionListener(new MenuActionListener("Circle selected"));
        redItem.addActionListener(new MenuActionListener("Red color selected"));
        greenItem.addActionListener(new MenuActionListener("Green color selected"));
        blueItem.addActionListener(new MenuActionListener("Blue color selected"));
    }

    // Inner class for handling menu actions
    private class MenuActionListener implements ActionListener {
        private String message;

        public MenuActionListener(String message) {
            this.message = message;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuBarExample example = new MenuBarExample();
            example.setVisible(true);
        });
    }
}