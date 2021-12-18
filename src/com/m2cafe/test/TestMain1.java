package com.m2cafe.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdf1=new SimpleDateFormat("HH:mm");
		System.out.println("Enter email:");
		String email=scan.nextLine();
		System.out.println("Enter reg date");
		Date regDate=sdf.parse(scan.nextLine());
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			String query="insert into selfwork values (?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setDate(2, new java.sql.Date(regDate.getTime()));
		System.out.println(pstmt.executeUpdate()>0 ?"Value inserted ":"Value not inserted");
		String selectQuesry="select * from selfwork";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(selectQuesry);
		if(rs.next())
		System.out.println(rs.getString(1)+"     "+sdf.format(rs.getDate(2))+" "+sdf1.format(rs.getTime(2)));

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
