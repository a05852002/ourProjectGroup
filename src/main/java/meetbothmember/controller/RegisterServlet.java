package meetbothmember.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import meetbothmember.model.Member;
import meetbothmember.service.ImgService;
import meetbothmember.service.MemberCRUD;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
* 500, maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/meetbothmember/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//進行編碼
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				// 準備存放錯誤訊息的Map物件(requestScope)
				Map<String, String> requestErrorMsg = new HashMap<String, String>();
				// 準備存放註冊成功之訊息的Map物件(sessionScope)
				Map<String, String> sessionMessageOK = new HashMap<String, String>();
				// 註冊成功後將用response.sendRedirect(newURL)導向新的畫面，所以需要以
				// HttpSession物件來存放共用資料。
				HttpSession session = request.getSession();
				request.setAttribute("MsgMap", requestErrorMsg); // 顯示錯誤訊息
				session.setAttribute("MsgOK", sessionMessageOK); // 顯示正常訊息
				String account = "";
				String password = "";
				String passwordcheck = "";
				String idNumber = "";
				String memName = "";
				String memNickName = "";
				int memOld = 0;
				String memBirth  = "";
				String memGender = "";
				String email = "";
				int phone = 0;
				String address = "";
				String fileName ="";
				long sizeInBytes = 0;				
				InputStream is = null;				
				
				Collection<Part> parts = request.getParts();
				for (Part p : parts) {
					//foreach資料提取
					String fldName = p.getName();
					String value = request.getParameter(fldName);
					
					//判斷並放入各對應值內處理
					if (p.getContentType() == null) {
						if (fldName.equals("account")) {
							account = value;
						} else if (fldName.equals("password")) {
							password = value;
						} else if (fldName.equals("passwordcheck")) {
							passwordcheck = value;
						} else if (fldName.equals("idNumber")) {
							idNumber = value;
						} else if (fldName.equals("memName")) {
							memName = value;
						} else if (fldName.equals("memNickName")) {
							memNickName = value;
						} else if (fldName.equals("memOld")) {
							memOld = Integer.parseInt(value);
						} else if (fldName.equals("memBirth")) {
							memBirth = value;
						} else if (fldName.equals("memGender")) {
							memGender = value;
						} else if (fldName.equals("email")) {
							email = value;
						} else if (fldName.equals("phone")) {
							phone = Integer.parseInt(value);
						} else if (fldName.equals("address")) {
							address = value;
						}
					} else {
						// 取出圖片檔的檔名
						fileName = ImgService.getFileName(p);
						// 調整圖片檔檔名的長度，需要檔名中的附檔名，所以調整主檔名以免檔名太長無法寫入表格
						fileName = ImgService.adjustFileName(fileName, ImgService.IMAGE_FILENAME_LENGTH);
						if (fileName != null && fileName.trim().length() > 0) {
							sizeInBytes = p.getSize();
							is = p.getInputStream();
						} 
					}
				}
				//檢查帳號是否重複，若有則回報error
				MemberCRUD mc = new MemberCRUD() ;
				try {
					if(mc.searchMemFromAccount(account).size() == 0 ) {
						if (password.equals(passwordcheck)) {
							mc.add(account, password, idNumber, memName, memNickName,
									memOld, memBirth, memGender, email, phone, address);
							if (fileName != null && fileName.trim().length() > 0) {
								mc.updatePhotoFromcAcount(account, is);
							}
						}
					}else {
						response.sendRedirect("../html/MeetBothMember/register.jsp");
					}
					List<Member> list = mc.searchAllMember();
					request.setAttribute("Member", list);
					RequestDispatcher rd = request.getRequestDispatcher("../html/MeetBothMember/admin.jsp");
					rd.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

}
