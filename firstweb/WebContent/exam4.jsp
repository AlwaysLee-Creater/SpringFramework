<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--jsp주석입니다!!!
	여러줄로도 사용가능.
 --%>
 <!-- HTML 주석입니다. -->
<%
//자바 주석입니다.
/*
여러줄도 가능.
*/
	for(int i=1;i<=5;i++){
		
	
%>
<h<%=i %>>아름다운 한글</h>
<%
	}
%>
</body>
</html>