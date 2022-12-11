package _04_ShoppingCart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
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

@WebServlet("/_04_ShoppingCart/OrderItemInsert.do")
public class OrderItemInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(OrderItemInsert.class);
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("開始要新增了");
//		OrderBean od =new OrderBean();
//		Integer orderNo = od.getOrderNo();
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		System.out.println(orderNo);
//		int seqno = Integer.parseInt(request.getParameter("seqno"));
		String productId = request.getParameter("productId");
		System.out.println(productId);
		String productName = request.getParameter("productName");
		System.out.println(productName);
		String description = request.getParameter("description");
		System.out.println(description);
		int qty = Integer.parseInt(request.getParameter("qty"));
		Double unitPrice = Double.valueOf(request.getParameter("unitPrice"));
		try {
			OrdersItemDao oItemDao = new OrdersItemDao();
			oItemDao.insertItem(orderNo,productId,productName, description,qty,unitPrice);
			System.out.println(oItemDao);
			request.setAttribute("OrdersItemDao", oItemDao);
			RequestDispatcher rd = request.getRequestDispatcher("/_04_ShoppingCart/searchItemServlet.do");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
