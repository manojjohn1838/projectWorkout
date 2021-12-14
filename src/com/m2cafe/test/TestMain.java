package com.m2cafe.test;

import java.util.List;
import java.util.Scanner;

import com.m2cafe.dao.OrderDao;
import com.m2cafe.dao.ProductDao;
import com.m2cafe.dao.UserDao;
import com.m2cafe.model.Products;
import com.m2cafe.model.User;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("\tWelcome to M2Cafe\t(The Coffe Shop)");
		System.out.println("\n1.Register\n2.Login\n3.Admin login\nEnter your chioce");
		int choice=Integer.parseInt(scan.nextLine());
		UserDao userDao=null;
		switch(choice)
		{
		case 1:
			userDao=new UserDao();
			System.out.println("Enter user Name:");
			String name=scan.nextLine();
			System.out.println("Enter mobile number:");
			long mobile=Long.parseLong(scan.nextLine());
			User user=new User(name, mobile);
			userDao.inserUser(user);
		case 2:
			userDao=new UserDao();
			System.out.println("User Login");
			System.out.println("Enter the registered mobile number");
			long mobileNo=Long.parseLong(scan.nextLine());
			User currentUser=userDao.validateUser(mobileNo);
			if(currentUser!=null)
			{
			System.out.println("Welcome "+currentUser.getName());
			System.out.println("\n1.show products\n2.show orders\n3.update order\n4.Cancel order");
			int userChoice=Integer.parseInt(scan.nextLine());
			
			switch(userChoice)
			{
			case 1:
				ProductDao proDao=new ProductDao();
				List<Products> lProducts=proDao.showProduct();
				for(int i=0;i<lProducts.size();i++)
				{
					System.out.println(lProducts.get(i));
					
				}
				System.out.println("\n1.Order Product\n");
				int orderChoice=Integer.parseInt(scan.nextLine());
				Products product=null;
				if(orderChoice==1)
				{	
					System.out.println("Enter the Product Name:");
					String proName=scan.nextLine();
					for(int i=0;i<lProducts.size();i++)
					{
						if(lProducts.get(i).getName().equals(proName))
						{
							product=lProducts.get(i);
						}
						
					}
					System.out.println("enter no of Products Needed");
					int noOf=Integer.parseInt(scan.nextLine());
					OrderDao orderDao=new OrderDao();
					orderDao.insertOrder(product,currentUser,noOf);
					
				}
				break;
				default:
					System.out.println("Invalid choice");
			}
			
			}
			else
			{
				System.out.println("Not a registered mobile number");
			}
			break;
		case 3:
			break;
		default:
				System.out.println("Invalid Choice");
				System.exit(0);
		}
		
		
		

	}

}
