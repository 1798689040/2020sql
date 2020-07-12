package cn.edu.zucc.take_away.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Frmmaincust extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmmaincust frame = new Frmmaincust();
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
	public Frmmaincust() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 368);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u76EE\u524D\u8BA2\u5355");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u8BA2\u5355");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u4E0B\u5355");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu menu_1 = new JMenu("\u5DF2\u5B8C\u6210\u8BA2\u5355");
		menuBar.add(menu_1);
		
		JMenu menu = new JMenu("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u7528\u6237\u4FE1\u606F");
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u914D\u9001\u5730\u5740");
		menu.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}
}
