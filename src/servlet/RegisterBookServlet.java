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
 * Servlet implementation class RegisterBookServlet
 */
@WebServlet("/register-book")
public class RegisterBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		HttpSession session = request.getSession();
		//		boolean loggedIn = (boolean) session.getAttribute("loggedIn");
		//		User loginUser = (User) session.getAttribute("loginUser");
		//		String status = loginUser.getStatus();
		//		System.out.println(status);
		//		if(status.equals("super")) {
		if (true) {
			System.out.println("正常に読み込み完了！");
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/register-book.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/top.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPostの実行開始！");

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

			//				dao.insert(newBookMaster);
			//				System.out.println("登録完了！");
			//				String studentId = request.getParameter("studentId");
			//				String password = request.getParameter("password");
			//				User loginUser = dao.checkById(Integer.parseInt(studentId));
			//				System.out.println(loginUser.getPassword());
			//				System.out.println(loginUser.getStatus());
			//				System.out.println(password);
			//				if (password.equals(loginUser.getPassword())) {
			//					System.out.println("ログイン成功！");
			//					session.setAttribute("loggedIn", true);
			//					session.setAttribute("loginUser", loginUser);
			//				} else {
			//					System.out.println("ログイン失敗...");
			//				}

			//			if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			//				//				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/top.jsp");
			//				System.out.println("top.jsへフォワード");
			////				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/top.jsp");
			////				dispatcher.forward(request, response);
			//				response.sendRedirect(request.getContextPath() + "/top");
			//			} else {
			//				System.out.println("login-register.jspへフォワード");
			//				request.setAttribute("errorMessage", "入力エラーがありました。もう一度入力してください。");
			//				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login-register.jsp");
			//				dispatcher.forward(request, response);
			//			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectionManager.closeConnection();
		}
	}

}
