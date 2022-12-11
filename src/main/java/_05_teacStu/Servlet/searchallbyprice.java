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

@WebServlet("/Servlet/searchallbyprice")
public class searchallbyprice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		teacAndStudDao classService = new teacAndStudDao();
		String lowstr = request.getParameter("low");
		String highstr = request.getParameter("high");
		if (lowstr.equals("最低時薪") || lowstr.equals("")) {
			lowstr="0";
		}
		if (highstr.equals("最高時薪") || highstr.equals("")) {
			highstr="999999999";
		}
		Integer low = Integer.valueOf(lowstr);
		Integer high = Integer.valueOf(highstr);
		try {

			List<tableForTeac> classlist = classService.searchTeacByPrice(low, high);
			request.setAttribute("classList", classlist);
			RequestDispatcher rd = request.getRequestDispatcher("/html/teacCRUD.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}

}