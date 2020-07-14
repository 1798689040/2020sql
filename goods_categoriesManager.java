package cn.edu.zucc.take_away.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.take_away.model.*;
import cn.edu.zucc.take_away.util.*;

public class goods_categoriesManager {
	public List<Beangoods_category> loadcate(Beanbus k)throws BaseException{
		List<Beangoods_category> result=new ArrayList<Beangoods_category>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select goods_category_id,bus_id,goods_category_name,goods_num" +" from goods_category where bus_id=?";
			java.sql.PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, k.getBus_id());
			java.sql.ResultSet rs=st.executeQuery();
			while(rs.next()){
				Beangoods_category u=new Beangoods_category();
				u.setGoods_category_id(rs.getString(1));
				u.setBus_id(rs.getString(2));
				u.setGoods_category_name(rs.getString(3));
				u.setGoods_num(rs.getInt(4));
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
