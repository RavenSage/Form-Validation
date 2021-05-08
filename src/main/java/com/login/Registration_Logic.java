package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Registration_Logic extends HttpServlet{ 
	Connection c;
	Statement st;
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	    PrintWriter o =res.getWriter();
		String Name =req.getParameter("name");
		String Email =req.getParameter("email");
		String UserName =req.getParameter("username");
		String Password =req.getParameter("password");
		String rPassword =req.getParameter("password");
		String BirthMonth =req.getParameter("BirthMonth");
		String BirthDay =req.getParameter("BirthDay");
		String BirthYear =req.getParameter("BirthYear");
		String Gender =req.getParameter("gender");
		String Mobile =req.getParameter("phone");
		
		if (Password.equals(rPassword)) {
			Data_Insertion id =new Data_Insertion();
			try {
				id.Insert(Name,Email,UserName,Password,BirthMonth,BirthDay,BirthYear,Gender,Mobile,res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			res.setContentType("text/html");
			RequestDispatcher rd =req.getRequestDispatcher("Sign_In.html");
			rd.include(req, res);
		}
		else {
			o.print("PASSWORDS DO NOT MATCH, PLEASE TRY AGAIN");
			res.setContentType("text/html");
			RequestDispatcher rd =req.getRequestDispatcher("Registration.html");
			rd.include(req, res);
		}
	}

}
