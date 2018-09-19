package login;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class Update_memary extends JFrame {
	private JTextField textField;
	
	private String id5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_memary frame = new Update_memary("zhangsan");
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
	public Update_memary(String userid) {
		id5 = userid;
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("修改消费记录界面");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入要修改的记录id:");
		lblNewLabel.setBounds(14, 39, 172, 18);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(178, 36, 86, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("修改");
		btnNewButton.setBounds(291, 35, 113, 27);
		getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String memaryid = textField.getText().toString();
				
				if(memaryid.length()==0) {
					Dialogs6 dig6 = new Dialogs6(null, "请输入要修改的id！！！");
					dig6.setVisible(true);
				}
				
				else {
				Updatememary_bymemaryid update = new Updatememary_bymemaryid(id5,memaryid);
				update.setVisible(true);
				}
			}
		});
		
		
		JLabel lblNewLabel_1 = new JLabel("不清楚id ?点击按钮查看");
		lblNewLabel_1.setBounds(14, 124, 172, 18);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("查看id");
		btnNewButton_1.setBounds(227, 120, 113, 27);
		getContentPane().add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Selectmemary_bycondition select = new Selectmemary_bycondition(id5);
				select.setVisible(true);
			}
		});

	}
	
	
	
	
}


//弹出对话框
class Dialogs6 extends JDialog{//制作对话框
	 public Dialogs6(JFrame parent,String show){
	 super(parent,"",true);
	 Container cp=getContentPane();
	 cp.setLayout(new FlowLayout());
	 cp.add(new JLabel(show));
	 JButton ok=new JButton("OK");
	 ok.addActionListener(new ActionListener(){
	 public void actionPerformed(ActionEvent e){
	 dispose();
	 }
	 });
	 cp.add(ok);
	 setSize(150,125);
	 }
	}




