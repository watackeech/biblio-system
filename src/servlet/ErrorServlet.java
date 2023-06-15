package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*
* [機 能] エラー画面サーブレット<br>
* [説 明] リクエストを受け付け、レスポンスを返す。<br>
* [備 考] なし<br>
* [環 境] OpenJDK 11 <br>
* Copyright(c) 2019 Fullness, Inc. All Rights Reserved
* @author [作 成] 2017/03/05 fullness(fullness)
*         [修 正] 2019/10/30 fullness(fullness)
*/
@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	*
	* [機 能] doGetメソッド<br>
	* [説 明] error.jspにフォワードする。<br>
	* [備 考] なし
	* @param request クライアントからのリクエスト情報
	* @param response クライアントへのレスポンス情報
	* @throws ServletException
	* @throws IOException
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//JSPへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/error.jsp");
		dispatcher.forward(request, response);
		return;

	}

}
