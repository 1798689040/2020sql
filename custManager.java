package cn.edu.zucc.take_away.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.take_away.model.Beancust;
import cn.edu.zucc.take_away.model.Beanuser;
import cn.edu.zucc.take_away.util.*;

public class custManager {

	public Beancust login(String userid, String passwd) throws BaseException{
		// TODO Auto-generated method stub
				Connection conn=null;
				try {
					conn=DBUtil.getConnection();
					String sql="select * from cust where cust_id=?";
					java.sql.PreparedStatement pst=conn.prepareStatement(sql);
					pst.setString(1,userid);
					java.sql.ResultSet rs=pst.executeQuery();
					if(!rs.next()) throw new BusinessException("登录账号不存在");
					Beancust p=new Beancust();
					p.setCust_id(rs.getString(1));
					p.setCust_name(rs.getString(2));
					p.setCust_gender(rs.getString(3));
					p.setCust_passwd(rs.getString(4));
					p.setCust_phone(rs.getString(5));
					p.setCust_mail(rs.getString(6));
					p.setCust_city(rs.getString(7));
					p.setCust_zhucetime(rs.getDate(8));
					p.setCust_shifouvip(rs.getString(9));
					p.setCust_vipendtime(rs.getDate(10));
					if(!(passwd).equals(p.getCust_passwd())){
						throw new BusinessException("密码错误");
					}
					
					rs.close();
					pst.close();
					return p;
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DbException(e);
				}
				finally{
					if(conn!=null)
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
		
	}

	public Beancust reg1(String cust_id, String cust_name,String passwd1, String passwd2,String cust_phone,String cust_mail,String cust_city)throws BaseException {//男注册
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if(cust_id==null || "".equals(cust_id) || cust_id.length()>20){
					throw new BusinessException("登陆账号必须是1-20个字");
				}
				if(passwd1==null || "".equals(passwd1)){
					throw new BusinessException("密码不能为空");
				}
				if(!passwd1.equals(passwd2)){
					throw new BusinessException("两个输入的密码不一致");
				}
				
				
				Connection conn=null;
				try {
					conn=DBUtil.getConnection();
					//检查用户是否存在
					String sql="select * from user where user_id=?";
					java.sql.PreparedStatement pst=conn.prepareStatement(sql);
					pst.setString(1,cust_id);
					java.sql.ResultSet rs=pst.executeQuery();
					if(rs.next()) {
						throw new BusinessException("该用户编号已经存在");
					}
					rs.close();
					pst.close();
					sql="insert into cust(cust_id,cust_name,cust_gender,cust_passwd,cust_phone,cust_mail,cust_city,cust_zhucetime,cust_shifouvip,cust_vipendtime) value(?,?,?,?,?,?,?,Now(),?,Now())";
					pst=conn.prepareStatement(sql);
					pst.setString(1, cust_id);
					pst.setString(2,cust_name);
					pst.setString(3, "男");
					pst.setString(4, passwd1);
					pst.setString(5, cust_phone);
					pst.setString(6, cust_mail);
					pst.setString(7, cust_city);
					pst.setString(8, "否");
					Beancust p=new Beancust();
					p.setCust_id(cust_id);
					p.setCust_name(cust_name);
					p.setCust_gender("男");
					p.setCust_passwd(passwd1);
					p.setCust_phone(cust_phone);
					p.setCust_mail(cust_mail);
					p.setCust_city(cust_city);
					p.setCust_zhucetime(new Date(System.currentTimeMillis()));
					p.setCust_shifouvip("否");
					p.setCust_vipendtime(new Date(System.currentTimeMillis()));
					
					pst.execute();
					pst.close();
					return p;
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DbException(e);
				}
				finally{
					if(conn!=null)
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
	}
	public Beancust reg2(String cust_id, String cust_name,String passwd1, String passwd2,String cust_phone,String cust_mail,String cust_city)throws BaseException {//女注册
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if(cust_id==null || "".equals(cust_id) || cust_id.length()>20){
					throw new BusinessException("登陆账号必须是1-20个字");
				}
				if(passwd1==null || "".equals(passwd1)){
					throw new BusinessException("密码不能为空");
				}
				if(!passwd1.equals(passwd2)){
					throw new BusinessException("两个输入的密码不一致");
				}
				
				
				Connection conn=null;
				try {
					conn=DBUtil.getConnection();
					//检查用户是否存在
					String sql="select * from user where user_id=?";
					java.sql.PreparedStatement pst=conn.prepareStatement(sql);
					pst.setString(1,cust_id);
					java.sql.ResultSet rs=pst.executeQuery();
					if(rs.next()) {
						throw new BusinessException("该用户编号已经存在");
					}
					rs.close();
					pst.close();
					sql="insert into cust(cust_id,cust_name,cust_gender,cust_passwd,cust_phone,cust_mail,cust_city,cust_zhucetime,cust_shifouvip,cust_vipendtime) value(?,?,?,?,?,?,?,Now(),?,Now())";
					pst=conn.prepareStatement(sql);
					pst.setString(1, cust_id);
					pst.setString(2,cust_name);
					pst.setString(3, " 女");
					pst.setString(4, passwd1);
					pst.setString(5, cust_phone);
					pst.setString(6, cust_mail);
					pst.setString(7, cust_city);
					pst.setString(8, "否");
					Beancust p=new Beancust();
					p.setCust_id(cust_id);
					p.setCust_name(cust_name);
					p.setCust_gender("女");
					p.setCust_passwd(passwd1);
					p.setCust_phone(cust_phone);
					p.setCust_mail(cust_mail);
					p.setCust_city(cust_city);
					p.setCust_zhucetime(new Date(System.currentTimeMillis()));
					p.setCust_shifouvip("否");
					p.setCust_vipendtime(new Date(System.currentTimeMillis()));
					
					pst.execute();
					pst.close();
					return p;
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DbException(e);
				}
				finally{
					if(conn!=null)
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
	}
	public List<Beancust> loadUser()throws BaseException{
		List<Beancust> result=new ArrayList<Beancust>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select cust_id,cust_name,cust_gender,cust_passwd,cust_phone,cust_mail,cust_city,cust_zhucetime,cust_shifouvip,cust_vipendtime from cust order by cust_id";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Beancust p=new Beancust();
				p.setCust_id(rs.getString(1));
				p.setCust_name(rs.getString(2));
				p.setCust_gender(rs.getString(3));
				p.setCust_passwd(rs.getString(4));
				p.setCust_phone(rs.getString(5));
				p.setCust_mail(rs.getString(6));
				p.setCust_city(rs.getString(7));
				p.setCust_zhucetime(rs.getDate(8));
				p.setCust_shifouvip(rs.getString(9));
				p.setCust_vipendtime(rs.getDate(10));
				result.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}
	public Beancust loadUser1()throws BaseException{
		Beancust p=new Beancust();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select userid,username,sex,passwd,phonenum,mail,city,regtime,isvip,vipenddate from userinformation order by userid";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			if(rs.next()){
				
				p.setCust_id(rs.getString(1));
				p.setCust_name(rs.getString(2));
				p.setCust_gender(rs.getString(3));
				p.setCust_passwd(rs.getString(4));
				p.setCust_phone(rs.getString(5));
				p.setCust_mail(rs.getString(6));
				p.setCust_city(rs.getString(7));
				p.setCust_zhucetime(rs.getDate(8));
				p.setCust_shifouvip(rs.getString(9));
				p.setCust_vipendtime(rs.getDate(10));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return p;
	}
	public void chengweivip()throws BaseException{
		Connection conn=null;
		if (Beancust.currentLoginCust.getCust_shifouvip()=="是") {
			throw new BusinessException("已经是会员");
		}
		try {
			conn=DBUtil.getConnection();
			String sql="update userinformation set isvip=?,vipenddate=? where userid=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, "是");
			pst.setDate(2, new java.sql.Date(System.currentTimeMillis()+2592000000L));
			pst.setString(3, Beancust.currentLoginCust.getCust_id());
			Beancust.currentLoginCust.setCust_shifouvip("是");
			pst.execute();
		
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
