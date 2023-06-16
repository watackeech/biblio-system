package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOs.BookDAO;
import DAOs.ConnectionManager;

/**
 * Servlet implementation class LendBookServlet
 */
@WebServlet("/lend-book")
public class LendBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LendBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/lend-book.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String barcodeId = request.getParameter("barcodeId");
		System.out.println(barcodeId);
		ConnectionManager connectionManager = new ConnectionManager();
		Connection con = null;

		try {
			con = connectionManager.getConnection();
			con.setAutoCommit(false);
			BookDAO dao = new BookDAO(con);

			System.out.println("貸出！！");
			dao.lendByBarcodeId(barcodeId);
			con.commit();
			response.sendRedirect("search-books");
		} catch (Exception e) {
			e.printStackTrace();
			if (con != null) {
				try {
					con.rollback(); // ロールバック
					System.out.println("トランザクションをロールバックしました");
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		} finally {
			connectionManager.closeConnection();
		}
	}

}
