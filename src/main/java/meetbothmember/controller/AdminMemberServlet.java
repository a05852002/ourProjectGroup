package meetbothmember.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.FullReadInputStream;

import meetbothmember.model.Member;
import meetbothmember.service.MemberCRUD;

/**
 * Servlet implementation class AdminMember
 */
@WebServlet("/meetbothmember/AdminMember.do")
public class AdminMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//進行編碼
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//向伺服器進行請求
		Map<String, String[]> orders = request.getParameterMap();
//		String delete = "";
//		delete = request.getParameter("delete");
		MemberCRUD mc = new MemberCRUD();
		if (orders.containsKey("selectAll")){
			try {
				List<Member> list = mc.searchAllMember();
				request.setAttribute("Member", list);
				RequestDispatcher rd = request.getRequestDispatcher("/MeetBothMember/admin.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if (orders.containsKey("delete") && orders.get("delete").length>0) {
			try {
				for (String p : orders.get("delete")) {
					int ID = Integer.parseInt(p);					
					mc.deleteMemfromMemberID(ID);
				}
				List<Member> list = mc.searchAllMember();
				request.setAttribute("Member", list);
				RequestDispatcher rd = request.getRequestDispatcher("/MeetBothMember/admin.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (orders.containsKey("showPhoto")) {
			
				try {
					
					for (String p : orders.get("showPhoto")) {
						String account = p;
						Blob blob = mc.ShowPhoto(account);

						InputStream is = null;
						is = blob.getBinaryStream();
						
						response.setContentType("image/png");
						OutputStream os = response.getOutputStream();
						int len = 0;
						byte[] bytes = new byte[8192];
						while ((len = is.read(bytes)) != -1) {
							os.write(bytes, 0, len);
						}
						
//						RequestDispatcher rd = request.getRequestDispatcher("/MeetBothMember/show.jsp");
//						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else if(orders.containsKey("register")){
			response.sendRedirect("../MeetBothMember/register.jsp");
		}else if(orders.containsKey("preupdate")) {
			try {
				int ID = 0;
				for (String p : orders.get("preupdate")) {
					ID = Integer.parseInt(p);					
				}
				List<Member> list = mc.searchMemFromID(ID);
				request.setAttribute("Member", list);
				RequestDispatcher rd = request.getRequestDispatcher("/MeetBothMember/MemberUpdate.jsp");
				rd.forward(request, response);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
