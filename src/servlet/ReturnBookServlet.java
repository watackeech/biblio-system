package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOs.BookDAO;
import DAOs.ConnectionManager;
import DAOs.RecordDAO;
import DTOs.Record;

/**
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet("/return-book")
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//sessionにログイン情報がない場合→ログインページにリダイレクト
		if (session.getAttribute("loggedIn") == null || session.getAttribute("loginUser") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login-register.jsp");
			dispatcher.forward(request, response);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/return-book.jsp");
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
			BookDAO dao = new BookDAO(con);
			if(dao.checkBorrowedByBarcodeId(barcodeId)) {
				try {
					con = connectionManager.getConnection();
					con.setAutoCommit(false);

					System.out.println("返却！！");
					dao.returnByBarcodeId(barcodeId);
					RecordDAO recordDao = new RecordDAO(con);
					Record record = new Record();
					record.setBarcodeId(barcodeId);
					record.setEndDate(new Date());
					recordDao.closeRecord(record);
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
			}else {
				System.out.println("既に返却済みの本です");
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
