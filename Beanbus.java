package cn.edu.zucc.take_away.model;

import java.util.Date;

public class Beanbus {
	public static final String[] tableTitles={"商家编号","商家名","商家星级","人均消费","总销量"};
	public static String currentLoginUser;
	private String bus_id;
	private String bus_name;
	private int bus_star;
	private float bus_renjunxiaofei;
	private float bus_zongxiaoliang;
	
	public String getCell(int col) {
		// TODO Auto-generated method stub
		if(col==0) return String.valueOf(getBus_id());
		else if(col==1) return String.valueOf(getBus_name());
		else if(col==2) return String.valueOf(getBus_star());
		else if(col==3) return String.valueOf(getBus_renjunxiaofei());
		else if(col==4) return String.valueOf(getBus_zongxiaoliang());
		else return "";
	}
	public static String getCurrentLoginUser() {
		return currentLoginUser;
	}
	public static void setCurrentLoginUser(String currentLoginUser) {
		Beanbus.currentLoginUser = currentLoginUser;
	}
	public String getBus_id() {
		return bus_id;
	}
	public void setBus_id(String bus_id) {
		this.bus_id = bus_id;
	}
	public String getBus_name() {
		return bus_name;
	}
	public void setBus_name(String bus_name) {
		this.bus_name = bus_name;
	}
	public int getBus_star() {
		return bus_star;
	}
	public void setBus_star(int bus_star) {
		this.bus_star = bus_star;
	}
	public float getBus_renjunxiaofei() {
		return bus_renjunxiaofei;
	}
	public void setBus_renjunxiaofei(float bus_renjunxiaofei) {
		this.bus_renjunxiaofei = bus_renjunxiaofei;
	}
	public float getBus_zongxiaoliang() {
		return bus_zongxiaoliang;
	}
	public void setBus_zongxiaoliang(float bus_zongxiaoliang) {
		this.bus_zongxiaoliang = bus_zongxiaoliang;
	}
	public static String[] getTabletitles() {
		return tableTitles;
	}
	
	

	 
}
