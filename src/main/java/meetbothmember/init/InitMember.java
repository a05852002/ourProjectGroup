package meetbothmember.init;


import java.sql.Connection;
import java.sql.Statement;

import factory.dbfactory;

public class InitMember {

	public static void main(String[] args) {
		
		try (
				Connection con = dbfactory.createMSSQLConnection().getConnection(); 
				Statement stmt = con.createStatement();
				)
		{
//			創建member與Vitae表格
			stmt.executeUpdate(DBService.getDropMember());
			System.out.println("Member表格刪除成功");
			stmt.executeUpdate(DBService.getCreateMember());
			System.out.println("Member表格產生成功");
			stmt.executeUpdate(DBService.getDropVitae());
			System.out.println("Vitae表格刪除成功");
			stmt.executeUpdate(DBService.getCreateVitae());
			System.out.println("Vitae表格產生成功");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
