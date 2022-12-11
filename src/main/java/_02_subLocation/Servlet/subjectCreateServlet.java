package _02_subLocation.Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean.subjectclass;
import dao.subjectdao;

@WebServlet("/Servlet/subjectCreateServlet")
public class subjectCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(subjectCreateServlet.class);

	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int subNo = Integer.valueOf(request.getParameter("subno"));
		String subName = request.getParameter("subname");
		String subClass = request.getParameter("subclass");
//		subjectclass subject = new subjectclass();
//		subject.setSubno(subNo);
//		subject.setSubname(subName);
//		subject.setSubclass(subClass);
		try {
			subjectdao classService = new subjectdao();
			classService.add(subNo,subName,subClass);
			request.setAttribute("classService", classService);
			RequestDispatcher rd = request.getRequestDispatcher("/Servlet/subjectSearch");
			rd.forward(request, response);
			return;

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
