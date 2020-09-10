package com.test.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionHandler {
	 Connection con = null;
	 
	    public static Connection getConnection() {
	        Connection con = null;
	        try {

	   		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	          
	        } catch (ClassNotFoundException ex) {
	        	System.out.println(ex);
	        }
	        try {
	        	   con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TEST", "TEST", "revuesoft@2013");
	        } catch (SQLException ex) {
	        	System.out.println(ex);
	        }
	        return con;
	    }
	
}

