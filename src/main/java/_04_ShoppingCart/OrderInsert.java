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
import _04_ShoppingCart.model.OrderBean;

@WebServlet("/_04_ShoppingCart/OrderInsert.do")
public class OrderInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(OrderInsert.class);
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String shippingAddress = request.getParameter("shippingAddress");
		try {
			OrdersDao oDao = new OrdersDao();
			oDao.insert(memberId, shippingAddress);;
			request.setAttribute("OrdersDao", oDao);
			RequestDispatcher rd = request.getRequestDispatcher("/_04_ShoppingCart/searchAllServlet");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

// 原本

//		if (memberId == null | shippingAddress == null | totalAmount == null) {
//			System.out.println("cancelled");
////			JOptionPane.showMessageDialog(null, "取消新增 返回主頁面", "觀光工廠資訊新增", JOptionPane.ERROR_MESSAGE);
//
//		}
//		if (memberId.isEmpty()) {
//			System.out.println("wrong entry");
////			JOptionPane.showMessageDialog(null, "沒有輸入任何資料", "觀光工廠資訊新增", JOptionPane.ERROR_MESSAGE);
//
//		} else {
//			try {
//				Boolean check = true;
//				OrderBean o = new OrderBean();
//				if (check) {
//					try {
//						classService.insert(memberId, orderDate, shippingAddress, totalAmount);
//
//						// Case3 屬性物件是Map物件==>透過EL來取用，${識別字串.鍵值}就可取得對應的value
//						Map<String, Object> map = new HashMap<String, Object>();
//						map.put("NameError", "會員編號不能空白");
//						map.put("AddreddError", "訂單地址不能空白"); // ${errorMSG.AddreddError}
//						map.put("order", o);
//						request.setAttribute("errorMSG", map); // ${errorMSG.NameError}
//
//						// 產生 RequestDispatcher 物件 rd
//						RequestDispatcher rd = request.getRequestDispatcher("/html/InsertOrdersSuccess.jsp");
//						// 請容器代為呼叫下一棒程式
//						rd.forward(request, response);
//						return;
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						// 產生 RequestDispatcher 物件 rd
////						RequestDispatcher rd = request.getRequestDispatcher("/ch02/InsertMemberError.jsp");
//						// 請容器代為呼叫下一棒程式
////						rd.forward(request, response);
//						return;
//					}
//				} else {
////					JOptionPane.showMessageDialog(null, "ID重複 返回首頁", "觀光工廠資訊新增", JOptionPane.ERROR_MESSAGE);
//				}
//			} catch (NumberFormatException nfe) {
////				JOptionPane.showMessageDialog(null, "請輸入數字", "觀光工廠資訊刪除", JOptionPane.ERROR_MESSAGE);
//
//			}
//
//		}
//	}
//	}
