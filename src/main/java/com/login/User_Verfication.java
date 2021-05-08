package com.login;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class User_Verfication extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uN =req.getParameter("username");
		String mN =req.getParameter("Mobile");
		String bY =req.getParameter("BirthYear");
		try {
		Statement stmt =Db_Connection.getConnection().createStatement();
        ResultSet rs =stmt.executeQuery("SELECT UserName, Mobile, BirthYear FROM REGISTRATION_FORM_DATA");
        while (rs.next()) {
			if (uN.equals(rs.getString(1))&&mN.equals(rs.getString(2))&& bY.equals(rs.getString(3))) {
				res.setContentType("text/html");
				RequestDispatcher rd =req.getRequestDispatcher("Otp.html");
				rd.forward(req, res);
			}else {
				RequestDispatcher rd =req.getRequestDispatcher("Password_Verfication.html");
				rd.include(req, res);
				ServletOutputStream so= res.getOutputStream();
				so.print("Please Check The Entered Details And Try Again");
			}
			}
		}catch (Exception e) {
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
