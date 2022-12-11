package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.locationclass;
import factory.dbfactory;

public class locationdao {
	QueryRunner queryRunner = new QueryRunner(dbfactory.createMSSQLConnection());



//	搜尋全部
	public List<locationclass> searchAllLoc() throws SQLException {
		String sql = "select * from locationclass";
		List<locationclass> list = queryRunner.query(sql, new BeanListHandler<locationclass>(locationclass.class));
//		for (subjectclass s : list) {
//			System.out.println(s);
//		}
		return list;
	}

//	搜尋by pk
	public List<locationclass> findById(Integer locno) throws SQLException {
		String sql = "select * FROM locationclass where locno = ?";

		List<locationclass> list = queryRunner.query(sql, new BeanListHandler<locationclass>(locationclass.class), locno);

		return list;
	}

//	透過類別建立查詢String

	public List<locationclass> findByClass(String locClass) throws SQLException {
		String sql = "select * FROM locationclass where locNo like ? or locName like ? or locClass like ?";
//			String sql1 = "select count(*) from subjectclass where subClass =?";

		List<locationclass> list = queryRunner.query(sql, new BeanListHandler<locationclass>(locationclass.class),
				 "%" + locClass  + "%", "%" + locClass  + "%", "%" + locClass  + "%");
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
	public void add(int locno, String locName, String locClass) throws SQLException {
		String sql = "insert into locationclass values(?,?,?)";
		Object[] params = { locno, locName, locClass };
		int row = queryRunner.update(sql, params);
		// 或是直接 queryRunner.update(sql,params); 就好
		System.out.println("新增了" + row + "筆資料");
	}

//	刪除
	public void deleteLocfromLocno(Integer locno) throws SQLException {
		String sql = "delete from locationclass where locno = ?";
		int row = queryRunner.update(sql, locno);
		if (row > 0) {
			System.out.println("成功刪除了" + row + "筆資料");
		} else {
			System.out.println("刪除失敗->\"沒有對應的科目編號\"");
		}
	}

//	修改
	public void updateLocFromLocno(Integer locno, String locName, String locClass) throws SQLException {
		String sql = "update locationclass set locName= ?,locClass= ? where locno= ? ";
		String sql1 = "select * from locationclass where locno= ? ";
		int row = queryRunner.update(sql, locName, locClass, locno);
		locationclass s = queryRunner.query(sql1, new BeanHandler<locationclass>(locationclass.class), locno);
		if (row > 0) {
			System.out.println("已成功修改了" + row + "筆資料");
			System.out.printf("產品編號 :\" %d \"的修改結果為 : %s", locno, s);
		}
	}
}
