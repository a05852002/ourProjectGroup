package _06_hala.halaservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _06_hala.crud.DaoHala;


@WebServlet("/updateHalaServlet")
public class updateHalaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(DaoHala.class);
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DaoHala dh = new DaoHala();
		System.out.println(request.getParameter("halaid"));
		int halaID = Integer.parseInt(request.getParameter("halaid"));
		String halaClassName=request.getParameter("halaclassname");
		int memberId=Integer.valueOf(request.getParameter("memberid"));
		String title=request.getParameter("title");
		String halaContent=request.getParameter("halacontent");
	
		
		try {
			dh.updateHala(halaID,halaClassName,memberId, title,  halaContent);
			RequestDispatcher rd = request.getRequestDispatcher("/halaservlet/crudservlet");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
