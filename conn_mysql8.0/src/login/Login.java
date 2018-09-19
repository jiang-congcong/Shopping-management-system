
package login;

/*
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}

*/


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private  String Userid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//点击右上角叉叉后只关闭当前界面，其他界面依然显示	
		setBounds(100, 100, 450, 300);
		setTitle("登录界面");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//JButton btnNewButton = new JButton("New button");
		
		JTextPane textPane = new JTextPane();
		textPane.setText("\u7528\u6237\u540D");
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		
		passwordField = new JPasswordField();
		
		JButton btnNewButton_1 = new JButton("\u767B\u5F55");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("hello");
				
				String userid=textField.getText();
				String password=passwordField.getText();
				if(userid!=null&&password!=null) {
					boolean mid=getUser(userid, password);
					if(mid) {
						Userid=userid;
						
						boolean flag = Is_setInformation(Userid);
						
						if(!flag) {
							Dialogs4 dlg=new Dialogs4 (null,"请及时完善个人信息！");
						    dlg.setVisible(true);//显示对话框
						}
					
						Main_function mainfunction=new Main_function(userid,flag);
						mainfunction.setVisible(true);
						System.out.println("欢迎登录");
						
					}
					else {
						//System.out.println("用户名或密码错误！");
						Dialogs4 dlg=new Dialogs4 (null,"用户名或密码错误！");
					    dlg.setVisible(true);//显示对话框
					}
							
					
				}
				
														
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u53D6\u6D88");
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		
		JButton btnNewButton_3 = new JButton("注册");
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Registe reg = new Registe();
				reg.setVisible(true);
			}
		});
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(91, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnNewButton_1, Alignment.TRAILING)
							.addComponent(lblNewLabel_1)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(157)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(btnNewButton_2))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(passwordField, Alignment.LEADING)
							.addComponent(textField, Alignment.LEADING)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1)
								.addComponent(btnNewButton_2)))
						.addComponent(btnNewButton_3))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		contentPane.setLayout(groupLayout);
	}
	
	public boolean getUser(String userid,String psd) {
		
        String driver1 = "com.mysql.cj.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/xqxqxq?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
		String username = "root";
		String password = "root123";	
		Connection conn = null;
		Statement stmt = null;
		
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName(driver1);
		      //STEP 3: Open a connection
		      //System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(url, username, password);
		      System.out.println("Connected database successfully...");
		      stmt = conn.createStatement();
		      //STEP 4: Execute a query
		      //System.out.println("Creating table in given database...");
		      String sql = "select * from Login";
				// 执行 SQL语句
				// ResultSet 接收查询返回的结果集的一个接口 result 定义的一个接收返回结果的变量名
		      ResultSet result=null;
			  result = stmt.executeQuery(sql);
				// 将查询返回的结果集进行遍历输出
			  boolean flag=false; 
			  while (result.next()) {
					// t_id 必须跟数据库的 字段名一致 getInt() 这个 是由对应字段的数据类型决定
				  
					String Userid = result.getString("Userid");
					String psd1 = result.getString("Password");
					//System.out.println("id=" + id + "\t" + "name=" + name);
					if(Userid.equals(userid)&&psd1.equals(psd)) {
						flag=true;
						return true;
						
					}
				}
			  
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   //System.out.println("Goodbye!");
		
		return false;
	}
	
	
public boolean Is_setInformation(String userid) {
		
        String driver1 = "com.mysql.cj.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/xqxqxq?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
		String username = "root";
		String password = "root123";	
		Connection conn = null;
		Statement stmt = null;
		
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName(driver1);
		      //STEP 3: Open a connection
		      //System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(url, username, password);
		      System.out.println("Connected database successfully...");
		      stmt = conn.createStatement();
		      //STEP 4: Execute a query
		      //System.out.println(shoppingtype);
		     
		      //String sql1 = "select Goodsprice from Shoppingmemary where Memaryid = " + memary_id+"AND Userid = "+"\'"+id6+"\'";
		      String sql1 = "select * from UserInformation where Userid = "+"\'"+userid+"\'";
		      //+"AND Userid = "+"\'"+id3+"\'"
				// 执行 SQL语句
				// ResultSet 接收查询返回的结果集的一个接口 result 定义的一个接收返回结果的变量名
		      ResultSet result=null;
			  result = stmt.executeQuery(sql1);
				// 将查询返回的结果集进行遍历输出
			  //boolean flag=false;
			  if(result.next()) {
				 
				 return true;
			  }
			  else {
				  //System.out.println("无此记录");
				  //System.out.println("222222222222222");
				  return false;
				  
			  }
  
			 				
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   //System.out.println("Goodbye!");
		return false;
				
	}
	
	
	
	
	
	
}


class Dialogs4 extends JDialog{//制作对话框
	 public Dialogs4(JFrame parent,String show){
	 super(parent,"登录验证",true);
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




