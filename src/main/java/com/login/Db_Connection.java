package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_Connection {

	public static Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		 Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "sai123");		    		
		return c;
	}
//	public static void main(String[]arg) throws SQLException {
//		
//		if (Db_Connection.getConnection()==null) {
//			System.out.println("Not Connected");
//		}else {
//			System.out.println("Connected");
//		}
//			
//	}
}
