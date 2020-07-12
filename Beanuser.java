package cn.edu.zucc.take_away.model;

import cn.edu.zucc.take_away.model.Beanuser;

public class Beanuser {
	public static final String[] tableTitles={"管理员编号","管理员姓名","管理员密码"};
	public static Beanuser currentLoginUser=null;
	  private String user_id;
	  private String user_name;
	  private String user_passswd;
	  
	  
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getCell(int col){
		if(col==0) return String.valueOf(user_id);
		else if(col==1) return String.valueOf(user_name);
		else if(col==2) return String.valueOf(user_passswd);
		else return "";
  }
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_passswd() {
		return user_passswd;
	}
	public void setUser_passswd(String user_passswd) {
		this.user_passswd = user_passswd;
	}

	  
}
