import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Phone_Model {
 private String first_name;
 private String last_name;
 private String phone_nbr;
 Connection con;
 String url; // location of the database, this will need to be
	//updated when transferring locations for the database;
 public Phone_Model(){
	 this.first_name = "";
	 this.last_name = "";
	 this.phone_nbr = "";
 }
 
 public Phone_Model(String fName, String lName, String PHNum) {
	 this.first_name = fName;
	 this.last_name = lName;
	 this.phone_nbr	= PHNum;
	 
 }
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public String getPhone_nbr() {
	return phone_nbr;
}
public void setPhone_nbr(String phone_nbr) {
	this.phone_nbr = phone_nbr;
}

protected void getPhones(HttpServletResponse res) throws IOException  {
	//This method produces the HTML code to present the table with the alphabatized list of names and phone numbers.
	String url = "/get_Phone_nums.jsp";
	ResultSet results = null; // this field will hold the results of the SQL query
	PrintWriter out = res.getWriter();
	res.setContentType("text/html"); //Display code will be written in HTML
	out.println("<html><body>");
	try {
		Class.forName("org.sqlite.JDBC");
		 url = "jdbc:sqlite:C:\\Users\\Scotty\\Phone_numbers.db";
		con = DriverManager.getConnection(url);
		Statement s = con.createStatement(); //This will hold the SQL query
		String query = "Select * from phone_nbrs order by last_name, first_name asc"; //SQL Query, organized by last name then first in alphabetical order
		results = s.executeQuery(query);
		//creates the table that will hold the query
		out.println("<table border = 1 width = 50% height = 50%");
		out.println("<tr><th>First_Name</th><th>Last_Name</th><th>Phone_Number</th><tr>");
		//This while loop pulls the First name, last name, and Phone Number from each individual record in the database while there are still records
		while(results.next()) {
			String f = results.getString("first_name");
			String l = results.getString("last_name");
			String p = results.getString("phone_nbr");
			out.println("<tr><td>"+ f + "</td><td>"+l+"</td><td>"+p+"</td></tr>"); //This line
		}
		//The following statements will close out the loop
		out.println("</table>");
		out.println("</html></body>");
	
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
protected void addPhone(String fName, String lName, String Phone) {
	try {
		Class.forName("org.sqlite.JDBC");
		 String url = "jdbc:sqlite:C:\\Users\\Scotty\\Phone_numbers.db";
		con = DriverManager.getConnection(url);
		Statement s = con.createStatement(); // will execute the query when it will run
		String query = "INSERT INTO phone_nbrs " + "(first_name,last_name,phone_nbr)" + "VALUES ('" +fName+ "', '"+ lName+ "', '" +Phone+"')"; // Query that will input the information presented in the 
		s.executeUpdate(query);
	}
	catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
}
