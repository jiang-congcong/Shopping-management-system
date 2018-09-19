package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Selectmemary_bycondition extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2; 
	private JComboBox comboBox_3; 
	private String id3;
	
	
	private String resultmemary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Selectmemary_bycondition frame = new Selectmemary_bycondition("zhangsan");
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
	public Selectmemary_bycondition(String userid) {
		id3 = userid;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 298);
		setTitle("查询消费记录界面");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("按物品类型查找");
		lblNewLabel.setBounds(14, 36, 113, 18);
		contentPane.add(lblNewLabel);
		
	    comboBox = new JComboBox();
		comboBox.setBounds(165, 33, 78, 24);
		comboBox.addItem("衣服类");
		comboBox.addItem("鞋子类");
		comboBox.addItem("化妆品类");
		comboBox.addItem("饰品类");
		comboBox.addItem("其他");
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("查找");
		btnNewButton.setBounds(305, 32, 113, 27);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String goodstype = comboBox.getSelectedItem().toString();
				String getresult = selectmemary_bygoodstype(goodstype);
				Selectmemary selectmemary = new Selectmemary(getresult);
				selectmemary.setVisible(true);
				
			}
		});
		
		
		
		JLabel lblNewLabel_1 = new JLabel("按购买方式查找");
		lblNewLabel_1.setBounds(14, 108, 113, 18);
		contentPane.add(lblNewLabel_1);
		
				
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(165, 105, 78, 24);
		comboBox_1.addItem("网购");
		comboBox_1.addItem("线下门店");
		contentPane.add(comboBox_1);
		
		JButton btnNewButton_1 = new JButton("查找");
		btnNewButton_1.setBounds(305, 104, 113, 27);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String shoppingtype = comboBox_1.getSelectedItem().toString();
				String getresult = selectmemary_byshoppingtype(shoppingtype);
				Selectmemary selectmemary = new Selectmemary(getresult);
				selectmemary.setVisible(true);
			}
		});
		
		
		
		JLabel lblNewLabel_2 = new JLabel("按购买时间查找");
		lblNewLabel_2.setBounds(14, 180, 113, 18);
		contentPane.add(lblNewLabel_2);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(165, 177, 48, 24);
		comboBox_2.addItem("1");
		comboBox_2.addItem("2");
		comboBox_2.addItem("3");
		comboBox_2.addItem("4");
		comboBox_2.addItem("5");
		comboBox_2.addItem("6");
		comboBox_2.addItem("7");
		comboBox_2.addItem("8");
		comboBox_2.addItem("9");
		comboBox_2.addItem("10");
		comboBox_2.addItem("11");
		comboBox_2.addItem("12");
		contentPane.add(comboBox_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(227, 177, 48, 24);
		comboBox_3.addItem("1");
		comboBox_3.addItem("2");
		comboBox_3.addItem("3");
		comboBox_3.addItem("4");
		comboBox_3.addItem("5");
		comboBox_3.addItem("6");
		comboBox_3.addItem("7");
		comboBox_3.addItem("8");
		comboBox_3.addItem("9");
		comboBox_3.addItem("10");
		comboBox_3.addItem("11");
		comboBox_3.addItem("12");
		comboBox_3.addItem("13");
		comboBox_3.addItem("14");
		comboBox_3.addItem("15");
		comboBox_3.addItem("16");
		comboBox_3.addItem("17");
		comboBox_3.addItem("18");
		comboBox_3.addItem("19");
		comboBox_3.addItem("20");
		comboBox_3.addItem("21");
		comboBox_3.addItem("22");
		comboBox_3.addItem("23");
		comboBox_3.addItem("24");
		comboBox_3.addItem("25");
		comboBox_3.addItem("26");
		comboBox_3.addItem("27");
		comboBox_3.addItem("28");
		comboBox_3.addItem("29");
		comboBox_3.addItem("30");
		comboBox_3.addItem("31");
		contentPane.add(comboBox_3);
		
		JButton btnNewButton_2 = new JButton("查找");
		btnNewButton_2.setBounds(305, 176, 113, 27);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String shoppingtime = comboBox_2.getSelectedItem().toString()+"月"+comboBox_3.getSelectedItem().toString()+"日";
				String getresult = selectmemary_byshoppingtime(shoppingtime);
				Selectmemary selectmemary = new Selectmemary(getresult);
				selectmemary.setVisible(true);
			}
		});
		
	}
	
	
    public String selectmemary_bygoodstype(String goodstype) {
		
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
		      System.out.println(goodstype);
		     
		      String sql = "select * from Shoppingmemary where Goodstype = " + "\'"+goodstype+"\'"+"AND Userid = "+"\'"+id3+"\'";
		      //+"AND Useid = "+"\'"+id3+"\'"
				// 执行 SQL语句
				// ResultSet 接收查询返回的结果集的一个接口 result 定义的一个接收返回结果的变量名
		      ResultSet result=null;
			  result = stmt.executeQuery(sql);
				// 将查询返回的结果集进行遍历输出
			  //boolean flag=false; 
			  resultmemary="";
			  while (result.next()) {
					// t_id 必须跟数据库的 字段名一致 getInt() 这个 是由对应字段的数据类型决定
				  
					String userid ="用户id:"+ result.getString("Userid");
					
					int memaryid = result.getInt("Memaryid");
					String memaryid1="  消费id:"+ String.valueOf(memaryid);
					
					String goodstype1 ="  物品类型:"+ result.getString("Goodstype");
					
					int goodsprice = result.getInt("Goodsprice");
					String goodsprice1="  物品价格:"+ String.valueOf(goodsprice);
					
					String shoppingtype ="  购物类型:" +result.getString("Shoppingtype");
					
					String shoppingtime ="  购物时间:"+ result.getString("Shoppingtime");
					//System.out.println("id=" + id + "\t" + "name=" + name);
					resultmemary=resultmemary+userid+memaryid1+goodstype1+goodsprice1+shoppingtype+shoppingtime+"\n";
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
		
		return resultmemary;
	}
	
	
    public String selectmemary_byshoppingtype(String shoppingtype1) {
		
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
		     
		      String sql = "select * from Shoppingmemary where Shoppingtype = " + "\'"+shoppingtype1+"\'"+"AND Userid = "+"\'"+id3+"\'";
		      //+"AND Useid = "+"\'"+id3+"\'"
				// 执行 SQL语句
				// ResultSet 接收查询返回的结果集的一个接口 result 定义的一个接收返回结果的变量名
		      ResultSet result=null;
			  result = stmt.executeQuery(sql);
				// 将查询返回的结果集进行遍历输出
			  //boolean flag=false; 
			  resultmemary="";
			  while (result.next()) {
					// t_id 必须跟数据库的 字段名一致 getInt() 这个 是由对应字段的数据类型决定
				  
					String userid ="用户id:"+ result.getString("Userid");
					
					int memaryid = result.getInt("Memaryid");
					String memaryid1="  消费id:"+ String.valueOf(memaryid);
					
					String goodstype1 ="  物品类型:"+ result.getString("Goodstype");
					
					int goodsprice = result.getInt("Goodsprice");
					String goodsprice1="  物品价格:"+ String.valueOf(goodsprice);
					
					String shoppingtype ="  购物类型:" +result.getString("Shoppingtype");
					
					String shoppingtime ="  购物时间:"+ result.getString("Shoppingtime");
					//System.out.println("id=" + id + "\t" + "name=" + name);
					resultmemary=resultmemary+userid+memaryid1+goodstype1+goodsprice1+shoppingtype+shoppingtime+"\n";
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
		
		return resultmemary;
	}
	
	
public String selectmemary_byshoppingtime(String shoppingtime1) {
		
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
		      //System.out.println(goodstype);
		     
		      String sql = "select * from Shoppingmemary where Shoppingtime = " + "\'"+shoppingtime1+"\'"+"AND Userid = "+"\'"+id3+"\'";
		      //+"AND Useid = "+"\'"+id3+"\'"
				// 执行 SQL语句
				// ResultSet 接收查询返回的结果集的一个接口 result 定义的一个接收返回结果的变量名
		      ResultSet result=null;
			  result = stmt.executeQuery(sql);
				// 将查询返回的结果集进行遍历输出
			  //boolean flag=false; 
			  resultmemary="";
			  while (result.next()) {
					// t_id 必须跟数据库的 字段名一致 getInt() 这个 是由对应字段的数据类型决定
				  
					String userid ="用户id:"+ result.getString("Userid");
					
					int memaryid = result.getInt("Memaryid");
					String memaryid1="  消费id:"+ String.valueOf(memaryid);
					
					String goodstype1 ="  物品类型:"+ result.getString("Goodstype");
					
					int goodsprice = result.getInt("Goodsprice");
					String goodsprice1="  物品价格:"+ String.valueOf(goodsprice);
					
					String shoppingtype ="  购物类型:" +result.getString("Shoppingtype");
					
					String shoppingtime ="  购物时间:"+ result.getString("Shoppingtime");
					//System.out.println("id=" + id + "\t" + "name=" + name);
					resultmemary=resultmemary+userid+memaryid1+goodstype1+goodsprice1+shoppingtype+shoppingtime+"\n";
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
		
		return resultmemary;
	}
	
	
	
	
	
	
}
