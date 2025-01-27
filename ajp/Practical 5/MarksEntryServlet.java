import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class MarksEntryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the session object
        HttpSession session = request.getSession();

        // Retrieve student data from session
        String name = (String) session.getAttribute("name");
        out.println("<html><body>");
        out.println("<h3>Welcome, " + name + "!</h3>");
        out.println("<h3>Enter your marks for 6 subjects:</h3>");
        out.println("<form action='ResultServlet' method='POST'>");
        for (int i = 1; i <= 6; i++) {
            out.println("Subject " + i + ": <input type='number' name='subject" + i + "' required><br>");
        }
        out.println("<input type='submit' value='Generate Result'/>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the session object
        HttpSession session = request.getSession();

        // Store personal data in session
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String department = request.getParameter("department");

        session.setAttribute("name", name);
        session.setAttribute("id", id);
        session.setAttribute("department", department);

        // Redirect to Marks Entry page
        response.sendRedirect("MarksEntryServlet");
    }
}
