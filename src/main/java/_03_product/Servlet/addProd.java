package _03_product.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import CRUD.dao;
import bean.product;

@MultipartConfig
@WebServlet("/addProd")
public class addProd extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pclass = Integer.valueOf(req.getParameter("pClass"));
		String pName = req.getParameter("pName");
		int pPrice = Integer.valueOf(req.getParameter("pPrice"));
		int memID = Integer.valueOf(req.getParameter("memID"));
		int invt = Integer.valueOf(req.getParameter("invt"));
//		String pPost = req.getParameter("pPost");
//		String pUpdate = req.getParameter("pUpdate");
		InputStream in = req.getPart("pPic").getInputStream();
		long size = req.getPart("pPic").getSize();
		try {
			Blob image = GlobalService.fileToBlob(in, size);
			dao d = new dao();
//			product p = null;
//			p.setProdClass(pclass);
//			p.setProdName(pName);
//			p.setProdPrice(pPrice);
//			p.setMemberID(memID);
//			p.setInventory(invt);
//			p.setProdPost(pPost);
//			p.setProdUpdate(pUpdate);
//			if (req.getPart("images").getSize() != 0) {
//				p.setProdImg(image);
//			}
			d.add(pclass, pName, pPrice, memID, invt,image);
			
			
			
			resp.sendRedirect(req.getContextPath() + "/web/searchingProd");

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
