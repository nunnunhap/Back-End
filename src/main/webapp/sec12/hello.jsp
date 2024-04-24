<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!	//자바코드 삽입
	//선언문 : 클래스 레벨의 필드, 메서드 위치에 존재
	String name = "홍길동";
	
	public String getName() {
		return name;
	} // 이 코드가 class 레벨에 생성되었다.
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문 연습</title>
</head>
<body>
	실제 스프링에선 이렇게 사용하지 않으니 그냥 가볍게 기억하기.
	<h1>jsp파일에 자바 코드 삽입하는 방법</h1>
	<h1>안녕하세요, <%=name // 위의 홍길동이 출력됨.
	%></h1>
	
</body>
</html>