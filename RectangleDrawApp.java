import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RectangleDrawApp extends JFrame implements MouseListener, MouseMotionListener {
    private int startX, startY, currentX, currentY;
    private boolean dragging;

    // Constructor to setup the JFrame
    public RectangleDrawApp() {
        setTitle("Rectangle Drawer");
        setSize(500, 500); // Set the size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on screen

        // Create a JPanel to draw on
        DrawPanel panel = new DrawPanel();
        add(panel);

        // Add mouse listeners
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
    }

    // Panel class for drawing the rectangle
    class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the rectangle only when dragging
            if (dragging) {
                int x = Math.min(startX, currentX);
                int y = Math.min(startY, currentY);
                int width = Math.abs(currentX - startX);
                int height = Math.abs(currentY - startY);
                g.setColor(Color.BLUE);
                g.drawRect(x, y, width, height);
            }
        }
    }

    // MouseListener methods
    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
        dragging = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        dragging = false;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    // MouseMotionListener methods
    @Override
    public void mouseDragged(MouseEvent e) {
        currentX = e.getX();
        currentY = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the frame and make it visible
            new RectangleDrawApp().setVisible(true);
        });
    }
}
