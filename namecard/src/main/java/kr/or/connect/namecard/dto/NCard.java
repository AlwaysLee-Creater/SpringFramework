package kr.or.connect.namecard.dto;

public class NCard {
	private String name;
	private String phone;
	private String companyName;
	
	public NCard(String name, String phone, String companyName) {
		super();
		this.name = name;
		this.phone = phone;
		this.companyName = companyName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "NCard [name=" + name + ", phone=" + phone + ", companyName=" + companyName + "]";
	}
}
