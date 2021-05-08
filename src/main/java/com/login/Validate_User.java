package com.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class Validate_User {
	    public static boolean checkUser(String un,String pa,HttpServletRequest req) throws SQLException 
	    {
	        boolean st =false;
			    PreparedStatement ps = Db_Connection.getConnection().prepareStatement("select * from REGISTRATION_FORM_DATA where USERNAME=? and PASSWORD=?");
	            ps.setString(1, un);
	            ps.setString(2, pa);
	            ResultSet rs =ps.executeQuery();	           
	            st = rs.next();
	            String s =rs.getString(1);
	            HttpSession se =req.getSession();
	            se.setAttribute("Name", s);
	            Db_Connection.getConnection().close();
	        return st;
	    }   
}
