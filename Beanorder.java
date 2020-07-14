package cn.edu.zucc.take_away.model;

public class Beanorder {
	public static final String[] CartTitles={"订单编号","商品编号","数量"," 价格","单品优惠金额","订单总价"};
	private String order_id;
	  private String goods_id;
	  private int order_goods_num;
	  private float order_goods_price;
	  private float order_goods_danpinyouhui;
	  private float order_allprice;
	  
	
	
	public String getCell(int col){
		if(col==0) return String.valueOf(order_id);
		else if(col==1) return String.valueOf(goods_id);
		else if(col==2) return String.valueOf(order_goods_num);
		else if(col==3) return String.valueOf(order_goods_price);
		else if(col==4) return String.valueOf(order_goods_danpinyouhui);
		else if(col==5) return String.valueOf(order_allprice);
		else return "";
	}



	public String getOrder_id() {
		return order_id;
	}



	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}



	public String getGoods_id() {
		return goods_id;
	}



	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}



	public int getOrder_goods_num() {
		return order_goods_num;
	}



	public void setOrder_goods_num(int order_goods_num) {
		this.order_goods_num = order_goods_num;
	}



	public float getOrder_goods_price() {
		return order_goods_price;
	}



	public void setOrder_goods_price(float order_goods_price) {
		this.order_goods_price = order_goods_price;
	}



	public float getOrder_goods_danpinyouhui() {
		return order_goods_danpinyouhui;
	}



	public void setOrder_goods_danpinyouhui(float order_goods_danpinyouhui) {
		this.order_goods_danpinyouhui = order_goods_danpinyouhui;
	}



	public float getOrder_allprice() {
		return order_allprice;
	}



	public void setOrder_allprice(float order_allprice) {
		this.order_allprice = order_allprice;
	}


	  
}
