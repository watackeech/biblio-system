package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOs.BookMasterDAO;
import DAOs.ConnectionManager;
import DTOs.BookMaster;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/update-book")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		response.setContentType("text/html;charset=UTF-8");
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection con = connectionManager.getConnection();
			BookMasterDAO dao = new BookMasterDAO(con);
			BookMaster book = new BookMaster();
			book = dao.selectByISBN(bookId);
			request.setAttribute("book", book);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectionManager.closeConnection();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/update-book.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
