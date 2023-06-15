package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servletを
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet{

	public HelloWorldServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");

		ServletContext context = getServletContext();
		String teamName = context.getInitParameter("team-name");


		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<h2>Hello World</h2>");
		out.println("Our team is " + teamName);
		out.println("<hr>");
		out.println("The time on the server is" + new java.util.Date());
		out.println("</body></html>");

	}
}
