package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnectionClassMySQL {
	public static Connection getConnection() {
		String driverName = "com.mysql.cj.jdbc.Driver";
		//String driverName = "com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/advjavabackup";
		String userName= "root";
		String password= "root";
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, password);
			if(con == null)
				System.out.println("not connected");
			else
				System.out.println("connected");
	//		System.out.println(con);
		}
		catch(Exception e){
			System.out.println("Something went wrong "+e);
		}
		return con;
	}
	public static void main(String[] args) {
		System.out.println(JDBCConnectionClassMySQL.getConnection());
	}
}
