package login;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPasswordField;

public class Registe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registe frame = new Registe();
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
	public Registe() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("注册界面");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名 ：");
		lblNewLabel.setBounds(114, 40, 85, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(198, 37, 104, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("密  码 :");
		lblNewLabel_1.setBounds(114, 89, 85, 18);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 86, 104, 24);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("确认密码：");
		lblNewLabel_2.setBounds(113, 143, 86, 18);
		contentPane.add(lblNewLabel_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(198, 140, 104, 24);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.setBounds(70, 197, 113, 27);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userid = textField.getText();
				String psd1 = passwordField.getText();
				String psd2 = passwordField_1.getText();
				
				if(userid.length()==0||psd1.length()==0||psd2.length()==0) {
					Dialogs1 dig = new Dialogs1(null,"请将信息填完整！！！");
					dig.setVisible(true);
				}
				
				else {
									
				if(psd1.equals(psd2)) {
					boolean flag = Isregiste(userid);
					if(flag) {
					Insert_login(userid, psd1);
					Dialogs1 dig = new Dialogs1(null,"注册成功！！！");
					dig.setVisible(true); 
					
					Login login = new Login();
					login.setVisible(true);
					}
					
					else {
						Dialogs1 dig = new Dialogs1(null,"用户名已经被注册，请更换其他用户名！");
						dig.setVisible(true);
						textField.setText(null);
						passwordField.setText(null);
						passwordField_1.setText(null);
					}
				}
				
				else {
					Dialogs1 dig = new Dialogs1(null,"密码不一致，请重新输入");
					dig.setVisible(true);
					textField.setText(null);
					passwordField.setText(null);
					passwordField_1.setText(null);
				}
				
			}
				
			}//else	
		
		});
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(248, 197, 113, 27);
		contentPane.add(btnNewButton_1);
						
	}
	
	
	public static void Insert_login(String userid,String psd) {
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

		      //STEP 4: Execute a query
		      //System.out.println("Creating table in given database...");
		      stmt = conn.createStatement();

		     
		      String sql = "insert into Login " +
		                   "values ( "+"\'"+userid +"\'"+" , "+"\'"+psd+"\'"+")" ;

		      stmt.executeUpdate(sql);
		      System.out.println("Successful insert table");
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
		
	}
	
	
public boolean Isregiste(String userid) {
		
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
		      
		     
		      String sql = "select Password from Login where Userid = " + "\'"+userid+"\'";
		      //+"AND Useid = "+"\'"+id3+"\'"
				// 执行 SQL语句
				// ResultSet 接收查询返回的结果集的一个接口 result 定义的一个接收返回结果的变量名
		      ResultSet result=null;
			  result = stmt.executeQuery(sql);
				// 将查询返回的结果集进行遍历输出
			  //if(result!=null) {
				  
				  
				  while (result.next()) {
						// t_id 必须跟数据库的 字段名一致 getInt() 这个 是由对应字段的数据类型决定
					  
						//String userid1 =result.getString("Userid");					
						String psd1 =result.getString("Password");
						System.out.println( "Password=" +psd1 );
						return false;
					}
 
				  //return false;				  								 
				  
			 // }
			  
			 // else
			//	  return true;
						  
			 
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
		
		return true;
	}
	
	
	
	
	
}


//弹出对话框
class Dialogs1 extends JDialog{//制作对话框
	 public Dialogs1(JFrame parent,String show){
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




