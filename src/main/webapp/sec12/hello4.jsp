<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// String age = request.getParameter("age");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주석문 연습</title>
</head>
<body>
	<h1>주석문 예제입니다.</h1>
	jsp주석 : 톰캣서버에서 실행 자체가 안됨.
	<%-- <%=Integer.parseInt(age) + 10 %> --%>
	
	아래는 html주석인데 톰캣 서버에서 실행됨. 서버에서 먼저 jsp 코드인 <%=10%>가 실행되고
	html주석에 의하여 소스가 안 보여질 뿐임. html주석은 브라우저에서 보이지 않게만 만드는 것이지
	실행을 막는 것이 아님.
	<!-- <%=10%> -->
	
	
</body>
</html>