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
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class Delete_memary extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private JComboBox comboBox_1 ;
	private JComboBox comboBox_2 ;
	
	private String id4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_memary frame = new Delete_memary("zhangsan");
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
	public Delete_memary(String userid) {
		id4 = userid;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("删除消费记录界面");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("按物品类型删除");
		lblNewLabel.setBounds(37, 40, 112, 18);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(178, 37, 75, 24);
		comboBox.addItem("衣服类");
		comboBox.addItem("鞋子类");
		comboBox.addItem("化妆品类");
		comboBox.addItem("饰品类");
		comboBox.addItem("其他");
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("删除");
		btnNewButton.setBounds(305, 36, 113, 27);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String goodstype = comboBox.getSelectedItem().toString();
				deletememary_bygoodstype(goodstype);
			}
		});
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("按时间删除");
		lblNewLabel_1.setBounds(37, 97, 75, 18);
		contentPane.add(lblNewLabel_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(158, 94, 47, 24);
		comboBox_1.addItem("1");
		comboBox_1.addItem("2");
		comboBox_1.addItem("3");
		comboBox_1.addItem("4");
		comboBox_1.addItem("5");
		comboBox_1.addItem("6");
		comboBox_1.addItem("7");
		comboBox_1.addItem("8");
		comboBox_1.addItem("9");
		comboBox_1.addItem("10");
		comboBox_1.addItem("11");
		comboBox_1.addItem("12");
		contentPane.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(219, 94, 47, 24);
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
		comboBox_2.addItem("13");
		comboBox_2.addItem("14");
		comboBox_2.addItem("15");
		comboBox_2.addItem("16");
		comboBox_2.addItem("17");
		comboBox_2.addItem("18");
		comboBox_2.addItem("19");
		comboBox_2.addItem("20");
		comboBox_2.addItem("21");
		comboBox_2.addItem("22");
		comboBox_2.addItem("23");
		comboBox_2.addItem("24");
		comboBox_2.addItem("25");
		comboBox_2.addItem("26");
		comboBox_2.addItem("27");
		comboBox_2.addItem("28");
		comboBox_2.addItem("29");
		comboBox_2.addItem("30");
		comboBox_2.addItem("31");
		contentPane.add(comboBox_2);
		
		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.setBounds(305, 93, 113, 27);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String month= comboBox_1.getSelectedItem().toString();
				String day= comboBox_2.getSelectedItem().toString();
				String shoppingtime=month+"月"+day+"日";
				deletememary_byshoppingtime(shoppingtime);
			}
		});
		
		
		
		JLabel lblNewLabel_2 = new JLabel("按记录编号删除");
		lblNewLabel_2.setBounds(37, 154, 112, 18);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(178, 151, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setDocument(new NumOnlyDocument1());
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.setBounds(305, 150, 113, 27);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String memaryid = textField.getText();
				
				if(memaryid.length()==0) {
					Dialogs dig5 = new Dialogs(null, "编号不能为空！！！");
					dig5.setVisible(true);		
				}
				
				else
					deletememary_bymemaryid(memaryid);
			
			}
		});
		
	}
	
	
    public void deletememary_bygoodstype(String goodstype1) {
		
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
		     
		      String sql = "delete from Shoppingmemary where Goodstype = " + "\'"+goodstype1+"\'"+"AND Userid = "+"\'"+id4+"\'";
		      //+"AND Useid = "+"\'"+id3+"\'"
				// 执行 SQL语句

		      int i = stmt.executeUpdate(sql);
			  //System.out.println(i);
			 
		      if(i!=0) {
				  Dialogs dig = new Dialogs(null,"删除记录成功！！！");
				  dig.setVisible(true);//显示对话框
			  }
				  //System.out.println("删除记录成功！！！");
			  else {
				  Dialogs dig = new Dialogs(null,"无此记录编号，无法删除！！！");
				  dig.setVisible(true);//显示对话框
			  }
			  				  
				  //System.out.println("无此记录编号，无法删除！！！");
			 				
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
		
		
	}
    
    
    public void deletememary_byshoppingtime(String shoppingtime1) {
		
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
		     
		      String sql = "delete from Shoppingmemary where Shoppingtime = " + "\'"+shoppingtime1+"\'"+"AND Userid = "+"\'"+id4+"\'";
		      //+"AND Useid = "+"\'"+id3+"\'"
				// 执行 SQL语句

		      int i = stmt.executeUpdate(sql);
			  //System.out.println(i);
			  if(i!=0) {
				  Dialogs dig = new Dialogs(null,"删除记录成功！！！");
				  dig.setVisible(true);//显示对话框
			  }
				  //System.out.println("删除记录成功！！！");
			  else {
				  Dialogs dig = new Dialogs(null,"无此记录编号，无法删除！！！");
				  dig.setVisible(true);//显示对话框
			  }				  
				  //System.out.println("无此记录编号，无法删除！！！");
			 				
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
    
public void deletememary_bymemaryid(String memaryid1) {
		
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
		     
		      String sql = "delete from Shoppingmemary where Userid = "+"\'"+id4+"\'"+"AND Memaryid = "+memaryid1;
		      //+"AND Useid = "+"\'"+id3+"\'"
				// 执行 SQL语句

			  int i = stmt.executeUpdate(sql);
			  //System.out.println(i);
			  if(i!=0) {
				  Dialogs dig = new Dialogs(null,"删除记录成功！！！");
				  dig.setVisible(true);//显示对话框
			  }
				  //System.out.println("删除记录成功！！！");
			  else {
				  Dialogs dig = new Dialogs(null,"无此记录编号，无法删除！！！");
				  dig.setVisible(true);//显示对话框
			  }				  
				  //System.out.println("无此记录编号，无法删除！！！");
			       
			 				
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

	
}


class Dialogs extends JDialog{//制作对话框
	 public Dialogs(JFrame parent,String show){
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



class NumOnlyDocument1 extends PlainDocument{
	  public void insertString(int offset, String s, AttributeSet attrSet)throws BadLocationException {
	   try {Integer.parseInt(s);
	   }catch(NumberFormatException ex){
	    return;
	   }
	   super.insertString(offset,s,attrSet);
	  }
	 }


