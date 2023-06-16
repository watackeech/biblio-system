package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOs.BookDAO;
import DAOs.ConnectionManager;

/**
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet("/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		String barcodeId = "1000";
		ConnectionManager connectionManager = new ConnectionManager();
		Connection con = null;

		try {
			con = connectionManager.getConnection();
			con.setAutoCommit(false);
			BookDAO dao = new BookDAO(con);

				System.out.println("返却！！");
				dao.returnByBarcodeId(barcodeId);
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
