<%@page import="DTO.Bean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Bean bean = (Bean) request.getAttribute("bean");
	System.out.println("bean===" + bean.getSeq());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����»��������Դϴ�</title>
</head>
<body>

	<div style="text-align: center">

		<h1><%=bean.getTitle()%></h1>

		<h3>
			���� <br />
			<%=bean.getContent()%><br />
			<br />
		</h3>
		����� :
		<%=bean.getName()%><br /> 
		<br /> <%-- <input type="button" value="����"
			onclick="location='/ojt/boardUpdate.do?seq=<%=bean.getSeq()%>'" /> <input
			type="button" value="����"
			onclick="location='/ojt/board/boardDelete.do?seq=<%=bean.getSeq()%>'" />
		<input type="button" value="���" onclick="location='/ojt/boardList.do'" /> --%>
		
		<input type="button" value="����"
			onclick="location='/ojt/board/password.jsp?seq=<%=bean.getSeq()%>&next=update'" /> 
			
			<input
			type="button" value="����"
			onclick="location='/ojt/board/password.jsp?seq=<%=bean.getSeq()%>&next=delete'" />
			
		<input type="button" value="���" onclick="location='/ojt/boardList.do'" />
		
	</div>
</body>
</html>