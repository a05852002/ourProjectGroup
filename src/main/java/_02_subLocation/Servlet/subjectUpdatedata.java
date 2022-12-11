package _02_subLocation.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.subjectclass;
import dao.subjectdao;



@MultipartConfig()
@WebServlet("/Servlet/subjectUpdatedata")
public class subjectUpdatedata extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}
	
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 request.setCharacterEncoding("utf-8");
	 response.setCharacterEncoding("utf-8");
	subjectdao sDao = new subjectdao();
	System.out.println(request.getParameter("subNo"));
	int subNo = Integer.parseInt(request.getParameter("subNo"));
	String subName = request.getParameter("subName");
	String subClass = request.getParameter("subClass");
    try {
   	    sDao.updateSubFromSubno(subNo, subName, subClass);
		RequestDispatcher rd = request.getRequestDispatcher("/Servlet/subjectSearch");
		rd.forward(request, response);
		return;
  
  } catch (IOException | SQLException e) {
   e.printStackTrace();
  }
  
  
  
  
 }


}
