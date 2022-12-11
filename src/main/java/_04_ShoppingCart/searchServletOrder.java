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
import _04_ShoppingCart.model.OrderBean;

@WebServlet("/_04_ShoppingCart/searchServlet.do")
public class searchServletOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(searchServletOrder.class);
	int pageNo = 1;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");  
		
		OrdersDao classService = new OrdersDao(); 
		  int oNo = Integer.valueOf( request.getParameter("orderNo"));
			try {
				List<OrderBean> classlist = classService.searchOrderNoLike(oNo);
				request.setAttribute("classList",classlist);
				RequestDispatcher rd = request.getRequestDispatcher("/html/order/orderUpdate.jsp");
				rd.forward(request, response);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
