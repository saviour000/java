// Base class (Superclass)
class SuperClass {
    // Declare an integer variable x in the superclass
    int x = 10;

    // Method to display the value of x in the superclass
    void show() {
        System.out.println("Value of x in SuperClass: " + x);
    }
}

// Subclass that extends the SuperClass
class SubClass extends SuperClass {
    // Declare an integer variable x in the subclass
    int x = 20;

    // Method to display the value of x in the subclass
    @Override
    void show() {
        // Display value of x in SuperClass
        super.show();
        // Display value of x in SubClass
        System.out.println("Value of x in SubClass: " + x);
    }
}

// Main class to test the program
public class Main {
    public static void main(String[] args) {
        // Create an object of SubClass
        SubClass obj = new SubClass();
        // Call the show() method to display values of x
        obj.show();
    }
}