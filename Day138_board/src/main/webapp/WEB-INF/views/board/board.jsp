<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드 시작페이지</title>
</head>
<body>
<h1>나의 회원관리 프로그램입니다.</h1>
<h4><ul>
<li><a href="<%=request.getContextPath() %>/login">로그인</a></li>
<li><a href="<%=request.getContextPath() %>/logout">로그아웃</a></li>
<li><a href="<%=request.getContextPath() %>/boardlist">게시판 가기(로그인 필요없음)</a></li>
</ul></h4>
<% if(session.getAttribute("loginid") != null ){
	out.println("<h2>" + session.getAttribute("loginid")+ "회원님 환영합니다.</h2>");
	}
	if(request.getAttribute("result") != null ){
	out.println("<h2>" +  request.getAttribute("result") + "</h2>");
	}
%>
</body>
</html>