package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.tableForTeac;
import dao.teacAndStudDao;

@WebServlet("/Servlet/searchLike")
public class searchLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		teacAndStudDao classService = new teacAndStudDao();
		String search =request.getParameter("search") ;
		try {

			List<tableForTeac> classlist = classService.searchAllLike(search);
			request.setAttribute("classList", classlist);
			RequestDispatcher rd = request.getRequestDispatcher("/html/teacCRUD.jsp");
			rd.forward(request, response);
			

		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}

}
