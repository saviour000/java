import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

@WebServlet("/SortServlet")
public class SortServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numbers = request.getParameter("numbers"); // Get comma-separated numbers
        String order = request.getParameter("order"); // Get sort order

        String[] numArray = numbers.split(",");
        Integer[] intArray = new Integer[numArray.length];

        // Convert to Integer array
        for (int i = 0; i < numArray.length; i++) {
            intArray[i] = Integer.parseInt(numArray[i].trim());
        }

        // Sort the array based on order
        if ("desc".equalsIgnoreCase(order)) {
            Arrays.sort(intArray, Collections.reverseOrder());
        } else {
            Arrays.sort(intArray);
        }

        // Set response content type and display sorted numbers
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Sorted Numbers:</h2>");
        for (int num : intArray) {
            out.print(num + " ");
        }
        out.println("</body></html>");
    }
}
