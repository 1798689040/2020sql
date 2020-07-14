package cn.edu.zucc.take_away.itf;

import java.util.List;

import cn.edu.zucc.take_away.model.Beanaddress;
import cn.edu.zucc.take_away.util.BaseException;

public interface IaddressManager {
	public List<Beanaddress> loadAddress() throws BaseException;
	public void deleteAdd(String address_id, String cust_id) throws BaseException;
	public void createManager(Beanaddress ad) throws BaseException;
}
