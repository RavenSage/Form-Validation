package com.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Otp_Verfication {
	int otp;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out =res.getWriter();
		try {
			String apiKey = "apikey=" + "ZGQyZDQ0ODk2MDBkZGY2ZDcyNGQwNjVhNjBkOWQ0MjA=";
			Random r =new Random();
			otp =r.nextInt(99999);
			String name =req.getParameter("username");
			String message = "&message=" + "Hello"+name+"your otp for resetting your Password is"+otp;
			String sender = "&sender=" + "TimeBomb";
			String numbers = "&numbers=" + req.getParameter("Mobile Number");
			
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			out.println("Otp Sent Sucessfully");
		} catch (Exception e) {
			out.println("Error SMS "+e);
		}
	}
}
