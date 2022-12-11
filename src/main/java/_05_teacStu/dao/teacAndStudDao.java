package dao;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import bean.tableForStud;
import bean.tableForTeac;
import factory.dbfactory;

public class teacAndStudDao {
	QueryRunner queryRunner = new QueryRunner(dbfactory.createMSSQLConnection());

	public tableForTeac select(Integer teacno) {
		String sql = "select * from teacher where teacno = ?";
		try {
			tableForTeac tftas = queryRunner.query(sql, new BeanHandler<tableForTeac>(tableForTeac.class), teacno);
			return tftas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	搜尋全部教師貼文done
	public List<tableForTeac> searchAllTeac() throws SQLException {
		String sql = "select * from teacher order by teacno";
		List<tableForTeac> list = queryRunner.query(sql, new BeanListHandler<tableForTeac>(tableForTeac.class) {
			public List<tableForTeac> handle(ResultSet rs) throws SQLException {
				List<tableForTeac> classList = new ArrayList<tableForTeac>();
				while (rs.next()) {
					tableForTeac cb = new tableForTeac();
					cb.setTeacno(rs.getInt("teacno"));
					cb.setMemberId(rs.getInt("memberId"));
					cb.setTitle(rs.getString("title"));
					cb.setPostDate(rs.getDate("postDate"));
					cb.setDetail(rs.getString("detail"));
					cb.setPrice(rs.getDouble("price"));
					cb.setSubjectItem(rs.getString("subjectItem"));
					cb.setClassPicture(rs.getBlob("ClassPicture"));
					classList.add(cb);
				}
				return classList;
			}
		});
		return list;
	}

//  搜尋全部教師貼文依會員編號排序	
	public List<tableForTeac> searchAllTeacOBmId() throws SQLException {
		String sql = "select * from teacher order by memberId";
		List<tableForTeac> list = queryRunner.query(sql, new BeanListHandler<tableForTeac>(tableForTeac.class) {
			public List<tableForTeac> handle(ResultSet rs) throws SQLException {
				List<tableForTeac> classList = new ArrayList<tableForTeac>();
				while (rs.next()) {
					tableForTeac cb = new tableForTeac();
					cb.setTeacno(rs.getInt("teacno"));
					cb.setMemberId(rs.getInt("memberId"));
					cb.setTitle(rs.getString("title"));
					cb.setPostDate(rs.getDate("postDate"));
					cb.setDetail(rs.getString("detail"));
					cb.setPrice(rs.getDouble("price"));
					cb.setSubjectItem(rs.getString("subjectItem"));
					cb.setClassPicture(rs.getBlob("ClassPicture"));
					classList.add(cb);
				}
				return classList;
			}
		});
		return list;
	}
	
//  搜尋全部教師貼文依日期降序排序	
	public List<tableForTeac> searchAllTeacOBpDate() throws SQLException {
		String sql = "select * from teacher order by postDate desc";
		List<tableForTeac> list = queryRunner.query(sql, new BeanListHandler<tableForTeac>(tableForTeac.class) {
			public List<tableForTeac> handle(ResultSet rs) throws SQLException {
				List<tableForTeac> classList = new ArrayList<tableForTeac>();
				while (rs.next()) {
					tableForTeac cb = new tableForTeac();
					cb.setTeacno(rs.getInt("teacno"));
					cb.setMemberId(rs.getInt("memberId"));
					cb.setTitle(rs.getString("title"));
					cb.setPostDate(rs.getDate("postDate"));
					cb.setDetail(rs.getString("detail"));
					cb.setPrice(rs.getDouble("price"));
					cb.setSubjectItem(rs.getString("subjectItem"));
					cb.setClassPicture(rs.getBlob("ClassPicture"));
					classList.add(cb);
				}
				return classList;
			}
		});
		return list;
	}
	
//  搜尋全部教師貼文依時薪降序排序	
	public List<tableForTeac> searchAllTeacOBprice() throws SQLException {
		String sql = "select * from teacher order by price desc";
		List<tableForTeac> list = queryRunner.query(sql, new BeanListHandler<tableForTeac>(tableForTeac.class) {
			public List<tableForTeac> handle(ResultSet rs) throws SQLException {
				List<tableForTeac> classList = new ArrayList<tableForTeac>();
				while (rs.next()) {
					tableForTeac cb = new tableForTeac();
					cb.setTeacno(rs.getInt("teacno"));
					cb.setMemberId(rs.getInt("memberId"));
					cb.setTitle(rs.getString("title"));
					cb.setPostDate(rs.getDate("postDate"));
					cb.setDetail(rs.getString("detail"));
					cb.setPrice(rs.getDouble("price"));
					cb.setSubjectItem(rs.getString("subjectItem"));
					cb.setClassPicture(rs.getBlob("ClassPicture"));
					classList.add(cb);
				}
				return classList;
			}
		});
		return list;
	}

//	搜尋全部學生貼文	
	public void searchAllStud() throws SQLException {
		String sql = "select * from student";
		List<tableForStud> list = queryRunner.query(sql, new BeanListHandler<tableForStud>(tableForStud.class));
		for (tableForStud s : list) {
			System.out.println(s);
		}
	}

//	透過貼文編號建立教師貼文查詢done
	public List<tableForTeac> searchTeacFromTeacno(Integer teacno) throws SQLException {
		String sql = "select  * from teacher where teacno= ? ";
		List<tableForTeac> list = queryRunner.query(sql, new BeanListHandler<tableForTeac>(tableForTeac.class) {
			public List<tableForTeac> handle(ResultSet rs) throws SQLException {
				List<tableForTeac> classList = new ArrayList<tableForTeac>();
				while (rs.next()) {
					tableForTeac cb = new tableForTeac();
					cb.setTeacno(rs.getInt("teacno"));
					cb.setMemberId(rs.getInt("memberId"));
					cb.setTitle(rs.getString("title"));
					cb.setPostDate(rs.getDate("postDate"));
					cb.setDetail(rs.getString("detail"));
					cb.setPrice(rs.getDouble("price"));
					cb.setSubjectItem(rs.getString("subjectItem"));
					cb.setClassPicture(rs.getBlob("ClassPicture"));
					classList.add(cb);
				}
				return classList;
			}
		}, teacno);
		return list;
	}

//	透過貼文編號建立學生貼文查詢
	public void searchStudFromStudno(Integer studno) throws SQLException {
		String sql = "select  * from student where studno= ? ";
		String sql1 = "select count(*) from student where studno = ? ";

		List<tableForStud> list = queryRunner.query(sql, new BeanListHandler<tableForStud>(tableForStud.class), studno);
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), studno);
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (tableForStud s : list) {
				System.out.println(s);
			}
		}
	}
	
//  透過時薪區間建立教師貼文查詢

	public List<tableForTeac> searchTeacByPrice(Integer low, Integer high) throws SQLException {
		boolean wrongside = (low > high);
		boolean lowisnull = (low == null);
		boolean highisnull = (high == null);
		System.out.println("111"+!(lowisnull && highisnull));
		String price = "";
		if (lowisnull && highisnull) {
			price = "";
		} else if (wrongside) {
			price = "";
		} else if (lowisnull) {
			price = " where price <= " + high;
		}else if (highisnull) {
			price = " where price >= " + low;
		}else if (!(lowisnull && highisnull)) {
			price = " where price >= " + low + "and price <=" + high + "";
		}
		
		String sql = "select * from teacher" + price;
		List<tableForTeac> list = queryRunner.query(sql, new BeanListHandler<tableForTeac>(tableForTeac.class) {
			public List<tableForTeac> handle(ResultSet rs) throws SQLException {
				List<tableForTeac> classList = new ArrayList<tableForTeac>();
				while (rs.next()) {
					tableForTeac cb = new tableForTeac();
					cb.setTeacno(rs.getInt("teacno"));
					cb.setMemberId(rs.getInt("memberId"));
					cb.setTitle(rs.getString("title"));
					cb.setPostDate(rs.getDate("postDate"));
					cb.setDetail(rs.getString("detail"));
					cb.setPrice(rs.getDouble("price"));
					cb.setSubjectItem(rs.getString("subjectItem"));
					cb.setClassPicture(rs.getBlob("ClassPicture"));
					classList.add(cb);
				}
				return classList;
			}
		});
		return list;
	}
	
//	透過會員編號建立教師貼文查詢
	public List<tableForTeac> searchTeacFromMemberId(Integer memberId) throws SQLException {
		String sql = "select  * from teacher where memberid = ? ";
		String sql1 = "select count(*) from teacher where memberid = ? ";

		List<tableForTeac> list = queryRunner.query(sql, new BeanListHandler<tableForTeac>(tableForTeac.class),
				memberId);
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), memberId);
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (tableForTeac t : list) {
				System.out.println(t);
			}
		}
		return list;
	}

//	透過會員編號建立學生貼文查詢
	public void searchStudFromMemberId(Integer memberId) throws SQLException {
		String sql = "select  * from student where memberid = ? ";
		String sql1 = "select count(*) from student where memberid = ? ";

		List<tableForStud> list = queryRunner.query(sql, new BeanListHandler<tableForStud>(tableForStud.class),
				memberId);
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), memberId);
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (tableForStud s : list) {
				System.out.println(s);
			}
		}
	}

// 模糊查詢教師全部

	public List<tableForTeac> searchAllLike(String searchAllLike) throws SQLException {
		String sql = "select * from teacher where memberId like ? or title like ? or detail like ? or price like ? or subjectItem like ? ";
		List<tableForTeac> list = queryRunner.query(sql, new BeanListHandler<tableForTeac>(tableForTeac.class) {
			public List<tableForTeac> handle(ResultSet rs) throws SQLException {
				List<tableForTeac> classList = new ArrayList<tableForTeac>();
				while (rs.next()) {
					tableForTeac cb = new tableForTeac();
					cb.setTeacno(rs.getInt("teacno"));
					cb.setMemberId(rs.getInt("memberId"));
					cb.setTitle(rs.getString("title"));
					cb.setPostDate(rs.getDate("postDate"));
					cb.setDetail(rs.getString("detail"));
					cb.setPrice(rs.getDouble("price"));
					cb.setSubjectItem(rs.getString("subjectItem"));
					cb.setClassPicture(rs.getBlob("ClassPicture"));
					classList.add(cb);
				}
				return classList;
			}
		}, "%" + searchAllLike + "%", "%" + searchAllLike + "%", "%" + searchAllLike + "%", "%" + searchAllLike + "%",
				"%" + searchAllLike + "%");
		System.out.println(list);
		return list;
	}

//	透過title建立學生貼文模糊查詢
	public void searchStudFromTitleLike(String title) throws SQLException {
		String sql = "select  * from student where title like ?";
		String sql1 = "select count(*) from student where title like ?";

		List<tableForStud> list = queryRunner.query(sql, new BeanListHandler<tableForStud>(tableForStud.class),
				"%" + title + "%");
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), "%" + title + "%");
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (tableForStud s : list) {
				System.out.println(s);
			}
		}
	}

//  透過日期建立教師貼文查詢

//  透過日期建立學生貼文查詢

//  透過文章內容建立教師貼文模糊查詢
	public void searchTeacFromDetailLike(String detail) throws SQLException {
		String sql = "select  * from teacher where detail like ?";
		String sql1 = "select count(*) from teacher where detail like ?";

		List<tableForTeac> list = queryRunner.query(sql, new BeanListHandler<tableForTeac>(tableForTeac.class),
				"%" + detail + "%");
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), "%" + detail + "%");
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (tableForTeac t : list) {
				System.out.println(t);
			}
		}
	}

//  透過文章內容建立學生貼文模糊查詢
	public void searchStudFromDetailLike(String detail) throws SQLException {
		String sql = "select  * from student where detail like ?";
		String sql1 = "select count(*) from student where detail like ?";

		List<tableForStud> list = queryRunner.query(sql, new BeanListHandler<tableForStud>(tableForStud.class),
				"%" + detail + "%");
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), "%" + detail + "%");
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (tableForStud s : list) {
				System.out.println(s);
			}
		}
	}
//  透過時薪範圍建立教師貼文模糊查詢

//  透過時薪範圍建立學生貼文模糊查詢

//  透過科目建立教師貼文查詢
	public void searchTeacFromSubjectItem(String subjectItem) throws SQLException {
		String sql = "select  * from teacher where subjectitem = ? ";
		String sql1 = "select count(*) from teacher where subjectitem = ? ";

		List<tableForTeac> list = queryRunner.query(sql, new BeanListHandler<tableForTeac>(tableForTeac.class),
				subjectItem);
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), subjectItem);
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (tableForTeac t : list) {
				System.out.println(t);
			}
		}
	}

//  透過科目建立學生貼文查詢
	public void searchStudFromSubjectItem(String subjectItem) throws SQLException {
		String sql = "select  * from student where subjectitem = ? ";
		String sql1 = "select count(*) from student where subjectitem = ? ";

		List<tableForStud> list = queryRunner.query(sql, new BeanListHandler<tableForStud>(tableForStud.class),
				subjectItem);
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), subjectItem);
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (tableForStud s : list) {
				System.out.println(s);
			}
		}
	}

//  透過學習地區建立學生貼文模糊查詢
	public void searchStudFromLearnLocLike(String leanLoc) throws SQLException {
		String sql = "select  * from student where detail like ?";
		String sql1 = "select count(*) from student where detail like ?";

		List<tableForStud> list = queryRunner.query(sql, new BeanListHandler<tableForStud>(tableForStud.class),
				"%" + leanLoc + "%");
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), "%" + leanLoc + "%");
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (tableForStud s : list) {
				System.out.println(s);
			}
		}
	}

//	新增教師貼文
	public void addTeac(int memberId, String title, Date postDate, String detail, Double price, String subjectItem,
			Blob ClassPicture) throws SQLException {
		String sql = "insert into teacher values(?,?,?,?,?,?,?)";
		Object[] params = { memberId, title, postDate, detail, price, subjectItem, ClassPicture };
		int row = queryRunner.update(sql, params);
		// 或是直接 queryRunner.update(sql,params); 就好
		System.out.println("新增了" + row + "筆資料");
	}

////	新增教師貼文
//	public void addTeac(int teacno, int memberId, String title, String detail, Double price, String subjectItem) throws SQLException {
//		String sql = "insert into teacher values(?,?,?,?,?,?,?)";
//		Object[] params = { teacno, memberId, title,  detail, price, subjectItem };
//		int row = queryRunner.update(sql, params);
//		// 或是直接 queryRunner.update(sql,params); 就好
//		System.out.println("新增了" + row + "筆資料");
//	}

//	新增學生貼文
	public void addStud(int teacno, int memberId, String title, Date postDate, String detail, Double price,
			String subjectItem, String learnLoc) throws SQLException {
		String sql = "insert into student values(?,?,?,?,?,?,?,?)";
		Object[] params = { teacno, memberId, title, postDate, detail, price, subjectItem, learnLoc };
		int row = queryRunner.update(sql, params);
		// 或是直接 queryRunner.update(sql,params); 就好
		System.out.println("新增了" + row + "筆資料");
	}

//	透過ID刪除教師貼文
	public void deleteTeacfromTeacno(Integer teacno) throws SQLException {
		String sql = "delete from teacher where teacno = ?";
		int row = queryRunner.update(sql, teacno);
		if (row > 0) {
			System.out.println("成功刪除了" + row + "筆資料");
		} else {
			System.out.println("刪除失敗->\"沒有對應的貼文編號\"");
		}
	}

//	透過ID刪除學生貼文
	public void deleteStudfromStudno(Integer studno) throws SQLException {
		String sql = "delete from student where studno = ?";
		int row = queryRunner.update(sql, studno);
		if (row > 0) {
			System.out.println("成功刪除了" + row + "筆資料");
		} else {
			System.out.println("刪除失敗->\"沒有對應的貼文編號\"");
		}
	}

//	透過ID修改教師貼文
	public int updateTeacFromTeacno(tableForTeac tableForTeac) throws SQLException {
		String sql = "update teacher set memberId = ?, title = ?, postDate = ?, detail = ?, price = ?, subjectItem = ?, ClassPicture = ? where teacno= ? ";
		int row = queryRunner.update(sql, tableForTeac.getMemberId(), tableForTeac.getTitle(),
				tableForTeac.getPostDate(), tableForTeac.getDetail(), tableForTeac.getPrice(),
				tableForTeac.getSubjectItem(), tableForTeac.getClassPicture(), tableForTeac.getTeacno());
		return row;
	}

//	透過ID修改學生貼文title
	public void updateStudFromStudno(Integer studno, String title) throws SQLException {
		String sql = "update student set title = ? where studno= ? ";
		String sql1 = "select * from student where studno = ? ";
		int row = queryRunner.update(sql, title, studno);
		tableForStud s = queryRunner.query(sql1, new BeanHandler<tableForStud>(tableForStud.class), studno);
		if (row > 0) {
			System.out.println("已成功修改了" + row + "筆資料");
			System.out.printf("貼文編號 :\" %d \"的修改結果為 : %s", studno, s);
		}

	}
}
