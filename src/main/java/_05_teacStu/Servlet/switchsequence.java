package Servlet;

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

import bean.tableForTeac;
import dao.teacAndStudDao;

@WebServlet("/Servlet/switchsequence")
public class switchsequence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int pageNo = 1;

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
	  doPost(request, response);
	 }

	  

	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
	  
	 
	  teacAndStudDao classService = new teacAndStudDao(); 
		try {
			String choose = request.getParameter("case");
			List<tableForTeac> classlist = new ArrayList<>();
			switch (choose) {
			case "1":
				classlist = classService.searchAllTeacOBmId();
				break;
			case "2":
				classlist = classService.searchAllTeacOBpDate();
				break;
			case "3":
				classlist = classService.searchAllTeacOBprice();
				break;
			default:
				classlist = classService.searchAllTeac();
				break;
			}
			
			request.setAttribute("classList",classlist);
			RequestDispatcher rd = request.getRequestDispatcher("/html/teacCRUD.jsp");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}


	 }
	}
