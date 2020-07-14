package cn.edu.zucc.take_away.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.edu.zucc.take_away.model.*;
import cn.edu.zucc.take_away.util.*;
import cn.edu.zucc.take_away.ui.*;

public class addressManager {
	public List<Beanaddress> loadAddress() throws BaseException{
		// TODO Auto-generated method stub
		List<Beanaddress> result=new ArrayList<Beanaddress>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select address_id,cust_id,address_province,address_city,address_area,address_add,address_wantname,address_phone from address where cust_id =? order by address_id";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,Beancust.currentLoginCust.getCust_id());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Beanaddress u=new Beanaddress();
				u.setAddress_id(rs.getString(1));;
				u.setCust_id(rs.getString(2));
				u.setAddress_province(rs.getString(3));
				u.setAddress_city(rs.getString(4));
				u.setAddress_area(rs.getString(5));
				u.setAddress_add(rs.getString(6));
				u.setAddress_wantname(rs.getString(7));
				u.setAddress_phone(rs.getString(8));
				
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
	
	public void deleteAdd(String address_id, String cust_id) throws BaseException{
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from address where address_id and cust_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,address_id);
			pst.setString(2, cust_id);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("所选配送地址并不存在");
			//if(rs.getDate(1)!=null) throw new BusinessException("该账号已经被删除");
			rs.close();
			pst.close();
			
			sql="delete from addressform where addid=? and userid=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, address_id);
			pst.setString(2, cust_id);
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
		public void createManager(Beanaddress ad) throws BaseException{
			// TODO Auto-generated method stub
			if(ad.getAddress_id()==null || "".equals(ad.getAddress_id()) || ad.getAddress_id().length()>50){
				throw new BusinessException("地址编号必须是1-50个字");
			}
			if(ad.getCust_id()==null || "".equals(ad.getCust_id()) ){
				throw new BusinessException("'下单用户'必须填写");
			}
			if(ad.getAddress_province()==null  ){
				throw new BusinessException("'省'不能为空");
			}
			if(ad.getAddress_city()==null || "".equals(ad.getAddress_city()) ){
				throw new BusinessException("'市'必须填写");
			}
			if(ad.getAddress_area()==null || "".equals(ad.getAddress_area()) ){
				throw new BusinessException("'区'必须填写");
			}
			if(ad.getAddress_add()==null || "".equals(ad.getAddress_add()) ){
				throw new BusinessException("'地址'必须填写");
			}
			if(ad.getAddress_wantname()==null || "".equals(ad.getAddress_wantname()) ){
				throw new BusinessException("'联系人'必须填写");
			}
			if(ad.getAddress_phone()==null || "".equals(ad.getAddress_phone()) ){
				throw new BusinessException("'电话'必须填写");
			}
			
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select * from addressform where userid=? and addid=?";
				java.sql.PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1,Beancust.currentLoginCust.getCust_id());
				pst.setString(2, ad.getAddress_id());
				java.sql.ResultSet rs=pst.executeQuery();
				if(rs.next()) throw new BusinessException("地址编号已存在");
				rs.close();
				pst.close();
				sql="insert into addressform(addid,userid,province,city,area,address,contacts,phonenum) values(?,?,?,?,?,?,?,?)";
				pst=conn.prepareStatement(sql);
				pst.setString(1, ad.getAddress_id());
				pst.setString(2, Beancust.currentLoginCust.getCust_id());
				pst.setString(3, ad.getAddress_province());
				pst.setString(4,ad.getAddress_city());
				pst.setString(5, ad.getAddress_area());
				pst.setString(6, ad.getAddress_add());
				pst.setString(7, ad.getAddress_wantname());
				pst.setString(8, ad.getAddress_phone());
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