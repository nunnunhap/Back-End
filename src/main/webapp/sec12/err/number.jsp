<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// num이란 파라미터가 없기 때문에 null로 처리되고 null을 숫자로 변환 시 예외 발생
	int num = Integer.parseInt(request.getParameter("num"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>num값은 <%=num %></h1>
</body>
</html>