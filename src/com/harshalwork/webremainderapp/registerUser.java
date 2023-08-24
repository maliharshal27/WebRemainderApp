package com.harshalwork.webremainderapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class registerUser
 */
public class registerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerUser() {
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
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mob = request.getParameter("mob");
		String pwd = request.getParameter("pwd");
		
		try
		{   
			Connection con = ConnectionDB.connect();
			PreparedStatement ps = con.prepareStatement("insert into register_db values(?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, mob);
			ps.setString(5, pwd);
		    int i =	ps.executeUpdate();
		   
		    if(i==1)
		    {
		    	response.sendRedirect("login.html");
		    }
		    else
		    {
		    	response.sendRedirect("index.html");
		    }




			
		}catch(Exception e)
		{
			e.printStackTrace();
		}


	}

}
