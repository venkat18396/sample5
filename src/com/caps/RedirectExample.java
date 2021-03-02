package com.caps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class RedirectExample extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String search = req.getParameter("find");
		
		String redirectUrl = "https://www.google.co.in/search?q="+search;
		resp.sendRedirect(redirectUrl);
		
//		resp.sendRedirect("http://localhost:8080/MyLastCapApp/index.html");
	}
}
