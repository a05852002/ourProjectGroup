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


@WebServlet("/findNameServlet")
public class findNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(crudservlet.class);

	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoHala dh = new DaoHala();

		try {
			String halaClassName = request.getParameter("halaclassname");
			List<hala> classList = dh.searchHalaClassName(halaClassName);
			System.out.println("123"+classList);
			request.setAttribute("classList", classList);
			RequestDispatcher rd = request.getRequestDispatcher("/html/hala.jsp");

			rd.forward(request, response);
			return;

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
