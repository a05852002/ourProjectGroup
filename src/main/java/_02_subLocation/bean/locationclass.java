package bean;

public class locationclass {
	private Integer locno;
	private String locname;
	private String locclass;
	
	

	
	
	public Integer getLocno() {
		return locno;
	}





	public void setLocno(Integer locno) {
		this.locno = locno;
	}





	public String getLocname() {
		return locname;
	}





	public void setLocname(String locname) {
		this.locname = locname;
	}





	public String getLocclass() {
		return locclass;
	}





	public void setLocclass(String locclass) {
		this.locclass = locclass;
	}





	@Override
	public String toString() {
		return String.format("locationclass [locno=%s, locname=%s, locclass=%s]", locno, locname, locclass
				);
	}
	
	
}
