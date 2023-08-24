package com.harshalwork.webremainderapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DeleteR
 */
public class DeleteR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteR() {
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
		 
		String title=request.getParameter("title");
		String email = Gettersetter.getEmail();
		
	        try
	        {    
	        	
	        	 Connection con = ConnectionDB.connect();
				   PreparedStatement  psm5 = con.prepareStatement("delete from remainder_db where email=? and title=?");
				     psm5.setString(1, email);
				     psm5.setString(2, title);

				     
				     int rs1 = psm5.executeUpdate();
				     if(rs1==1)
				     {
				    	 response.sendRedirect("menu.html");
				     }
				     else
				     { 
				    	 response.sendRedirect("add.html");
				     }
			}
	        catch(Exception e)
	        {
	          e.printStackTrace();	
	       	 System.out.println("Faild ");
	        }

	}

}
