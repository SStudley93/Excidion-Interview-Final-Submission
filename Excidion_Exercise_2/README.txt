Scott Studley's Excidion Exercise Readme Document:

Download Instructions
 - Download the WAR file, Database, and Readme file from the GitHub repository
 - Create a folder for the Website in ypour computer
 - Start the tomcat server
 - copy WAR file to the Tomcat Folder under webapps.

Methodology:
 - This code combines HTML, Java, and SQL in order to connect a web application to a database in order to keep track of phone numbers. 
 - This code uses Maven to compile into a WAR file in order for ease of distribution.
 - the Database has been designed in SQLite3 and has been connected to the program VIA a Maven Dependency
 - This web application was designed in Java Eclipse and has taken advantage of Java Servelets and JSP files in order to display information in a web browser
 - This web application also sanitizes inputs, using the regexCheck function in ProcessPNinfo, names that have a number and are greater than 30 characters per name
   as well as phone numbers that are less than 10, greater than 17 or contain abything except numbers will not be inputted into the database.
Data Dictionary:
 - First_Name Text
 - Last_ Name Text
 - Phone Number Text

Running the code:
 - Prep
 -- After Downloading the code, move the Database to a location that the user will return it to. 
 -- In Phone_Model.java there is a String called "url" at the top of the page, please copy the path to the database, 
    Phone_Nbrs.db, and paste it into this variable.
 - Running the Program
 -- When the Code is downloaded and open, go to http://localhost:8080/Excidion_Exercise_2/Index.jsp
 -- From here you can enter the first name, last name, and phone number of the record in the label fields, Upon pressing send, the database will be updated.
 -- to see all of the data in the database, Just click on the Get all Phone Numbers button.

Testing Methodology:
 - Test case 1 Involved me first inputting values into the database directly using the command prompt and then using that same prompt in order to test if the database
   updated. Database successfully updated
 - Test case 2 Required me to write the code to test if the database was accessible from the java application. Ping was successful, database connected to Java
 - Test case 3 Required testing if the Tomcat was successfully downloaded. Ping was conducted with Tomcat server. Tomcat was successfully pinged.
 - Test Case 4 Testing to see if the code to display the data from the database was successful. Database information was seen in get_Phone_nbrs.jsp
 - Test Case 5 Writing and testing to see if the the fields that were written to the database from the Web App. Test was successful, Database was updated, reran test
   4 and test 1 to verify that database was updated. Test was Successful.
 - Test Case 6 Testing the Sanitzation function of the web app. tested the various conditions that are outside of the parameters. tested them against the database, 
   the information was not added to the database. Success