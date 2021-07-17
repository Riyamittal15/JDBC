package com.session.registration;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

	String dbDriver = "com.mysql.cj.jdbc.Driver";
    String dbURL = "jdbc:mysql://localhost:3306/userdb";
    
    String dbUsername = "root";
    String dbPassword = "Riya@1511";
   
  //String Insert_User_Sql="INSERT INTO member (fname,email,phone,password) VALUES (?,?,?,?);";
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
	
	
	public String insert(Member member)
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Data  not entered";
		String sql = "insert into member values(?,?,?,?)";
		
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, member.getFname());
		ps.setString(2, member.getEmail());
		ps.setString(3, member.getPhone());
		ps.setString(4, member.getPassword());
		ps.executeUpdate();
		result="Data successfull";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		}
		return result;
	}
}
