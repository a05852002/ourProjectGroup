package meetbothmember.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.jasper.compiler.NewlineReductionServletWriter;

import com.zaxxer.hikari.HikariDataSource;

import factory.dbfactory;
import meetbothmember.model.Member;

public class MemberCRUD {
	HikariDataSource con = dbfactory.createMSSQLConnection();
	QueryRunner queryRunner = new QueryRunner(con);

//	搜尋全部
	public List<Member> searchAllMember() throws SQLException {
		String sql = "select memberID, account, password, idNumber, memName, memOld, memBirth, memGender,"
				+ "eMail, phone, address, registime from Member";
		List<Member> list = queryRunner.query(sql, new BeanListHandler<Member>(Member.class));
		return list;
	}

//	透過會員編號建立查詢
	public List<Member> searchMemFromID(Integer memberID) throws SQLException {
		String sql = "select memberID, account, password, idNumber, memName, memNickName, memOld, memBirth, memGender,"
				+ "eMail, phone, address, registime from Member where memberID=?";
		String sql1 = "select count(*) from Member where memberID =?";

		List<Member> list = queryRunner.query(sql, new BeanListHandler<Member>(Member.class), memberID);
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), memberID);
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (Member p : list) {
				System.out.println(p);
			}
		}
		return list;

	}
	
//	透過會員帳號建立模糊查詢
	public List<Member> searchMemFromAccount(String account) throws SQLException {
		String sql = "select memberID, account, password, idNumber, memName, memNickName, memOld, memBirth, memGender,"
				+ "eMail, phone, address, registime from Member where account like ?";
		String sql1 = "select count(*) from Member where account like ?";
		
		List<Member> list = queryRunner.query(sql, new BeanListHandler<Member>(Member.class), "%"+account+"%");
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), "%"+account+"%");
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (Member p : list) {
				System.out.println(p);
			}
		}
		return list;
	}

//	透過會員姓名建立模糊查詢
	public List<Member> searchMemByNameLike(String memName) throws SQLException {
		String sql = "select memberID, account, password, idNumber, memName, memNickName, memOld, memBirth, memGender,"
				+ "eMail, phone, address, registime from Member where memName like ?";
		String sql1 = "select count(*) from member where memName like ?";

		List<Member> list = queryRunner.query(sql, new BeanListHandler<Member>(Member.class),
				"%" + memName + "%");
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), "%" + memName + "%");
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (Member p : list) {
				System.out.println(p);
			}
		}
		return list;
	}

//	新增
	public void add(String account,String password,String idNumber,
			String memName, String memNickName, int memOld, String memBirth, String memGender,
			String eMail, int phone, String address) throws SQLException {
		String sql = "insert into member (account, password, idNumber, memName, memNickName, memOld, memBirth, memGender,"
				+ "	eMail, phone, address, registime) values(?,?,?,?,?,?,?,?,?,?,?,GETDATE())";
		Object[] params = { account, password, idNumber, memName, memNickName, memOld, memBirth, memGender,
				eMail, phone, address};
		int row = queryRunner.update(sql, params);
		// 或是直接 queryRunner.update(sql,params); 就好
		System.out.println("新增了" + row + "筆資料");
	}

//	刪除
	public void deleteMemfromMemberID(Integer memberID) throws SQLException {
		String sql = "delete from member where memberID = ?";
		int row = queryRunner.update(sql, memberID);
		if (row > 0) {
			System.out.println("成功刪除了" + row + "筆資料");
		} else {
			System.out.println("刪除失敗->\"沒有此會員資料\"");
		}
	}

//	透過帳號修改會員基本資料
	public void updateMemFromMemberID(String account,String password,String idNumber,
			String memName, String memNickName, int memOld, String memBirth, String memGender,
			String eMail, int phone, String address) throws SQLException {
		String sql = "update member set password = ?, idNumber = ?, memName = ?,"
				+ "memNickName = ?, memOld = ?, memBirth = ?, memGender = ?,"
				+ "eMail = ?, phone = ?, address = ? where account= ? ";
		Object[] params = { password, idNumber, memName, memNickName, memOld, memBirth, memGender,
				eMail, phone, address, account};
		int row = queryRunner.update(sql, params);
		if (row > 0) {
			System.out.println("已成功修改了" + row + "筆資料");
		}
	}
//	透過帳號傳入大頭照
	public void updatePhotoFromcAcount(String account, InputStream is) throws SQLException, IOException {
		String sql = "update member set photo = ? where account= ? ";
		int row = queryRunner.update(sql, is, account);
		if (row > 0) {
			System.out.println("已成功修改了" + row + "筆資料");
		}
	}
//	透過帳號輸出大頭照
	public Blob ShowPhoto(String account) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=MeetBoth;TrustServerCertificate=True", "sa", "sa123456");
		String sql = "select photo from Member where account = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, account);
		ResultSet rs = pre.executeQuery();
		rs.next();
		Blob blob = rs.getBlob(1);
		return blob;
	}


}