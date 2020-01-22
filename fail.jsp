<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아쉽습니다!</title>
<style>
* {
text-align : center;
}
body {
		background-color: black;
	}
</style>	
</head>
<%
   Date now = new Date();
%>
<body>
<br>
<br>
<h2 style='color:#ffffff'> <%= now.getHours()%>시 <%= now.getMinutes()%>분에 당첨실패! 다시 도전!</h2>
<br>
<br>
<img src="/sedu/jspexam/dispression.jpg" width="500">
<br>
<br>
<h3 style='color:#ffffff'>다시... 도전해볼까요?</h3>
<a href="<%= request.getHeader("referer") %>">처음화면으로</a>
</body>
</html>