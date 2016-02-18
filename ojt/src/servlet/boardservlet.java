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

			request.setAttribute("list", list); // list�� �ѱ��

			RequestDispatcher rd = request.getRequestDispatcher("/board/boardList.jsp"); // �����
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
			System.out.println("�ö󰣴�");
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardList.do");
			rd.forward(request, response);

		} else if (request.getRequestURI().endsWith("boardDetail.do")) {

			System.out.println("detail");
			boardDAO dao = new boardDAO();
			int seq = Integer.parseInt(request.getParameter("seq"));
			System.out.println("������ seq=====" + seq); // ok

			Bean bean = dao.select(seq);
			System.out.println("bean���빰" + bean.getSeq());

			request.setAttribute("bean", bean); // bean�� �ѱ��
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardDetail.jsp"); // �����
			rd.forward(request, response);

		} else if (request.getRequestURI().endsWith("boardUpdate.do")) {
			// ����������
			System.out.println("updatepage");
			boardDAO dao = new boardDAO();
			int seq = Integer.parseInt(request.getParameter("seq"));
			System.out.println("������ seq=====" + seq); // ok

			Bean bean = dao.select(seq);
			System.out.println("bean���빰" + bean.getSeq());

			request.setAttribute("bean", bean); // bean�� �ѱ��
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardUpdate.jsp"); // �����
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
			} else {// url������� ����������
			}
			System.out.println("pass"+request.getParameter("password"));
			if (request.getParameter("password").equals(bean.getPassword())) {
				// ��ȣ��ġ
				request.setAttribute("bean", bean); // bean�� �ѱ��
				RequestDispatcher rd = request.getRequestDispatcher(url); // �����
				rd.forward(request, response);
			} else {
				// ����ġ
			}

		} else if (request.getRequestURI().endsWith("update.do")) {

			int seq = Integer.parseInt(request.getParameter("seq"));
			boardDAO dao = new boardDAO();
			Bean bean = dao.select(seq);
		
			bean.setTitle(request.getParameter("title"));
			bean.setContent(request.getParameter("content"));
			bean.setName(request.getParameter("name"));
			bean.setPassword(request.getParameter("password"));
			// System.out.println("passwd�� �� null?==" + bean.getPassword());

			dao.update(bean);
			System.out.println("������Ʈ");
			System.out.println("seq==" + bean.getSeq());
			request.setAttribute("bean", bean);
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardDetail.do?seq=" + bean.getSeq());
			rd.forward(request, response);

		} else if (request.getRequestURI().endsWith("boardDelete.do")) {
			System.out.println("����");
			int seq = Integer.parseInt(request.getParameter("seq"));
			boardDAO dao = new boardDAO();
			dao.delete(seq);

			RequestDispatcher rd = request.getRequestDispatcher("/board/boardList.do");
			rd.forward(request, response);

			/*
			 * System.out.println("Delete"); boardDAO dao = new boardDAO(); int
			 * seq = Integer.parseInt(request.getParameter("seq"));
			 * System.out.println( "������ seq=====" + seq); Bean bean =
			 * dao.select(seq);
			 * System.out.println("��ȣ"+bean.getPassword()+"�Է¾�ȣ"+request.
			 * getParameter("pw")); //��ȣȮ���ϱ� if (bean.getPassword() ==
			 * request.getParameter("pw")){ System.out.println("��ȣ��ġ");
			 * dao.delete(seq); //����Ʈ�� RequestDispatcher rd =
			 * request.getRequestDispatcher("/board/boardList.do"); // �����
			 * rd.forward(request, response);
			 * 
			 * }else { //�˶�?���â? System.out.println("��ȣ����ġ"); RequestDispatcher
			 * rd = request.getRequestDispatcher("/board/boardDelet.jsp"); //
			 * ����� rd.forward(request, response); }
			 */

		}

	}

}
