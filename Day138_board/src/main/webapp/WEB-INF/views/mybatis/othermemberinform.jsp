<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진 보여주기</title>
</head>
<body>
<h1> ${otherinform.name}님의 정보입니다.(관리자만 허용)</h1>
<h3>아이디 : ${otherinform.id}<br></h3>
<h3>사진 : ${otherinform.image}<br></h3>
<img alt="사진이 없습니다." src="/upload/${otherinform.image}">
<script type="text/javascript">
alert('${result}')
</script>
</body>
</html>