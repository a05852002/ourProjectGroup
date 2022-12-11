package bean;

import java.sql.Blob;

public class PIC {
	private int prodID;
	private Blob prodImg;
	
	public int getProdID() {
		return prodID;
	}
	public void setProdID(int prodID) {
		this.prodID = prodID;
	}
	public Blob getProdImg() {
		return prodImg;
	}
	public void setProdImg(Blob prodImg) {
		this.prodImg = prodImg;
	} 
	
	
	
	
}
