
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int seq = Integer.parseInt(request.getParameter("seq"));

	String url = null;
	String next = (String) request.getParameter("next");
	if ( next.equals("delete")){
		url = "/password.do?next=delete&seq="+seq;
	} else if ( next.equals("update")){
		url = "/password.do?next=update&seq="+seq;
	}else {
		//that's no
	}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>암호를입력받을껍니다</title>
</head>
<body>
	<div style="text-align: center">
	암호를 입력해주세요
	<br /> 암호를 입력해주세요
	<br />


	<form method="post" action="/ojt<%=url%>">
		<input type="password" name="password" > <input type="submit"
			value="확인" />
	</form>
	</div>
</body>
</html>