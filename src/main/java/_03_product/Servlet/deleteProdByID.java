package _03_product.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CRUD.dao;

/**
 * Servlet implementation class deleteProdByID
 */
@WebServlet("/deleteProdByID")
public class deleteProdByID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int prodID = Integer.valueOf(request.getParameter("id"));

		dao d = new dao();
		try {
			d.deleteProdfromProdID(prodID);
			RequestDispatcher rd = request.getRequestDispatcher("/web/searchingProd");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
