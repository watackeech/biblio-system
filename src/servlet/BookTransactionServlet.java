package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTOs.User;

/**
 * Servlet implementation class BookTransactionServlet
 */
@WebServlet("/book-transaction")
public class BookTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("loggedIn") == null || session.getAttribute("loginUser") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login-register.jsp");
			dispatcher.forward(request, response);
		}
		User loginUser = (User) session.getAttribute("loginUser");
		String status = loginUser.getStatus();
		System.out.println(status);
		if(status.equals("super")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/book-transaction.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/top.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
