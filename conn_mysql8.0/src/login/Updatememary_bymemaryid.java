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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JLabel;

public class Updatememary_bymemaryid extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	
	private String resultmemary;
	private String memaryiidd;
	private String id6;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updatememary_bymemaryid frame = new Updatememary_bymemaryid("zhangsan","1");
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
	public Updatememary_bymemaryid(String userid,String memaryid) {
		id6 = userid;
		memaryiidd=memaryid;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("修改消费记录界面");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("物品类型");
		lblNewLabel.setBounds(14, 26, 72, 18);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(82, 23, 72, 24);
		comboBox.addItem("衣服类");
		comboBox.addItem("鞋子类");
		comboBox.addItem("化妆品类");
		comboBox.addItem("饰品类");
		comboBox.addItem("其他");
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("价格");
		lblNewLabel_1.setBounds(228, 26, 49, 18);
		contentPane.add(lblNewLabel_1);

		
		textField = new JTextField();
		textField.setBounds(276, 23, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setDocument(new NumOnlyDocument2());
		
		JLabel lblNewLabel_2 = new JLabel("购买方式");
		lblNewLabel_2.setBounds(14, 82, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(82, 79, 72, 24);
		comboBox_1.addItem("网购");
		comboBox_1.addItem("线下门店");
		contentPane.add(comboBox_1);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("购买时间");
		lblNewLabel_3.setBounds(212, 82, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(287, 79, 54, 24);
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
		comboBox_3.setBounds(355, 79, 49, 24);
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
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBounds(60, 160, 113, 27);
		contentPane.add(btnNewButton);
		
		String getprice= updatememary_byid(memaryiidd);
		textField.setText(getprice);//将原来的记录放入界面，只放入了price
		
		btnNewButton.addActionListener(new ActionListener() {
			
			//String getprice= updatememary_byid(memaryiidd);
			//textField.setText(getprice);//将原来的记录放入界面，只放入了price
			@Override
			public void actionPerformed(ActionEvent e) {
				String getprice= updatememary_byid(memaryiidd);
				String getnew = textField.getText();
				textField.setText(getnew);
				if(getprice!=null) {
					//textField.setText(getprice);
					System.out.println(getprice);
					String goodstype= comboBox.getSelectedItem().toString();
					//System.out.println(goodstype);
					
					String price1=textField.getText();				
					//int price=Integer.parseInt(price1);
					//System.out.println(price);
					
					String shoppingtype= comboBox_1.getSelectedItem().toString();
					//System.out.println(shoppingtype);
					
					String month= comboBox_2.getSelectedItem().toString();
					String day= comboBox_3.getSelectedItem().toString();
					String shoppingtime=month+"月"+day+"日";
					//System.out.println(shoppingtime);
					
					if(price1.length()==0) {
						Dialogs3 dig3 = new Dialogs3(null, "价格不能为空！！！");
						dig3.setVisible(true);
					}
					
					else {				
					Updatememary(memaryiidd,goodstype, price1, shoppingtype, shoppingtime);					
					Dialogs3 dig3 = new Dialogs3(null, "修改成功！！！");
					dig3.setVisible(true);
					}
					
				}
							
				
				
				
			}
		});
		
		
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(228, 160, 113, 27);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				textField.setText(null);
				
			}
		});					
		
	}

  
    public String updatememary_byid(String memary_id) {
		
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
		      String sql1 = "select Goodsprice from Shoppingmemary where Userid = "+"\'"+id6+"\'"+" and Memaryid = "+memary_id;
		      //+"AND Userid = "+"\'"+id3+"\'"
				// 执行 SQL语句
				// ResultSet 接收查询返回的结果集的一个接口 result 定义的一个接收返回结果的变量名
		      ResultSet result=null;
			  result = stmt.executeQuery(sql1);
				// 将查询返回的结果集进行遍历输出
			  //boolean flag=false;
			  if(result.next()) {
				  int goodsprice = result.getInt("Goodsprice");
				  String goodsprice1=String.valueOf(goodsprice);
				  return goodsprice1;
			  }
			  else {
				  System.out.println("无此记录");
				  return null;
			  }
				  //System.out.println("无此记录");
			  
			  
			  
			 				
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
		return null;
				
	}

	
    public void Updatememary(String memaryid,String goodstype,String goodsprice,String shoppingtype,String shoppingtime) {
		
		String goodstype1 = "\'"+goodstype+"\'";
		String shoppingtype1 = "\'"+shoppingtype+"\'";
		String shoppingtime1 = "\'"+shoppingtime+"\'";
		
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
		      
              String sql = "update Shoppingmemary set Goodstype = "+goodstype1+","+"Shoppingtype = "+shoppingtype1+","+"Shoppingtime = "+shoppingtime1+","+ "Goodsprice= "+goodsprice+" where Memaryid = "+memaryid;                    
              System.out.println(sql);
              
		      stmt.executeUpdate(sql);
		      System.out.println("Successful Update table");
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


//弹出对话框
class Dialogs3 extends JDialog{//制作对话框
	 public Dialogs3(JFrame parent,String show){
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

class NumOnlyDocument2 extends PlainDocument{
	  public void insertString(int offset, String s, AttributeSet attrSet)throws BadLocationException {
	   try {Integer.parseInt(s);
	   }catch(NumberFormatException ex){
	    return;
	   }
	   super.insertString(offset,s,attrSet);
	  }
	 }

