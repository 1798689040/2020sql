package cn.edu.zucc.take_away.itf;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JDialog;

import cn.edu.zucc.take_away.model.Beangoods_category;
import cn.edu.zucc.take_away.model.Beangoods_detail;
import cn.edu.zucc.take_away.model.Beanorder;
import cn.edu.zucc.take_away.model.Beanbus;
import cn.edu.zucc.take_away.model.Beancart;
import cn.edu.zucc.take_away.util.BaseException;

public interface IgoodsManager {
	public List<Beangoods_detail> loadAll(Beangoods_category cart);
	public List<Beangoods_category> loadAllcategories(Beanbus k) throws BaseException;
	public void addcate(String name, String cateid, String catename, String cnt) throws Exception;
	public List<Beangoods_category> loadAllcategories() throws BaseException;
	public void creatgoods(String goodid, String cateid, String goodname, String price, String reduce) throws Exception;
	public List<Beancart> addgoods(Beangoods_detail de);
	public List<Beancart> listcart();
}
