package _04_ShoppingCart;

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

import _04_ShoppingCart.dao.OrdersDao;

@WebServlet("/_04_ShoppingCart/OrderDelete.do")
public class OrderDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(OrderDelete.class);
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 OrdersDao oDao = new OrdersDao(); 
		 int orderNo = Integer.valueOf( request.getParameter("orderNo"));
			try {
				oDao.deleteOrderNo(orderNo);
//				response.sendRedirect(request.getContextPath()+"_04_ShoppingCart/searchAllServlet");
				RequestDispatcher rd = request.getRequestDispatcher("/_04_ShoppingCart/searchAllServlet");
				rd.forward(request, response);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
