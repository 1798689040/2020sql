package cn.edu.zucc.take_away.itf;

import java.util.List;

import cn.edu.zucc.take_away.model.Beanbus;
import cn.edu.zucc.take_away.model.Beanbus;
import cn.edu.zucc.take_away.model.Beanbus;
import cn.edu.zucc.take_away.util.BaseException;
import cn.edu.zucc.take_away.model.Beanbus;


public interface IbusManager {
	public List<Beanbus> searchuser(String text) throws BaseException;
	public  void createMerchant(Beanbus k) throws BaseException;
	public List<Beanbus> loadAll() throws BaseException;
	public void removeMerchant(Beanbus beanbus)throws BaseException;
}