package cn.edu.zucc.take_away.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_away.control.userManager;
import cn.edu.zucc.take_away.model.Beanuser;
import cn.edu.zucc.take_away.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class FrmLogin3 extends JFrame implements ActionListener{
//管理员
	private JPanel contentPane;
	private JTextField edtUserId;
	JButton btnNewButton = new JButton("登录");
	JButton btnNewButton_1 = new JButton("注册");
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin3 frame = new FrmLogin3();
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
	public FrmLogin3() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("管理员名字 ：");
		lblNewLabel.setBounds(34, 41, 98, 15);
		contentPane.add(lblNewLabel);
		
		edtUserId = new JTextField();
		edtUserId.setBounds(142, 38, 175, 21);
		contentPane.add(edtUserId);
		edtUserId.setColumns(10);
		
		JLabel label = new JLabel("密码 ：");
		label.setBounds(35, 111, 58, 15);
		contentPane.add(label);
		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(35, 186, 97, 23);
		contentPane.add(btnNewButton);
		

		btnNewButton_1.setBounds(220, 186, 97, 23);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(142, 108, 175, 21);
		contentPane.add(passwordField);
		this.btnNewButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnNewButton) {
		String userid=this.edtUserId.getText();
		String passwd=new String(passwordField.getPassword());
		try {
			userManager userManager = new userManager();
			Beanuser.currentLoginUser= userManager.login(userid,passwd);
		} catch (BaseException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		Frmmainuser frame = new Frmmainuser();
		
		frame.setVisible(true);
		}
		setVisible(false);
	}
}

