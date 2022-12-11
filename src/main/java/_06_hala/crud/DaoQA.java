package _06_hala.crud;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import _06_hala.bean.qa;
import factory.dbfactory;

public class DaoQA {
	QueryRunner queryRunner = new QueryRunner(dbfactory.createMSSQLConnection());

	// id查詢
	public List<qa> findById(Integer qaID) throws SQLException {
		String sql = "select* from QA where QAID=?";
		
			List<qa> list = queryRunner.query(sql, new BeanListHandler<qa>(qa.class), qaID);
			for (qa p : list) {
				System.out.println(p);
			}
		return list;
	}

	// 查詢全部資料
	public List<qa> searchAll() throws SQLException {
		String sql = "select * from qa order by qaid";
		List<qa> list = queryRunner.query(sql, new BeanListHandler<qa>(qa.class));
		for (qa p : list) {
			System.out.println(p);
		}
		return list;
	}

//		透過類別名稱建立模糊查詢
	public void searchClassLike(String qaClassName) throws SQLException {
		String sql = "select  * from qa where qaClassName like ?";
		String sql1 = "select count(*) from qa where qaClassName like ?";

		List<qa> list = queryRunner.query(sql, new BeanListHandler<qa>(qa.class), "%" + qaClassName + "%");
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), "%" + qaClassName + "%");
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (qa p : list) {
				System.out.println(p);
			}
		}
	}

//		新增一筆資料
	public String add( String qaClassName, Integer memberId, String title,
			 String qaContent) {
		String sql = "insert into qa values(?,?,?,GETDATE(),?)";
		try {
			int qa = queryRunner.update(sql,  qaClassName, memberId, title, qaContent);
			System.out.println(qa);
			return "新增成功";
		} catch (SQLException e) {
			e.printStackTrace();
			return "失敗";
		}
	}

	// 查詢ID刪除
	public void delete(Integer qaID) throws SQLException {
		String sql = "delete from qa where qaID=?";
		int row = queryRunner.update(sql, qaID);
		if (row > 0) {
			System.out.println("成功刪除了" + row + "筆資料");
		} else {
			System.out.println("刪除失敗");
		}
	}

//		搜尋id修改 標題與內容
	public void updateTitleContent(Integer qaID, String qaClassName,Integer memberId, String title, String qaContent) throws SQLException {
		String sql = "update qa set  qaClassName=?, memberId=?, title= ?,postdate=GETDATE(), qacontent=? where qaid= ? ";
		String sql1 = "select * from qa where qaID= ? ";
		int row = queryRunner.update(sql,qaClassName,memberId, title, qaContent, qaID);
		queryRunner.query(sql1, new BeanHandler<qa>(qa.class), qaID);
		if (row > 0) {
			System.out.println("已成功修改了" + row + "筆資料");

		}

	}
	public List<qa>  searchHalaClassName(String qaClassName) throws SQLException {
		String sql ="select * from qa where qaclassname=?";
		System.out.println(qaClassName);
		List<qa> list=queryRunner.query(sql, new BeanListHandler<qa>(qa.class),qaClassName);
		return list;
		
		
	}	
	
	
	
	

}
