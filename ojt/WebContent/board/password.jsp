
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
<title>��ȣ���Է¹������ϴ�</title>
</head>
<body>
	<div style="text-align: center">
	��ȣ�� �Է����ּ���
	<br /> ��ȣ�� �Է����ּ���
	<br />


	<form method="post" action="/ojt<%=url%>">
		<input type="password" name="password" > <input type="submit"
			value="Ȯ��" />
	</form>
	</div>
</body>
</html>