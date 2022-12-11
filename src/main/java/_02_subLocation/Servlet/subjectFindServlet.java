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

@WebServlet("/Servlet/subjectFindServlet")
public class subjectFindServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

 private static Logger log = LoggerFactory.getLogger(subjectFindServlet.class);
 
 int pageNo = 1;

 protected void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  doPost(request, response);
 }

  

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  
 
	 subjectdao classFindService = new subjectdao(); 
	try {
		request.setCharacterEncoding("UTF-8");
		String subclass = request.getParameter("subclass"); //讀取瀏覽器送來的資料
        if (subclass == null || subclass.trim().length() == 0 ) {
        	subclass = "";   // 如果讀不到使用者輸入的資料，將變數設為"";
        	RequestDispatcher rd = request.getRequestDispatcher("/Servlet/subjectSearch");
    		rd.forward(request, response);
        }else {
		List<subjectclass> findByClassList = classFindService.findByClass(subclass);
		request.setAttribute("findByClassList",findByClassList);
		RequestDispatcher rd = request.getRequestDispatcher("/html/subject/subRead.jsp");
		rd.forward(request, response);
        }
		return;
	} catch(UnsupportedEncodingException e) {
        throw new ServletException(e); 
     } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	



 }
}
