package com.login;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Creat_Table extends HttpServlet{
	@Override
	public void init(ServletConfig config) throws ServletException {
			try {
			Statement st = Db_Connection.getConnection().createStatement();
			String q ="CREATE TABLE REGISTRATION_FORM_DATA("+"Name VARCHAR2(20),"+"Email VARCHAR2(30),"+"UserName VARCHAR(10),"+"Password VARCHAR2(10),"+"BirthMonth VARCHAR(10),"+"BirthDay VARCHAR(5),"+"BirthYear VARCHAR(4),"+"Gender VARCHAR(10),"+"Mobile VARCHAR(10))";
			st.executeQuery(q);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		ServletOutputStream so =res.getOutputStream();
		so.print("Table is Created !");
	}
	public void destroy () {
		try {
			Db_Connection.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}