package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class ServletLifeCycleDemo extends HttpServlet{
	 
	public ServletLifeCycleDemo() {
		System.out.println("instantiation phase");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init phase");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("inside service phase");
		PrintWriter out = resp.getWriter();
		out.println("got the req.");
	}
	
	@Override
	public void destroy() {
		System.out.println("inside destroy phase...bye bye world :( ");
	}
	
}
