package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.log.SystemLogHandler;

import com.mysql.fabric.xmlrpc.base.Data;

import DAO.boardDAO;
import DTO.Bean;

/**
 * Servlet implementation class boradservlet
 */
@WebServlet("/boradservlet")
public class boardservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		System.out.println("get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("post");
		request.setCharacterEncoding("euc-kr");
		System.out.println("request.getRequestURI()===" + request.getRequestURI());

		if (request.getRequestURI().endsWith("boardList.do")) {
			boardDAO dao = new boardDAO();
			List<Bean> list = dao.selectall();
			System.out.println("list.size()=====" + list.size());

			request.setAttribute("list", list); // list를 넘긴다

			RequestDispatcher rd = request.getRequestDispatcher("/board/boardList.jsp"); // 여기로
			rd.forward(request, response);

		} else if (request.getRequestURI().endsWith("boardInsert.do")) {
			System.out.println("insert");

			Bean bean = new Bean();
			bean.setTitle(request.getParameter("title"));
			bean.setContent(request.getParameter("content"));
			bean.setName(request.getParameter("name"));
			bean.setPassword(request.getParameter("password"));

			boardDAO dao = new boardDAO();
			dao.insert(bean);
			System.out.println("올라간다");
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardList.do");
			rd.forward(request, response);

		} else if (request.getRequestURI().endsWith("boardDetail.do")) {

			System.out.println("detail");
			boardDAO dao = new boardDAO();
			int seq = Integer.parseInt(request.getParameter("seq"));
			System.out.println("선택한 seq=====" + seq); // ok

			Bean bean = dao.select(seq);
			System.out.println("bean내용물" + bean.getSeq());

			request.setAttribute("bean", bean); // bean를 넘긴다
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardDetail.jsp"); // 여기로
			rd.forward(request, response);

		} else if (request.getRequestURI().endsWith("boardUpdate.do")) {
			// 수정페이지
			System.out.println("updatepage");
			boardDAO dao = new boardDAO();
			int seq = Integer.parseInt(request.getParameter("seq"));
			System.out.println("선택한 seq=====" + seq); // ok

			Bean bean = dao.select(seq);
			System.out.println("bean내용물" + bean.getSeq());

			request.setAttribute("bean", bean); // bean를 넘긴다
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardUpdate.jsp"); // 여기로
			rd.forward(request, response);

		} else if (request.getRequestURI().endsWith("password.do")) {
			System.out.println("passasdf---");
			String url = null;
			int seq = Integer.parseInt(request.getParameter("seq"));
			boardDAO dao = new boardDAO();
			Bean bean = dao.select(seq);
			if (request.getParameter("next").equals("delete")) {
				url = "/board/boardDelete.do?seq=" + bean.getSeq();
			} else if (request.getParameter("next").equals("update")) {
				url = "/board/boardUpdate.do?seq=" + bean.getSeq();
			} else {// url마음대로 조작하지마
			}
			System.out.println("pass"+request.getParameter("password"));
			if (request.getParameter("password").equals(bean.getPassword())) {
				// 암호일치
				request.setAttribute("bean", bean); // bean를 넘긴다
				RequestDispatcher rd = request.getRequestDispatcher(url); // 여기로
				rd.forward(request, response);
			} else {
				// 불일치
			}

		} else if (request.getRequestURI().endsWith("update.do")) {

			int seq = Integer.parseInt(request.getParameter("seq"));
			boardDAO dao = new boardDAO();
			Bean bean = dao.select(seq);
		
			bean.setTitle(request.getParameter("title"));
			bean.setContent(request.getParameter("content"));
			bean.setName(request.getParameter("name"));
			bean.setPassword(request.getParameter("password"));
			// System.out.println("passwd가 왜 null?==" + bean.getPassword());

			dao.update(bean);
			System.out.println("업데이트");
			System.out.println("seq==" + bean.getSeq());
			request.setAttribute("bean", bean);
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardDetail.do?seq=" + bean.getSeq());
			rd.forward(request, response);

		} else if (request.getRequestURI().endsWith("boardDelete.do")) {
			System.out.println("삭제");
			int seq = Integer.parseInt(request.getParameter("seq"));
			boardDAO dao = new boardDAO();
			dao.delete(seq);

			RequestDispatcher rd = request.getRequestDispatcher("/board/boardList.do");
			rd.forward(request, response);

			/*
			 * System.out.println("Delete"); boardDAO dao = new boardDAO(); int
			 * seq = Integer.parseInt(request.getParameter("seq"));
			 * System.out.println( "선택한 seq=====" + seq); Bean bean =
			 * dao.select(seq);
			 * System.out.println("암호"+bean.getPassword()+"입력암호"+request.
			 * getParameter("pw")); //암호확인하기 if (bean.getPassword() ==
			 * request.getParameter("pw")){ System.out.println("암호일치");
			 * dao.delete(seq); //리스트로 RequestDispatcher rd =
			 * request.getRequestDispatcher("/board/boardList.do"); // 여기로
			 * rd.forward(request, response);
			 * 
			 * }else { //알람?경고창? System.out.println("암호불일치"); RequestDispatcher
			 * rd = request.getRequestDispatcher("/board/boardDelet.jsp"); //
			 * 여기로 rd.forward(request, response); }
			 */

		}

	}

}
