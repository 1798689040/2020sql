package cn.edu.zucc.take_away.model;

public class Beanaddress {
		public static final String[] AddressTitles={"地址编号","用户编号","省","市","区","地址","联系人","电话"};
	  private String address_id;
	  private String cust_id;
	  private String address_province;
	  private String address_city;
	  private String address_area;
	  private String address_add;
	  private String address_wantname;
	  private String address_phone;
	  public String getCell(int col){
	    	 if(col==0) return String.valueOf(address_id);
	 	else if(col==1) return String.valueOf(cust_id);
		else if(col==2) return String.valueOf(address_province);
		else if(col==3) return String.valueOf(address_city);
		else if(col==4) return String.valueOf(address_area);
		else if(col==5) return String.valueOf(address_add);
		else if(col==6) return String.valueOf(address_wantname);	
		else if(col==7) return String.valueOf(address_phone);
		else return "";
	}
	public String getAddress_id() {
		return address_id;
	}
	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getAddress_province() {
		return address_province;
	}
	public void setAddress_province(String address_province) {
		this.address_province = address_province;
	}
	public String getAddress_city() {
		return address_city;
	}
	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}
	public String getAddress_area() {
		return address_area;
	}
	public void setAddress_area(String address_area) {
		this.address_area = address_area;
	}
	public String getAddress_add() {
		return address_add;
	}
	public void setAddress_add(String address_add) {
		this.address_add = address_add;
	}
	public String getAddress_wantname() {
		return address_wantname;
	}
	public void setAddress_wantname(String address_wantname) {
		this.address_wantname = address_wantname;
	}
	public String getAddress_phone() {
		return address_phone;
	}
	public void setAddress_phone(String address_phone) {
		this.address_phone = address_phone;
	}
	public static String[] getAddresstitles() {
		return AddressTitles;
	}
	  
	  

	  
}
