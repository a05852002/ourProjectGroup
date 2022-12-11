package bean;

public class subjectclass {
	private Integer subno;
	private String subname;
	private String subclass;
	
	

	public Integer getSubno() {
		return subno;
	}
	public void setSubno(Integer subno) {
		this.subno = subno;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getSubclass() {
		return subclass;
	}
	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}
	
	
	@Override
	public String toString() {
		return String.format("subjectclass [subno=%s, subname=%s, subclass=%s]", subno, subname, subclass
				);
	}
	
	
}
