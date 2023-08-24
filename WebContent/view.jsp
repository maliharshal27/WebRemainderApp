<%@ page import="com.harshalwork.webremainderapp.*" %>
<%@ page import="java.sql.*" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<style>
/* Reset some default styles */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

/* Basic styling for the body and header */
body {
  font-family: Arial, sans-serif;
  line-height: 1.6;
}

header {
  background-color: #333;
  color: #fff;
  padding: 1rem;
  text-align: center;
}

h1 {
  margin: 0;
}

/* Styling for the main content */
main {
  padding: 2rem;
}

.view-reminders {
  max-width: 800px; /* Adjust the max-width as needed */
  margin: 0 auto;
}

h2 {
  margin-bottom: 1rem;
}

table {
  width: 100%;
  border-collapse: collapse;
  border: 1px solid #ccc;
  margin-bottom: 1rem;
}

th,
td {
  border: 1px solid #ccc;
  padding: 0.5rem;
  text-align: left;
}

th {
  background-color: #f4f4f4;
}

/* Styling for the footer */
footer {
  background-color: #333;
  color: #fff;
  text-align: center;
  padding: 1rem;
}

</style>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>View Reminders Menu</title>
</head>

<body>
<form action="view.jsp">
  <header>
    <h1>Reminder App</h1>
  </header>

  <main>
    <section class="view-reminders">
      <h2>View Reminders</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
             <th>Action</th>
            
            
          </tr>
        </thead>
       <tbody>
        
  
  
  
  <%    
  Connection con = ConnectionDB.connect();

  
  try
  {     
	  String email=Gettersetter.getEmail();
         
	   PreparedStatement psm = con.prepareStatement("select * from remainder_db where email=?");
	   psm.setString(1, email);
	    ResultSet rs =	psm.executeQuery();
	    while(rs.next())
	    {   
	    	 
	                
  %> 
		                   <tr>
		                  <td><%=rs.getString("id") %></td>
		                  <td><%=rs.getString("title") %></td>
		                 <td><%=rs.getString("des") %></td>
		                  <td><a href="deleteR.jsp?id=<%=rs.getString("id")%>" >Delete</a></td>
		                  
		                  
		                    </tr>
		                  
		                
  <%
                 
	               
	    }           
	   	   
	   
   }
   catch(Exception e)
   {
	   e.printStackTrace();
   }
%>   

       </tbody>
		                   </table>
  
  
  
  
  
  
  
  
  
     
    </section>
  </main>

  <footer>
    <p>&copy; 2023 Your Reminder App</p>
  </footer>
  </form>
</body>

</html>
