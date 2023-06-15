package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			System.out.println(bookId);
			book = dao.selectByISBN(bookId);
			System.out.println(book.getAuthor());
			System.out.println(book.getTotalStock());
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
		response.setContentType("text/html;charset=UTF-8");
		ConnectionManager connectionManager = new ConnectionManager();

		String action = request.getParameter("action");
		System.out.println(action);
		HttpSession session = request.getSession();

		try {
			Connection con = connectionManager.getConnection();
			BookMasterDAO dao = new BookMasterDAO(con);
			String id = request.getParameter("id");
			System.out.println(id);
			BookMaster result = dao.selectByISBN(id);
			if (result == null) {
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				Integer publicationYear = Integer.parseInt(request.getParameter("publicationYear"));
				String description = request.getParameter("description");
				String image = request.getParameter("image");

				BookMaster newBookMaster = new BookMaster();
				newBookMaster.setId(id);
				newBookMaster.setTitle(title);
				newBookMaster.setAuthor(author);
				newBookMaster.setPublicationYear(publicationYear);
				newBookMaster.setDescription(description);
				newBookMaster.setImage(image);
				dao.insert(newBookMaster);
			} else {
				System.out.println("dao.addAnotherBook起動");
				dao.addAnotherBook(result); //既存の本だった場合、一冊追加する
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectionManager.closeConnection();
		}
	}

}
