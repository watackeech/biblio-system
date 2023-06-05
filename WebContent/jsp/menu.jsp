<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Login has successed!</p>
	<% Integer result = (Integer)request.getAttribute("result");
		String userName = (String) session.getAttribute("userName");
	%>

	答え = <%=result%>
	ユーザー名： <%=userName %>
</body>
</html>