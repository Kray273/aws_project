<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입_mybitis</title>
</head>
<script src="js/jquery-3.6.1.min.js" ></script>
<script >

</script>
<h1>회원가입</h1>
<form action="<%=request.getContextPath() %>/memberinsert" 
	method="post" enctype="multipart/form-data"> 
	
	아이디	 <input type="text" name="id" required><br>
	암호 <input type="password" name="pw" required><br>
	이름 <input type="text" name="name" required><br>
	전화번호 <input type="number" name="phone" value="010" required><br>
	이메일 <input type="email" name="email" value="sba@a.com" required><br>
	주소 <input type="text" name="address" value="서울시 용산구" required><br>
	이미지 <input type="file" name="imagefile"  id="imagefile"><br>
<input type="submit" value="회원가입"> 
</form>

</body>
</html>