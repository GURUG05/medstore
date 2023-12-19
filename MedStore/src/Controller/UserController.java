package Controller;
import Model.UserData;
public class UserController {
UserData userData = new UserData();
	public void saveUser(String name, String address, String emailid, String phoneno, String password) {
		   userData.addUser(name, address, emailid, phoneno, password);
	}
	public boolean verifyUser(String userName, String userPassword) {	
		return userData.checkUser(userName, userPassword);
	}	
}
