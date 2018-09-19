package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Main_function extends JFrame {

	private JPanel contentPane;
	private static String id1;
	
	private boolean flag1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_function frame = new Main_function(id1,false);
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
	public Main_function(String userid,boolean flag) {
		id1=userid;
		flag1 = flag;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("主功能界面");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("添加购物记录");
		btnNewButton.setBounds(14, 48, 137, 27);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Insert_memary insertmemary=new Insert_memary(id1);
				insertmemary.setVisible(true);
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("删除购物记录");
		btnNewButton_1.setBounds(14, 127, 137, 27);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Delete_memary delete = new Delete_memary(id1);
				delete.setVisible(true);
			}
		});
		
		
		JButton btnNewButton_2 = new JButton("查看购物记录");
		btnNewButton_2.setBounds(264, 48, 143, 27);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Selectmemary_bycondition select = new Selectmemary_bycondition(id1);
				select.setVisible(true);
			}
		});
		
		
		
		JButton btnNewButton_3 = new JButton("修改购物记录");
		btnNewButton_3.setBounds(264, 127, 143, 27);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Update_memary update = new Update_memary(id1);
				update.setVisible(true);
			}
		});
		
		
		JButton btnNewButton_4 = new JButton("购物金额清算");
		btnNewButton_4.setBounds(14, 195, 137, 27);
		contentPane.add(btnNewButton_4);
		
		
		
		btnNewButton_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Count_money money = new Count_money(id1);
				//money.setVisible(true);
				money.Show(id1);
			}
		});
		
		JButton btnNewButton_5 = new JButton("编辑个人信息");
		btnNewButton_5.setBounds(264, 195, 143, 27);
		contentPane.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				User_information info = new User_information(id1,flag1);
				info.setVisible(true);
			}
		});
		
	}
	
	
	
}
