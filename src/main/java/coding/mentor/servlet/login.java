package coding.mentor.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.mentor.entity.Account;
import coding.mentor.service.AccountService;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			AccountService accountService = new AccountService();
			Account account = new Account();
			account = accountService.accountLogin(username, password);

			if (account == null) {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				request.setAttribute("errorMessage", "Login details are incorrect, please try again!");
				rd.forward(request, response);

			} else {
				HttpSession session = request.getSession(false);
				session.setAttribute("username", username);
				session.setAttribute("accountId", account.getId());
				RequestDispatcher rd = request.getRequestDispatcher("home");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
