<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/insertboard" method="post">
<table border="2">
	<tr><th>제목</th><td><input type="text" placeholder="제목을 입력해주세요" name="title" required></td></tr>
	<tr><th>내용</th><td><textarea rows="3" cols="50" name="contents" required></textarea></td></tr>
	<tr><th>작성자</th><td><input type="text" value="${sessionScope.loginid}" name="writer" readonly></td></tr>
	<tr><td colspan="2"><input type="submit" value="수정버튼">
	<input type="reset" value="취소버튼"><td></tr>
</table>
</form>

</body>
</html>