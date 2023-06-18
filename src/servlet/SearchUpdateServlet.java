package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
import DTOs.User;

/**
 * Servlet implementation class SearchUpdateServlet
 */
@WebServlet("/search-update")
public class SearchUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//sessionにログイン情報がない場合→ログインページにリダイレクト
		if (session.getAttribute("loggedIn") == null || session.getAttribute("loginUser") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login-register.jsp");
			dispatcher.forward(request, response);
		}
		boolean loggedIn = (boolean) session.getAttribute("loggedIn");
		User loginUser = (User) session.getAttribute("loginUser");
		String status = loginUser.getStatus();
		System.out.println(status);
		if(status.equals("super")) {
			ConnectionManager connectionManager = new ConnectionManager();
	        try {
	        	Connection con = connectionManager.getConnection();
	        	BookMasterDAO bookMasterDAO = new BookMasterDAO(con);
	            List<BookMaster> books = bookMasterDAO.getAll(); // すべての本の情報を取得
	            request.setAttribute("books", books); // 取得した本の情報をリクエスト属性にセット
	            request.getRequestDispatcher("/jsp/search-update.jsp").forward(request, response); // JSPにフォワードして表示
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/top.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectionManager connectionManager = new ConnectionManager();
	    try {
	        Connection con = connectionManager.getConnection();
	        BookMasterDAO bookMasterDAO = new BookMasterDAO(con);
	        // 検索条件をリクエストパラメータから取得
	        String title = request.getParameter("title"); //requestはサーブレットで完結させるべき
	        String author = request.getParameter("author");
	        System.out.println("タイトル：" + title);
	        System.out.println("著者" + author);

	        // 検索条件を設定したBookMasterオブジェクトを作成
	        BookMaster searchCondition = new BookMaster();
	        if(!title.equals("")) {
	        	searchCondition.setTitle(title);
	        }
	        if(!author.equals("")) {
	        	searchCondition.setAuthor(author);
	        }


	        // 検索を実行
	        List<BookMaster> books = bookMasterDAO.select(searchCondition);

	        request.setAttribute("books", books);
	        request.getRequestDispatcher("/jsp/search-update.jsp").forward(request, response);

	    } catch (SQLException e) {
	        e.printStackTrace();
	        // エラーハンドリング
	    } finally {
	        connectionManager.closeConnection();
	    }
	}

}
