package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOs.ConnectionManager;
import DAOs.UsersDAO;
import DTOs.User;

/**
 * Servlet implementation class LoginRegisterServlet
 */
@WebServlet("/login-register")
public class LoginRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login-register.jsp");
		dispatcher.forward(request, response);
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
			UsersDAO dao = new UsersDAO(con);
			if (action != null && action.equals("register")) {
				String username = request.getParameter("regUsername");
				String studentId = request.getParameter("regStudentId");
				String password = request.getParameter("regPassword");

				User newUser = new User();
				newUser.setName(username);
				newUser.setStudentId(studentId);
				newUser.setPassword(password);

				dao.insert(newUser);
				System.out.println("登録完了！");
				session.setAttribute("loggedIn", true);
				session.setAttribute("loginUser", newUser);
			} else if (action != null && action.equals("login")) {
				String studentId = request.getParameter("studentId");
				String password = request.getParameter("password");
				User loginUser = dao.checkById(Integer.parseInt(studentId));
				System.out.println(loginUser.getPassword());
				System.out.println(password);
				if (password.equals(loginUser.getPassword())) {
					System.out.println("ログイン成功！");
					session.setAttribute("loggedIn", true);
					session.setAttribute("loginUser", loginUser);
				} else {
					System.out.println("ログイン失敗...");
				}

			} else {
				// 不正なリクエストまたは未指定の処理
				// エラーハンドリングなどを行う
				System.out.println("ログイン/登録の失敗...");
			}

			List<User> results = dao.getAll();
			System.out.println(results);
			request.setAttribute("results", results);
			if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
				//				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/top.jsp");
				System.out.println("top.jsへフォワード");
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/top.jsp");
//				dispatcher.forward(request, response);
				response.sendRedirect(request.getContextPath() + "/top");
			} else {
				System.out.println("login-register.jspへフォワード");
				request.setAttribute("errorMessage", "入力エラーがありました。もう一度入力してください。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login-register.jsp");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectionManager.closeConnection();
		}
	}

}
