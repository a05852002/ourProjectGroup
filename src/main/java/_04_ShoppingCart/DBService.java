package _04_ShoppingCart;

import org.apache.commons.dbutils.QueryRunner;

import factory.dbfactory;

public class DBService {
	QueryRunner queryRunner = new QueryRunner(dbfactory.createMSSQLConnection());
	
	public  static final String DB_SQLSERVER = "SQLSERVER";
	public  static final String DB_TYPE = DB_SQLSERVER;
	
	private static final String DROP_Orders_SQLServer = 
			"IF OBJECT_ID('dbo.Orders', 'U') IS NOT NULL "
			+ " DROP TABLE dbo.Orders; ";

	private static final String DROP_OrderItems_SQLServer = 
			"IF OBJECT_ID('dbo.OrderItems', 'U') IS NOT NULL "
			+ " DROP TABLE dbo.OrderItems; ";
	

	private static final String CREATE_OrderItems_SQLServer = "Create TABLE OrderItems "
			+ "(seqno            int NOT NULL IDENTITY Primary Key , " 
			+ " orderNo          int, "
			+ " bookId           int, " 
			+ " Description      varchar(72), " 
			+ " amount           int, "
			+ " unitPrice        DECIMAL(18,1), " 
			+ " Discount         MONEY " 
			+ " ) ";


	private static final String CREATE_Orders_SQLServer = "Create Table Orders "
			+ "(orderNo  int NOT NULL IDENTITY Primary Key , " 
			+ " memberId          varchar(20), "
			+ " totalAmount       Decimal(11,1), " 
			+ " shippingAddress   varchar(64), "
			+ " BNO               varchar(8), " 
			+ " invoiceTitle      varchar(72), " 
			+ " orderDate         DateTime, "
			+ " ShippingDate      DateTime, " 
			+ " CancelTag         Char(1) " 
			+ " )";





	public static String getDropOrders() {
		String drop = null;
	if (DB_TYPE.equalsIgnoreCase(DB_SQLSERVER)) {
			drop = DROP_Orders_SQLServer;
		}
		return drop;
	}

	public static String getCreateOrders() {
		String create = null;
	 if (DB_TYPE.equalsIgnoreCase(DB_SQLSERVER)) {
			create = CREATE_Orders_SQLServer;
		}
		return create;
	}
	
	public static String getDropOrderItems() {
		String drop = null;
		 if (DB_TYPE.equalsIgnoreCase(DB_SQLSERVER)) {
			drop = DROP_OrderItems_SQLServer;
		}
		return drop;
	}

	public static String getCreateOrderItems() {
		String create = null;
		if (DB_TYPE.equalsIgnoreCase(DB_SQLSERVER)) {
			create = CREATE_OrderItems_SQLServer;
		}
		return create;
	}
	
	

}
