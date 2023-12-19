package Model;

public class User {
	String Name;
	String Address;
	String Emailid;
	String Phoneno;
	String Password;
	public User(String name, String address, String emailid, String phoneno, String password) {
		super();
	  this.Name = name;
	  this.Address = address;
	  this.Emailid = emailid;
	  this.Phoneno = phoneno;
	  this.Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmailid() {
		return Emailid;
	}
	public void setEmailid(String emailid) {
		Emailid = emailid;
	}
	public String getPhoneno() {
		return Phoneno;
	}
	public void setPhoneno(String phoneno) {
		Phoneno = phoneno;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "User [Name=" + Name + ", Address=" + Address + ", Emailid=" + Emailid + ", Phoneno=" + Phoneno
				+ ", Password=" + Password + "]";
	}

	
}
