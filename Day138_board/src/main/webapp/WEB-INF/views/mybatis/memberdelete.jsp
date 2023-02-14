<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원삭제</title>
<script src="js/jquery-3.6.1.min.js" ></script>
<script >
	$(document).ready(function(){
		$('#form').on('submit', function(e){
			if($('#pw').val() != $('#pw2').val()){
				$('#result').html("<h3>암호가 다릅니다.</h3>");
				e.preventDefault();
			}
		});
	});
</script>
</head>
<body>
<h1>정말 탈퇴하기겠습니까?</h1>
<form  id="form" action="<%=request.getContextPath() %>/memberdelete" method="post">
	아이디	 <input type="text" name="id" value="${one.id}" readonly><br>
	암호 <input type="password" value="${one.pw}" id="pw" readonly><br>
	암호 확인 <input type="password" id="pw2" required><br>
<input type="submit" value="회원탈퇴"> 
<input type="reset" value="취소"> 
</form>
<div id="result"></div>

</body>
</html>