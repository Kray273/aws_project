<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 리스트</title>
</head>
<body>
<h1>${param.page }페이지 게시믈 출력</h1>
<table><tr><th>번호</th><th>제목</th><th>작성자</th></tr>
<c:forEach items="${list}" var="board">
<tr><th><a href="oneboard?seq=${board.seq}">${board.seq}</a></th><th>${board.title}</th><th>${board.writer}</th></tr>
</c:forEach>
</table>
<% int totalcount = (Integer)request.getAttribute("totalcount");
	int totalpage = 0;
	if( (totalcount % 3) == 0){
		totalpage = totalcount /3 ;
	}else{
		totalpage = totalcount/3 +1;
	}
	for(int i=1; i<= totalpage; i++){ %>
	
	<a href="boardlist?page=<%= i %>"><%= i %>페이지</a>
		
	<% }%>
${totalcount }

<input type="button" value="글쓰기" id="writebtn">
<script src="js/jquery-3.6.1.min.js" ></script>
<script >
	$('#writebtn').on('click', function(e){
		location.href="insertboard"; //get
	});

</script>
</body>
</html>