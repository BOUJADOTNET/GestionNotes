package com.Boujadotnet.gestionetudiant;

import java.sql.Statement;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Menu {
	
	static String userName = "root";
	static String password = "";
	static String url = "jdbc:mysql://localhost/test";
	static Connection Con;
	//public Etudiant etudiant;
public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
	 Etudiant etudiant = new Etudiant();
	 // Main Menu
	 //Etudiant = new Etudiant();
	 
     System.out.println("//////////////////Welcome to the User Information System///////////////////");
     System.out.println("Please enter the following details:");
  // Taking user input
     System.out.print("Enter First Name: ");
     String name = scanner.nextLine();
   
		try {
			Con = DriverManager.getConnection(url,userName,password);
		    Statement st = Con.createStatement();
		    
		    System.out.println();
		    
		} catch (SQLException  e) {
			// TODO: handle exception
			System.out.println("Connection is found  : "+ e.getMessage());
		}
	}
}
