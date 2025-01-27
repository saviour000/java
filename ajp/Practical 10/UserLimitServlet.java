import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserLimitServlet")
public class UserLimitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the application context
        Integer userCount = (Integer) getServletContext().getAttribute("userCount");

        // If user count is null, initialize it
        if (userCount == null) {
            userCount = 0;
        }

        // If user count exceeds 3, redirect to error page
        if (userCount >= 3) {
            response.sendRedirect("error.jsp");
            return;
        }

        // Increment user count
        userCount++;

        // Set the updated user count in the context
        getServletContext().setAttribute("userCount", userCount);

        // Display welcome page
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h3>Welcome! You are user number " + userCount + ".</h3>");
        response.getWriter().println("</body></html>");
    }

    @Override
    public void destroy() {
        // Reset the user count when the application is shut down
        getServletContext().removeAttribute("userCount");
    }
}
