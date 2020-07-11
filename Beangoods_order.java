package cn.edu.zucc.take_away.model;

import java.util.Date;

public class Beangoods_order {
	  private String order_id;
	  private String bus_id;
	  private String cust_id;
	  private String rider_id;
	  private int order_startprice;
	  private int order_trueprice;
	  private String redu_id;
	  private String coupon_id;
	  private Date order_starttime;
	  private Date order_wanttime;
	  private String address_id;
	  private String order_howabout;
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getBus_id() {
		return bus_id;
	}
	public void setBus_id(String bus_id) {
		this.bus_id = bus_id;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getRider_id() {
		return rider_id;
	}
	public void setRider_id(String rider_id) {
		this.rider_id = rider_id;
	}
	public int getOrder_startprice() {
		return order_startprice;
	}
	public void setOrder_startprice(int order_startprice) {
		this.order_startprice = order_startprice;
	}
	public int getOrder_trueprice() {
		return order_trueprice;
	}
	public void setOrder_trueprice(int order_trueprice) {
		this.order_trueprice = order_trueprice;
	}
	public String getRedu_id() {
		return redu_id;
	}
	public void setRedu_id(String redu_id) {
		this.redu_id = redu_id;
	}
	public String getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}
	public Date getOrder_starttime() {
		return order_starttime;
	}
	public void setOrder_starttime(Date order_starttime) {
		this.order_starttime = order_starttime;
	}
	public Date getOrder_wanttime() {
		return order_wanttime;
	}
	public void setOrder_wanttime(Date order_wanttime) {
		this.order_wanttime = order_wanttime;
	}
	public String getAddress_id() {
		return address_id;
	}
	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	public String getOrder_howabout() {
		return order_howabout;
	}
	public void setOrder_howabout(String order_howabout) {
		this.order_howabout = order_howabout;
	}
	  
	  
}
