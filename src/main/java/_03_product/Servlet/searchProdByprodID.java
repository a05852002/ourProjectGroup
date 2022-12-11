package _03_product.Servlet;

import java.io.IOException;
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

import CRUD.dao;
import bean.product;


@WebServlet("/searchProdByprodID")
public class searchProdByprodID extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 private static Logger log = LoggerFactory.getLogger(searchProdByprodID.class);
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
	  
	  int prodID = 0;
	  String id = request.getParameter("id");
	  prodID = Integer.parseInt(id);
	  dao d = new dao();
	  
	  try {
		List<product> bean = d.searchProdFromProdID(prodID);
		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("/html/UpdateProd.jsp");
		rd.forward(request, response);
		return;
	  } catch (SQLException e) {
		e.printStackTrace();
	  }
	 
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
	  doGet(request, response);
	 }
	}
