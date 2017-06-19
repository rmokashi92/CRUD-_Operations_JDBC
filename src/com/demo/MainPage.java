package com.demo;

import java.util.ArrayList;
import java.util.Scanner;



public class MainPage
{
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Books> mybooks = new ArrayList<>();
	static boolean flag = true;
	static ConnectDB handle;
	
	public static void main(String args[])
	{
		handle = new ConnectDB();
		while(flag)
		{
		System.out.println("Select operation");
		System.out.println("-------------------------");
		System.out.println("1. Create Record");
		System.out.println("2. Read Record");
		System.out.println("3. Update Record");
		System.out.println("4. Delete Record");
		System.out.println("5. Display Records");
		System.out.println("6. Stop");
		System.out.println("-------------------------");
		
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1: create();
				break;
		case 2 : read();
				break;
		case 3: update();
				break;
		case 4: delete();
				break;
		case 5: display();
				break;
		case 6: exit();
				break;
		}
		}
	}

	private static void exit() {
		// TODO Auto-generated method stub
		flag = false;
		handle.exit();
	}

	private static void display() {
		// TODO Auto-generated method stub
		System.out.println("Displaying records");
		System.out.println("--------------------------------------");
		handle.displayAll();
	}

	private static void delete() {
		// TODO Auto-generated method stub
		System.out.println("Enter the id to be removed");
		int id = sc.nextInt();
		handle.remove(id);
		
		System.out.println("Record removed for Book ID :" + id);
		System.out.println("---------------------------------");
		
	}

	private static void update() {
		// TODO Auto-generated method stub
		System.out.println("Allows you to change the price");
		System.out.println("Enter the Book ID");
		int id = sc.nextInt();
		System.out.println("Change price to?");
		double price = sc.nextDouble();
		handle.updatePrice(id,price);
		
		System.out.println("Record has been updated for Book ID:" + id);
		System.out.println("-------------------------------------");
		
	}

	private static void read() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Book id");
		int id = sc.nextInt();
		
		System.out.println("Displaying details");
		System.out.println("----------------------------------");
		handle.fetch(id);
		
		
	}

	private static void create() {
		// TODO Auto-generated method stub
		
		sc.nextLine();
		System.out.println("Enter title");
		String title = sc.nextLine();
		System.out.println("Enter Author");
		String author = sc.nextLine();
		System.out.println("Enter price");
		double price = sc.nextDouble();
		
		//Books b = new Books(title,author,price);
		handle.create(title,author,price);
		//mybooks.add(b);
		System.out.println("Record created");
		System.out.println();
		System.out.println("-----------------------------------------");
		
		
		
	}

	
}
