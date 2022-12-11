package _06_hala.crud;

import java.sql.SQLException;

public class runQA {

	public static void main(String[] args) throws SQLException {

		DaoQA daoQA = new DaoQA();
		// 查詢全部資料
//		daoQA.searchAll();

		// 用id查詢
//		daoQA.findById(1);

		// 透過類別名稱建立模糊查詢
//		daoQA.searchClassLike("公告");

		// 新增資料
//		String ad = daoQA.add(6, "公告", 5278, "規範", "2022/01/02", "你成年了嗎");
//		System.out.println(ad);

		// 查詢id修改標題與內容
		//daoQA.updateTitleContent(3,"問題",59999, "標題","2002/03/05","你有問題嗎");

		// 刪除資料
//		daoQA.delete(6);

	}

}
