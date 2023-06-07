<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="DTOs.BookMaster"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
	<h1>BookMaster Records</h1>
	<form action="results" method="post">
		<input type="submit" value="書籍情報取得">
	</form>
	<table>
		<tr>
			<th>Book ID</th>
			<th>Title</th>
			<th>Author</th>
		</tr>
		<%-- 結果のリストを取得 --%>
		<%
		List<BookMaster> results = (List<BookMaster>) request.getAttribute("results");
		%>
		<%-- 結果を表示 --%>
		<%
		if (results != null) {
		%>
			<%
			for (BookMaster book : results) {
			%>
				<tr>
					<td><%=book.getId()%></td>
					<td><%=book.getTitle()%></td>
					<td><%=book.getAuthor()%></td>
				</tr>
			<%
			}
		}
		%>
	</table>
</body>
</html>