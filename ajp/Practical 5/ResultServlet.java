import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the session object
        HttpSession session = request.getSession();

        // Retrieve student data from session
        String name = (String) session.getAttribute("name");
        String id = (String) session.getAttribute("id");
        String department = (String) session.getAttribute("department");

        // Retrieve marks from the request
        int[] marks = new int[6];
        for (int i = 1; i <= 6; i++) {
            marks[i - 1] = Integer.parseInt(request.getParameter("subject" + i));
        }

        // Calculate total marks and result
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        // Assuming passing criteria is 40 marks in each subject and 200 total marks
        boolean isPass = true;
        for (int mark : marks) {
            if (mark < 40) {
                isPass = false;
                break;
            }
        }

        // Generate result (pass/fail)
        String result = isPass ? "Pass" : "Fail";
        String resultColor = isPass ? "green" : "red";

        // Display result
        out.println("<html><body>");
        out.println("<h3>Welcome, " + name + "!</h3>");
        out.println("<h3>Student ID: " + id + "</h3>");
        out.println("<h3>Department: " + department + "</h3>");
        out.println("<h3>Total Marks: " + totalMarks + "/600</h3>");
        out.println("<h3 style='color:" + resultColor + ";'>Result: " + result + "</h3>");
        out.println("</body></html>");
    }
}
