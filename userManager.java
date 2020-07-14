package cn.edu.zucc.take_away.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.take_away.model.Beancust;
import cn.edu.zucc.take_away.model.Beanuser;
import cn.edu.zucc.take_away.util.BaseException;
import cn.edu.zucc.take_away.util.BusinessException;
import cn.edu.zucc.take_away.util.DbException;
import cn.edu.zucc.take_away.util.DBUtil;

public class userManager {
	public Beanuser login(String userid, String passwd) throws BaseException{
		// TODO Auto-generated method stub
				Connection conn=null;
				try {
					conn=DBUtil.getConnection();
					String sql="select user_id,user_name,user_passwd from user where user_id=?";
					java.sql.PreparedStatement pst=conn.prepareStatement(sql);
					pst.setString(1,userid);
					java.sql.ResultSet rs=pst.executeQuery();
					if(!rs.next()) throw new BusinessException("登录账号不存在");
					Beanuser p=new Beanuser();
					p.setUser_id(rs.getString(1));
					p.setUser_name(rs.getString(2));
					p.setUser_passswd(rs.getString(3));
					if(!(passwd).equals(p.getUser_passswd())){
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

	
	public Beanuser reg(String user_id, String user_name,String user_passwd1, String user_passwd2)throws BaseException {//男注册
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if(user_id==null || "".equals(user_id) || user_id.length()>20){
					throw new BusinessException("登陆账号必须是1-50个字");
				}
				if(user_passwd1==null || "".equals(user_passwd1)){
					throw new BusinessException("密码不能为空");
				}
				if(!user_passwd1.equals(user_passwd2)){
					throw new BusinessException("两个输入的密码不一致");
				}
				
				
				Connection conn=null;
				try {
					conn=DBUtil.getConnection();
					//检查用户是否存在
					String sql="select * from user where user_id=?";
					java.sql.PreparedStatement pst=conn.prepareStatement(sql);
					pst.setString(1,user_id);
					java.sql.ResultSet rs=pst.executeQuery();
					if(rs.next()) {
						//rs.close();
						//pst.close();
						throw new BusinessException("登陆账号已经存在");
					}
					rs.close();
					pst.close();
					sql="insert into user(user_id,user_name,user_passwd) value(?,?,?)";
					pst=conn.prepareStatement(sql);
					pst.setString(1, user_id);
					pst.setString(2,user_name);
					pst.setString(3, user_passwd1);
					Beanuser u=new Beanuser();
					u.setUser_id(user_id);
					u.setUser_name(user_name);
					u.setUser_passswd(user_passwd1);
					pst.execute();
					pst.close();
					return u;
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

	public void changePwd(Beanuser user, String oldPwd, String newPwd, String newPwd2) throws BaseException {
		// TODO Auto-generated method stub
		if(oldPwd==null||"".equals(oldPwd)) throw new BusinessException("原始密码不能为空");
		if(newPwd==null || "".equals(newPwd) ) throw new BusinessException("新密码不能为空");
		if(!newPwd.equals(newPwd2)) throw new BusinessException("新密码两次输入不同");
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select user_passwd from user where user_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,Beanuser.currentLoginUser.getUser_passswd());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("登陆账号不 存在");
			if(!Beanuser.currentLoginUser.getUser_passswd().equals(oldPwd)) throw new BusinessException("原始密码错误");
			rs.close();
			pst.close();
			sql="update user set user_passwd=? where user_id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, newPwd);
			pst.setString(2, user.getUser_id());
			pst.execute();
			pst.close();
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
	public List<Beanuser> loadUser()throws BaseException{
		List<Beanuser> result=new ArrayList<Beanuser>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select user_id,user_name,user_passwd from user order by user_id";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Beanuser u=new Beanuser();
				u.setUser_id(rs.getString(1));
				u.setUser_name(rs.getString(2));
				u.setUser_passswd(rs.getString(3));
				result.add(u);
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
}
