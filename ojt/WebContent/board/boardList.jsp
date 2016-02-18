<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="DTO.Bean"%>
<%@page import="DAO.boardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	ArrayList<Bean> list = (ArrayList) request.getAttribute("list");
	System.out.println("list.size()====" + list.size());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>여기가 내 게시판이다</title>

</head>
<body>
	<div style="text-align: center">
		<h1>게시판</h1>

		<table border=1 width=1000 height="60" align="center">
			<tr>
				<td>번호</td>
				<td width="400">제목</td>
				<!-- <td>내용</td> -->
				<td>작성자</td>
				<td>작성날짜</td>
				<td>수정날짜</td>
			</tr>

			<%
				for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getSeq()%></td>
				<td><a href="/ojt/boardDetail.do?seq=<%=list.get(i).getSeq()%>"><%=list.get(i).getTitle()%></a></td>
				<%-- <td><a href="/ojt/boardDetail.do&seq=<%=list.get(i).getSeq()%>"><%=list.get(i).getTitle()%></a></td> --%>
				<%-- <td><%=list.get(i).getContent()%></td> --%>
				<td><%=list.get(i).getName()%></td>
				<td><%=list.get(i).getReg_date()%></td>
				<td><%=list.get(i).getUpdate_date()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<br /> <br /> <input type="button" value="글쓰기"
			onclick="location='/ojt/board/boardInsert.jsp'" />
		<%
			Date now = new Date();
		%>
		<h6><%=now%></h6>
	</div>
</body>
</html>