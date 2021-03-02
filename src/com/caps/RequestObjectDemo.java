package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reqDemo")
public class RequestObjectDemo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*PrintWriter out = resp.getWriter();
		out.print("<h1>Got the Request!...Hii</h1>");
		
		System.out.println("Http Method: "+req.getMethod());
		System.out.println("URL: "+req.getRequestURL());
		System.out.println("Protocol: "+req.getProtocol());
		
		String[] q1 = req.getParameterValues("q1");
		String[] q2 = req.getParameterValues("q2");
		String q3 = req.getParameter("q3");
		
		resp.setContentType("text/html");
		
		
		System.out.println(Arrays.toString(q1));
		System.out.println(Arrays.toString(q2));
		System.out.println(q3);*/
		
		resp.sendError(500, "Something went wrong... :{ / ");
	}
}













