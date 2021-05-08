package com.login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class Login_Logic  extends HttpServlet{

	 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {		
		res.setContentType("text/html");
		PrintWriter out =res.getWriter();
		String un=req.getParameter("username");
		String pa =req.getParameter("password");			
			try {
				if(Validate_User.checkUser(un, pa, req)){
					HttpSession se = req.getSession();
					String s =(String) se.getAttribute("Name");
				     out.println("Welcome : "+s);
					se.setAttribute("User", s);
				        res.sendRedirect("User_Profile.jsp");
				    }
				    else
				    {
				       out.println("Username or Password incorrect");
				       RequestDispatcher rs = req.getRequestDispatcher("Sign_In.html");
				       rs.include(req, res);
				    }
			} catch (SQLException | ServletException | IOException e) {
				e.printStackTrace();
			}
	}
}



