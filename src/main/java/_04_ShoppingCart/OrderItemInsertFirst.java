package _04_ShoppingCart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _04_ShoppingCart.dao.OrdersDao;
import _04_ShoppingCart.dao.OrdersItemDao;
import _04_ShoppingCart.model.OrderBean;
import _04_ShoppingCart.model.OrderItemBean;

@WebServlet("/_04_ShoppingCart/OrderItemInsertFirst.do")
public class OrderItemInsertFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(OrderItemInsertFirst.class);
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("找編號");
		int orderNo = Integer.valueOf( request.getParameter("orderNo"));
		System.out.println(orderNo);
		OrdersItemDao ordersItemDao =new OrdersItemDao();
		try {
			List<OrderItemBean> oItemDao = ordersItemDao.searchOrderNoByOrderNo(orderNo);
			System.out.println("找到了");
			request.setAttribute("OrdersItemDao", oItemDao);
			RequestDispatcher rd = request.getRequestDispatcher("/html/order/orderItemInsert.jsp");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
