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
import DTOs.User;

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
		HttpSession session = request.getSession();
		//sessionにログイン情報がない場合→ログインページにリダイレクト
		if (session.getAttribute("loggedIn") == null || session.getAttribute("loginUser") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login-register.jsp");
			dispatcher.forward(request, response);
		}
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

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		con = connectionManager.getConnection();
		BookDAO dao = new BookDAO(con);
		try {
			if (dao.checkStockByBarcodeId(barcodeId)) { //ストックが>0なら処理開始！
				try {
					con.setAutoCommit(false);
					System.out.println("貸出！！");
					dao.lendByBarcodeId(barcodeId);

					Record record = new Record();
					record.setUserId(loginUser.getStudentId());
					record.setBarcodeId(barcodeId);
					record.setStartDate(new Date());
					System.out.println(record.getStartDate());
					RecordDAO recordDao = new RecordDAO(con);

					recordDao.addRecord(record);
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
			} else {
				System.out.println("在庫はないはずです！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
