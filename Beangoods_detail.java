package cn.edu.zucc.take_away.model;

import java.util.Date;

public class Beangoods_detail {
	public static final String[] GoodsTitles={"商品编号","所属分类编号","商品名称","商品价格","优惠价格"};

	private String goods_id;
	private String goods_category_id;
	private String goods_name;
	private int goods_price;
	private int goods_youhuiprice;
	
	public String getCell(int col){
		if(col==0) return String.valueOf(goods_id);
		else if(col==1) return String.valueOf(goods_category_id);
		else if(col==2) return String.valueOf(goods_name);
		else if(col==3) return String.valueOf(goods_price);
		else if(col==4) return String.valueOf(goods_youhuiprice);	
		else return "";
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_category_idString() {
		return goods_category_id;
	}
	public void setGoods_category_idString(String goods_category_idString) {
		this.goods_category_id = goods_category_id;
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
