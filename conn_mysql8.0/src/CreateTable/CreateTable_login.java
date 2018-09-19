package CreateTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable_login {
	
	public static void CreateTable_Login() {
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
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(url, username, password);
		      System.out.println("Connected database successfully...");

		      //STEP 4: Execute a query
		      System.out.println("Creating table in given database...");
		      stmt = conn.createStatement();

		      String sql = "CREATE TABLE Login " +
		    		  "(Userid VARCHAR(255) not NULL, " +
	                   " Password VARCHAR(255), " + 	                    
	                   " PRIMARY KEY ( Userid ))"; 

		      stmt.executeUpdate(sql);
		      System.out.println("Successful created table in given database...");
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
	
	
	public static void Insert_Login() {
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

		      String sql = "INSERT INTO Login " +
	                   "VALUES ('zhangsan', '123456')"; 

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
	
	
	public static void CreateTable_shoppingmemary() {
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
              
		     /* 
		      String sql = "CREATE TABLE Shoppingmemary " +
		    		  "(Memaryid INTEGER not NULL PRIMARY KEY AUTO_INCREMENT, " +	
		    		   " Userid VARCHAR(255) not NULL , " +
	                   //" Memaryid INTEGER not NULL PRIMARY KEY AUTO_INCREMENT, " +
	                   " Goodstype VARCHAR(255) , " +
	                   " Goodsprice INTEGER , " +
	                   " Shoppingtype VARCHAR(255) , " +
	                   " Shoppingtime VARCHAR(255) " +
	                   //" PRIMARY KEY (Userid,Memaryid) , " +
	                   ")"; 
	                   */
		      
		      String sql = "CREATE TABLE Shoppingmemary " +
		    		  "(Memaryid INTEGER not NULL PRIMARY KEY AUTO_INCREMENT, " +	
		    		   " Userid VARCHAR(255) not NULL , " +
	                   //" Memaryid INTEGER not NULL PRIMARY KEY AUTO_INCREMENT, " +
	                   " Goodstype VARCHAR(255) , " +
	                   " Goodsprice INTEGER , " +
	                   " Shoppingtype VARCHAR(255) , " +
	                   " Shoppingtime VARCHAR(255) , " +
	                   " foreign key(Userid) references Login(Userid)  " +
	                   ")"; 
		      
		      System.out.println(sql);
		      
		      stmt.executeUpdate(sql);
		      System.out.println("Successful created table in given database...");
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
	
	
	public static void Insert_shoppingmemary() {
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

		      String sql = "INSERT INTO Shoppingmemary " +
	                   "VALUES (1,'zhangsan','衣服类',300 ,'网购','5月6日')"; 

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
	
	
	public static void Drop_table(String tablename) {
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

		      String sql = "DROP TABLE "+tablename; 
	                    

		      stmt.executeUpdate(sql);
		      System.out.println("Successful drop table");
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
	
	
	public static void CreateTable_userInformation() {
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
		      stmt = conn.createStatement();
             
		     /* 
		      String sql = "CREATE TABLE Shoppingmemary " +
		    		  "(Memaryid INTEGER not NULL PRIMARY KEY AUTO_INCREMENT, " +	
		    		   " Userid VARCHAR(255) not NULL , " +
	                   //" Memaryid INTEGER not NULL PRIMARY KEY AUTO_INCREMENT, " +
	                   " Goodstype VARCHAR(255) , " +
	                   " Goodsprice INTEGER , " +
	                   " Shoppingtype VARCHAR(255) , " +
	                   " Shoppingtime VARCHAR(255) , " +
	                   " foreign key(Userid) references Login(Userid)  " +
	                   ")"; 
	                   */
		      
		      String sql = "CREATE TABLE UserInformation " +
		    		  "(Username varchar(50) not null , " +	
		    		   " Userid VARCHAR(255) not NULL primary key, " +
	                   " Sex varchar(2) , " +
	                   " Birthday varchar(20) , " +
	                   " Tel varchar(50) , " +
	                   " Email varchar(50) , " +
	                   " foreign key(Userid) references Login(Userid)  " +
	                   ")"; 
		      
		      System.out.println(sql);
		      
		      stmt.executeUpdate(sql);
		      System.out.println("Successful created table in given database...");
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
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		//CreateTable_Login();
		//Insert_Login();
		//CreateTable_shoppingmemary();
		//Drop_table("Shoppingmemary");
		//Insert_shoppingmemary();
		CreateTable_userInformation();
		//Drop_table("Userinformation");
		
	}


}
