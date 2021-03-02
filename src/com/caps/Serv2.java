package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.dto.Person;
import com.caps.dto.Rabbit;


public class Serv2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Person p = (Person)req.getAttribute("personInfo");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>"+p+"</h1>");
		
		out.println("<br>");
		
		ServletContext ctx = getServletContext();
		Rabbit r = (Rabbit)ctx.getAttribute("rabbit");
		out.println("<h1>"+r+"</h1>");
		
	}
}
