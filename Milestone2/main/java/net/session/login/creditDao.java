package net.session.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class creditDao {
	String dbDriver = "com.mysql.cj.jdbc.Driver";
    String dbURL = "jdbc:mysql://localhost:3306/userdb";
    
    String dbUsername = "root";
    String dbPassword = "Riya@1511";
   
  	public void loadDriver(String dbDriver)
  	{
  		try {
  			Class.forName(dbDriver);
  		}catch(ClassNotFoundException e) {
  			e.printStackTrace();
  		}
  	}
  	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
  	public boolean update(creditBean memberbean)
  	{
  		loadDriver(dbDriver);
  		Connection con=getConnection();
  		
  		boolean status=false;
  		
  		String sql="Select balance from member WHERE fname=?";
  		//String s2="UPDATE member SET balance=" +memberbean.getCamt()+"WHERE fname=?";
  		//double ba;
  		PreparedStatement ps;
  		try {
  			ps=con.prepareStatement(sql);
  			//ps.setDouble(1,memberbean.getCamt());
  			ps.setString(1,  memberbean.getUser());
  			ResultSet rs=ps.executeQuery();
  			status=rs.next();
  			double ba=rs.getDouble(1);
  			ba=ba+memberbean.getCamt();
  			System.out.println(ba);
  			
  			PreparedStatement update = con.prepareStatement
  	  			    ("UPDATE member SET balance = ? WHERE fname = ?");

  	  			update.setDouble(1, ba);
  	  			update.setString(2,  memberbean.getUser());

  	  			update.executeUpdate();
  	  			System.out.println("Success");
  	  		
  		}catch(SQLException e) {
  			e.printStackTrace();
  		}
  		
  		return status;
  	}
  	
}
