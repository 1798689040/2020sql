package cn.edu.zucc.take_away.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_away.take_awayUtil;
import cn.edu.zucc.take_away.control.*;
import cn.edu.zucc.take_away.model.*;
import cn.edu.zucc.take_away.ui.*;
import cn.edu.zucc.take_away.util.*;
import cn.edu.zucc.take_away.model.Beancust;
import javax.swing.JTextField;

public class Frmjiesuan extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JLabel label = new JLabel("收货地址");
	private JComboBox cmbaddress = new JComboBox();
	private JComboBox cmbcoupon = new JComboBox();
	private JLabel lblNewLabel_1 = new JLabel("合计:");
	private JButton okButton = new JButton("提交订单");
	private JButton cancelButton = new JButton("返回");
	List<Beanaddress> address=new ArrayList<Beanaddress>();
	private JTextField textField;
	public Frmjiesuan(JDialog f, String s, boolean b) {
		super(f,s,b);
		setBounds(100, 100, 546, 431);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 514, 217);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		cmbaddress.setBounds(179, 43, 208, 24);
		cmbaddress.addItem("------请选择地址------");
		
		this.okButton.addActionListener(this);
		this.cancelButton.addActionListener(this);
		
		try {
			addressManager ad=new addressManager();
			address=ad.loadAddress();
		}catch(BaseException e1){
			JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		for(int i=0;i<address.size();i++) {
			cmbaddress.addItem(address.get(i).getAddress_id()+" "+address.get(i).getAddress_province()+address.get(i).getAddress_city()+address.get(i).getAddress_area()+address.get(i).getAddress_add()+" "+address.get(i).getAddress_wantname()+" "+address.get(i).getAddress_phone());
		}
		contentPanel.add(cmbaddress);
		label.setBounds(28, 46, 72, 18);
		contentPanel.add(label);
		
		
		
		contentPanel.add(cmbcoupon);
		
		lblNewLabel_1.setBounds(52, 164, 72, 18);
		contentPanel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(156, 163, 220, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(14, 335, 500, 37);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.cancelButton) {
			this.setVisible(false);
		} else if(e.getSource() == this.okButton) {
			try {
				String str = "";
				int i = 0;
				while(String.valueOf(this.cmbaddress.getSelectedItem()).charAt(i) != ' ') {
					str = str + String.valueOf(this.cmbaddress.getSelectedItem()).charAt(i);
					i++;
				}
			}	finally {
				
			}
		}
	}
	
	public float totalprice() {
		float sum = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "select goods_price from goods_datail where cust_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, Beancust.currentLoginCust.getCust_id());
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next()) 
				sum += rs.getFloat(1) ;
			conn.commit();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null)
				try {
					conn.rollback();
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
		}
		return sum;
	}
}

