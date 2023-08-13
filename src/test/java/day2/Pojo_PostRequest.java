package day2;

public class Pojo_PostRequest {

	String name;
	String address;
	String company;
	String [] roles;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] arr) {
		this.roles = arr;
	}
	
	
}
