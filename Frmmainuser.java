package cn.edu.zucc.take_away.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Frmmainuser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmmainuser frame = new Frmmainuser();
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
	public Frmmainuser() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 371);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu_3 = new JMenu("\u5546\u54C1");
		menuBar.add(menu_3);
		
		JMenuItem menuItem_8 = new JMenuItem("\u4FEE\u6539\u5546\u54C1\u4FE1\u606F");
		menu_3.add(menuItem_8);
		
		JMenuItem menuItem = new JMenuItem("\u589E\u52A0\u5546\u54C1");
		menu_3.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5220\u9664\u5546\u54C1");
		menu_3.add(menuItem_1);
		
		JMenu menu = new JMenu("\u4F18\u60E0\u5238\u4FE1\u606F");
		menuBar.add(menu);
		
		JMenuItem menuItem_9 = new JMenuItem("\u4FEE\u6539\u4F18\u60E0\u5238");
		menu.add(menuItem_9);
		
		JMenuItem menuItem_2 = new JMenuItem("\u589E\u52A0\u4F18\u60E0\u5238");
		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5220\u9664\u4F18\u60E0\u5238");
		menu.add(menuItem_3);
		
		JMenu menu_1 = new JMenu("\u5546\u5BB6\u4FE1\u606F");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_10 = new JMenuItem("\u4FEE\u6539\u5546\u5BB6\u4FE1\u606F");
		menu_1.add(menuItem_10);
		
		JMenuItem menuItem_4 = new JMenuItem("\u65B0\u589E\u5546\u5BB6");
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u5220\u9664\u5546\u5BB6");
		menu_1.add(menuItem_5);
		
		JMenu menu_2 = new JMenu("\u6EE1\u51CF\u65B9\u6848");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_7 = new JMenuItem("\u4FEE\u6539\u6EE1\u51CF\u65B9\u6848");
		menu_2.add(menuItem_7);
		
		JMenuItem menuItem_6 = new JMenuItem("\u65B0\u589E\u6EE1\u51CF\u65B9\u6848");
		menu_2.add(menuItem_6);
		
		JMenuItem menuItem_11 = new JMenuItem("\u5220\u9664\u6EE1\u51CF\u65B9\u6848");
		menu_2.add(menuItem_11);
		
		JMenu menu_4 = new JMenu("\u9A91\u624B");
		menuBar.add(menu_4);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u66F4\u6539\u9A91\u624B\u4FE1\u606F");
		menu_4.add(mntmNewMenuItem);
		
		JMenuItem menuItem_12 = new JMenuItem("\u65B0\u589E\u9A91\u624B");
		menu_4.add(menuItem_12);
		
		JMenuItem menuItem_13 = new JMenuItem("\u5220\u9664\u9A91\u624B");
		menu_4.add(menuItem_13);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
