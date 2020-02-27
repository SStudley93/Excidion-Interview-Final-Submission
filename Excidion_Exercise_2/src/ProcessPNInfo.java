import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Servlet implementation class ProcessPNInfo
 */
@WebServlet("/ProcessPNInfo")

public class ProcessPNInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ProcessPNInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "/DisplayInfo.jsp";
			String fName = request.getParameter("fname"); // the first name of the person from the input screen
			String lName = request.getParameter("lname"); // the last name of the person from the input screen
			String PhNum = request.getParameter("phone"); // the phone number of the person from the input screen
			
			if(!regexCheck("^[A-Za-z\\.\\' \\ -]{2,30}$", fName)) {
				url = "/Index.jsp";
				fName = "Error, must be valid name";
			}
			if(!regexCheck("^[A-Za-z\\.\\' \\ -]{2,30}$", lName)) {
				url = "/Index.jsp";
				lName = "Error, must be valid name";
			}
			if(!regexCheck("^[0-9\\-]{10,17}$", PhNum)) {
				url = "/Index.jsp";
				PhNum = "Error, must be valid phone Number";
			}
			Phone_Model PHN = new Phone_Model(fName,lName,PhNum);

			if(!url.contentEquals("/Index.jsp")) {
			PHN.addPhone(fName, lName,PhNum);}
			//The next 3 lines sets the error message for the display information
			request.setAttribute("fname",fName);
			request.setAttribute("lname", lName);
			request.setAttribute("phone", PhNum);
			
		//these lines send the information from the last section and sends them to the URL Provided
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
			
		}
	
	/*	protected void addPhone(String fName, String lName, String Phone) {
			Connection con;
			try {
				Class.forName("org.sqlite.JDBC");
				String url = "jdbc:sqlite:C:\\Users\\Scotty\\Phone_Numbers.db";
				con = DriverManager.getConnection(url);
				System.out.println("Connected");
				Statement s = con.createStatement();
				String query = "INSERT INTO phone_nbrs " + "(first_name,last_name,phone_nbr)" + "VALUES ('" +fName+ "', '"+ lName+ "', '" +Phone+"')";
				System.out.println(query);
				s.executeUpdate(query);
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}*/
	static boolean regexCheck(String Regex, String Str2Check) {
		Pattern regexPattern = Pattern.compile(Regex);
		Matcher regexMatcher = regexPattern.matcher(Str2Check);
		if(regexMatcher.matches()) {
			return true;
		}else
			return false;
		}
		
	}



