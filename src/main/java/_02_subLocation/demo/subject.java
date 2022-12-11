package demo;

import java.sql.SQLException;
import java.util.List;

import bean.subjectclass;
import dao.subjectdao;

public class subject {

	public static void main(String[] args) throws SQLException {
		subjectdao sdao = new subjectdao();
		List<subjectclass> fbi = sdao.findById(1);
		System.out.println(fbi.toString());
		sdao.searchAllSub();
		List list= sdao.findByClass("1");
		System.out.println(list);
//		sdao.add(5,"西班牙文","語文");
//		sdao.deleteSubfromSubno(3);
//		sdao.updateSubFromSubno(3, "數學", "數理");
	}

}
