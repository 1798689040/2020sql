package cn.edu.zucc.take_away.model;

import java.util.Date;

public class Beangoods_category {
	public static final String[] tableTitles={"分类编号","商家编号","分类栏目名","商品数量 "};
	private String goods_category_id;
	private String bus_id;
	private String goods_category_name;
	private int goods_num;
	
	public String getCell(int col){
		if(col==0) return String.valueOf(goods_category_id);
		else if(col==1) return String.valueOf(bus_id);
		else if(col==2) return String.valueOf(goods_category_name);
		else if(col==3) return String.valueOf(goods_num);
		else return "";
	}

	public String getGoods_category_id() {
		return goods_category_id;
	}

	public void setGoods_category_id(String goods_category_id) {
		this.goods_category_id = goods_category_id;
	}

	public String getBus_id() {
		return bus_id;
	}

	public void setBus_id(String bus_id) {
		this.bus_id = bus_id;
	}

	public String getGoods_category_name() {
		return goods_category_name;
	}

	public void setGoods_category_name(String goods_category_name) {
		this.goods_category_name = goods_category_name;
	}

	public int getGoods_num() {
		return goods_num;
	}

	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}

	
	


	
}
