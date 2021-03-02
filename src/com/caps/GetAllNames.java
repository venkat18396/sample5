package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAllNames extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs =null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			resp.setContentType("text/html");
			//2. get the DB connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/caps50_db?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);
			
			//3. Issue the query
			String sql = "SELECT * FROM person_info";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			//4. Process the Results
			while(rs.next()) {
				String regno = ""+rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				
				out.println(fname);
				out.println("<br>");
				out.println("**************************");
				out.println("<br>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5. Close all the JDBC Code
			try {
				if(rs != null) 
					rs.close();
				if(stmt != null)
					stmt.close();
				if(con != null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
