<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="DTOs.User"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン画面</title>
</head>
<body>
	<div align="center">
		<form action="login" method="post">
			<input type="text" name="param1"> +
			<input type="text" name="param2"> <br>
			<input type="hidden" name="param3" value="10000" />
			<input type="submit" value="計算">
		</form>
	</div>
</body>
</html>