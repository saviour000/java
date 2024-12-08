class Calculator {
    // Method to add two integers
    public int addfunc(int a, int b) {
        return a + b;
    }

    // Method to add two doubles
    public double addfunc(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        // Calling the method with integer parameters
        int sumInt = calc.addfunc(10, 20);
        System.out.println("Sum of integers: " + sumInt);
        // Calling the method with double parameters
        double sumDouble = calc.addfunc(10.5, 20.5);
        System.out.println("Sum of doubles: " + sumDouble);
    }
}