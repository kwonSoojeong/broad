<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>여기는 등록페이지입니다</title>
</head>
<body>
	<div style="text-align: center">

		<h1>글쓰기</h1>
		<form method="post" action="/ojt/boardInsert.do">
			제목<br /> <input name="title" size="50" maxlength="50"> <br />
			<br /> 내용<br />
			<textarea name="content" cols="50" rows="10"></textarea>
			<br /> <br /> <br /> 등록자 <input name="name" size="10"
				maxlength="50"> 암호 <input name="password" size="10"
				maxlength="50"> <input type="submit" value="등록" /> <br />
		</form>
	</div>

</body>
</html>