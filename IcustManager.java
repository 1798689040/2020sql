package cn.edu.zucc.take_away.itf;

import java.util.List;

import cn.edu.zucc.take_away.model.Beanbus;
import cn.edu.zucc.take_away.model.Beancust;
import cn.edu.zucc.take_away.model.Beancust;
import cn.edu.zucc.take_away.model.Beancust;
import cn.edu.zucc.take_away.util.BaseException;
import cn.edu.zucc.take_away.model.Beancust;

public interface IcustManager {
public Beancust login(String clerkid,String pwd)throws BaseException;
	
	public Beancust reg(String clerkname,String pwd,String pwd2) throws BaseException;

	public List<Beancust> loadAll() throws BaseException;
	public List<Beancust> searchuser(String text);

	public List<Beancust> loadcurrent()  throws BaseException;
	
	
}