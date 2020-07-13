package cn.edu.zucc.take_away.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_away.control.custManager;
import cn.edu.zucc.take_away.control.userManager;
import cn.edu.zucc.take_away.model.Beancust;
import cn.edu.zucc.take_away.model.Beanuser;
import cn.edu.zucc.take_away.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Frmuseradd extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	JLabel lblNewLabel = new JLabel("员工编号 ：");
	JLabel lblNewLabel_1 = new JLabel("员工姓名 ：");
	JLabel lblNewLabel_2 = new JLabel("登录密码 ：");
	
	private JPasswordField passwordField;
	private JButton button;
	private JButton button_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmuseradd frame = new Frmuseradd();
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
	public Frmuseradd() {
		setTitle("管理员注册界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		lblNewLabel.setBounds(25, 42, 109, 15);
		contentPane.add(lblNewLabel);
		//员工编号
		

		lblNewLabel_1.setBounds(25, 103, 97, 15);
		contentPane.add(lblNewLabel_1);
		//员工姓名
		

		lblNewLabel_2.setBounds(24, 153, 98, 15);
		contentPane.add(lblNewLabel_2);
		//登录密码
		
		textField = new JTextField();
		textField.setBounds(142, 39, 133, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 100, 133, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(142, 150, 133, 21);
		contentPane.add(passwordField);
		
		button = new JButton("退出");
		button.setBounds(220, 218, 97, 23);
		contentPane.add(button);
		
		button_1 = new JButton("确认注册");
		button_1.setBounds(25, 218, 97, 23);
		contentPane.add(button_1);
		
		lblNewLabel_3 = new JLabel("请再次输入密码 ：");
		lblNewLabel_3.setBounds(10, 178, 116, 15);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(142, 175, 133, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		this.button.addActionListener(this);
		this.button_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.button) 
			this.setVisible(false);
		else if(e.getSource()==this.button_1){
			String user_id=this.textField.getText();
			String user_name=this.textField_1.getText();
			String passwd1=new String(this.passwordField.getPassword());
			String passwd2=new String(this.passwordField.getPassword());
			userManager userManager = new userManager();
			try {
				Beanuser user=userManager.reg(user_id, user_name, passwd1, passwd2);
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
