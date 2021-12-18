package com.m2cafe.test;

import java.util.List;
import java.util.Scanner;

import com.m2cafe.dao.OrderDao;
import com.m2cafe.dao.ProductDao;
import com.m2cafe.dao.UserDao;
import com.m2cafe.model.Cart;
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
			String name=null;
			long mobile=0;
			userDao=new UserDao();
			do
			{
			System.out.println("Enter user Name:");
			name=scan.nextLine();
			if(name.isEmpty())
			{
				System.out.println("name can't be empty");
			}
			}while(name.isEmpty());
			String tempMobile=null;
			do
			{
			System.out.println("Enter mobile number:");
			tempMobile=scan.nextLine();
			if(!tempMobile.matches("[0-9]{10}"))
			{
				System.out.println("mobile number must have 10 digits");
			}
			if(tempMobile.isEmpty())
			{
				System.out.println("Mobile number cant be empty");
			}
			}while(!tempMobile.matches("[0-9]{10}"));
			mobile=Long.parseLong(tempMobile);
			
			User user=new User(name, mobile);
			userDao.inserUser(user);
			
		case 2:
			userDao=new UserDao();
			System.out.println("User Login");
			System.out.println("Enter the registered mobile number");
			long mobileNo=Long.parseLong(scan.nextLine());
			User currentUser=userDao.validateUser(mobileNo);
			int userChoice=0;
			do
			{
			if(currentUser!=null)
			{
			System.out.println("Welcome "+currentUser.getName());
			String userFlagChoice=null;
			do
			{
			System.out.println("\n1.show products\n2.show orders\n3.update order\n4.Cancel order");
			userChoice=Integer.parseInt(scan.nextLine());
			OrderDao orderDao=new OrderDao();
				switch(userChoice)
				{
				case 1:
					ProductDao proDao=new ProductDao();
					List<Products> ProductsList=proDao.showProduct();
					for(int i=0;i<ProductsList.size();i++)
					{
						System.out.println(ProductsList.get(i));
						
					}
					int orderChoice=10;
					do
					{
					System.out.println("\n1.Order Product\n2.show cart");
					orderChoice=Integer.parseInt(scan.nextLine());
					Products product=null;
					String userFalg=null;
						switch(orderChoice)
						{	
						case 1:
							
							do
							{
							System.out.println("\nEnter the Product Name:");
							String proName=scan.nextLine();
							for(int i=0;i<ProductsList.size();i++)
							{
								if(ProductsList.get(i).getName().equals(proName))
								{
									product=ProductsList.get(i);
								}
							}
							System.out.println(product);
							System.out.println("\nEnter no of Products Needed");
							int noOf=Integer.parseInt(scan.nextLine());
							
							orderDao.insertOrder(product,currentUser,noOf);
							
						
							System.out.println("\ndo you want to buy more products(y/n)");
							userFalg=scan.nextLine();
						}while(userFalg.charAt(0)=='y');
						break;
						case 2:
							System.out.println("Orders from You");
							List<Cart> userCartList=orderDao.viewUserCart(currentUser);
							System.out.println(userCartList);
							break;
						}
						}while(orderChoice<3);
						break;
				case 2:
					System.out.println("Orders in cart");
					List<Cart> CartList=orderDao.viewCart(currentUser);
					System.out.println(CartList.get(0));
					break;
				}
				System.out.println("Do you want to continue or Logout ..(y/n)");
				userFlagChoice=scan.nextLine();
			}while(userFlagChoice.charAt(0)=='y');
				
			}
			
			
			else
			{
				System.out.println("Not a registered mobile number");
			}
			}while(userChoice<5);
			break;
		case 3:
			break;
		default:
				System.out.println("Invalid Choice");
				System.exit(0);
		}
		
		
		

	}

}
