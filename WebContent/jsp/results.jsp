<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="DTOs.BookMaster"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <c:choose>
            <c:when test="${empty results}">
                <tr>
                    <td colspan="3">No records found.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach items="${results}" var="book">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
</body>
</html>