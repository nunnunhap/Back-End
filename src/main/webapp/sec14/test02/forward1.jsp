<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	// request : 요청이 종료되면 소멸됨.
	request.setAttribute("id", "hong"); // hong은 String이 Object타입으로 형변환됨.
	request.setAttribute("pwd", "1234");
	// session : 세션이 종료되면 소멸됨.
	// 사용자가 로그인해서 인증상태를 유지
	session.setAttribute("name", "홍길동");
	session.setAttribute("email", "hong@test.com");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="member1.jsp"></jsp:forward>
</body>
</html>