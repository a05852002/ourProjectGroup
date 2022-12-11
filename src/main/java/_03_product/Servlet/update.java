package _03_product.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import CRUD.dao;
import bean.product;

@MultipartConfig()
@WebServlet("/update")
public class update extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		
		int prodID = Integer.valueOf(req.getParameter("prodID"));
		int pclass = Integer.valueOf(req.getParameter("prodClass"));
		String pName = req.getParameter("prodName");
		int pPrice = Integer.valueOf(req.getParameter("prodPrice"));
		int memID = Integer.valueOf(req.getParameter("memberID"));
		int invt = Integer.valueOf(req.getParameter("inventory"));
		String pPost = req.getParameter("prodPost");
		String pUpdate = req.getParameter("prodUpdate");
		InputStream in = req.getPart("images").getInputStream();
		long size = req.getPart("images").getSize();
		try {
			Blob image = GlobalService.fileToBlob(in, size);

			dao d = new dao();
			List<product> list = d.searchProdFromProdID(prodID);
			if (req.getPart("images").getSize() != 0) {
				d.updateProdFromProdID(pclass, pName, pPrice, memID, invt, image,prodID);
			}else {
				d.updateProdWithoutPicFromProdID(pclass, pName, pPrice, memID, invt, prodID);
			}
			
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
