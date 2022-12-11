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

@WebServlet("/_04_ShoppingCart/OrderInsertTest.do")
public class OrderInsertTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(OrderInsertTest.class);
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("新增訂單功能之Controller: 開始");
		Map<String, String> errorMsgs = new HashMap<String, String>();
		Map<String, String> successMsgs = new HashMap<String, String>();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		request.setAttribute("ErrMsg", errorMsgs);
		session.setAttribute("successMsg", successMsgs);

//		OrdersDao classService = new OrdersDao();
//		// 讀取使用者所輸入，由瀏覽器送來的 memberId 欄位內的資料，注意大小寫
//		String memberId = request.getParameter("memberId");
//		// 讀取使用者所輸入，由瀏覽器送來的 orderDate 欄位內的資料，注意大小寫
//		Date orderDate = new Date();
//		// 讀取使用者所輸入，由瀏覽器送來的 shippingAddress 欄位內的資料
//		String shippingAddress = request.getParameter("shippingAddress");
//		// 讀取使用者所輸入，由瀏覽器送來的 totalAmount 欄位內的資料
//		Double totalAmount = Double.valueOf(request.getParameter("totalAmount"));
//		// 讀取使用者所輸入，由瀏覽器送來的 birthday 欄位內的資料
//
////		OrdersDao classServisce = new OrdersDao();
		// 讀取使用者所輸入，由瀏覽器送來的 memberId 欄位內的資料，注意大小寫
		String memberId = "";
		// 讀取使用者所輸入，由瀏覽器送來的 orderDate 欄位內的資料，注意大小寫
		Date orderDate = new Date();
		// 讀取使用者所輸入，由瀏覽器送來的 shippingAddress 欄位內的資料
		String shippingAddress = "";
		// 讀取使用者所輸入，由瀏覽器送來的 totalAmount 欄位內的資料
		String totalAmountStr = "";
		// 讀取使用者所輸入，由瀏覽器送來的 birthday 欄位內的資料
		Double totalAmount = 0.0;
		// 讀取使用者所輸入，由瀏覽器送來的 birthday 欄位內的資料

		
		Collection<Part> parts = request.getParts();

		// GlobalService.exploreParts(parts, request);
		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) {
				String fldName = p.getName();
//				System.out.println("fldName=" + fldName);
				String value = request.getParameter(fldName);
				if (p.getContentType() == null) { // 表示 p 為一般欄位而非上傳的表單
					// 根據欄位名稱來讀取欄位的內容，然後存入適當的變數內
					if (fldName.equals("memberId")) {
						memberId = value;
						if (value == null || memberId.trim().length() == 0) {
							errorMsgs.put("errMemberId", "必須輸入會員編號");
						} else {
							request.setAttribute("memberId", memberId);
						}
					} else if (fldName.equals("shippingAddress")) {
						shippingAddress = value;
						if (shippingAddress == null || shippingAddress.trim().length() == 0) {
							errorMsgs.put("errShippingAddress", "必須輸入會員地址");
						} else {
							request.setAttribute("shippingAddress", shippingAddress);
						}
					} else if (fldName.equals("totalAmountStr")) {
						totalAmountStr = value;
						totalAmountStr = totalAmountStr.trim();
						if (totalAmount == null || totalAmountStr.trim().length() == 0) {
							errorMsgs.put("errPrice", "必須輸入總金額");
						} else {
							try {
								totalAmount = Double.parseDouble(totalAmountStr);
							} catch (NumberFormatException e) {
								errorMsgs.put("errTotalAmount", "價格必須是數值");
							}
						}
						request.setAttribute("totalAmount", totalAmountStr);
					} 

				} 
				}
			}
		
		// 如果輸入資料有錯誤
		if (!errorMsgs.isEmpty()) {
			// 轉交給原輸入資料的網頁來顯示錯誤訊息
			log.info("新增書籍功能之Controller: 轉交給原輸入資料的網頁來顯示錯誤訊息");
			RequestDispatcher rd = request.getRequestDispatcher("/html/ordersCRUD.jsp");
			rd.forward(request, response);
			return;
		}
		
		// 將上傳的檔案轉換為 Blob 物件
		OrdersDao oDao = new OrdersDao();
		try {
			oDao.insert(memberId, orderDate, shippingAddress, totalAmount);
			log.info("新增書籍功能之Controller: 資料新增成功, BookBean=" );
			successMsgs.put("success", "資料新增成功");
			// 新增成功，通知瀏覽器對新網址發出請求
//		int lastPage = new BookServiceImpl().getTotalPages();
			RequestDispatcher rd = request.getRequestDispatcher("/_20_productMaintain/BookInsert.jsp");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
