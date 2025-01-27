import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/UserDB"; // Your MySQL DB URL
            String dbUser = "root"; // DB username
            String dbPassword = ""; // DB password (leave empty if not set)

            // Establish connection to the database
            conn = DriverManager.getConnection(url, dbUser, dbPassword);

            // Query to check if username and password exist in the database
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            // Execute the query
            rs = ps.executeQuery();

            if (rs.next()) {
                // If valid user, redirect to the welcome page
                HttpSession session = request.getSession();
                session.setAttribute("username", username); // Store username in session
                response.sendRedirect("welcome.jsp");
            } else {
                // If invalid user, redirect to the error page
                response.sendRedirect("error.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
