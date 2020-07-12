package cn.edu.zucc.take_away.model;

import java.util.Date;

public class Beancust_coupon {

	private String cust_id;
	private String coupon_id;
	private String bus_id;
	private int redu_youhuijine;
	private int cust_coupon_num;
	private Date cust_coupon_endtime;

	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}
	public String getBus_id() {
		return bus_id;
	}
	public void setBus_id(String bus_id) {
		this.bus_id = bus_id;
	}
	public int getRedu_youhuijine() {
		return redu_youhuijine;
	}
	public void setRedu_youhuijine(int redu_youhuijine) {
		this.redu_youhuijine = redu_youhuijine;
	}
	public int getCust_coupon_num() {
		return cust_coupon_num;
	}
	public void setCust_coupon_num(int cust_coupon_num) {
		this.cust_coupon_num = cust_coupon_num;
	}
	public Date getCust_coupon_endtime() {
		return cust_coupon_endtime;
	}
	public void setCust_coupon_endtime(Date cust_coupon_endtime) {
		this.cust_coupon_endtime = cust_coupon_endtime;
	}
	  
	  
}
