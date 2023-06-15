package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if(session == null) {
			session = request.getSession(true);
//			session.setAttribute("visited", "1");
		}else {
//			String visitedStr = (String)session.getAttribute("visited");
//			int visited = Integer.parseInt(visitedStr);
//			visited++;
//			session.setAttribute("visited", Integer.toString(visited));
		}


		session.setAttribute("userName", "なべちゃん");



		String p1 = request.getParameter("param1");
		String p2 = request.getParameter("param2");
		String p3 = request.getParameter("param3");
//				request.getParameter("param3");
		//演習-6で以下を追加
		//2.未入力(入力された値が"")の場合、/errorへリダイレクトする。
		if("".equals(p1) || "".equals(p2) || "".equals(p3)){
			response.sendRedirect("error");
			return;
		}
		//2.入力された値1、値2を加算する。
		int result = Integer.parseInt(p1) + Integer.parseInt(p2) + Integer.parseInt(p3);

		//3.リクエストに計算結果を設定する。
		request.setAttribute("result", result);

		//4.practice04_2.jspにフォワードする。
		RequestDispatcher dispatcher =
			request.getRequestDispatcher("jsp/menu.jsp");
		dispatcher.forward(request, response);
		return;
	}

}
