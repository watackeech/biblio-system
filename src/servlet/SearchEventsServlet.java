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

import DAOs.ConnectionManager;
import DAOs.EventDAO;
import DTOs.Event;

/**
 * Servlet implementation class SearchEventsServlet
 */
@WebServlet("/search-events")
public class SearchEventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEventsServlet() {
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
        	EventDAO dao = new EventDAO(con);
            List<Event> events = dao.getAll(); // すべての本の情報を取得

            request.setAttribute("events", events); // 取得した本の情報をリクエスト属性にセット
            request.getRequestDispatcher("/jsp/search-events.jsp").forward(request, response); // JSPにフォワードして表示

        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリング
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
