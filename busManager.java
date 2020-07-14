package cn.edu.zucc.take_away.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cn.edu.zucc.take_away.itf.IbusManager;
import cn.edu.zucc.take_away.model.Beanbus;
import cn.edu.zucc.take_away.model.Beanbus;
import cn.edu.zucc.take_away.util.BaseException;
import cn.edu.zucc.take_away.util.BusinessException;
import cn.edu.zucc.take_away.util.DBUtil;
import cn.edu.zucc.take_away.util.DbException;
import cn.edu.zucc.take_away.itf.IbusManager;
import cn.edu.zucc.take_away.model.Beanbus;

public class busManager implements IbusManager{

	public List<Beanbus> searchuser(String text) throws BaseException{
		// TODO Auto-generated method stub
		List<Beanbus> result=new ArrayList<Beanbus>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select bus_id,bus_name,bus_star,bus_renjunxiaofei,bus_zongxiaoliang"
					+ " from bus where bus_name=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,text);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beanbus mc = new Beanbus();
				mc.setBus_id(rs.getString(1));
				mc.setBus_name(rs.getString(2));
				mc.setBus_star(rs.getInt(3));
				mc.setBus_renjunxiaofei(rs.getFloat(4));
				mc.setBus_zongxiaoliang(rs.getFloat(5));
				result.add(mc);
			
			}
		}catch (SQLException e) {
		 e.printStackTrace();
		 //throw new DbException(e);
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
     public  void createMerchant(Beanbus mc) throws BaseException{
		
		
		if( "".equals(mc.getBus_id()) || "".equals(mc.getBus_name())){
			throw new BusinessException("商家编号，姓名不能为空");
		}
		
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from bus where bus_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,mc.getBus_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("商家已存在");
			rs.close();
			pst.close();
			sql="insert into bus(bus_id,bus_name,bus_star,bus_renjunxiaofei,bus_zongxiaoliang) "
					+ "values(?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, mc.getBus_id());
			pst.setString(2, mc.getBus_name());
			pst.setInt(3, mc.getBus_star());
			pst.setFloat(4, mc.getBus_renjunxiaofei());
			pst.setFloat(4, mc.getBus_zongxiaoliang());
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
	public List<Beanbus> loadAll() throws BaseException {
		List<Beanbus> result=new ArrayList<Beanbus>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select bus_id,bus_name,bus_star,bus_renjunxiaofei,bus_zongxiaoliang"
					+ " from bus";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			//pst.setString(1, beanbus.currentLoginUser);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beanbus mc = new Beanbus();
				mc.setBus_id(rs.getString(1));
				mc.setBus_name(rs.getString(2));
				mc.setBus_star(rs.getInt(3));
				mc.setBus_renjunxiaofei(rs.getFloat(4));
				mc.setBus_zongxiaoliang(rs.getFloat(5));
				result.add(mc);
			}
			
		}catch (SQLException e) {
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

	public void removeMerchant(Beanbus beanbus)throws BaseException {
		// TODO Auto-generated method stub
		if(beanbus.getBus_id()==null || "".equals(beanbus.getBus_id()) ){throw new BusinessException("商家为空");}
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from bus where bus_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, beanbus.getBus_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("商家不存在");
			sql="delete from bus where bus_id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, beanbus.getBus_id());
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
}