package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOs.BookMasterDAO;
import DTOs.BookMaster;

/**
 * Servlet implementation class ResultsServlet
 */
@WebServlet("/results")
public class ResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/results.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>てすっとおおおおおお</body></html>");
//        System.out.println("doPostが呼ばれた！");

        try {
        	BookMasterDAO dao = new BookMasterDAO();
        	List<BookMaster> results = dao.getAll();
        	System.out.println(results);

        	request.setAttribute("results", results);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/results.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
//            out.println("Error: " + e.getMessage());
//            out.println("ResultsServletのException");
        } finally {
//            out.close();
        }
	}

}