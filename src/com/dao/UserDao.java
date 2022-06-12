package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	public static List<UserBean> getAllUsers(){
		List<UserBean> users = new ArrayList<UserBean>();
		try(Connection con = JDBCConnectionClassMySQL.getConnection();
				PreparedStatement psmt = con.prepareStatement("select * from usertable");
				){
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				UserBean u = new UserBean();
				u.setEmailID(rs.getString("emailid"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setUserID(rs.getInt("userid"));
				u.setPassword(rs.getString("password"));
				users.add(u);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	public static boolean duplicateEmailChecker(String emailID) {
		boolean flag = false;
		try(Connection conn = JDBCConnectionClassMySQL.getConnection();
			PreparedStatement psmt = conn.prepareStatement("select count(*) c from usertable where emailid=?");
				){
			psmt.setString(1, emailID);
			ResultSet rs = psmt.executeQuery();
			int count  = -1;
			while(rs.next()) {
				count = rs.getInt("c");
			}
			if(count==0) {
				flag = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static boolean checkLogin(String emailID, String password) {
		boolean flag=false;
		try(Connection conn = JDBCConnectionClassMySQL.getConnection();
			PreparedStatement psmt = conn.prepareStatement("select count(*) c from usertable where emailid=? and password=?");
			){
			psmt.setString(1, emailID);
			psmt.setString(2, password);
			ResultSet rs = psmt.executeQuery();
			int count = -1;
			while(rs.next()) {
				count = rs.getInt("c");
			}
			if(count==1) {
				flag = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static boolean deleteUser(int userID) {
		boolean flag = true;
		try(Connection con = JDBCConnectionClassMySQL.getConnection();
			PreparedStatement psmt = con.prepareStatement("delete from usertable where userid = ?");	
			){
			psmt.setInt(1, userID);
			int num = psmt.executeUpdate();
			if(num!=1) {
				flag = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	public static void main(String[] args) {
		System.out.println(duplicateEmailChecker("pjap041@gmail.com"));
	}
}
