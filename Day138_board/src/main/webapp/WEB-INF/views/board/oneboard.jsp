<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/updateboard" method="post">
<table border="2">
	<tr><th>번호</th><td><input type="text" value="${oneboard.seq}" name="seq" readonly></td></tr>
	<tr><th>제목</th><td><input type="text" value="${oneboard.title}" name="title"></td></tr>
	<tr><th>내용</th><td><textarea rows="3" cols="50" name="contents">${oneboard.contents}</textarea></td></tr>
	<tr><th>작성자</th><td><input type="text" value="${oneboard.writer}" name="writer" readonly></td></tr>
	<tr><th>조회수</th><td><input type="text" value="${oneboard.viewcount}" name="viewcount" readonly></td></tr>
	<tr><th>작성시간</th><td><input type="text" value="${oneboard.writingtime}" name="writingtime" readonly></td></tr>
	<tr><td colspan="2"><input type="submit" value="수정버튼">
	<input type="button" value="삭제버튼" onclick="location.href='deleteboard?seq=${oneboard.seq}'"><td></tr>
</table>
</form>
<% if(request.getAttribute("result") != null ){
	out.println("<h2>" +  request.getAttribute("result") + "</h2>");
	} %>

</body>
</html>