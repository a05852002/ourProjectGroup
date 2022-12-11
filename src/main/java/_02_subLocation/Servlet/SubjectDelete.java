package _02_subLocation.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import dao.subjectdao;

@WebServlet("/Servlet/SubjectDelete.do")
public class SubjectDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(SubjectDelete.class);
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		subjectdao sDao = new subjectdao();
		 int subNo = Integer.valueOf( request.getParameter("subNo"));
			try {
				sDao.deleteSubfromSubno(subNo);
				RequestDispatcher rd = request.getRequestDispatcher("/Servlet/subjectSearch");
				rd.forward(request, response);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
