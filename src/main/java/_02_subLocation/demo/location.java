package demo;


import java.sql.SQLException;
import java.util.List;

import bean.locationclass;
import dao.locationdao;



public class location {

	public static void main(String[] args) throws SQLException {
		locationdao sdao = new locationdao();
		List<locationclass> fbi = sdao.findById(1);
		System.out.println(fbi.toString());
		sdao.searchAllLoc();
		List list= sdao.findByClass("中正區");
		System.out.println(list);
//		sdao.add(3,"中山區","台北市");
//		sdao.deleteLocfromLocno(3);
//		sdao.updateLocFromLocno(1, "中正區", "台北市");
	}

}
