//retrieves the data from the index.jsp page (the 2nd form on that page) and produces a page with the First Name, Last Name, 
//and Phone numbers from the database in alphabetical order

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class get_Phone_nums
 */
@WebServlet("/get_Phone_nums")
public class get_Phone_nums extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Connection con;
	 String url;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public get_Phone_nums() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//I connected this to the doPost Function in order to simplify the sequence.
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // This will project out to get_Phone_nums.jsp when the code is finished
		Phone_Model PH = new Phone_Model();
		PH.getPhones(response);
			//This method produces the HTML code to present the table with the
		    //alphabatized list of names and phone numbers.
			
		}
		
	}


