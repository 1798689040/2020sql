package cn.edu.zucc.take_away.model;

import java.util.Date;

public class Beangoods_evaluate {
	private String goods_id;
	private String bus_id;
	private String cust_id;
	private String goods_evaluate_neirong;
	private Date goods_evaluate_time;
	private int goods_evaluate_star;
	private String goods_evaluate_photo;
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
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
	public String getGoods_evaluate_neirong() {
		return goods_evaluate_neirong;
	}
	public void setGoods_evaluate_neirong(String goods_evaluate_neirong) {
		this.goods_evaluate_neirong = goods_evaluate_neirong;
	}
	public Date getGoods_evaluate_time() {
		return goods_evaluate_time;
	}
	public void setGoods_evaluate_time(Date goods_evaluate_time) {
		this.goods_evaluate_time = goods_evaluate_time;
	}
	public int getGoods_evaluate_star() {
		return goods_evaluate_star;
	}
	public void setGoods_evaluate_star(int goods_evaluate_star) {
		this.goods_evaluate_star = goods_evaluate_star;
	}
	public String getGoods_evaluate_photo() {
		return goods_evaluate_photo;
	}
	public void setGoods_evaluate_photo(String goods_evaluate_photo) {
		this.goods_evaluate_photo = goods_evaluate_photo;
	}
	
	
}
