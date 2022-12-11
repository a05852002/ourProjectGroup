package meetbothmember.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import meetbothmember.model.Member;
import meetbothmember.service.MemberCRUD;

/**
 * Servlet implementation class SeachMemByAccount
 */
@WebServlet("/meetbothmember/SeachMem.do")
public class SeachMemByAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//進行編碼
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
//		建立查詢物件
		MemberCRUD mc = new MemberCRUD();
		Map<String, String[]> orders = request.getParameterMap();
//		取值做查詢
		String value =request.getParameter("value");
		System.out.println(value);
		if(orders.containsKey("selectByAccount")) {
			try {
				List<Member> list = mc.searchMemFromAccount(value);
				request.setAttribute("Member", list);
				RequestDispatcher rd = request.getRequestDispatcher("/MeetBothMember/admin.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(orders.containsKey("selectByName")) {
			List<Member> list;
			try {
				list = mc.searchMemByNameLike(value);
				request.setAttribute("Member", list);
				RequestDispatcher rd = request.getRequestDispatcher("/MeetBothMember/admin.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}

}
