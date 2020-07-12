package cn.edu.zucc.take_away.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLogin1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	JButton button = new JButton("用户登录");
	JButton button_1 = new JButton("管理员登录");
	JButton btnNewButton = new JButton("退出");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin1 frame = new FrmLogin1();
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
	public FrmLogin1() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button) {
					new FrmLogin2();
				}
				setVisible(false);
			}


		});
		button.setBounds(89, 32, 171, 57);
		contentPane.add(button);
		//用户登录
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_1) {
					new FrmLogin3();
				}
				setVisible(false);
			}
			

		});
		

		button_1.setBounds(89, 122, 171, 49);
		contentPane.add(button_1);
		//管理员登录
		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton) {
					System.exit(0);
				}
			}
		});
		btnNewButton.setBounds(89, 210, 171, 23);
		contentPane.add(btnNewButton);
		
		//退出
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
