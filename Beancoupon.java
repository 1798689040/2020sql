package cn.edu.zucc.take_away.model;

import java.util.Date;

public class Beancoupon {
	public static final String[] CouponTitles={"优惠券编号","优惠金额","集单数要求","起始日期","结束日期"};
	private String coupon_id;
	private String coupon_amount;
	private int coupon_num;
	private Date coupon_starttime;
	private Date coupon_endtime;

	public String getCell(int col){
		if(col==0) return String.valueOf(coupon_id);
		else if(col==1) return String.valueOf(coupon_amount);
		else if(col==2) return String.valueOf(coupon_num);
		else if(col==3) return String.valueOf(coupon_starttime);
		else if(col==4) return String.valueOf(coupon_endtime);	
		else return "";
	}
	private String getCoupon_id() {
		return coupon_id;
	}
	
	public Date getCoupon_starttime() {
		return coupon_starttime;
	}
	public void setCoupon_starttime(Date coupon_starttime) {
		this.coupon_starttime = coupon_starttime;
	}
	public Date getCoupon_endtime() {
		return coupon_endtime;
	}
	public void setCoupon_endtime(Date coupon_endtime) {
		this.coupon_endtime = coupon_endtime;
	}
	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}
	public void setCoupon_amount(String coupon_amount) {
		this.coupon_amount = coupon_amount;
	}
	public void setCoupon_num(int coupon_num) {
		this.coupon_num = coupon_num;
	}
	private String getCoupon_amount() {
		return coupon_amount;
	}
	
	private int getCoupon_num() {
		return coupon_num;
	}
	
	private void getCoupon_starttime(Date coupon_starttime) {
		this.coupon_starttime = coupon_starttime;
	}
}
