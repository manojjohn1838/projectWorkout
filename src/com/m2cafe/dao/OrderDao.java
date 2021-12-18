package com.m2cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.m2cafe.model.Cart;
import com.m2cafe.model.Products;
import com.m2cafe.model.User;

public class OrderDao {

	public boolean insertOrder(Products product, User user, int noOf) {
		String insertQuery = "insert into cart_cafe (product_id,user_id,quantity,total_price) values(?,?,?,?)";

		//String findProductID = "select id from products_cafe where name= '" + product.getName() + "'";

		Connection con = ConnectionUtil.getDbConnection();
		boolean result = false;
		try {
			int ProductID = 0;
			int UserID = 0;
			Statement stmt = con.createStatement();

//			ResultSet rs = stmt.executeQuery(findProductID);
//			if (rs.next()) {
//				ProductID = rs.getInt(1);
//			}
			ProductID=ProductDao.findProductId(product);
			UserID = UserDao.findUserId(user);

			// System.out.println(ProductID+" "+UserID);
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, ProductID);
			pstmt.setInt(2, UserID);
			pstmt.setInt(3, noOf);
			pstmt.setDouble(4, product.getPrice() * noOf);
			Cart cart = new Cart(product, user, noOf, product.getPrice() * noOf);
			result = pstmt.executeUpdate() > 0;
			System.out.println(result ? "Order inserted" : "Not inserted");
			// System.out.println(pstmt.executeUpdate("commit")?"cart updated in DB":"cart
			// not updated in Db");
			// System.out.println(cart);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return result;
	}

	public List<Cart> viewUserCart(User currentUser) {
		String query = "select * from cart_cafe where user_id=?";
		int userId = UserDao.findUserId(currentUser);
		List<Cart> userCartList = new ArrayList<Cart>();
		ProductDao productDao = new ProductDao();
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setLong(1, userId);
			// System.out.println(userId+" UserID");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
//				System.out.println("product id " + rs.getInt(2));
//				System.out.println("product name:" + rs.getString(3));
				Products product = productDao.findProduct(rs.getInt(2));

				Cart cart = new Cart(product, currentUser, rs.getInt(4), rs.getDouble(5));
				userCartList.add(cart);
			}
			// TODO Auto-generated method stub
			// return userCartList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return userCartList;

	}

	public List<Cart> viewCart(User currentUser) {
		String query = "select * from cart_cafe";
		// int userId=UserDao.findUserId(currentUser);
		List<Cart> userCartList = new ArrayList<Cart>();
		ProductDao productDao = new ProductDao();
		UserDao userDao = new UserDao();
		int userId = userDao.findUserId(currentUser);
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setLong(1, userId);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Products product = productDao.findProduct(rs.getInt(2));
				User user=UserDao.findUser(rs.getInt(3));
				Cart cart = new Cart(product, user, rs.getInt(4), rs.getDouble(5));
				userCartList.add(cart);
			}
			// TODO Auto-generated method stub
			// return userCartList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return userCartList;

	}
}
