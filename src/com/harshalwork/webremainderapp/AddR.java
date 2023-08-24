package com.harshalwork.webremainderapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddR
 */
public class AddR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddR() {
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
		 
		String title= request.getParameter("title");
		String des =request.getParameter("des");
	    
		
		 try
         {     		
			 String email = Gettersetter.getEmail();

         	   Connection con = ConnectionDB.connect();
			   PreparedStatement  psm = con.prepareStatement("insert into remainder_db values(?,?,?,?)");
			   psm.setInt(1, 0);
			   psm.setString(2,title);
			   psm.setString(3,des);
			   psm.setString(4, email);
			   int i =psm.executeUpdate();
			   if(i>0){			
				       
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
