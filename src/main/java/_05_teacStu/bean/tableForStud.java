package bean;

import java.util.Date;

public class tableForStud {
	private Integer studno;
	private Integer memberId;
	private String title;
	private Date postDate;
	private String detail;
	private Double price;
	private String subjectItem;
	private String learnLoc;
	public Integer getStudno() {
		return studno;
	}
	public void setStudno(Integer studno) {
		this.studno = studno;
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
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getSubjectItem() {
		return subjectItem;
	}
	public void setSubjectItem(String subjectItem) {
		this.subjectItem = subjectItem;
	}
	public String getLearnLoc() {
		return learnLoc;
	}
	public void setLearnLoc(String learnLoc) {
		this.learnLoc = learnLoc;
	}
	@Override
	public String toString() {
		return String.format(
				"tableForStud [studno=%s, memberId=%s, title=%s, postDate=%s, detail=%s, price=%s, subjectItem=%s, learnLoc=%s]",
				studno, memberId, title, postDate, detail, price, subjectItem, learnLoc);
	}
	
}
