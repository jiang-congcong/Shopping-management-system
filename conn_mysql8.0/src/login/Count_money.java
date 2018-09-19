package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextPane;
import javax.swing.JTextField;

public class Count_money extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	private int resultmemary;
	private String id7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Count_money frame = new Count_money("zhangsan");
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
	public Count_money(String userid) {
		id7 = userid;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("消费金额清算界面");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("各类消费金额统计");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel.setBounds(143, 13, 141, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("衣服类：");
		lblNewLabel_1.setBounds(14, 59, 60, 18);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(88, 56, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		int clothes = countmoney_bygoodstype("衣服类");
		String clothes1 = String.valueOf(clothes);
		textField.setText(clothes1);
		
		
		JLabel lblNewLabel_2 = new JLabel("鞋子类：");
		lblNewLabel_2.setBounds(212, 59, 60, 18);
		contentPane.add(lblNewLabel_2);
			
		textField_1 = new JTextField();
		textField_1.setBounds(277, 56, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		int shoes = countmoney_bygoodstype("鞋子类");
		String shoes1 = String.valueOf(shoes);
		textField_1.setText(shoes1);
		
		JLabel lblNewLabel_3 = new JLabel("化妆品类:");
		lblNewLabel_3.setBounds(14, 128, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(88, 125, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		int cosmetics = countmoney_bygoodstype("化妆品类");
		String cosmetics1 = String.valueOf(cosmetics);
		textField_2.setText(cosmetics1);
		
		
		JLabel lblNewLabel_4 = new JLabel("饰品类：");
		lblNewLabel_4.setBounds(212, 128, 60, 18);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(277, 125, 86, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		int ornament = countmoney_bygoodstype("饰品类");
		String ornament1 = String.valueOf(ornament);
		textField_3.setText(ornament1);
		
		
		JLabel lblNewLabel_5 = new JLabel("其他：");
		lblNewLabel_5.setBounds(14, 185, 72, 18);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(88, 182, 86, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		int other = countmoney_bygoodstype("其他");
		String other1 = String.valueOf(other);
		textField_4.setText(other1);
		
		
		JLabel lblNewLabel_6 = new JLabel("总计：");
		lblNewLabel_6.setBounds(212, 185, 72, 18);
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(277, 182, 86, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		int all = clothes + shoes + cosmetics + ornament + other;
		String all1 = String.valueOf(all);
		textField_5.setText(all1);
	}
	
	
  public int countmoney_bygoodstype(String goodstype1) {
		
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
		     
		     
		      String sql = "select Goodsprice from Shoppingmemary where Goodstype = " + "\'"+goodstype1+"\'"+"and Userid = "+"\'"+id7+"\'";          ;
		      //+"AND Useid = "+"\'"+id3+"\'"
				// 执行 SQL语句
				// ResultSet 接收查询返回的结果集的一个接口 result 定义的一个接收返回结果的变量名
		      ResultSet result=null;
			  result = stmt.executeQuery(sql);
				// 将查询返回的结果集进行遍历输出
			  resultmemary=0;
			  while (result.next()) {
					// t_id 必须跟数据库的 字段名一致 getInt() 这个 是由对应字段的数据类型决定
				  
										
					int goodsprice = result.getInt("Goodsprice");					
					resultmemary=resultmemary+goodsprice;
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
	
	public void Show(String useridd) {
		Count_money count = new Count_money(useridd);
		count.setVisible(true);
		
	} 
	
}
