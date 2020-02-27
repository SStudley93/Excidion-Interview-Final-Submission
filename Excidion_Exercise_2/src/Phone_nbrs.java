
public class Phone_nbrs {
 private String first_name;
 private String last_name;
 private String phone_nbr;
 
 public Phone_nbrs(){
	 this.first_name = "";
	 this.last_name = "";
	 this.phone_nbr = "";
 }
 
 public Phone_nbrs(String fName, String lName, String PHNum) {
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

}
