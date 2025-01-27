import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class BankServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Assuming the account number and initial balance are pre-set
        BankAccount account = new BankAccount("123456", 000.0);

        // Set the account object in the request scope for use in JSP
        request.setAttribute("account", account);

        // Forward to the JSP page to display account details
        RequestDispatcher dispatcher = request.getRequestDispatcher("bankAccount.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Assuming the account object is stored in the session
        HttpSession session = request.getSession();
        BankAccount account = (BankAccount) session.getAttribute("account");

        if (account == null) {
            // Initialize a new account if it's not in the session
            account = new BankAccount("123456", 1000.0);
            session.setAttribute("account", account);
        }

        // Get the deposit and withdraw amounts from the request
        double depositAmount = Double.parseDouble(request.getParameter("deposit"));
        double withdrawAmount = Double.parseDouble(request.getParameter("withdraw"));

        // Perform deposit and withdrawal operations
        if (depositAmount > 0) {
            account.deposit(depositAmount);
        }

        if (withdrawAmount > 0) {
            boolean success = account.withdraw(withdrawAmount);
            if (!success) {
                request.setAttribute("error", "Insufficient funds for withdrawal.");
            }
        }

        // Set updated account in the request scope
        request.setAttribute("account", account);

        // Forward the request to the JSP page to display the updated account
        RequestDispatcher dispatcher = request.getRequestDispatcher("bankAccount.jsp");
        dispatcher.forward(request, response);
    }
}
