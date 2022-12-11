package meetbothmember.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import meetbothmember.model.UserLoginData;

/**
 * Servlet implementation class AdminControll
 */
@WebServlet("/meetbothmember/logout.do")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        // 清除資料
        if (request.getParameter("check").equals("1")) {
        	session.invalidate();
        	response.sendRedirect("../html/index.jsp");
//        	request.getRequestDispatcher("../html/index.jsp").forward(request, response);			
		}else {
			response.sendRedirect("../html/index.jsp");
//			request.getRequestDispatcher("../html/index.jsp").forward(request, response);						
		}
	}

}
