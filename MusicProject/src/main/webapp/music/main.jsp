<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*"%>
<%
	//자바
	String[] poster=new String[50];
	String[] title=new String[50];
	
	try{
		Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
		Elements pp=doc.select("table.list-wrap a.cover img");
		Elements tt=doc.select("table.list-wrap a.title");
		for(int i=0;i<pp.size();i++){
			poster[i]=pp.get(i).attr("src");
			title[i]=tt.get(i).text();
		}
	}catch(Exception ex){}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<%
				//for(String po:poster){ // for-each
				for(int i=0;i<poster.length;i++){
			%>
			<div class="col-md-4">
			    <div class="thumbnail">
			      <a href="/w3images/lights.jpg">
			        <img src="<%=poster[i] %>" alt="Lights" style="width:100%">
			        <div class="caption">
			        	<p><%=title[i].length()>25?title[i].substring(0,25)+"...":title[i] %></p>
			        </div>
			      </a>
			    </div>
			 </div>
			<% 
				}
			%>
		</div>
	</div>
</body>
</html>