package com.m2cafe.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.m2cafe.model.Products;
import com.m2cafe.model.User;

public class ProductDao {
	
	public List<Products> showProduct()
	{
		List<Products> productsList=new ArrayList<Products>();
		
		String showQuery="select * from products_cafe";
		Connection con=ConnectionUtil.getDbConnection();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(showQuery);
			while(rs.next())
			{
				Products product=new Products(rs.getString(2), rs.getString(3), Double.parseDouble(rs.getString(4)), rs.getString(5));
				productsList.add(product);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productsList;
	}
	public static int findProductId(Products product)
	{
		String findUserID="select id from products_cafe where mobile_number= '"+product.getName()+"'";
		Connection con=ConnectionUtil.getDbConnection();
		Statement stmt;
		int productId=0;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findUserID);
			if(rs.next())
			{
			productId=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productId;
		
	}


}
