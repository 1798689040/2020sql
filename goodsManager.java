package cn.edu.zucc.take_away.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import cn.edu.zucc.take_away.model.*;
import cn.edu.zucc.take_away.util.BaseException;
import cn.edu.zucc.take_away.util.BusinessException;
import cn.edu.zucc.take_away.util.DBUtil;
import cn.edu.zucc.take_away.util.DbException;
import cn.edu.zucc.take_away.model.Beangoods_category;
import cn.edu.zucc.take_away.model.Beanbus;
import cn.edu.zucc.take_away.model.Beangoods_category;
import cn.edu.zucc.take_away.model.Beangoods_detail;
import cn.edu.zucc.take_away.model.Beanbus;
import cn.edu.zucc.take_away.model.Beancart;
import cn.edu.zucc.take_away.itf.IgoodsManager;

public class goodsManager implements IgoodsManager{
	public List<Beangoods_detail> loadAll(Beangoods_category cart) {
		List<Beangoods_detail> result=new ArrayList<Beangoods_detail>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select goods_id,goods_category_id,goods_name,goods_price,goods_youhuiprice"
					+ " from goods_detail  where goods_category_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, cart.getGoods_category_id());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beangoods_detail gd = new Beangoods_detail();
				gd.setGoods_id(rs.getString(1));
			    gd.setGoods_category_id(rs.getString(2));;
			    gd.setGoods_name(rs.getString(3));
			    gd.setGoods_price(rs.getFloat(4));
			    gd.setGoods_youhuiprice(5);
				result.add(gd);
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
	
	public List<Beangoods_category> loadAllcategories(Beanbus k) throws BaseException {
		List<Beangoods_category> result=new ArrayList<Beangoods_category>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select goods_category_id,bus_id,goods_category_name,goods_num"
					+ " from goods_category where bus_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, k.getBus_id());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beangoods_category cart = new Beangoods_category();
				cart.setGoods_category_id(rs.getString(1));
			    cart.setBus_id(rs.getString(2));
			    cart.setGoods_category_name(rs.getString(3));
			    cart.setGoods_num(rs.getInt(4));
				result.add(cart);
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
	public void addcate(String name, String cateid, String catename, String cnt) throws Exception {
		if("".equals(name))throw new BusinessException("商品类别不为空");
		Beangoods_category cate=new Beangoods_category();
		Beangoods_detail detail=new Beangoods_detail();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select goods_category_id from goods_category where goods_category_name=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, catename);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next())throw new BusinessException("类别已存在");
			else {
				pst.close();
				rs.close();
				//int categories_id=0;//计算
				//sql="select plan_order from tbl_plan where user_id=? order by plan_order desc";
				//sql="select max(plan_order) from tbl_plan where user_id=?";
				//pst=conn.prepareStatement(sql);
				//pst.setString(1, bu.currentLoginUser.getUser_id());
				//rs=pst.executeQuery();
				//if(rs.next())
				//	plan_order=rs.getInt(1)+1;
				//else
				//	plan_order=1;
				//pst.close();
				//rs.close();
				sql="insert into goods_categories (goods_category_id,bus_id,goods_category_name,goods_num) "
						+ "values(?.?,?,?)";
				pst=conn.prepareStatement(sql);
				pst.setString(1,cateid);
				pst.setString(2,name);
				pst.setString(3, catename);
				pst.setString(4, cnt);
				//pst.setTimestamp(4,new java.sql.Timestamp(System.currentTimeMillis()));
				//pst.setInt(5,0);
				//pst.setInt(6,0);
				//pst.setInt(7,0);
				pst.execute();
				pst.close();	
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
		//return null;
	}

	@Override
	public List<Beangoods_category> loadAllcategories() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void creatgoods(String goodid, String cateid, String goodname, String price, String reduce) throws Exception {
		if("".equals(goodid))throw new BusinessException("商品编号不为空");
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select goods_name from goods_detail where goods_name=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, goodname);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next())throw new BusinessException("商品已存在");
			else {
				pst.close();
				rs.close();
				sql="insert into goods_detail (goods_id,goods_category_id,goods_name,`goods_price,goods_youhuiprice)"
						+ "values(?,?,?,?,?)";
				pst=conn.prepareStatement(sql);
				pst.setString(1,goodid);
				pst.setString(2,cateid);
				pst.setString(3,goodname);
				pst.setString(4,price);
				pst.setString(5,reduce);
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
		
		
	}

	public List<Beancart> addgoods(Beangoods_detail goods) {
		// TODO Auto-generated method stub
		List<Beancart> result=new ArrayList<Beancart>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into cart( goods_name,goods_wnum,goods_price,goods_youhuiprice )"
					+ "values (?,1,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, goods.getGoods_id());
			pst.setString(2, goods.getGoods_name());
            pst.setFloat(3, goods.getGoods_price());
            pst.execute();
            pst.close();
            
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
	
	public List<Beancart> listcate(){
		List<Beancart> result=new ArrayList<Beancart>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select goods_name,goods_wnum,goods_price,goods_youhuiprice from cart ";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beancart shop = new Beancart();
				//shop.setMerchant_name(rs.getString(1));
			    shop.setGoods_name(rs.getString(1));
			    shop.setGoods_price(rs.getFloat(3));
			    shop.setGoods_wnum(rs.getInt(2));
			    shop.setGoods_youhuiprice(rs.getFloat(4));
				result.add(shop);
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

	@Override
	public List<Beancart> listcart() {
		// TODO Auto-generated method stub
		return null;
	}



	
	
	
}
