<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����� ����������Դϴ�</title>
</head>
<body>
	<div style="text-align: center">

		<h1>�۾���</h1>
		<form method="post" action="/ojt/boardInsert.do">
			����<br /> <input name="title" size="50" maxlength="50"> <br />
			<br /> ����<br />
			<textarea name="content" cols="50" rows="10"></textarea>
			<br /> <br /> <br /> ����� <input name="name" size="10"
				maxlength="50"> ��ȣ <input name="password" size="10"
				maxlength="50"> <input type="submit" value="���" /> <br />
		</form>
	</div>

</body>
</html>