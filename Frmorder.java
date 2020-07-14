package cn.edu.zucc.take_away.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.take_away.model.Beancust;
import cn.edu.zucc.take_away.ui.*;
import cn.edu.zucc.take_away.take_awayUtil;
import cn.edu.zucc.take_away.control.*;
import cn.edu.zucc.take_away.model.*;
import cn.edu.zucc.take_away.ui.*;
import cn.edu.zucc.take_away.util.*;
import cn.edu.zucc.take_away.take_awayUtil;
import cn.edu.zucc.take_away.model.Beangoods_detail;
import cn.edu.zucc.take_away.take_awayUtil;

public class Frmorder extends JDialog implements ActionListener {
private JMenuBar menubar=new JMenuBar();
private JPanel toolBar = new JPanel();
private Button btnAdd = new Button("结算");
	
	private JMenu menu_goodManager=new JMenu("订单管理");
	private JMenu menu_goodcategoriesManager=new JMenu("下单");
	
	private JMenuItem  menuItem_Addgoodcategories=new JMenuItem("购物车管理");
	private JMenuItem  menuItem_deletegoodcategories=new JMenuItem("结算");
	private JMenuItem  menuItem_Addgoods=new JMenuItem("订单详情");
	private JMenuItem  menuItem_deletegoods=new JMenuItem("结算");
	
	//private FrmLogin dlgLogin=null;
	private JPanel statusBar = new JPanel();
	
	private Object tblbusTitle[]=Beanbus.tableTitles;
	private Object tblbusData[][];
	DefaultTableModel tabPlanModel=new DefaultTableModel();
	private JTable dataTablePlan=new JTable(tabPlanModel);
	
	private Object tblgoodscategoryTitle[]=Beangoods_category.tableTitles;
	private Object tblgoodscategoryData[][];
	DefaultTableModel tabgoodscategoryModel=new DefaultTableModel();
	private JTable dataTablegoodscategory=new JTable(tabgoodscategoryModel);
	
	private Object tblgoodsTitle[]=Beangoods_detail.tableTitles;
	private Object tblgoodsData[][];
	DefaultTableModel tabStepModel=new DefaultTableModel();
	private JTable dataTableStep=new JTable(tabStepModel);
	
	
	
	private Beanbus mc=null;
	List<Beanbus> allbus=null;
	List<Beangoods_category> categories=null;
	private Beangoods_category gc =null;
	List<Beangoods_detail> goods=null;
	
	
	private void reloadPlanTable(){
		try {
			allbus=new busManager().loadAll();
		}catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblbusData =  new Object[allbus.size()][Beanbus.tableTitles.length];
		for(int i=0;i<allbus.size();i++){
			for(int j=0;j<Beanbus.tableTitles.length;j++)
				tblbusData[i][j]=allbus.get(i).getCell(j);
		}
		tabPlanModel.setDataVector(tblbusData,tblbusTitle);
		this.dataTablePlan.validate();
		this.dataTablePlan.repaint();	
} 
	private void reloadgoods_categories(int p) {
		if(p<0) return;
		mc=allbus.get(p);
		try {
			categories=new goodsManager().loadAllcategories(mc);
		}catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblgoodscategoryData =  new Object[categories.size()][Beangoods_category.tableTitles.length];
		for(int i=0;i<categories.size();i++){
			for(int j=0;j<Beangoods_category.tableTitles.length;j++)
				tblgoodscategoryData[i][j]=categories.get(i).getCell(j);
		}
		tabgoodscategoryModel.setDataVector(tblgoodscategoryData,tblgoodscategoryTitle);
		this.dataTablegoodscategory.validate();
		this.dataTablegoodscategory.repaint();	
	}
	private void reloadPlanStepTabel(int planIdx){
		if(planIdx<0) return;
		gc=categories.get(planIdx);
		goods=new goodsManager().loadAll(gc);
		tblgoodsData =new Object[goods.size()][Beangoods_detail.tableTitles.length];
		for(int i=0;i<goods.size();i++){
			for(int j=0;j<Beangoods_detail.tableTitles.length;j++)
				tblgoodsData[i][j]=goods.get(i).getCell(j);
		}
		
		tabStepModel.setDataVector(tblgoodsData,tblgoodsTitle);
		this.dataTableStep.validate();
		this.dataTableStep.repaint();
		
	}
	
	public Frmorder(){
		
		
		this.setTitle("商品管理");
		
		menu_goodManager.add(menuItem_Addgoods);
		menuItem_Addgoods.addActionListener(this);
		menu_goodManager.add(menuItem_deletegoods);
		menuItem_deletegoods.addActionListener(this);
		menubar.add(menu_goodManager);
		
		menu_goodcategoriesManager.add(menuItem_Addgoodcategories);
		menuItem_Addgoodcategories.addActionListener(this);
		menu_goodcategoriesManager.add(menuItem_deletegoodcategories);
		menuItem_deletegoodcategories.addActionListener(this);
		menubar.add(menu_goodcategoriesManager);
		
		
		
		this.setJMenuBar(menubar);
		
		this.getContentPane().add(new JScrollPane(this.dataTablePlan), BorderLayout.WEST);
		this.dataTablePlan.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frmorder.this.dataTablePlan.getSelectedRow();
				if(i<0) {
					return;
				}
				Frmorder.this.reloadgoods_categories(i);
			}
	    	
	    });
		this.getContentPane().add(new JScrollPane(this.dataTablegoodscategory), BorderLayout.CENTER);
		this.dataTablegoodscategory.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frmorder.this.dataTablegoodscategory.getSelectedRow();
				if(i<0) {
					return;
				}
				Frmorder.this.reloadPlanStepTabel(i);
			}
	    	
	    });
	    this.getContentPane().add(new JScrollPane(this.dataTableStep), BorderLayout.EAST);
	    
	   this.reloadPlanTable();
	   
	   toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
	   toolBar.add(this.btnAdd);
	   this.getContentPane().add(toolBar,BorderLayout.AFTER_LAST_LINE);
	   btnAdd.addActionListener(this);
	   
	  //状态栏
	    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel label=new JLabel("您好!"+Beancust.currentLoginCust.getCust_name());//修改成   您好！+登陆用户名
	    statusBar.add(label);
	    this.getContentPane().add(statusBar,BorderLayout.SOUTH);
	    this.addWindowListener(new WindowAdapter(){   
	    	public void windowClosing(WindowEvent e){ 
	    		//System.exit(0);
             }
        });
	    this.setVisible(true);
	    
	    this.setSize(1500, 800);
	    this.menuItem_Addgoodcategories.addActionListener(this);
	    this.btnAdd.addActionListener(this);
	}


	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnAdd) {
			Frmjiesuan js = new Frmjiesuan(this,"结算",true);
			js.setVisible(true);
		}
		else if(e.getSource()==this.menuItem_Addgoodcategories) {
			int i=this.dataTableStep.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择商品","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				Beangoods_detail p=goods.get(i);
				new goodsManager().addgoods(p);
			}catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
