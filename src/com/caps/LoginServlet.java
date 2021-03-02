package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caps.dao.JDBCImpl;
import com.caps.dto.Person;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter out = resp.getWriter();
		Cookie[] cookies = req.getCookies();
		
		if(cookies == null) {
			
			out.print("<h1>Cookies are disabled</h1>");
			return;
		}
		
		//Get the data from the Login Form
		String regno = req.getParameter("regno");
		String pass = req.getParameter("passwd");
		
		
		//Use JDBC to verify the credentials
		JDBCImpl db = new JDBCImpl();
		Person p = db.login(Integer.parseInt(regno), pass);
		
		//To check if Login is Successful
		if(p !=null) {
			//Create a Session Object.
			HttpSession httpSession = req.getSession();
			
			//Store the user information in session object
			httpSession.setAttribute("user", p);
			
			//Prints the Success Msg
			out.println("<h1>Login Successful</h1>");
			
		}else {
			out.println("<h1>Login Failed</h1>");
		}
		
		
	}
}
