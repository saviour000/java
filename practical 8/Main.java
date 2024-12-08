// Interface defining common methods for all shapes
interface Shape {
    double calculateArea();

    double calculateCircumference();

    double calculateVolume();
}

// Abstract class for two-dimensional shapes
abstract class TwoDimensionalShape implements Shape {
    @Override
    public double calculateVolume() {
        // Two-dimensional shapes do not have volume
        return 0;
    }
}

// Final class for Circle (2D shape)
final class Circle extends TwoDimensionalShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
}

// Final class for Sphere (3D shape)
final class Sphere implements Shape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double calculateCircumference() {
        // Circumference is usually not defined for 3D shapes
        // Returning the circumference of a great circle (circle on the sphere's
        // surface)
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateVolume() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }
}

// Final class for Rectangle (2D shape)
final class Rectangle extends TwoDimensionalShape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculateCircumference() {
        return 2 * (length + width);
    }
}

// Main class to test the application
public class Main {
    public static void main(String[] args) {
        // Creating objects for Circle, Sphere, and Rectangle
        Circle circle = new Circle(5);
        Sphere sphere = new Sphere(5);
        Rectangle rectangle = new Rectangle(4, 6);
        // Displaying results for Circle
        System.out.println("Circle:");
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Circumference: " + circle.calculateCircumference());
        System.out.println("Volume: " + circle.calculateVolume());
        // Displaying results for Sphere
        System.out.println("\nSphere:");
        System.out.println("Area: " + sphere.calculateArea());
        System.out.println("Circumference: " + sphere.calculateCircumference());
        System.out.println("Volume: " + sphere.calculateVolume());
        // Displaying results for Rectangle
        System.out.println("\nRectangle:");
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Circumference: " + rectangle.calculateCircumference());
        System.out.println("Volume: " + rectangle.calculateVolume());
    }
}
