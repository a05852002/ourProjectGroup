package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.teacAndStudDao;

@WebServlet("/Servlet/deletedata")
public class deletedata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 teacAndStudDao oDao = new teacAndStudDao(); 
		 int teacno = 0;
		 teacno = Integer.valueOf( request.getParameter("teacno"));
			try {
				oDao.deleteTeacfromTeacno(teacno);
				RequestDispatcher rd = request.getRequestDispatcher("/Servlet/searchAllTeacServlet");
				rd.forward(request, response);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}