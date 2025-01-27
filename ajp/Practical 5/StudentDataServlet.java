import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class StudentDataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the session object
        HttpSession session = request.getSession();

        // Display the form to get student data
        out.println("<html><body>");
        out.println("<h3>Welcome, Please Enter Your Details</h3>");
        out.println("<form action='MarksEntryServlet' method='POST'>");
        out.println("Name: <input type='text' name='name' required><br>");
        out.println("ID: <input type='text' name='id' required><br>");
        out.println("Department: <input type='text' name='department' required><br>");
        out.println("<input type='submit' value='Next'/>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
