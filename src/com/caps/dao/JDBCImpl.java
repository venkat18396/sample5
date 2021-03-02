package com.caps.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.caps.dto.Person;
import com.mysql.jdbc.Driver;

public class JDBCImpl {
	public boolean createProfile(Person person) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			 //1. Load the Driver
			java.sql.Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//2. get the DB connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/caps50_db?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);
			
			//3. Issue the SQL query via connection
			String query1 = "INSERT INTO person_info values(?,?,?)";
			pstmt = con.prepareStatement(query1);
			pstmt.setInt(1, Integer.parseInt(person.getRegno()));
			pstmt.setString(2, person.getFirstname());
			pstmt.setString(3, person.getLastname());
			
			int count1 = pstmt.executeUpdate();
			pstmt.close();
			
			String query2 = "INSERT INTO person_otherinfo "
					+ " VALUES(?,?,?)";
			pstmt = con.prepareStatement(query2);
			pstmt.setInt(1, Integer.parseInt(person.getRegno()));
			pstmt.setString(2, person.getPassword());
			pstmt.setString(3, person.getIsAdmin());
			
			int count2 = pstmt.executeUpdate();
			
			//4. Process the results
			if(count1== 1 && count2 == 1) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//5. Closing all the JDBC Objects
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public Person login(int regno, String passwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 //1. Load the Driver
			java.sql.Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//2. get the DB connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/caps50_db?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);
			
			//3. Issue the SQL query via connection
			String query1 = "select * from person_info pi, person_otherinfo po "
					+ " where pi.regno=po.regno and po.password=? and po.regno =? ";
			pstmt = con.prepareStatement(query1);
			pstmt.setString(1, passwd);
			pstmt.setInt(2, regno);
			
			rs = pstmt.executeQuery();
			
			
			
			//4. Process the results
			if(rs.next()) {
				Person p = new Person();
				p.setRegno(rs.getInt("regno")+"");
				p.setFirstname(rs.getString("firstname"));
				p.setLastname(rs.getString("lastname"));
				p.setPassword(rs.getString("password"));
				p.setIsAdmin(rs.getString("type"));
				
				return p;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//5. Closing all the JDBC Objects
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
