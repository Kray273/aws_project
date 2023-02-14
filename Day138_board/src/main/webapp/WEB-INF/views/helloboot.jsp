<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫 Hello</title>
<script src="js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#ajaxbtn").on('click',function(){
			$.ajax({
				url : "hellobootajax",
				type : 'get',
				dataType : "json",
				success : function(data){
					$('#result').html("<h4>"+data.result+"</h4>");
				} //성공
			}); //ajax
		});// on ajaxbtn
		
	});//ready

</script>
</head>
<body>
<h1>${dto.model}</h1>
<input type="button" id="ajaxbtn" value="Ajax요청버튼">
<div id="result"></div>
</body>
</html>