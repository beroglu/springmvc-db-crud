package com.berfin.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javassist.bytecode.stackmap.BasicBlock.Catch;


@WebServlet("/TestDb")
public class TestDB  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		
		String user="berfin";
		String pass="1234";
		String jdbcUrl="jdbc:oracle:thin:@localhost:1521/ORCL";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		try {
		PrintWriter out= response.getWriter();
		out.println("Veritabanina baglanti :"+jdbcUrl);
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection myConn =DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("Basariliii");
			myConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	}
	
	}
		catch(Exception e) {
		
		e.printStackTrace();
		throw new ServletException();
	}
	
	}
}

