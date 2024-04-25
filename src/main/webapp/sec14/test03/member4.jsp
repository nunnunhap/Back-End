<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>

<c:set var="id" value="hong" scope="page" />
<c:set var="pwd" value="1234" scope="page" />
<%-- <c:set var="name" value="${ '홍길동' }" scope="page" /> --%>
<c:set var="age" value="${ 15 }" scope="page" />
<c:set var="height" value="${ 177 }" scope="page" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<%--<c:when test="${ name == null }"> --%>
		<c:when test="${ empty name }">
			<h3>name 변수가 존재하지 않습니다.</h3>
		</c:when>
		<c:otherwise> <!-- otherwise는 else개념 -->
			아이디 : ${ id }<br>
			비밀번호 : ${ pwd }<br>
			이름 : ${ name }<br>
			나이 : ${ age }<br>
			신장 : ${ height }<br>
		</c:otherwise>
	</c:choose>
</body>
</html>