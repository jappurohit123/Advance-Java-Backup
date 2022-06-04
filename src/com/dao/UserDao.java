package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.UserBean;
import com.util.JDBCConnectionClassMySQL;
/*
 * Conventional Approach: Closing the connection and prepared Statement every time by developer side
  	try {
			
			Connection conn = JDBCConnectionClassMySQL.getConnection();
			PreparedStatement psmt = conn.prepareStatement("insert into usertable(firstname,lastname,emailid,password) values (?,?,?,?)");
			psmt.setString(1, user.getFirstName());
			psmt.setString(2, user.getLastName());
			psmt.setString(3, user.getEmailID());
			psmt.setString(4, user.getPassword());
			int num = psmt.executeUpdate();
			System.out.println("Num : "+num);
			flag = true;
			conn.close();
			psmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	
 * Try with resources (Try-Catch) : Closing of the connection and prepared statement from Java side (1.7+)
 * 	
 * 
 */
public class UserDao {
	public static boolean insertUser(UserBean user) {
		boolean flag = false;
		try (Connection conn = JDBCConnectionClassMySQL.getConnection();
			PreparedStatement psmt = conn.prepareStatement("insert into usertable(firstname,lastname,emailid,password) values (?,?,?,?)");){			
			psmt.setString(1, user.getFirstName());
			psmt.setString(2, user.getLastName());
			psmt.setString(3, user.getEmailID());
			psmt.setString(4, user.getPassword());
			int num = psmt.executeUpdate();
			System.out.println("Num : "+num);
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
