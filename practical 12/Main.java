import java.util.Iterator;
import java.util.LinkedList;

class Address {
    private String name;
    private String city;
    private String state;

    // Constructor
    public Address(String name, String city, String state) {
        this.name = name;
        this.city = city;
        this.state = state;
    }

    // toString method to display address information
    @Override
    public String toString() {
        return "Name: " + name + ", City: " + city + ", State: " + state;
    }
}

class Maillist {
    private LinkedList<Address> addressList;

    // Constructor
    public Maillist() {
        addressList = new LinkedList<>();
    }

    // Method to add address to the list
    public void addAddress(Address address) {
        addressList.add(address);
    }

    // Method to display all addresses using Iterator
    public void displayAddresses() {
        Iterator<Address> iterator = addressList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Maillist instance
        Maillist mailList = new Maillist();
        // Add Address objects to the Maillist
        mailList.addAddress(new Address("Alice Johnson", "New York", "NY"));
        mailList.addAddress(new Address("Bob Smith", "Los Angeles", "CA"));
        mailList.addAddress(new Address("Carol White", "Chicago", "IL"));
        // Display all addresses in the Maillist
        System.out.println("Mailing List:");
        mailList.displayAddresses();
    }
}
