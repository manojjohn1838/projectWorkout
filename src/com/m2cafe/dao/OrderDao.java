package com.m2cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.m2cafe.model.Products;
import com.m2cafe.model.User;

public class OrderDao {
	
	public boolean insertOrder(Products product,User user,int noOf)
	{
		String insertQuery="insert into cart_cafe (product_id,user_id,quantity,price) values(?,?,?,?)";
		
		String findProductID="select id from products_cafe where name= '"+product.getName()+"'";
		String findUserID="select id from user_cafe where mobile_number= '"+user.getMobile()+"'";
		Connection con=ConnectionUtil.getDbConnection();
		try {
			int ProductID=0;
			int UserID=0;
			Statement stmt =con.createStatement();
			
			ResultSet rs=stmt.executeQuery(findProductID);
			if(rs.next())
			{
			ProductID=rs.getInt(1);
			}
			rs=stmt.executeQuery(findUserID);
			if(rs.next())
			{
			UserID=rs.getInt(1);
			}
			System.out.println(ProductID+"     "+UserID);
			PreparedStatement pstmt=con.prepareStatement(insertQuery);
			pstmt.setInt(1, ProductID);
			pstmt.setInt(2, UserID);
			pstmt.setInt(3, noOf);
			pstmt.setDouble(4, product.getPrice()*noOf);
			System.out.println(pstmt.executeUpdate()>0?"Order inserted":"Non inserted");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		return false;
	}

}
