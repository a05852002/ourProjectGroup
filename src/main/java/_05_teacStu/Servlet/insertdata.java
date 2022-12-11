package Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.teacAndStudDao;

@MultipartConfig()
@WebServlet("/Servlet/insertdata")
public class insertdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  doPost(req, resp);
	 }

	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  Integer memberId = Integer.parseInt(req.getParameter("memberId"));
	  System.out.println(memberId+"asda");
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
	   tDao.addTeac(memberId, title, date, detail, price, subjectItem, image);
	   resp.sendRedirect(req.getContextPath()+"/Servlet/searchAllTeacServlet");
	  
	  } catch (IOException | SQLException e) {
	   e.printStackTrace();
	  }
	 }
}
