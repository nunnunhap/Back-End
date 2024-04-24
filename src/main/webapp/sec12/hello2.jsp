<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!	// 선언문 : 클래스 레벨에 삽입됨. ! 있는 것 기억
	// 이건 작성된 내용은 jsp파일의 어디 있든 상관없음.
	// 왜냐면 class파일 바로 밑에 위치하도록 지정되어 있기 때문임.
	String name = "이순신";
	public String getName() {return name;}%>
<%  // !가 없는 이게 스크립트 릿(scriptlet)
	// jsp에선 서블릿 환경에서 제공해주었던 request와 response를 기본적으로 제공
	// 이건 꼭 위에 있어야 하는 코드임. 작성된 순서대로 위치됨.
	String age = request.getParameter("age");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP파일에 자바코드 삽입하는 방법2 - 스크립트릿 </h1>
	<h1>안녕하세요, <%=name %>님!!</h1>
	<h1>나이는 <%=age %>살입니다!!!</h1>
</body>
</html>