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
			int a=10/0;	//������ ������ �ǳʶٵ���, ����ó�� ������ ��������ü�� ���������� => h1 ���X		
		}catch(Exception e){} 
	%>
	<h1>Hello Java!!</h1>
	<h1>Hello Java!!</h1>
	<h1>Hello Java!!</h1>
	<h1>Hello Java!!</h1>
	<h1>Hello Java!!</h1>
</body>
</html>