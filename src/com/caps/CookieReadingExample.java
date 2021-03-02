package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readCookies")
public class CookieReadingExample extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		
		PrintWriter out = resp.getWriter();
		if(cookies == null) {
			out.println("Cookies are not Present in the Browser");
		}
		else {
			out.println("Cookies are present");
			for(Cookie c:cookies) {
				out.println("<h1>Name: "+c.getName()+"</h1>");
				out.println("<h1>Value: "+c.getValue()+"</h1>");
				out.println("<br>");
			}
		}
		
		resp.setContentType("text/html");
	}
}







