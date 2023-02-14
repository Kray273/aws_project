<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보보기_mybitis</title>
</head>
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
<h1>내 정보</h1>
<form  id="form" action="<%=request.getContextPath() %>/memberupdate" method="post">
	아이디	 <input type="text" name="id" value="${one.id}" readonly><br>
	암호 <input type="password" value="${one.pw}" id="pw" readonly><br>
	암호 확인 <input type="password" id="pw2" required><br>
	이름 <input type="text" name="name" value="${one.name}" required><br>
	전화번호 <input type="number" name="phone" value="${one.phone}" pattern="010[0-9][8]" required><br>
	이메일 <input type="email" name="email" value="${one.email}" required><br>
	주소 <input type="text"  value="${one.address}" readonly><br>
	가입일 <input type="text" value="${one.indate}" readonly><br>
<input type="submit" value="내 정보 수정"> 
<input type="reset" value="취소"> 
</form>
<div id="result"></div>


</body>
</html>