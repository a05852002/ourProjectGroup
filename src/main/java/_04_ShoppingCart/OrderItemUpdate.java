package _04_ShoppingCart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _04_ShoppingCart.dao.OrdersDao;
import _04_ShoppingCart.dao.OrdersItemDao;
import _04_ShoppingCart.model.OrderBean;

@WebServlet("/_04_ShoppingCart/OrderItemUpdate.do")
public class OrderItemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(OrderItemUpdate.class);
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}
//	Integer orderNo, Integer seqno,String description, Integer qty, Double unitPrice
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		OrdersItemDao oItemDao = new OrdersItemDao();
		System.out.println(request.getParameter("orderNo"));
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		int seqno = Integer.parseInt(request.getParameter("seqno"));
		String description = request.getParameter("description");
		int qty = Integer.parseInt(request.getParameter("qty"));
		Double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
		try {
			oItemDao.updateOrderFromOrderNo(orderNo, seqno,description,qty, unitPrice);
			RequestDispatcher rd = request.getRequestDispatcher("/_04_ShoppingCart/searchServlet.do");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
