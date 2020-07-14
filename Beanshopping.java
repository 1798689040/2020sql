package cn.edu.zucc.take_away.model;

public class Beanshopping {
	   private String goods_name;
	   private float goods_price;
	   private int goods_wnum;
	   private float goods_youhuiprice;
	public static final String[] CartTitles={"商品名称","商品价格","商品数量","优惠价格"};
	public String getCell(int col){
		if(col==0) return String.valueOf(goods_name);
		else if(col==1) return String.valueOf(goods_price);
		else if(col==2) return String.valueOf(goods_wnum);
		else if(col==3) return String.valueOf(goods_youhuiprice);
		else return "";
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public float getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(float goods_price) {
		this.goods_price = goods_price;
	}
	public int getGoods_wnum() {
		return goods_wnum;
	}
	public void setGoods_wnum(int goods_wnum) {
		this.goods_wnum = goods_wnum;
	}
	public float getGoods_youhuiprice() {
		return goods_youhuiprice;
	}
	public void setGoods_youhuiprice(float goods_youhuiprice) {
		this.goods_youhuiprice = goods_youhuiprice;
	}
	
}
