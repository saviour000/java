import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h3>A Data Driven Servlet Application</h3>");
        out.println("<form action='LoginServlet' method='POST'>");
        out.println("Username: <input type='text' name='username'><br>");
        out.println("Password: <input type='password' name='password'><br>");
        out.println("<input type='submit' value='Login'>");
        out.println("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get user credentials from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate credentials from database
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Connection URL for MySQL in XAMPP (localhost, port 3306)
            String url = "jdbc:mysql://localhost:3306/UserDB"; // Make sure to use the correct database name
            String dbUser = "root"; // Default MySQL user for XAMPP
            String dbPassword = ""; // Default MySQL password (empty by default in XAMPP)

            // Load MySQL JDBC driver (needed for MySQL connection)
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUser, dbPassword);

            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Successful login
                out.println("<h3>Welcome, " + username + "!</h3>");
            } else {
                // Invalid login
                out.println("<h3>Invalid username or password!</h3>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error occurred: " + e.getMessage() + "</h3>");
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
