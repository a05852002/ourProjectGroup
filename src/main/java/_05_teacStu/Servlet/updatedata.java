package Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.tableForTeac;
import dao.teacAndStudDao;


@MultipartConfig()
@WebServlet("/Servlet/updatedata")
public class updatedata extends HttpServlet {

	private static final long serialVersionUID = 1L;
@Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  Integer teacno = Integer.valueOf(req.getParameter("teacno"));
  Integer memberId = Integer.parseInt(req.getParameter("memberId"));
  String title = req.getParameter("title");
  String detail = req.getParameter("detail");
  Double price = Double.valueOf(req.getParameter("price"));
  String subjectItem = req.getParameter("subjectItem");
  InputStream in = req.getPart("images").getInputStream();
  long size = req.getPart("images").getSize();
  try {
   Blob image = GlobalService.fileToBlob(in, size);
   Date date = new Date();

   teacAndStudDao tDao = new teacAndStudDao();
   List<tableForTeac> list = tDao.searchTeacFromTeacno(teacno);
   tableForTeac t1 = null;
   for(tableForTeac t:list) {
	   t1=t;
   }
    t1.setMemberId(memberId);
    t1.setTitle(title);
    t1.setPostDate(date);
    t1.setDetail(detail);
    t1.setPrice(price);
    t1.setSubjectItem(subjectItem);
    if (req.getPart("images").getSize()!=0) {
    	t1.setClassPicture(image);
    }
   tDao.updateTeacFromTeacno(t1);
   resp.sendRedirect(req.getContextPath()+"/Servlet/searchAllTeacServlet");
  
  } catch (IOException | SQLException e) {
   e.printStackTrace();
  }
  
  
  
  
 }
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  doPost(req, resp);
 }

}
