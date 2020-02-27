<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<! this is the main webpage that people see upon starting the web app>
<title>Please enter an option here</title>
</head>
<body>
<h3> Enter the user's First Name, Last Name, and Phone Number</h3>
<form action="ProcessPNInfo" method="post"><! this form will access the Process PNInfo. java class, allowing users to input a phone number into the database>
<label>First Name : </label>
<input type="text" name="fname" value = "${fname }"><br><!Firsnt name field>
<label>Last Name : </label>
<input type="text" name="lname" value = "${lname }"><br><!last name field>
<label>Phone : </label>
<input type="text" name="phone" value = "${phone }"><br><!Phone Number field>
<input type="submit" value="Send">
</form>
<form action ="get_Phone_nums" method = "post"> <! this function will allow for the user to retrieve all phone numbers in alphabetical order>
<h3>See all Phone Numbers</h3>
<input type = "submit" value = "Get All Phone Numbers">
</form>
</body>
</html>