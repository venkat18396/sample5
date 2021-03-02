package com.caps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingleThreadedServ extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//line 1
		//line 2
		//line 3
		synchronized (this) {
			//line 4
			//line 5
		}
		
		
		//line 6
		//line 7
		
	}
}
