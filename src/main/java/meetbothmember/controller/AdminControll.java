package meetbothmember.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/meetbothmember/AdminControll.do")
public class AdminControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }

        if (username.equals("admin") && password.equals("admin123")) {
            out.print("Welcome, " + username);
//            HttpSession session = request.getSession();
            UserLoginData prof = new UserLoginData();
            prof.setId(username);
            session.setAttribute("user", prof);
            response.sendRedirect("../html/index.jsp");
//            request.getRequestDispatcher("../html/index.jsp").forward(request, response);
            
        } else {
            out.print("<font style='color:red;'>對不起，使用者名或密碼錯誤!</font>");
            response.sendRedirect("../html/index.jsp");
//            request.getRequestDispatcher("../html/Login.jsp").forward(request, response);
            
        }
        out.close();
	}

}
