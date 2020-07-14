package cn.edu.zucc.take_away.model;

import java.util.Date;


import cn.edu.zucc.take_away.model.Beancust;

public class Beancust {
	public static final String[] tableTitles={"用户编号","姓名","性别","密码","手机号码","邮箱","所在城市","注册时间","是否会员","会员截止日期"};

	public static Beancust currentLoginCust=null;
	private String cust_id;
	private String cust_name;
	private String cust_gender;
	private String cust_passwd;
	private String cust_phone;
	private String cust_mail;
	private String cust_city;
	private Date cust_zhucetime;
	private String cust_shifouvip;
	private Date cust_vipendtime;

	

	
	public String getCell(int col){
		if(col==0) return String.valueOf(cust_id);
		else if(col==1) return String.valueOf(cust_name);
		else if(col==2) return String.valueOf(cust_gender);
		else if(col==3) return String.valueOf(cust_passwd);
		else if(col==4) return String.valueOf(cust_phone);	
		else if(col==5) return String.valueOf(cust_mail);
		else if(col==6) return String.valueOf(cust_city);
		else if(col==7) return String.valueOf(cust_zhucetime);
		else if(col==8) return String.valueOf(cust_shifouvip);
		else if(col==9) return String.valueOf(cust_vipendtime);
		else return "";

	
	
}




	public String getCust_id() {
		return cust_id;
	}




	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}




	public String getCust_name() {
		return cust_name;
	}




	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}




	public String getCust_gender() {
		return cust_gender;
	}




	public void setCust_gender(String cust_gender) {
		this.cust_gender = cust_gender;
	}




	public String getCust_passwd() {
		return cust_passwd;
	}




	public void setCust_passwd(String cust_passwd) {
		this.cust_passwd = cust_passwd;
	}




	public String getCust_phone() {
		return cust_phone;
	}




	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}




	public String getCust_mail() {
		return cust_mail;
	}




	public void setCust_mail(String cust_mail) {
		this.cust_mail = cust_mail;
	}




	public String getCust_city() {
		return cust_city;
	}




	public void setCust_city(String cust_city) {
		this.cust_city = cust_city;
	}




	public Date getCust_zhucetime() {
		return cust_zhucetime;
	}




	public void setCust_zhucetime(Date cust_zhucetime) {
		this.cust_zhucetime = cust_zhucetime;
	}




	public String getCust_shifouvip() {
		return cust_shifouvip;
	}




	public void setCust_shifouvip(String cust_shifouvip) {
		this.cust_shifouvip = cust_shifouvip;
	}




	public Date getCust_vipendtime() {
		return cust_vipendtime;
	}




	public void setCust_vipendtime(Date cust_vipendtime) {
		this.cust_vipendtime = cust_vipendtime;
	}






}