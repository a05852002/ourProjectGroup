package _04_ShoppingCart.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import _04_ShoppingCart.model.OrderBean;
import _04_ShoppingCart.model.OrderItemBean;
import factory.dbfactory;

public class OrdersItemDao {
	QueryRunner queryRunner = new QueryRunner(dbfactory.createMSSQLConnection());

	// private Integer seqNo; //序號
	// private Integer orderNo; //訂單編號
	// private Integer productId; //商品編號
	//	private String productName; //商品名稱
	// private String description; //描述
	// private Integer qty; //數量
	// private Double unitPrice; //單價
	// private Double itemTotal; //總金額
	//

	// 新增------------------
//	新增一筆訂單
	public void insertItem(int orderNo, String productId,String productName, String description, int qty, Double unitPrice)
			throws SQLException {
		String sql = "insert into orderItem values(?,?,?,?,?,?,?,?)";
		String sql1 = "select count(*) from orderItem where orderNo=? ";
		int row1 = queryRunner.query(sql1, new ScalarHandler<Integer>(), orderNo);
		System.out.println(row1);
		if (row1 > 0) {
			String sql2 = "select Top 1 seqNo from orderItem where orderNo=? order by seqNo DESC";
			int row2 = queryRunner.query(sql2, new ScalarHandler<Integer>(), orderNo);
			Object[] params = { orderNo, row2 + 1, productId,productName, description, qty, unitPrice,
					Double.valueOf(qty * unitPrice) };
			int row = queryRunner.update(sql, params);
			System.out.println("新增了" + row + "筆資料");

			// 更新order金額
			String sqlTotal = "select totalAmount from orders where orderNo=?";
			OrderBean o = queryRunner.query(sqlTotal, new BeanHandler<OrderBean>(OrderBean.class), orderNo);
			Double totalAmount = o.getTotalAmount();
			System.out.println(totalAmount);
			String sqlOrder = "update orders set totalAmount=? where orderNo=?";
			Object[] paramsOrder = { totalAmount + Double.valueOf(qty * unitPrice), orderNo };
			queryRunner.update(sqlOrder, paramsOrder);
			// 更新訂單的修改日期
			Date dt = new Date();
			String sqlOrder1 = "update orders set upOrderDate=? where orderNo=?";
			Object[] paramsOrder1 = { dt, orderNo };
			queryRunner.update(sqlOrder1, paramsOrder1);

		} else {
			Object[] params = { orderNo, row1 + 1, productId,productName, description, qty, unitPrice,
					Double.valueOf(qty * unitPrice) };

			int row = queryRunner.update(sql, params);
			System.out.println("新增了" + row + "筆資料");

			// 更新order金額
			String sqlTotal = "select totalAmount from orders where orderNo=?";
			OrderBean o = queryRunner.query(sqlTotal, new BeanHandler<OrderBean>(OrderBean.class), orderNo);
			Double totalAmount = o.getTotalAmount();
			System.out.println(totalAmount);
			String sqlOrder = "update orders set totalAmount=? where orderNo=?";
			Object[] paramsOrder = { totalAmount + Double.valueOf(qty * unitPrice), orderNo };
			queryRunner.update(sqlOrder, paramsOrder);
			// 更新訂單的修改日期
			Date dt = new Date();
			String sqlOrder1 = "update orders set upOrderDate=? where orderNo=?";
			Object[] paramsOrder1 = { dt, orderNo };
			queryRunner.update(sqlOrder1, paramsOrder1);

		}
		// 或是直接 queryRunner.update(sql,params); 就好
	}

//	Double.valueOf(qty*unitPrice)

	// 搜尋------------------
//	搜尋某訂單全部Item
	public List<OrderItemBean> searchOrderItemByOrderNo(int orderNo) throws SQLException {
		String sql = "select * from orderItem where orderNo=? Order BY seqNo";
		List<OrderItemBean> list = queryRunner.query(sql, new BeanListHandler<OrderItemBean>(OrderItemBean.class),
				orderNo);
		for (OrderItemBean o : list) {
			System.out.println(o);
		}
		return list;

	}
//	搜尋某訂單的OrderNo
	
	public List<OrderItemBean> searchOrderNoByOrderNo(int orderNo) throws SQLException {
		String sql = "select TOP 1 * from orderItem where orderNo=? Order BY seqNo";
		List<OrderItemBean> list = queryRunner.query(sql, new BeanListHandler<OrderItemBean>(OrderItemBean.class),
				orderNo);
		for (OrderItemBean o : list) {
			System.out.println(o);
		}
		return list;
	}

//	透過會員編號建立明確查詢
	public void searchOrderItemByMemberId(String memberId) throws SQLException {
		String sql = "select * from orderItem join orders ON orderItem.orderNo=orders.orderNo where memberId ? Order BY orderNo,seqNo";

		List<OrderItemBean> list = queryRunner.query(sql, new BeanListHandler<OrderItemBean>(OrderItemBean.class),
				memberId);
		int count = queryRunner.query(sql, new ScalarHandler<Integer>(), memberId);
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (OrderItemBean o : list) {
				System.out.println(o);
			}
		}

	}

//	透過產品編號建立查詢
	public List<OrderItemBean> searchOrderItemByProductId(String productId) throws SQLException {
		String sql = "select * from orderItem where productId=? Order BY orderNo";
		String sql1 = "select count(*) from orderItem where productId=? Order BY orderNo";

		List<OrderItemBean> list = queryRunner.query(sql, new BeanListHandler<OrderItemBean>(OrderItemBean.class),
				"%" + productId + "%");
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), "%" + productId + "%");
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (OrderItemBean o : list) {
				System.out.println(o);
			}
		}
		return list;
	}

//	找尋單價區間的item
	public List<OrderItemBean> searchOrderItemByunitPrice(Double Price1, Double Price2) throws SQLException {
		String sql = "select  * from orderItem where unitPrice BETWEEN ? AND ? Order BY seqno";
		String sql1 = "select  * from orderItem where unitPrice BETWEEN ? AND ? Order BY seqno";

		List<OrderItemBean> list = queryRunner.query(sql, new BeanListHandler<OrderItemBean>(OrderItemBean.class),
				Price1, Price2);
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), Price1, Price2);
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (OrderItemBean o : list) {
				System.out.println(o);
			}
		}
		return list;
	}

	// private Integer seqNo; //序號
		// private Integer orderNo; //訂單編號
		// private Integer productId; //商品編號
		//	private String productName; //商品名稱
		// private String description; //描述
		// private Integer qty; //數量
		// private Double unitPrice; //單價
		// private Double itemTotal; //總金額
		//
	
//	找尋商品編號 商品 描述的模糊搜尋
	public List<OrderItemBean> searchOrderItemLike(String search) throws SQLException {
		String sql = "select  * from orderItem where productId=? or productName=? or description=? ";
		String sql1 = "select  * from orderItem where productId=? or productName=? or description=? ";

		List<OrderItemBean> list = queryRunner.query(sql, new BeanListHandler<OrderItemBean>(OrderItemBean.class),
				search);
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), search);
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (OrderItemBean o : list) {
				System.out.println(o);
			}
		}
		return list;
	}
	
	// 刪除------------------
//	透過訂單項目編號刪除
	public void deleteOrderItemNo(int orderNo, int seqNo) throws SQLException {
		String sql = "delete from orderItem where orderNo = ? and seqNo = ? ";
		int row = queryRunner.update(sql, orderNo, seqNo);
		if (row > 0) {
			System.out.println("成功刪除了" + row + "筆資料");
		} else {
			System.out.println("刪除失敗->\"沒有對應的產品編號\"");
		}
	}

	// private Integer seqNo; //序號
	// private Integer orderNo; //訂單編號
	// private Integer productId; //商品編號
	//	private String productName; //商品名稱
	// private String description; //描述
	// private Integer qty; //數量
	// private Double unitPrice; //單價
	// private Double itemTotal; //總金額
	//

//	修改
	public void updateOrderFromOrderNo(Integer orderNo, Integer seqno,String description, Integer qty, Double unitPrice)
			throws SQLException {
		//找出原本的品像的總金額
		String sqlItemtotal = "select itemTotal from orderItem where orderNo=?";
		OrderItemBean order = queryRunner.query(sqlItemtotal, new BeanHandler<OrderItemBean>(OrderItemBean.class), orderNo);
		Double itemTotal = order.getItemTotal();
		
		//更新價格
		String sql = "update orderItem set description=?, qty=?,unitPrice=?,itemtotal=? where orderNo= ? and seqno= ?";
		Object[] params = {description, qty, unitPrice, Double.valueOf(qty * unitPrice), orderNo, seqno };
		int row = queryRunner.update(sql, params);
		String sql1 = "select * from orderItem where orderNo=? and seqno= ?";
		OrderItemBean o = queryRunner.query(sql1, new BeanHandler<OrderItemBean>(OrderItemBean.class), orderNo, seqno);
		Double itemTotal2 = o.getItemTotal();
		
		// 更新order金額
		String sqlTotal = "select totalAmount from orders where orderNo=?";
		OrderBean order1 = queryRunner.query(sqlTotal, new BeanHandler<OrderBean>(OrderBean.class), orderNo);
		Double totalAmount = order1.getTotalAmount();
		System.out.println(totalAmount);
		String sqlOrder = "update orders set totalAmount=? where orderNo=?";
		Object[] paramsOrder = { totalAmount -itemTotal+ itemTotal2, orderNo };
		queryRunner.update(sqlOrder, paramsOrder);

		// 更新訂單的修改日期
		Date dt = new Date();
		String sqlOrder1 = "update orders set upOrderDate=? where orderNo=?";
		Object[] paramsOrder1 = { dt, orderNo };
		queryRunner.update(sqlOrder1, paramsOrder1);
		if (row > 0) {
			System.out.println("已成功修改了" + row + "筆資料");
			System.out.printf("產品編號 :\" %d \"的修改結果為 : %s", orderNo, o);
		}
	}

}
