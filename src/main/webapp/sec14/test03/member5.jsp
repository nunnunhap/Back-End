<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<%
	List dataList = new ArrayList();
	dataList.add("hello");
	dataList.add("world");
	dataList.add("안녕");	
%>
<c:set var="list" value="<%= dataList %>" />

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>반복문 실습</h3>
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
		i = ${ i }&nbsp;&nbsp;&nbsp;반복횟수 : ${ loop.count }<br>
	</c:forEach>
	<br>
	<c:forEach var="i" begin="1" end="10" step="2">
		5 * ${ i } = ${ 5 * i }<br>
	</c:forEach>
	<br>
	<!-- 위에서 만들어둔 list처럼 collection을 사용할 수 있음. -->
	<c:forEach items="${ list }" var="data">
		${ data }<br>
	</c:forEach>
	<br>
	<c:set var="fruits" value="사과, 파인애플, 바나나, 망고, 귤" />
	<c:forTokens items="${ fruits }" delims=", " var="token">
		${ token }<br>
	</c:forTokens>
</body>
</html>