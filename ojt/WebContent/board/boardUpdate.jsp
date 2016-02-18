<%@page import="DTO.Bean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Bean bean = (Bean) request.getAttribute("bean");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>여기선 게시글 수정합니다</title>
</head>
<body>
	<div style="text-align: center">
		<h1>수정페이지</h1>

		<br />


		<form method="post" action="/ojt/update.do?seq=<%=bean.getSeq()%>">
			<h1>
				제목<br /> <input name="title" size="50" maxlength="50"
					value=<%=bean.getTitle()%>>
			</h1>
			<br /> 내용<br />
			<textarea name="content" cols="50" rows="10"><%=bean.getContent()%></textarea>
			<br /> 등록자 <input name="name" size="10" maxlength="50"
				value=<%=bean.getName()%>> 암호 <input name="password"
				size="10" maxlength="50" value=<%=bean.getPassword()%>> <input
				type="submit" value="수정" /> <br />
		</form>




	</div>
</body>
</html>