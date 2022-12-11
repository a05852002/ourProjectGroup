package _06_hala.halaservlet;

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

import _06_hala.bean.hala;
import _06_hala.crud.DaoHala;


@WebServlet("/save")
public class save extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(save.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int halaID = 0;
		String takeID = request.getParameter("halaID");
		halaID = Integer.parseInt(takeID);
		try {
			DaoHala dh = new DaoHala();
			List<hala> beans = dh.findById(halaID);
			System.out.println(beans);
			request.setAttribute("bean", beans);
			RequestDispatcher rd = request.getRequestDispatcher("/html/updateHala.jsp");
			rd.forward(request, response);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}
}
