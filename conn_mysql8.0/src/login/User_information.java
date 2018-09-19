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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;

public class User_information extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JComboBox comboBox_1 ;
	private JComboBox comboBox_2 ;
	
	private String id9;
	private boolean flag2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_information frame = new User_information("zhangsan",true);
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
	public User_information(String userid,boolean flagg) {
		id9 = userid;
		flag2 = flagg;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("编辑信息界面");
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(30, 28, 72, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(80, 25, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("性别");
		lblNewLabel_1.setBounds(30, 81, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(80, 78, 49, 24);
		contentPane.add(comboBox);
		comboBox.addItem("男");
		comboBox.addItem("女");
		
		
		JLabel lblNewLabel_2 = new JLabel("出生年月");
		lblNewLabel_2.setBounds(30, 140, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(103, 137, 63, 24);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("1949");
		comboBox_1.addItem("1950");
		comboBox_1.addItem("1951");
		comboBox_1.addItem("1952");
		comboBox_1.addItem("1953");
		comboBox_1.addItem("1954");
		comboBox_1.addItem("1955");
		comboBox_1.addItem("1956");
		comboBox_1.addItem("1957");
		comboBox_1.addItem("1958");
		comboBox_1.addItem("1959");
		comboBox_1.addItem("1960");
		comboBox_1.addItem("1961");
		comboBox_1.addItem("1962");
		comboBox_1.addItem("1963");
		comboBox_1.addItem("1964");
		comboBox_1.addItem("1965");
		comboBox_1.addItem("1966");
		comboBox_1.addItem("1967");
		comboBox_1.addItem("1968");
		comboBox_1.addItem("1969");
		comboBox_1.addItem("1970");
		comboBox_1.addItem("1971");
		comboBox_1.addItem("1972");
		comboBox_1.addItem("1973");
		comboBox_1.addItem("1974");
		comboBox_1.addItem("1975");
		comboBox_1.addItem("1976");
		comboBox_1.addItem("1977");
		comboBox_1.addItem("1978");
		comboBox_1.addItem("1979");
		comboBox_1.addItem("1980");
		comboBox_1.addItem("1981");
		comboBox_1.addItem("1982");
		comboBox_1.addItem("1983");
		comboBox_1.addItem("1984");
		comboBox_1.addItem("1985");
		comboBox_1.addItem("1986");
		comboBox_1.addItem("1987");
		comboBox_1.addItem("1988");
		comboBox_1.addItem("1989");
		comboBox_1.addItem("1990");
		comboBox_1.addItem("1991");
		comboBox_1.addItem("1992");
		comboBox_1.addItem("1993");
		comboBox_1.addItem("1994");
		comboBox_1.addItem("1995");
		comboBox_1.addItem("1996");
		comboBox_1.addItem("1997");
		comboBox_1.addItem("1998");
		comboBox_1.addItem("1999");
		comboBox_1.addItem("2000");
		comboBox_1.addItem("2001");
		comboBox_1.addItem("2002");
		comboBox_1.addItem("2003");
		comboBox_1.addItem("2004");
		comboBox_1.addItem("2005");
		comboBox_1.addItem("2006");
		comboBox_1.addItem("2007");
		comboBox_1.addItem("2008");
		comboBox_1.addItem("2009");
		comboBox_1.addItem("2010");
		comboBox_1.addItem("2011");
		comboBox_1.addItem("2012");
		comboBox_1.addItem("2013");
		comboBox_1.addItem("2014");
		comboBox_1.addItem("2015");
		comboBox_1.addItem("2016");
		comboBox_1.addItem("2017");
		comboBox_1.addItem("2018");
	
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(179, 137, 49, 24);
		contentPane.add(comboBox_2);
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
		
		
		
		JLabel lblNewLabel_3 = new JLabel("手机号");
		lblNewLabel_3.setBounds(226, 28, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(293, 25, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		//textField_1.setDocument(new NumOnlyDocument7());
		if(!flag2) {
			textField_1.setDocument(new NumOnlyDocument7());
		}
		
		
		JLabel lblNewLabel_4 = new JLabel("邮箱");
		lblNewLabel_4.setBounds(226, 81, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(293, 78, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBounds(91, 197, 86, 27);
		contentPane.add(btnNewButton);
		
		
		final boolean flag = setInformation(id9);
		
		//textField_1.setDocument(new NumOnlyDocument7());
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//setInformation(id9);
				
				String name = textField.getText();
				String sex = comboBox.getSelectedItem().toString();
				String birth1 = comboBox_1.getSelectedItem().toString();
				String birth2 = comboBox_2.getSelectedItem().toString();
				String birth = birth1 + "年" + birth2+"日";
				String tel = textField_1.getText();
				String email = textField_2.getText();
				
				boolean mid = Isnum(tel);
				
				if(name.length()==0||tel.length()==0||email.length()==0||mid==false) {
					System.out.println("所填信息不能为空,或者手机号不为纯数字！！！");
					Dialogs12 dig = new Dialogs12(null,"所填信息不能为空,或者手机号不为纯数字！！！");
					dig.setVisible(true);
				}
				else {
					
					int checktel = checkTel(tel);
					if(checktel==1)
						System.out.println("手机号位数不对");
					else if(checktel==3)
						System.out.println("手机号开头不符合事实！！！");
					else
						System.out.println("手机号正确！！！");
					
					
					int checkemail = checkEmail(email);
					if(checkemail == 2)
						System.out.println("邮箱格式不对！！！");
					else
						System.out.println("邮箱正确！！！");
					
					if(checktel==0&&checkemail==0) {
						//String userid = "zhangsan";
						if(flag== false) {
						    Insert_information(id9, name, sex, birth, tel, email);
						}
						else
							Updateinformation(id9, name, sex, birth, tel, email);
						
					}
									
				}
				
				
				
				
			}
		});
		
		
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(260, 197, 86, 27);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setInformation(id9);
			}
		});
		
		
		
	}
	
	
	public int checkTel(String tel) {
		
		if(tel.length()!=11)
			return 1;//手机号长度不对
		else {
		
		    String head = tel.substring(0, 3); 
		    String str[]= {"139","138","137","136","135","134","159","158","157","150","151","152","188","187","130","131","132","155","156","133","153","189"};
				
		    for(int i=0;i<str.length;i++) {
			     if(head.equals(str[i]))
			    	 return 0 ;//手机号正确			     
		    }
		
		}
		
		return 3; //手机号开头不符合事实
	}
	
	
	public int checkEmail (String email) {
		
		if(email.length()==0) {
			return 1; //输入为空
		}
		
		else {
			 //boolean tag = true; 
		        final String pattern1 = "^([a-zA-Z0-9] *[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
		        //"^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$"
		        final Pattern pattern = Pattern.compile(pattern1); 
		        final Matcher mat = pattern.matcher(email); 
		        if (!mat.find()) { 
		            //tag = false; 
		        	return 2;//邮箱格式不对
		        } 
			
		}
		
		
		return 0;//邮箱格式正确
	} 
	
	
	
	public void Insert_information(String userid,String name,String sex,String birth,String tel,String email) {
		String userid1="\'"+userid+"\'";
		String name1 = "\'"+name+"\'";
		String sex1 = "\'"+sex+"\'";
		String birth1 = "\'"+birth + "\'";
		String tel1 = "\'"+tel+"\'";
		String email1 = "\'"+email+"\'";
		
		
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
              //System.out.println(userid);
		      //String sql = "INSERT INTO Shoppingmemary (Userid,Goodstype,Goodsprice,Shoppingtype,Shoppingtime) " +
	                   //"VALUES (userid,1, goodstype,goodsprice,shoppingtype,shoppingtime)"; 
		      String sql = "INSERT INTO  UserInformation " +
	                   "VALUES ("+name1+","+userid1+","+ sex1+","+birth1+","+tel1+","+email1+")";
		      System.out.println(sql);
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
	
	
public boolean setInformation(String userid) {
		
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
				 String name  = result.getString("Username");
				 String tel = result.getString("Tel");
				 String email = result.getString("Email");
				 textField.setText(name);
				 //System.out.println("111111111111");
			     //long tel1 = Long.parseLong(tel);
				 textField_1.setText(tel);
				 //System.out.println("222222222222");
				 textField_2.setText(email);
				 //System.out.println("333333333");
				 //#####################
				 //textField_1.setDocument(new NumOnlyDocument7());
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
	
	
public void Updateinformation(String userid,String name,String sex,String birth,String tel,String email) {
	
	String userid1="\'"+userid+"\'";
	String name1 = "\'"+name+"\'";
	String sex1 = "\'"+sex+"\'";
	String birth1 = "\'"+birth + "\'";
	String tel1 = "\'"+tel+"\'";
	String email1 = "\'"+email+"\'";
	
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
	      
          String sql = "update Userinformation set Userid = "+userid1+","+"Username = "+name1+","+"Sex = "+sex1+","+ "Birthday= "+birth1+","+"Tel = "+tel1+","+"Email = "+email1+" where Userid = "+userid1;                    
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


//判断输入字符串是否为纯数字
public boolean Isnum(String str) {
	boolean flag = str.matches("[0-9]+");	
	return flag;
}


	
}



class NumOnlyDocument7 extends PlainDocument{
	  public void insertString(int offset, String s, AttributeSet attrSet)throws BadLocationException {
	   try {Integer.parseInt(s);
	   }catch(NumberFormatException ex){
	    return;
	   }
	   super.insertString(offset,s,attrSet);
	  }
	 }


//弹出对话框
class Dialogs12 extends JDialog{//制作对话框
	 public Dialogs12(JFrame parent,String show){
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
	 setSize(300,125);
	 }
	}


