package com.m2cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.m2cafe.model.User;

public class UserDao {
	
	public void inserUser(User user) {
		String insertQuery = "insert into user_cafe(user_name,mobile_number) values(?,?)";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		PreparedStatement pstmt = null;
		try {

			pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, user.getName());
			pstmt.setLong(2, user.getMobile());
			pstmt.executeUpdate();
			System.out.println("Value Inserted Successfully");

		} catch (SQLException e) {
			//catch the exception and get that message
			e.printStackTrace();
			System.out.println("Value not Setted in the query");
		}
		

	}
	public boolean updateUser(User user)
	{
		String insertQuery = "update table user_cafe set user_name=? where mobile_number=?";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt = null;
		try {

			pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, user.getName());
			pstmt.setLong(2, user.getMobile());
			pstmt.executeUpdate();
			System.out.println("User Updated Successfully");

		} catch (SQLException e) {
			//catch the exception and get that message
			e.printStackTrace();
			System.out.println("Value not updated properly");
		}
		return result;
	}
	public boolean deleteUser(User user)
	{
		String insertQuery = "delete from user_cafe where mobile_number=?";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt = null;
		try {

			pstmt = con.prepareStatement(insertQuery);
			pstmt.setLong(2, user.getMobile());
			pstmt.executeUpdate();
			System.out.println("User Deleted Successfully");

		} catch (SQLException e) {
			//catch the exception and get that message
			e.printStackTrace();
			System.out.println("Value not updated properly");
		}
		return result;
	}
	public User validateUser(long mobileNo)
	{
		String validateQuery="select * from user_cafe where mobile_number="+mobileNo;
		Connection con=ConnectionUtil.getDbConnection();
		User user=null;
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(validateQuery);
			if(rs.next())
			{
			//System.out.println(rs.getString(2)+"  "+rs.getLong(3));
			user=new User(rs.getString(2), rs.getLong(3));
			}
			else
			{
				System.out.println("Please Login again");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement error");
		}
	
		return user;
	}
	public List<User> showAllUser()
	{
		List<User> userList=new ArrayList<User>();
		
		String selectQuery="select * from user_cafe";
		
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(selectQuery);
			while(rs.next())
			{
				userList.add(new User(rs.getString(2),rs.getLong(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return userList;
	}
	
	public static int findUserId(User user)
	{
		String findUserID="select id from user_cafe where mobile_number= '"+user.getMobile()+"'";
		Connection con=ConnectionUtil.getDbConnection();
		Statement stmt;
		int userId=0;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findUserID);
			if(rs.next())
			{
			userId=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;
		
	}
	public static User findUser(int userId)
	{
		String findUser="select id from user_cafe where userID= '"+userId+"'";
		Connection con=ConnectionUtil.getDbConnection();
		Statement stmt;
		User user=null;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findUser);
			if(rs.next())
			{
			user=new User(rs.getString(1),rs.getLong(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}

}
