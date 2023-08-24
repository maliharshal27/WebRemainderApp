package com.harshalwork.webremainderapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class loginUser
 */
public class loginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		try
		{
			Connection con = ConnectionDB.connect();
			PreparedStatement psm = con.prepareStatement("select * from register_db where email=? and password=?");
			psm.setString(1, email);
			psm.setString(2, pwd);
		    ResultSet rs =	psm.executeQuery();
            Gettersetter.setEmail(email);

		    if(rs.next())
		    {    
		    	response.sendRedirect("menu.html");
		    }
		    else
		    {
		    	response.sendRedirect("login.html");
		    }

			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}
	
	

}
