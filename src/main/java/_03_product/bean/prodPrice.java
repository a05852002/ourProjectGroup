package bean;

public class prodPrice {
	private int prodID;
	private int STDprice;
	private int MINprice;
	private String startDate;
	private String endDate;
	public int getProdID() {
		return prodID;
	}
	public void setProdID(int prodID) {
		this.prodID = prodID;
	}
	public int getSTDprice() {
		return STDprice;
	}
	public void setSTDprice(int sTDprice) {
		STDprice = sTDprice;
	}
	public int getMINprice() {
		return MINprice;
	}
	public void setMINprice(int mINprice) {
		MINprice = mINprice;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "prodPrice [prodID=" + prodID + ", STDprice=" + STDprice + ", MINprice=" + MINprice + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
}
