<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results from all books</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>タイトル</th>
				<th>著者</th>
				<th>発行年</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${books}">
				<tr>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.publicationYear}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>