package cn.edu.zucc.take_away.model;

import java.util.Date;

public class Beancust {
	private String cust_id;
	private String cust_name;
	private String cust_gender;
	private String cust_passwd;
	private int cust_phone;
	private String cust_mail;
	private String cust_city;
	private Date cust_zhucetime;
	private boolean cust_shifouvip;
	private Date cust_vipendtime;
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
	public int getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(int cust_phone) {
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
	public boolean isCust_shifouvip() {
		return cust_shifouvip;
	}
	public void setCust_shifouvip(boolean cust_shifouvip) {
		this.cust_shifouvip = cust_shifouvip;
	}
	public Date getCust_vipendtime() {
		return cust_vipendtime;
	}
	public void setCust_vipendtime(Date cust_vipendtime) {
		this.cust_vipendtime = cust_vipendtime;
	}
	
	
}
