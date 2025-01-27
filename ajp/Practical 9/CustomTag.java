import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class CustomTag extends SimpleTagSupport {

    private String numbers; // Comma-separated string of numbers
    private String order; // Sort order: "asc" or "desc"

    // Getter and setter methods for attributes
    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public void doTag() throws IOException {
        // Split the numbers string into an array
        String[] numArray = numbers.split(",");
        Integer[] intArray = new Integer[numArray.length];

        // Convert to Integer array
        for (int i = 0; i < numArray.length; i++) {
            intArray[i] = Integer.parseInt(numArray[i].trim());
        }

        // Sort the array based on the order
        if ("desc".equalsIgnoreCase(order)) {
            Arrays.sort(intArray, Collections.reverseOrder());
        } else {
            Arrays.sort(intArray);
        }

        // Output the sorted numbers
        getJspContext().getOut().write("Sorted Numbers: ");
        for (int num : intArray) {
            getJspContext().getOut().write(num + " ");
        }
    }
}
