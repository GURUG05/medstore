package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserData {

	ArrayList<User> userDetails= new ArrayList<>();
	{
//	storing the content of the file(userDetails.txt) into an ArrayList(userDetails)			
		try (Scanner scanner = new Scanner(Paths.get("UserDetails.txt"))){
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] arrayline=line.split(",");
				
				
				String Name=arrayline[0];
				String Address=arrayline[1];
				String Emailid=arrayline[2];
				String Phoneno=arrayline[3];
				String Password=arrayline[4];
			
				userDetails.add(new User(Name,Address,Emailid,Phoneno,Password));
		}
		}
			catch (IOException ioException) 
		{
				
				ioException.printStackTrace();
		}
	}
//	Adding the user in file and ArrayList when user register
	public boolean addUser(String name, String address, String emailid, String phoneno, String password) {
		userDetails.add(new User(name,address,emailid,phoneno,password));
		System.out.println("User Successfully Registered");	
		System.out.println(userDetails);
		try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("UserDetails.txt"));
				for (User user : userDetails) {
	                writer.write(user.toString());
	                writer.newLine(); // Add a new line after each User object
	            }
				writer.close();
				return true;
		}
		catch (IOException ioException) {
				
			   ioException.printStackTrace();
			   return false;
			}	
	 
	}
	public boolean checkUser(String name, String password) {
	    return  userDetails.stream().anyMatch(user->user.getName().equals(name)&&user.getPassword().equals(password));
	}
	

}
