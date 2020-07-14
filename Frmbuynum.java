package cn.edu.zucc.take_away.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Frmbuynum extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textField=new JTextField(50);
	JLabel lblNewLabel = new JLabel("请输入购买数量");
	JButton okButton = new JButton("确定");
	JButton cancelButton = new JButton("取消");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Frmbuynum dialog = new Frmbuynum();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Frmbuynum(Frame f, String s, boolean b) {
		super(f,s,b);
		setTitle("购买数量");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		lblNewLabel.setBounds(51, 56, 125, 61);
		contentPanel.add(lblNewLabel);
		
		//textField = new JTextField();
		textField.setBounds(230, 56, 111, 61);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
		this.cancelButton.addActionListener(this);
		this.okButton.addActionListener(this);
	}

	public Frmbuynum() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.cancelButton)
			this.setVisible(false);
		else if(e.getSource()==this.okButton){
			if(this.textField.getText()==null||"".equals(this.textField.getText())) {
				JOptionPane.showMessageDialog(null, "请输入数量","错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.setVisible(false);
		
			
		}
	}
	public int loadNum() {
		return Integer.valueOf(this.textField.getText());
	}
}
