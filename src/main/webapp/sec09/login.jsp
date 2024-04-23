<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 아래의 30은 세션소멸시간이 30초란 뜻임. -->
	<% session.setMaxInactiveInterval(5 * 60); %>
	<h3>유영의 쁘띠빠띠 로그인 페이지</h3>
	<form action="/Sec09Ex01LoginServlet" method="post">
		아이디 : <input type="text" name="user_id"><br>
		비밀번호 : <input type="password" name="user_pw"><br>
		<input type="hidden" name="user_address" value="서울시 노원구 이젠빌딩">
		<input type="hidden" name="user_email" value="user01@abc.com">
		<input type="hidden" name="user_hp" value="010-0000-0000">
		<input type="submit" value="로그인">
		<input type="reset" value="다시 입력">
	</form>
</body>
</html>