package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import bean.subjectclass;
import factory.dbfactory;

public class subjectdao {
	QueryRunner queryRunner = new QueryRunner(dbfactory.createMSSQLConnection());

//	搜尋全部
	public List<subjectclass> searchAllSub() throws SQLException {
		String sql = "select * from subjectclass";
		List<subjectclass> list = queryRunner.query(sql, new BeanListHandler<subjectclass>(subjectclass.class));
//		for (subjectclass s : list) {
//			System.out.println(s);
//		}
		return list;
	}

//	搜尋by pk
	public List<subjectclass>  findById(Integer subno) throws SQLException {
		String sql = "select * FROM subjectclass where subno = ?";

		
			List<subjectclass> list = queryRunner.query(sql, new BeanListHandler<subjectclass>(subjectclass.class),subno);
//			subjectclass sc = queryRunner.query(sql, new BeanHandler<subjectclass>(subjectclass.class), subno);
			
		
		return list;
	}
	
//	透過類別建立查詢String

	public List<subjectclass> findByClass(String subClass) throws SQLException {
			String sql = "select * FROM subjectclass where subNo like ? or subName like ? or subClass like ? ";
//			String sql1 = "select count(*) from subjectclass where subClass =?";

			List<subjectclass> list = queryRunner.query(sql, new BeanListHandler<subjectclass>(subjectclass.class), "%" + subClass  + "%", "%" + subClass  + "%", "%" + subClass  + "%");
//			int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), subClass);
//			System.out.printf("搜尋到了%d筆資料", count);
//			if (count > 0) {
//				System.out.println("查詢結果 : ");
//				for (subjectclass s : list) {
//					System.out.println(s);
//				}
//			}
			return list;
	}	
	
//	新增
	public void add(int subno, String subName, String subClass) throws SQLException {
		String sql = "insert into subjectclass values(?,?,?)";
		Object[] params = { subno, subName, subClass};
		int row = queryRunner.update(sql, params);
		// 或是直接 queryRunner.update(sql,params); 就好
		System.out.println("新增了" + row + "筆資料");
	}

//	刪除
	public void deleteSubfromSubno(Integer subno) throws SQLException {
		String sql = "delete from subjectclass where subno = ?";
		int row = queryRunner.update(sql, subno);
		if (row > 0) {
			System.out.println("成功刪除了" + row + "筆資料");
		} else {
			System.out.println("刪除失敗->\"沒有對應的科目編號\"");
		}
	}

//	修改
	public void updateSubFromSubno(Integer subno, String subName, String subClass) throws SQLException {
		String sql = "update subjectclass set subName= ?,subClass= ? where subno= ? ";
		String sql1 = "select * from subjectclass where subno= ? ";
		int row = queryRunner.update(sql, subName,subClass, subno);
		subjectclass s = queryRunner.query(sql1, new BeanHandler<subjectclass>(subjectclass.class), subno);
		if (row > 0) {
			System.out.println("已成功修改了" + row + "筆資料");
			System.out.printf("產品編號 :\" %d \"的修改結果為 : %s", subno, s);
		}

	}


	


			
}
