package com.login;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Reset_Password extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletOutputStream so =res.getOutputStream();
		String user =req.getParameter("Username");
		String pass =req.getParameter("Password");
		String rPassword =req.getParameter("Re-Password");
		PreparedStatement ps;
		try {
			ps = Db_Connection.getConnection().prepareStatement("UPDATE REGISTRATION_FORM_DATA SET PASSWORD = ? WHERE USERNAME =?");
			if(pass.equals(rPassword)) {
			  ps.setString(1, pass);
		      ps.setString(2, user);
		      ps.executeUpdate();
		      //so.print("Password Updated.");
		      RequestDispatcher rd =req.getRequestDispatcher("Sign_In.html");
		      rd.forward(req, res);
		      so.print("Password Updated.");
			}else {
				RequestDispatcher rd =req.getRequestDispatcher("Reset_Pass.html");
				rd.include(req, res);
				so.print("Both Passwords must be same !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	@Override
	public void destroy() {
	try {
		Db_Connection.getConnection().close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
}
