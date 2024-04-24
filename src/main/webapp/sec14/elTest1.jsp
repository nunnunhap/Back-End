<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어(Expression Language)에서 사용되는 데이터들</title>
</head>
<body>
	<h1>표현언어(EL)로 여러가지 </h1>
	<h1>
		\${ 100 }:	${ 100 }<br>
		\${ "안녕하세요" }: ${"안녕하세요"}<br>
		\${ 10 + 1 }: ${ 10 + 1 }<br>
		\${ "10" + 1 }: ${ "10" + 1 }<br>
		<%--\${ null + 10 }: ${ null + 10 }<br> --%> <!-- 에러는 나지 않았으나 정상적이지 못한 코드 -->
		<%--\${ "안녕" + 11 }: ${ "안녕" + 11 }<br> --%> <!-- 에러발생 : 문자열과 숫자는 더할 수 없다. -->
		<%-- \${ "hello" + "world" }: ${ "hello" + "world" } --%> <!-- 에러발생 : 문자열과 문자열은 더할 수 없다. -->
	</h1>
</body>
</html>