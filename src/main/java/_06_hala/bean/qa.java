package _06_hala.bean;

public class qa {
	private Integer qaID;

	private String qaClassName;

	private Integer memberId;

	private String title;

	private String postDate;

	private String qaContent;

	public qa(int qaID2, String qaClassName2, int memberId2, String title2, String postDate2, String qaContent2) {
	}

	public Integer getqaID() {
		return qaID;
	}

	public void setqaID(Integer qaID) {
		this.qaID = qaID;
	}

	public String getQaClassName() {
		return qaClassName;
	}

	public void setQaClassName(String qaClassName) {
		this.qaClassName = qaClassName;
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

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getQaContent() {
		return qaContent;
	}

	public void setQaContent(String qaContent) {
		this.qaContent = qaContent;
	}

	@Override
	public String toString() {
		return "qa [qaID=" + qaID + ", qaClassName=" + qaClassName + ", memberId=" + memberId + ", title=" + title
				+ ", postDate=" + postDate + ", qaContent=" + qaContent + "]";
	}
	public qa() {
		
	}

}
