<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Memberlist_MVC</title>
<script src="js/jquery-3.6.1.min.js" ></script>
<script >
	$(document).ready(function(){
		$('a').on('click',function(e){
			e.preventDefault();
			alert($(this).attr('id'));
			$.ajax({
				url : '/othermemberinform',
				data : {'id' : $(this).attr("id")},
				type : 'get',
				dataType : 'json',
				success : function(response){
					$("#result").html(response.id+"<br>");
					$("#result").append(response.name+"<br>");
					if(response.image != null){
					$("#result").append("<img src='/upload/" +response.image+"'><br>");
					}
				}
			});//ajax
		}); //on ajaxlink
	});//ready
</script>
</head>
<body>
<h1>전체 회원 정보를 가져옵니다.</h1>
<h6>url : mybatismemberlist</h6>
<div id="result"></div>
<c:forEach items="${ memberlist }" var ="member">
${member.id} : ${member.pw}:<a id="${member.id}" href="othermemberinform?id=${member.id}"> ${member.name}</a>:${member.address}<br>
</c:forEach>

</body>
</html>