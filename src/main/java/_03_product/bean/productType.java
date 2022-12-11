package bean;

public class productType {
	private Integer prodClass;
	private String prodClassName;
	
	public Integer getProdClass() {
		return prodClass;
	}
	public void setProdClass(Integer prodClass) {
		this.prodClass = prodClass;
	}
	public String getProdClassName() {
		return prodClassName;
	}
	public void setProdClassName(String prodClassName) {
		this.prodClassName = prodClassName;
	}
	
	@Override
	public String toString() {
		return "productType [prodClass=" + prodClass + ", prodClassName=" + prodClassName + "]";
	}

	
}
