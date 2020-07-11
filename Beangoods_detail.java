package cn.edu.zucc.take_away.model;

import java.util.Date;

public class Beangoods_detail {
	private String goods_id;
	private String goods_category_idString;
	private String goods_name;
	private int goods_price;
	private int goods_youhuiprice;
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_category_idString() {
		return goods_category_idString;
	}
	public void setGoods_category_idString(String goods_category_idString) {
		this.goods_category_idString = goods_category_idString;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}
	public int getGoods_youhuiprice() {
		return goods_youhuiprice;
	}
	public void setGoods_youhuiprice(int goods_youhuiprice) {
		this.goods_youhuiprice = goods_youhuiprice;
	}
	
	
}
