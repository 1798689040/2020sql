package cn.edu.zucc.take_away.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_away.control.*;
import cn.edu.zucc.take_away.model.*;

import cn.edu.zucc.take_away.ui.*;
import cn.edu.zucc.take_away.util.*;

import cn.edu.zucc.take_away.control.custManager;
import cn.edu.zucc.take_away.model.Beancust;
import cn.edu.zucc.take_away.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FrmLogin2 extends JFrame implements ActionListener{
//ÓÃ»§/¹Ë¿Í
	private JPanel contentPane;
	private JTextField edtUserId;

	JButton btnNewButton_1 = new JButton("×¢²á");
	JButton btnNewButton = new JButton("µÇÂ¼");
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin2 frame = new FrmLogin2();
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
	public FrmLogin2() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("ÓÃ»§Ãû×Ö £º");
		label.setBounds(22, 31, 94, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("ÃÜÂë £º");
		label_1.setBounds(22, 98, 58, 15);
		contentPane.add(label_1);
		
		edtUserId = new JTextField();
		edtUserId.setBounds(126, 28, 125, 21);
		contentPane.add(edtUserId);
		edtUserId.setColumns(10);
		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(22, 179, 97, 23);
		contentPane.add(btnNewButton);
		

		btnNewButton_1.setBounds(217, 179, 97, 23);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 95, 125, 21);
		contentPane.add(passwordField);
		this.btnNewButton.addActionListener(this);
	}



	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnNewButton) {
		String custid=this.edtUserId.getText();
		String passwd=new String(passwordField.getPassword());
		try {
			custManager custManager = new custManager();
			Beancust.currentLoginCust= custManager.login(custid,passwd);
		} catch (BaseException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Frmmaincust frame = new Frmmaincust();
		
		frame.setVisible(true);
		}
		setVisible(false);
	}
}