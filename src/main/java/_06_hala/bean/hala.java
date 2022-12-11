package _06_hala.bean;

public class hala {
	private Integer halaID;

	private String halaClassName;

	private Integer memberId;

	private String title;

	private String postDate;

	private String halaContent;

	@Override
	public String toString() {
		return "hala [halaID=" + halaID + ", halaClassName=" + halaClassName + ", memberId=" + memberId + ", title="
				+ title + ", postDate=" + postDate + ", halaContent=" + halaContent + "]";
	}

	public Integer getHalaID() {
		return halaID;
	}

	public void setHalaID(Integer halaID) {
		this.halaID = halaID;
	}

	public String getHalaClassName() {
		return halaClassName;
	}

	public void setHalaClassName(String halaClassName) {
		this.halaClassName = halaClassName;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public hala(int halaID2, String halaClassName2, int memberId2, String title2, String postDate2, String halaContent2) {

	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getHalaContent() {
		return halaContent;
	}

	public void setHalaContent(String halaContent) {
		this.halaContent = halaContent;
	}
	public hala() {
		
	}

}
