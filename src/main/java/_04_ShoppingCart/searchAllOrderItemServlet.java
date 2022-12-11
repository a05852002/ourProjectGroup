package _04_ShoppingCart;

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

import _04_ShoppingCart.dao.OrdersDao;
import _04_ShoppingCart.dao.OrdersItemDao;
import _04_ShoppingCart.model.OrderBean;
import _04_ShoppingCart.model.OrderItemBean;

@WebServlet("/_04_ShoppingCart/searchOrderItemAllServlet")
public class searchAllOrderItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(searchAllOrderItemServlet.class);
	int pageNo = 1;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		OrdersItemDao classService = new OrdersItemDao(); 
		int oNo = Integer.valueOf( request.getParameter("orderNo"));
			try {
				List<OrderItemBean> classlist = classService.searchOrderItemByOrderNo(oNo);
				request.setAttribute("classList",classlist);
				RequestDispatcher rd = request.getRequestDispatcher("/html/order/ordersCRUD.jsp");
				rd.forward(request, response);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
