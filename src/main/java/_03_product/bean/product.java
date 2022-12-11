package bean;

import java.sql.Blob;

public class product {
	private int prodClass;
	private int prodID;
	private String prodName;
	private int prodPrice;
	private int memberID;
	private int inventory;
	private String prodPost;
	private String prodUpdate;
	
	
	
	public product() {
		super();
	}
	
//	test
	private Blob prodImg;
	
	public Blob getProdImg() {
		return prodImg;
	}
	public void setProdImg(Blob prodImg) {
		this.prodImg = prodImg;
	} 	
//	test
	
	
	
	public int getProdClass() {
		return prodClass;
	}
	
	
	public product(int prodClass, int prodID, String prodName, int prodPrice, int memberID, int inventory, String prodPost,
		String prodUpdate, Blob prodImg) {
	super();
	this.prodClass = prodClass;
	this.prodID = prodID;
	this.prodName = prodName;
	this.prodPrice = prodPrice;
	this.memberID = memberID;
	this.inventory = inventory;
	this.prodPost = prodPost;
	this.prodUpdate = prodUpdate;
	this.prodImg = prodImg;
}
	public void setProdClass(int prodClass) {
		this.prodClass = prodClass;
	}
	public int getProdID() {
		return prodID;
	}
	public void setProdID(int prodID) {
		this.prodID = prodID;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public String getProdPost() {
		return prodPost;
	}
	public void setProdPost(String prodPost) {
		this.prodPost = prodPost;
	}
	public String getProdUpdate() {
		return prodUpdate;
	}
	public void setProdUpdate(String prodUpdate) {
		this.prodUpdate = prodUpdate;
	}
	@Override
	public String toString() {
		return "product [prodClass=" + prodClass + ", prodID=" + prodID + ", prodName=" + prodName + ", prodPrice="
				+ prodPrice + ", memberID=" + memberID + ", inventory=" + inventory + ", prodPost=" + prodPost
				+ ", prodUpdate=" + prodUpdate + "]";
	}
		
	
	
}
