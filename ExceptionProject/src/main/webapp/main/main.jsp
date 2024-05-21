<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		try{
			int a=10/0;	//에러가 나더라도 건너뛰도록, 예외처리 없을시 페이지전체가 오류페이지 => h1 출력X		
		}catch(Exception e){} 
	%>
	<h1>Hello Java!!</h1>
	<h1>Hello Java!!</h1>
	<h1>Hello Java!!</h1>
	<h1>Hello Java!!</h1>
	<h1>Hello Java!!</h1>
</body>
</html>