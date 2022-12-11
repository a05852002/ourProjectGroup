package CRUD;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import bean.product;
import factory.dbfactory;

public class dao {

	QueryRunner queryRunner = new QueryRunner(dbfactory.createMSSQLConnection());
//	List<product> list;

//	搜尋全部
//	public List<product> searchAllProd() throws SQLException {
//		String sql = "select * from product";
//		List<product> list = queryRunner.query(sql, new BeanListHandler<product>(product.class));
////		for (product p : list) {
////			System.out.println(p);
////		}
//		return list;
//	}

//	新增 100
	public void add(int prodClass, String prodName, int prodPrice, int memberID, int inventory, Blob prodImg)
			throws SQLException {
		String sql = "insert into Product values (?,?,?,?,?,GETDATE(),GETDATE(),?);";
		queryRunner.update(sql, prodClass, prodName, prodPrice, memberID, inventory, prodImg);
	}

//	刪除 100
	public void deleteProdfromProdID(Integer prodID) throws SQLException {
		String sql = "delete from product where prodid = ?";
		queryRunner.update(sql, prodID);
	}

//	修改 100
	public void updateProdFromProdID(int prodClass, String prodName, int prodPrice, int memberID, int inventory,
			Blob prodImg, int prodID) throws SQLException {
		String sql = "update product set prodClass=?,prodName=?,prodPrice=?,memberID=?,inventory= ?,prodUpdate = GETDATE(),prodImg=? where prodID= ? ";
		queryRunner.update(sql, prodClass, prodName, prodPrice, memberID, inventory, prodImg, prodID);
	}

//	修改(但不改圖片)嘿嘿 100
	public void updateProdWithoutPicFromProdID(int prodClass, String prodName, int prodPrice, int memberID,
			int inventory, int prodID) throws SQLException {
		String sql = "update product set prodClass=?,prodName=?,prodPrice=?,memberID=?,inventory= ?,prodUpdate = GETDATE() where prodID= ? ";
		queryRunner.update(sql, prodClass, prodName, prodPrice, memberID, inventory, prodID);
	}

//	搜尋全部加圖片 100
	public List<product> searchAll() throws SQLException {
		String sql = "select * from product order by prodID";
		List<product> list = queryRunner.query(sql, new BeanListHandler<product>(product.class) {
			public List<product> handle(ResultSet rs) throws SQLException {
				List<product> classList = new ArrayList<product>();
				while (rs.next()) {
					product p = new product();
					p.setProdClass(rs.getInt("prodClass"));
					p.setProdID(rs.getInt("prodID"));
					p.setProdName(rs.getString("prodName"));
					p.setProdPrice(rs.getInt("prodPrice"));
					p.setMemberID(rs.getInt("memberID"));
					p.setInventory(rs.getInt("inventory"));
					p.setProdPost(rs.getString("prodPost"));
					p.setProdUpdate(rs.getString("prodUpdate"));
					p.setProdImg(rs.getBlob("prodImg"));
					classList.add(p);
				}
				return classList;
			}
		});
		return list;
	}

//	幹你娘這三小搜尋 7777
	public List<product> searchShit(String type, Integer low, Integer high, String name, Integer order)
			throws SQLException {
//		System.out.println("type="+type);
//		System.out.println("low="+low);
//		System.out.println("high="+high);
//		System.out.println("name="+name);

//		where
		boolean lowisNull = (low == 0);
		boolean highisNull = (high == 999999);
		boolean typeisNull = (type.equals("*"));
		boolean nameisNull = (name == null);
//		System.out.println("lowisnull="+lowisNull);
//		System.out.println("highisnull="+highisNull);
//		System.out.println("typeisnull="+typeisNull);
//		System.out.println("nameisnull="+nameisNull);
//		System.out.println("low&high="+(lowisNull&&highisNull));
//		System.out.println("!low&high="+!(lowisNull&&highisNull));
		
		String where = " where ";
		if (lowisNull) {
			if (highisNull) {
				if (typeisNull) {
					if (nameisNull) {
						where = "";
					}
				}
			}
		}

//		price
		boolean wroungside = (low > high);
		String price = "";
		if (lowisNull && highisNull) {
			price = "";
		} else if (wroungside) {
			price = "";
		} else if (lowisNull) {
			price = "prodprice <= " + high + " ";
		} else if (highisNull) {
			price = "prodprice >= " + low + " ";
		} else if (!(highisNull && lowisNull)) {
			price = "prodPrice >= " + low + " and prodPrice <= " + high + " ";
		}
//		System.out.println(price);
//		type
		String and = "and";
		if (price.equals("")||typeisNull) {
			and = "";
		}
		String typeOf = "";
		if (type.equals("*")) {
			typeOf = "";
		} else if (type.equals("1")) {
			typeOf = " prodclass = " + type + " ";
		} else if (type.equals("2")) {
			typeOf = " prodclass = " + type + " ";
		} else if (type.equals("3")) {
			typeOf = " prodclass = " + type + " ";
		}

//		name %%%%
		String and2 = " and ";
		if (lowisNull && highisNull) {
			if (typeisNull) {
				and2 = "";
			}
		}

		if (nameisNull) {
			and2 = "";
		}

		String sqlnamelike = "";
		String querynamelike = "";
		if (!nameisNull) {
			sqlnamelike = " prodName like ? ";
			querynamelike = "%" + name + "%";
		}

//		order by
		String orderBy = "";
		if (order == 1) {
			orderBy = " order by prodID";
		} else if (order == 2) {
			orderBy = " order by prodPrice DESC";
		} else if (order == 3) {
			orderBy = " order by prodPrice";
		} else if (order == 4) {
			orderBy = " order by prodPost DESC";
		} else if (order == 5) {
			orderBy = " order by prodUpdate DESC";
		}

		String sql = "select * from product" + where + price + and + typeOf + and2 + sqlnamelike + orderBy;
//		System.out.println(sql);
		List<product> List = new ArrayList<product>();
		if (nameisNull) {
			List = queryRunner.query(sql, new BeanListHandler<product>(product.class) {
				public List<product> handle(ResultSet rs) throws SQLException {
					List<product> classList = new ArrayList<product>();
					while (rs.next()) {
						product p = new product();
						p.setProdClass(rs.getInt("prodClass"));
						p.setProdID(rs.getInt("prodID"));
						p.setProdName(rs.getString("prodName"));
						p.setProdPrice(rs.getInt("prodPrice"));
						p.setMemberID(rs.getInt("memberID"));
						p.setInventory(rs.getInt("inventory"));
						p.setProdPost(rs.getString("prodPost"));
						p.setProdUpdate(rs.getString("prodUpdate"));
						p.setProdImg(rs.getBlob("prodImg"));
						classList.add(p);
					}
					return classList;
				}

			});
		} else {
			List = queryRunner.query(sql, new BeanListHandler<product>(product.class) {
				public List<product> handle(ResultSet rs) throws SQLException {
					List<product> classList = new ArrayList<product>();
					while (rs.next()) {
						product p = new product();
						p.setProdClass(rs.getInt("prodClass"));
						p.setProdID(rs.getInt("prodID"));
						p.setProdName(rs.getString("prodName"));
						p.setProdPrice(rs.getInt("prodPrice"));
						p.setMemberID(rs.getInt("memberID"));
						p.setInventory(rs.getInt("inventory"));
						p.setProdPost(rs.getString("prodPost"));
						p.setProdUpdate(rs.getString("prodUpdate"));
						p.setProdImg(rs.getBlob("prodImg"));
						classList.add(p);
					}
					return classList;
				}

			}, querynamelike);
		}
		return List;

	}

//	查詢全部 價格由大到小 
	public List<product> searchAll_OrderByPriceDESC() throws SQLException {
		String sql = "select * from product order by prodPrice DESC";
		List<product> list = queryRunner.query(sql, new BeanListHandler<product>(product.class) {
			public List<product> handle(ResultSet rs) throws SQLException {
				List<product> classList = new ArrayList<product>();
				while (rs.next()) {
					product p = new product();
					p.setProdClass(rs.getInt("prodClass"));
					p.setProdID(rs.getInt("prodID"));
					p.setProdName(rs.getString("prodName"));
					p.setProdPrice(rs.getInt("prodPrice"));
					p.setMemberID(rs.getInt("memberID"));
					p.setInventory(rs.getInt("inventory"));
					p.setProdPost(rs.getString("prodPost"));
					p.setProdUpdate(rs.getString("prodUpdate"));
					p.setProdImg(rs.getBlob("prodImg"));
					classList.add(p);
				}
				return classList;
			}
		});
		return list;
	}

//	查詢全部 價格由小到大 
	public List<product> searchAll_OrderByPrice() throws SQLException {
		String sql = "select * from product order by prodPrice";
		List<product> list = queryRunner.query(sql, new BeanListHandler<product>(product.class) {
			public List<product> handle(ResultSet rs) throws SQLException {
				List<product> classList = new ArrayList<product>();
				while (rs.next()) {
					product p = new product();
					p.setProdClass(rs.getInt("prodClass"));
					p.setProdID(rs.getInt("prodID"));
					p.setProdName(rs.getString("prodName"));
					p.setProdPrice(rs.getInt("prodPrice"));
					p.setMemberID(rs.getInt("memberID"));
					p.setInventory(rs.getInt("inventory"));
					p.setProdPost(rs.getString("prodPost"));
					p.setProdUpdate(rs.getString("prodUpdate"));
					p.setProdImg(rs.getBlob("prodImg"));
					classList.add(p);
				}
				return classList;
			}
		});
		return list;
	}

//	查詢全部 依更新日期排序 
	public List<product> searchAll_OrderByUpdate() throws SQLException {
		String sql = "select * from product order by prodUpdate DESC";
		List<product> list = queryRunner.query(sql, new BeanListHandler<product>(product.class) {
			public List<product> handle(ResultSet rs) throws SQLException {
				List<product> classList = new ArrayList<product>();
				while (rs.next()) {
					product p = new product();
					p.setProdClass(rs.getInt("prodClass"));
					p.setProdID(rs.getInt("prodID"));
					p.setProdName(rs.getString("prodName"));
					p.setProdPrice(rs.getInt("prodPrice"));
					p.setMemberID(rs.getInt("memberID"));
					p.setInventory(rs.getInt("inventory"));
					p.setProdPost(rs.getString("prodPost"));
					p.setProdUpdate(rs.getString("prodUpdate"));
					p.setProdImg(rs.getBlob("prodImg"));
					classList.add(p);
				}
				return classList;
			}
		});
		return list;
	}

//	查詢全部 依上架日期排序 
	public List<product> searchAll_OrderByPost() throws SQLException {
		String sql = "select * from product order by prodPost DESC";
		List<product> list = queryRunner.query(sql, new BeanListHandler<product>(product.class) {
			public List<product> handle(ResultSet rs) throws SQLException {
				List<product> classList = new ArrayList<product>();
				while (rs.next()) {
					product p = new product();
					p.setProdClass(rs.getInt("prodClass"));
					p.setProdID(rs.getInt("prodID"));
					p.setProdName(rs.getString("prodName"));
					p.setProdPrice(rs.getInt("prodPrice"));
					p.setMemberID(rs.getInt("memberID"));
					p.setInventory(rs.getInt("inventory"));
					p.setProdPost(rs.getString("prodPost"));
					p.setProdUpdate(rs.getString("prodUpdate"));
					p.setProdImg(rs.getBlob("prodImg"));
					classList.add(p);
				}
				return classList;
			}
		});
		return list;
	}

//	查詢全部 依上架日期排序(限制時間) 
	public List<product> searchAll_OrderByPostDATEDIFF(String datepart, int amount) throws SQLException {
		String sql = "select * from product where datediff(?,prodUpdate,GETDATE())<? order by prodPost DESC ";
		List<product> list = queryRunner.query(sql, new BeanListHandler<product>(product.class) {
			public List<product> handle(ResultSet rs) throws SQLException {
				List<product> classList = new ArrayList<product>();
				while (rs.next()) {
					product p = new product();
					p.setProdClass(rs.getInt("prodClass"));
					p.setProdID(rs.getInt("prodID"));
					p.setProdName(rs.getString("prodName"));
					p.setProdPrice(rs.getInt("prodPrice"));
					p.setMemberID(rs.getInt("memberID"));
					p.setInventory(rs.getInt("inventory"));
					p.setProdPost(rs.getString("prodPost"));
					p.setProdUpdate(rs.getString("prodUpdate"));
					p.setProdImg(rs.getBlob("prodImg"));
					classList.add(p);
				}
				return classList;
			}
		}, datepart, amount);
		return list;
	}

//	透過商品編號建立查詢
	public List<product> searchProdFromProdID(Integer prodID) throws SQLException {
		String sql = "select  * from product where prodID=?";
		List<product> list = queryRunner.query(sql, new BeanListHandler<product>(product.class) {
			public List<product> handle(ResultSet rs) throws SQLException {
				List<product> classList = new ArrayList<product>();
				while (rs.next()) {
					product p = new product();
					p.setProdClass(rs.getInt("prodClass"));
					p.setProdID(rs.getInt("prodID"));
					p.setProdName(rs.getString("prodName"));
					p.setProdPrice(rs.getInt("prodPrice"));
					p.setMemberID(rs.getInt("memberID"));
					p.setInventory(rs.getInt("inventory"));
					p.setProdPost(rs.getString("prodPost"));
					p.setProdUpdate(rs.getString("prodUpdate"));
					p.setProdImg(rs.getBlob("prodImg"));
					classList.add(p);
				}
				return classList;
			}
		}, prodID);
		return list;

	}

	public void searchAllProdOrderByProdClass() throws SQLException {
		String sql = "select * from product order by prodclass,prodID";
		List<product> list = queryRunner.query(sql, new BeanListHandler<product>(product.class));
		for (product p : list) {
			System.out.println(p);
		}
	}

//	透過類別編號建立查詢
	public void searchProdFromType(Integer productClass) throws SQLException {
		String sql = "select  * from product where prodClass=?";
		String sql1 = "select count(*) from product where prodClass =?";

		List<product> list = queryRunner.query(sql, new BeanListHandler<product>(product.class), productClass);
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), productClass);
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (product p : list) {
				System.out.println(p);
			}
		}

	}

//	透過類別名稱建立模糊查詢
	public void searchProdfromNameLike(String productName) throws SQLException {
		String sql = "select  * from product where prodName like ?";
		String sql1 = "select count(*) from product where prodName like ?";

		List<product> list = queryRunner.query(sql, new BeanListHandler<product>(product.class),
				"%" + productName + "%");
		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), "%" + productName + "%");
		System.out.printf("搜尋到了%d筆資料", count);
		if (count > 0) {
			System.out.println("查詢結果 : ");
			for (product p : list) {
				System.out.println(p);
			}
		}
	}

}
