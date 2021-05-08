package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.http.HttpServletResponse;

public class Data_Insertion  {
	public void  Insert (String Name, String Email, String UserName, String Password, String BirthMonth, String BirthDay, String BirthYear, String Gender, String Mobile,  HttpServletResponse res) throws SQLException ,IOException {
		    Statement st =Db_Connection.getConnection().createStatement();
			st.executeUpdate("INSERT INTO REGISTRATION_FORM_DATA VALUES('"+Name+"','"+Email+"','"+UserName+"','"+Password+"','"+BirthMonth+"','"+BirthDay+"','"+BirthYear+"','"+Gender+"','"+Mobile+"')");
			PrintWriter out =res.getWriter();
			out.println(" Registered Sucessfully");
  }
	
}

