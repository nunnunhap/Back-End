<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>여러가지 논리연산자 ?, &&, ||, != </h2>
	<h2>
		\${ (10 == 10) && (20 == 20) } : ${ (10 == 10) && (20 == 20) }<br>
		\${ (10 == 10) and (20 == 20) } : ${ (10 == 10) and (20 == 20) }<br>
		
		\${ (10 == 10) || (20 == 20) } : ${ (10 == 10) || (20 == 20) }<br>
		\${ (10 != 10) or (20 != 20) } : ${ (10 != 10) or (20 != 20) }<br>
		
		\${ !(20 == 10) } : ${ !(20 == 10) }<br>
		\${ not(20 == 10) } : ${ not(20 == 10) }<br>
		
		\${ !(20 != 10) } : ${ !(20 != 10) }<br>
		\${ not(20 != 10) } : ${ not(20 != 10) }<br>
	</h2>
</body>
</html>