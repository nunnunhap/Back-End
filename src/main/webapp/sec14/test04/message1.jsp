<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="en_US"/><!-- 브라우저 언어 설정 안 바꾸고 이 코드로 실험해볼 수 있음. -->
	<h3>회원정보</h3>
	<fmt:bundle basename="resource.member">
		이름 : <fmt:message key="mem.name" /><br>
		주소 : <fmt:message key="mem.address" /><br>
		직업 : <fmt:message key="mem.job" />
	</fmt:bundle>
</body>
</html>