package com.caps;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.dto.Rabbit;

@WebServlet("/serv3")
public class Serv3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		
		Rabbit r = new Rabbit();
		r.setName("Pikachu");
		r.setColor("White");
		r.setGender("Male");
		r.setAge(3);
		
		ctx.setAttribute("rabbit", r);
		
		resp.getWriter().println("Pikachu is Online");
	}
}











