class CustomThread extends Thread {
    public CustomThread(String name) {
    super(name); // Set thread name
    }
    @Override
    public void run() {
    // Print the name and priority of the current thread
    System.out.println("Thread Name: " + getName() + ", Priority: " + getPriority());
    }
    }
    public class MultiThreadExample {
    public static void main(String[] args) {
    // Create threads
    CustomThread thread1 = new CustomThread("Thread-1");
    CustomThread thread2 = new CustomThread("Thread-2");
    CustomThread thread3 = new CustomThread("Thread-3");
    // Set thread priorities
    thread1.setPriority(Thread.MIN_PRIORITY); // Lowest priority (1)
    thread2.setPriority(Thread.NORM_PRIORITY); // Normal priority (5)
    thread3.setPriority(Thread.MAX_PRIORITY); // Highest priority (10)
    // Start the threads
    thread1.start();
    thread2.start();
    thread3.start();
    }
    }