package _03_product.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CRUD.dao;
import bean.product;

@WebServlet("/web/searchingProd")
public class searchingProd extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao d = new dao();

		List<product> list;
		try {
			list = d.searchAll();
			request.setAttribute("allprodlist", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/html/shopHome.jsp");
		rd.forward(request, response);
		return;

//			-------
//			List<product> allprod = d.searchAllProd();
//			request.setAttribute("allprodlist", allprod);
//			request.setAttribute("imgsrc", "http://localhost:8080/jspExercise/html/"+"prodimg/acc.png");
//			RequestDispatcher rd = request.getRequestDispatcher("/html/shopHome.jsp");
//			rd.forward(request, response);

	}

}
