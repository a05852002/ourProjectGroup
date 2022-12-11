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

@WebServlet("/Servlet/subjectSearch")
public class subjectSearch extends HttpServlet {
private static final long serialVersionUID = 1L;

 private static Logger log = LoggerFactory.getLogger(subjectSearch.class);
 
 int pageNo = 1;

 protected void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  doPost(request, response);
 }

  

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  
 
	 subjectdao classService = new subjectdao(); 
	try {
		
		List<subjectclass> classlist = classService.searchAllSub();
		request.setAttribute("classList",classlist);
		RequestDispatcher rd = request.getRequestDispatcher("/html/subject/subsCRUD.jsp");
		rd.forward(request, response);
		return;
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	

 }
}
                                                                                                                                                                                                                                                                                                                                  