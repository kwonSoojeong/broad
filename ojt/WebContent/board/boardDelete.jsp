<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>삭제페이지입니다</title>
</head>
<body>
	<form method="post" action="/ojt/delete.do?seq=<%=seq%>">

		삭제하려면 암호를 입력하세요.<br /> 암호 <input type="password" name="pw" size="10"
			maxlength="50" /><br /> <input type="submit" value="등록" /> <br />
		<input type="button" value="취소" />
	</form>
</body>
</html>