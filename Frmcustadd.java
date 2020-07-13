package cn.edu.zucc.take_away.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_away.control.*;
import cn.edu.zucc.take_away.model.*;
import cn.edu.zucc.take_away.util.*;
import cn.edu.zucc.take_away.control.custManager;
import cn.edu.zucc.take_away.model.Beancust;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Frmcustadd extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JLabel label_1 = new JLabel("姓名 ：");
	JLabel label_2 = new JLabel("密码 ：");
	JLabel lblNewLabel_1 = new JLabel("手机号码 ：");
	JLabel lblNewLabel_2 = new JLabel("邮箱 ：");
	JLabel lblNewLabel_3 = new JLabel("所在城市 ：");
	JLabel label = new JLabel("性别 ：");
	private JButton btnNewButton;
	private JButton button;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JLabel label_3;
	private JTextField textField_4;
	private JLabel label_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmcustadd frame = new Frmcustadd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frmcustadd() {
		setVisible(true);
		setTitle("用户注册界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		label_1.setBounds(24, 37, 58, 15);
		contentPane.add(label_1);
		//姓名
		

		label_2.setBounds(27, 68, 58, 15);
		contentPane.add(label_2);
		//密码
		

		lblNewLabel_1.setBounds(27, 173, 80, 15);
		contentPane.add(lblNewLabel_1);
		//手机号码
		
		

		lblNewLabel_2.setBounds(27, 243, 58, 15);
		contentPane.add(lblNewLabel_2);
		//邮箱
		
		

		lblNewLabel_3.setBounds(27, 297, 83, 15);
		contentPane.add(lblNewLabel_3);
		//城市
		
		
		textField = new JTextField();
		textField.setBounds(114, 37, 104, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		//姓名
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 65, 105, 21);
		contentPane.add(passwordField);
		//密码
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 170, 104, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		//手机号码
		
		textField_2 = new JTextField();
		textField_2.setBounds(116, 240, 104, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		//邮箱
		
		textField_3 = new JTextField();
		textField_3.setBounds(116, 294, 104, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		///城市
		

		label.setBounds(21, 135, 58, 15);
		contentPane.add(label);
		
		btnNewButton = new JButton("确认注册");
		btnNewButton.setBounds(66, 377, 97, 23);
		contentPane.add(btnNewButton);
		
		button = new JButton("返回");
		button.setBounds(238, 377, 97, 23);
		contentPane.add(button);
		
		rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setBounds(99, 130, 127, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setBounds(241, 127, 127, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		label_3 = new JLabel("用户编号");
		label_3.setBounds(27, 10, 85, 15);
		contentPane.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(115, 5, 101, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		//用户编号
		
		label_4 = new JLabel("请再次输入密码 ：");
		label_4.setBounds(2, 99, 114, 15);
		contentPane.add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(114, 98, 107, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		//第二次密码
		
		this.btnNewButton.addActionListener(this);
		this.button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.button)
			this.setVisible(false);
		else if(e.getSource()==this.btnNewButton){
			if(this.rdbtnNewRadioButton.isSelected()) {

			String cust_id=this.textField_4.getText();
			String cust_name=this.textField.getText();
			String passwd1=new String(this.passwordField.getPassword());
			String passwd2=new String(this.passwordField.getPassword());
			String cust_phone=new String(this.textField_1.getText());
			String cust_mail=new String(this.textField_2.getText());
			String cust_city=new String(this.textField_3.getText());
			custManager custManager = new custManager();
			try {
				Beancust cust=custManager.reg1(cust_id, cust_name, passwd1, passwd2, cust_phone, cust_mail, cust_city);
				this.setVisible(false);
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
			else if(this.rdbtnNewRadioButton_1.isSelected()) {
				String cust_id=this.textField_4.getText();
				String cust_name=this.textField.getText();
				String passwd1=new String(this.passwordField.getPassword());
				String passwd2=new String(this.passwordField.getPassword());
				String cust_phone=new String(this.textField_1.getText());
				String cust_mail=new String(this.textField_2.getText());
				String cust_city=new String(this.textField_3.getText());
				custManager custManager = new custManager();
				try {
					Beancust user=custManager.reg2(cust_id, cust_name, passwd1, passwd2, cust_phone, cust_mail, cust_city);
					this.setVisible(false);
				} catch (BaseException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
				setVisible(false);
			}
			
			
		}
	}
}
