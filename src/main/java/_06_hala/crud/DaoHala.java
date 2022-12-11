package _06_hala.crud;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import _06_hala.bean.hala;
import factory.dbfactory;

public class DaoHala {
	QueryRunner queryRunner = new QueryRunner(dbfactory.createMSSQLConnection());

	// id查詢
	public List<hala> findById(Integer halaID) throws SQLException {
		String sql = "select* from HALA where HALAID=? ";
		
			List<hala> list = queryRunner.query(sql, new BeanListHandler<hala>(hala.class), halaID);
			for (hala p : list) {
				System.out.println(p);
			}
		return list;
	}




//	新增一筆資料
	public String add( String halaClassName, Integer memberId, String title,
			 String halaContent) {
		String sql = "insert into HALA values(?,?,?,GETDATE(),?)";

		try {
			int hala = queryRunner.update(sql, halaClassName, memberId, title,
					halaContent);
			System.out.println(hala);
			return "新增成功";
		} catch (SQLException e) {
			e.printStackTrace();
			return "失敗";
		}
	}



	// 查詢ID刪除
	public void delete(Integer halaID) throws SQLException {
		String sql = "delete from HALA where HALAID=?";
		int row = queryRunner.update(sql, halaID);
		if (row > 0) {
			System.out.println("成功刪除了" + row + "筆資料");
		} else {
			System.out.println("刪除失敗");
		}
	}

	public void add1( String halaClassName, Integer memberId, String title,
			String halaContent) throws SQLException {
		String sql = "insert into HALA values(?,?,?,GETDATE(),?)";
		Object[] params = {halaClassName, memberId, title, halaContent };
		int row = queryRunner.update(sql, params);
		System.out.println("新增了" + row + "筆資料");
	}
//	搜尋id修改 標題與內容
	public void updateHala(Integer halaID,String halaClassName,Integer memberId, String title, String halaContent) throws SQLException {
		String sql = "update hala set halaClassName= ?, memberId=?,title=?,postdate=GETDATE(),halaContent=? where halaid= ? ";
		String sql1 = "select * from hala where halaID= ? ";
		int row = queryRunner.update(sql, halaClassName,memberId,title, halaContent, halaID);
		queryRunner.query(sql1, new BeanHandler<hala>(hala.class), halaID);
		if (row > 0) {
			System.out.println("已成功修改了" + row + "筆資料");

		}

	}
	
	
//	透過類別名稱建立模糊查詢
	public void searchClassLike(String halaClassName) throws SQLException {
		String sql = "select  * from hala where halaClassName like ?";
		String sql1 = "select count(*) from hala where halaClassName like ?";
		
		List<hala> list = queryRunner.query(sql, new BeanListHandler<hala>(hala.class), "%" + halaClassName + "%");
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), "%" + halaClassName + "%");
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (hala p : list) {
				System.out.println(p);
			}
		}
	}
	//半成品
	public List<hala>  searchHalaClassName(String halaClassName) throws SQLException {
		String sql ="select * from hala where halaclassname=?";
		System.out.println(halaClassName);
		List<hala> list=queryRunner.query(sql, new BeanListHandler<hala>(hala.class),halaClassName);
		return list;
		
		
	}	
	
	// 查詢全部資料
	public List<hala> searchAll() throws SQLException {
		String sql = "select * from hala order by halaid ";
		List<hala> list = queryRunner.query(sql, new BeanListHandler<hala>(hala.class));
		for (hala p : list) {
			System.out.println(p);
		}
		return list;
	}
}
