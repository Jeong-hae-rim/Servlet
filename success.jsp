<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>축하합니다!</title>
<style>
* {
	text-align: center;
}

div {
	border: 8px outset #D0FA58;
	border-radius: 50%;
	background-color: #ffffff;
	margin: 10px auto;
	width: 70%;
	padding: 10px;
}

body {
	background-color: #D0F5A9;
}
</style>

</head>
<%
	Date now = new Date();
%>
<body>
	<div>
		<br> <br>
		<h2>
			<%=now.getHours()%>시
			<%=now.getMinutes()%>분에 당첨! 축하합니다!
		</h2>
		<img src="/sedu/jspexam/congraturation.jpg" width="500"> <br>
		<br> <br> <br>
	</div>
</body>
</html>