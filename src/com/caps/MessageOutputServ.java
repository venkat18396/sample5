package com.caps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caps.dto.Person;

@WebServlet("/output")
public class MessageOutputServ extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String output = req.getParameter("msg");
		HttpSession session = req.getSession(false);
		if(session != null) {
			Person p = (Person)session.getAttribute("user");
			
			if(p != null)
			System.out.println(p.getFirstname()+": "+output);
		}
		else
			System.out.println(output);
		resp.getWriter().print("<h1>Message Sent</h1>");
	}
}
