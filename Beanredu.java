package cn.edu.zucc.take_away.model;

public class Beanredu {
	public static final String[] DiscountTitles={"Âú¼õ±àºÅ","Âú¼õ½ğ¶î","ÓÅ»İ½ğ¶î","ÊÇ·ñ¿ÉÓëÓÅ»İÈ¯µş¼Ó"};
	private String redu_id;
	private int redu_manjianjine;
	private int redu_youhuijine;
	private boolean kediejiamang;
	public String getCell(int col){
		if(col==0) return String.valueOf(redu_id);
		else if(col==1) return String.valueOf(redu_manjianjine);
		else if(col==2) return String.valueOf(redu_youhuijine);
		else if(col==3) return String.valueOf(kediejiamang);
		else return "";
	}
	
	public String getRedu_id() {
		return redu_id;
	}
	public void setRedu_id(String redu_id) {
		this.redu_id = redu_id;
	}
	public int getRedu_manjianjine() {
		return redu_manjianjine;
	}
	public void setRedu_manjianjine(int redu_manjianjine) {
		this.redu_manjianjine = redu_manjianjine;
	}
	public int getRedu_youhuijine() {
		return redu_youhuijine;
	}
	public void setRedu_youhuijine(int redu_youhuijine) {
		this.redu_youhuijine = redu_youhuijine;
	}
	public boolean isKediejia() {
		return kediejiamang;
	}
	public void setKediejia(boolean kediejia) {
		this.kediejiamang = kediejiamang;
	}
	
	
}
