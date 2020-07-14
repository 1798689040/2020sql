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
		setTitle("管理员界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 371);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu_3 = new JMenu("商品");
		menuBar.add(menu_3);
		
		JMenuItem menuItem_8 = new JMenuItem("修改商品");
		menu_3.add(menuItem_8);
		
		JMenuItem menuItem = new JMenuItem("增加商品");
		menu_3.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("删除商品");
		menu_3.add(menuItem_1);
		
		JMenu menu = new JMenu("优惠券信息");
		menuBar.add(menu);
		
		JMenuItem menuItem_9 = new JMenuItem("修改优惠券");
		menu.add(menuItem_9);
		
		JMenuItem menuItem_2 = new JMenuItem("新增优惠券");
		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("删除优惠券");
		menu.add(menuItem_3);
		
		JMenu menu_1 = new JMenu("商家信息");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_10 = new JMenuItem("修改商家信息");
		menu_1.add(menuItem_10);
		
		JMenuItem menuItem_4 = new JMenuItem("新增商家信息");
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("删除商家信息");
		menu_1.add(menuItem_5);
		
		JMenu menu_2 = new JMenu("满减方案");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_7 = new JMenuItem("修改满减方案");
		menu_2.add(menuItem_7);
		
		JMenuItem menuItem_6 = new JMenuItem("新增满减方案");
		menu_2.add(menuItem_6);
		
		JMenuItem menuItem_11 = new JMenuItem("删除满减方案");
		menu_2.add(menuItem_11);
		
		JMenu menu_4 = new JMenu("骑手");
		menuBar.add(menu_4);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("维护骑手信息");
		menu_4.add(mntmNewMenuItem);
		
		JMenuItem menuItem_12 = new JMenuItem("新增骑手");
		menu_4.add(menuItem_12);
		
		JMenuItem menuItem_13 = new JMenuItem("解雇骑手");
		menu_4.add(menuItem_13);
		
		JMenu menu_5 = new JMenu("\u66F4\u591A");
		menuBar.add(menu_5);
		
		JMenuItem menuItem_14 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menu_5.add(menuItem_14);
		
		JMenuItem menuItem_15 = new JMenuItem("\u5220\u9664\u7BA1\u7406\u5458");
		menu_5.add(menuItem_15);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
