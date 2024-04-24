<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	// user_id가 null일 경우에는 클라이언트에서 user_id 파라미터가 존재하지 않을 때
		// user_id.length()가 0일 때는 user_id 파라미터는 존재하나 입력한 값이 없을 때
		if(user_id == null || user_id.length() == 0) {	%>
	아이디를 입력하시오<br>
	<a href="/sec12/login.jsp">로그인하기</a>
	<% }else { %>
	<h1>환영합니다. <%=user_id %>님</h1>
	<% } %>
</body>
</html>