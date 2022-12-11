package _06_hala.halaservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _06_hala.bean.hala;
import _06_hala.crud.DaoHala;



@WebServlet("/halaservlet/addservlet")
public class addservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(addservlet.class);

	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String halaClassName=request.getParameter("halaclassname");
		int memberId=Integer.valueOf(request.getParameter("memberid"));
		String title=request.getParameter("title");
		String halaContent=request.getParameter("halacontent");
		hala ha= new hala();
		try {
		DaoHala dh=new DaoHala();
		dh.add1(halaClassName,memberId,title,halaContent);
		request.setAttribute("hala", ha);
		RequestDispatcher rd=request.getRequestDispatcher("/halaservlet/crudservlet");
		rd.forward(request, response);
		return;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	
