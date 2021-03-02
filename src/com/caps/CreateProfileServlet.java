package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.dao.JDBCImpl;
import com.caps.dto.Person;

@WebServlet("/createProfile")
public class CreateProfileServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String regno = req.getParameter("regno");
		String fName = req.getParameter("fnm");
		String lName = req.getParameter("lnm");
		String password = req.getParameter("passwd");
		String isAdmin = req.getParameter("admin");
		
		Person p = new Person();
		p.setRegno(regno);
		p.setFirstname(fName);
		p.setLastname(lName);
		p.setPassword(password);
		p.setIsAdmin(isAdmin);
		
		PrintWriter out = resp.getWriter();
		
		JDBCImpl jd = new JDBCImpl();
		boolean state = jd.createProfile(p);
		
		if(state) {
			out.println("<h1>Profile Created</h1>");
		}
		else {
			out.println("<h1>Profile Creation Failed</h1>");
		}
	}
}








