package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {

	public static void main(String[] args) {
		System.out.println(DbConnection.getDb());
		
		
		
	}

	public static Connection getDb() {
		Connection conn=null;
		String URL="jdbc:mysql://localhost:3306/full_stack01";
		String USER="root";
		String password="1234";
		
		String SQL_create_table01="create table if not exists customerData("
				+"id INT AUTO_INCREMENT PRIMARY KEY not null, "
				+ "customer_id VARCHAR(100),"
				+ "customer_name VARCHAR(100),"
				+ "account VARCHAR(100),"
				+ "password VARCHAR(100),"
				+ "address VARCHAR(100),"
				+ "mail_address VARCHAR(100),"
				+ "telephone VARCHAR(100),"
				+ "vip VARCHAR(100))";
				
		String SQL_create_table02="create table if not exists memberData("
				+"id INT AUTO_INCREMENT PRIMARY KEY not null, "
				+ "member_id VARCHAR(100),"
				+ "position VARCHAR(100),"
				+ "member_name VARCHAR(100),"
				+ "account VARCHAR(100),"
				+ "password VARCHAR(100),"
				+ "address VARCHAR(100),"
				+ "mail_address VARCHAR(100),"
				+ "telephone VARCHAR(100))";
		
		String SQL_create_table03="create table if not exists positionData("
				+"id INT AUTO_INCREMENT PRIMARY KEY not null, "
				+ "position_code VARCHAR(100),"
				+ "position_name VARCHAR(100),"
				+ "createPositionTime VARCHAR(100))";
		
		String SQL_create_table04="create table if not exists ProductData("
				+"id INT AUTO_INCREMENT PRIMARY KEY not null, "
				+ "product_id VARCHAR(100),"
				+ "product_type VARCHAR(100),"
				+ "product_name VARCHAR(100),"
				+ "price INT,"
				+ "addProductDateTime VARCHAR(100))";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(URL,USER,password);
			
			PreparedStatement ps1=conn.prepareStatement(SQL_create_table01);
			PreparedStatement ps2=conn.prepareStatement(SQL_create_table02);
			PreparedStatement ps3=conn.prepareStatement(SQL_create_table03);
			PreparedStatement ps4=conn.prepareStatement(SQL_create_table04);

			ps1.executeUpdate();
			ps2.executeUpdate();
			ps3.executeUpdate();
			ps4.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

}



/*
	String SQL_create_table01="create table if not exists customerData("
				+"id INT AUTO_INCREMENT PRIMARY KEY not null, "
				+ "customer_id VARCHAR(100),"
				+ "customer_name VARCHAR(100),"
				+ "account VARCHAR(100),"
				+ "password VARCHAR(100),"
				+ "address VARCHAR(100),"
				+ "mail_address VARCHAR(100),"
				+ "telephone VARCHAR(100),"
				+ "vip VARCHAR(100))";
				
	String SQL_create_table02="create table if not exists memberData("
				+"id INT AUTO_INCREMENT PRIMARY KEY not null, "
				+ "member_id VARCHAR(100),"
				+ "member_name VARCHAR(100),"
				+ "account VARCHAR(100),"
				+ "password VARCHAR(100),"
				+ "address VARCHAR(100),"
				+ "mail_address VARCHAR(100),"
				+ "telephone VARCHAR(100))";

	PreparedStatement ps=conn.prepareStatement(SQL_create_table01);
	PreparedStatement ps1=conn.prepareStatement(SQL_create_table02);
	ps.executeUpdate();
	ps1.executeUpdate();
 * 
 * 
 */