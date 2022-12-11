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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean.tableForTeac;
import dao.teacAndStudDao;

@WebServlet("/Servlet/datesave")
public class datesave extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
 private static Logger log = LoggerFactory.getLogger(datesave.class);
 
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  
  int teacno = 0;
  String strclassId = request.getParameter("teacno");
  teacno = Integer.parseInt(strclassId);
  teacAndStudDao classDao = new teacAndStudDao();
  
  try {
	List<tableForTeac> bean = classDao.searchTeacFromTeacno(teacno);
	request.setAttribute("bean", bean);
	RequestDispatcher rd = request.getRequestDispatcher("/html/updateteac.jsp");
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
