package bean;

import java.sql.Blob;
import java.util.Date;

public class tableForTeac {
	private Integer teacno;
	private Integer memberId;
	private String title;
	private Date postDate;
	private String detail;
	private Double price;
	public tableForTeac(Integer teacno, Integer memberId, String title, String detail, Double price,
			String subjectItem) {
		super();
		this.teacno = teacno;
		this.memberId = memberId;
		this.title = title;
		this.detail = detail;
		this.price = price;
		this.subjectItem = subjectItem;
	}
	
	public tableForTeac() {
		super();
	}

	private String subjectItem;
	// 圖片測試
	private Blob ClassPicture;
	
	public Blob getClassPicture() {
		return ClassPicture;
	}
	public tableForTeac(Integer teacno, Integer memberId, String title, Date postDate, String detail, Double price,
			String subjectItem, Blob classPicture) {
		super();
		this.teacno = teacno;
		this.memberId = memberId;
		this.title = title;
		this.postDate = postDate;
		this.detail = detail;
		this.price = price;
		this.subjectItem = subjectItem;
		ClassPicture = classPicture;
	}
	public void setClassPicture(Blob classPicture) {
		ClassPicture = classPicture;
	}
	// 圖片測試結束
	
	public Integer getTeacno() {
		return teacno;
	}
	public void setTeacno(Integer teacno) {
		this.teacno = teacno;
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
	@Override
	public String toString() {
		return String.format(
				"tableForTeacAndStu [teacno=%s, memberId=%s, title=%s, postDate=%s, detail=%s, price=%s, subjectItem=%s]",
				teacno, memberId, title, postDate, detail, price, subjectItem);
	}
	
}
