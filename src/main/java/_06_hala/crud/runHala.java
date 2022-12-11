package _06_hala.crud;

import java.sql.SQLException;


public class runHala {

	public static void main(String[] args) throws SQLException {
		DaoHala daoHala = new DaoHala();
		// 查詢全部資料
//		daoHala.searchAll();

		// 用id查詢
//		daoHala.findById(1);

		// 透過類別名稱建立模糊查詢
//		daoHala.searchClassLike("公告");

		// 新增資料
//		String ad = daoHala.add(5, "公告", 5278, "規範", "2022/01/02", "你成年了嗎");
//		System.out.println(ad);

		// 查詢id修改標題與內容
//		daoHala.updateHala(1, "心得", 44,"好難","2022-02-02","真的好難");
//		
		// 刪除資料
//		daoHala.delete(5);
		
//		daoHala.add1(6, "心得", 3345,"JAVA", "2022/01/02", "你學會了嗎");
		
    	daoHala.searchHalaClassName("公告");
		
     

	}
}
