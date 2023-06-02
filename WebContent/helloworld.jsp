<%@ page import="test.*" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
	<jsp:include page="my-header.html" />
    The time on the server is <%= new java.util.Date() %>
    <%
    for (int i = 1; i < 5; i++) {
        out.println("<br/>I really luv 2 code: " + i);
    }
    %>
    <%-- Self Introduction: <%= FunUtils.makeItLower("IamAFunGuy") %> --%>

    Request user agent: <%= request.getHeader("User-Agent") %>
    
    
</body>
</html>