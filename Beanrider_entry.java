package cn.edu.zucc.take_away.model;

import java.util.Date;

public class Beanrider_entry {
	private String rider_id;
	private String order_id;
	private Date order_time;
	private String goods_evaluate_neirong;
	private int rider_danbishouru;
	public String getRider_id() {
		return rider_id;
	}
	public void setRider_id(String rider_id) {
		this.rider_id = rider_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public String getGoods_evaluate_neirong() {
		return goods_evaluate_neirong;
	}
	public void setGoods_evaluate_neirong(String goods_evaluate_neirong) {
		this.goods_evaluate_neirong = goods_evaluate_neirong;
	}
	public int getRider_danbishouru() {
		return rider_danbishouru;
	}
	public void setRider_danbishouru(int rider_danbishouru) {
		this.rider_danbishouru = rider_danbishouru;
	}
	
	
}
