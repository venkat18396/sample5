package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.dto.Person;


public class Serv1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Person p = new Person();
		p.setFirstname("Surya");
		p.setLastname("Pradhan");
		p.setRegno("36");
		p.setPassword("root");

		req.setAttribute("personInfo", p);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/serv2");
		dispatcher.forward(req, resp);
	}
}
