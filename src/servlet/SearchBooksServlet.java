package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOs.BookMasterDAO;
import DAOs.ConnectionManager;
import DTOs.BookMaster;

/**
 * Servlet implementation class SearchBooksServlet
 */
@WebServlet("/search-books")
public class SearchBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectionManager connectionManager = new ConnectionManager();

        try {
        	Connection con = connectionManager.getConnection();
        	BookMasterDAO bookMasterDAO = new BookMasterDAO(con);
            List<BookMaster> books = bookMasterDAO.getAll(); // すべての本の情報を取得

            request.setAttribute("books", books); // 取得した本の情報をリクエスト属性にセット
            request.getRequestDispatcher("/jsp/search-books.jsp").forward(request, response); // JSPにフォワードして表示

        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリング
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
	        request.getRequestDispatcher("/jsp/search-books.jsp").forward(request, response);

	    } catch (SQLException e) {
	        e.printStackTrace();
	        // エラーハンドリング
	    } finally {
	        connectionManager.closeConnection();
	    }
	}

}
