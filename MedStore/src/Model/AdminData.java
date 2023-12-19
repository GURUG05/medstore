package Model;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminData {
     List<Admin> adminList = new ArrayList<Admin>();
     {
     try(Scanner scanner = new Scanner(Paths.get("AdminDetails.txt"))){
    	 while(scanner.hasNext()) {
    		 String detailsArray = scanner.nextLine();
    		 String [] adminDetailLine = detailsArray.split(",");
    		 
    		  String adminName = adminDetailLine[0];
    		  String adminPassword = adminDetailLine[1];
    		  
    		  adminList.add(new Admin(adminName, adminPassword));
    	 }
     } catch (IOException e) {
		e.printStackTrace();
	 }
     
   }
     public boolean verifyAdmin(String adminName, String adminPassword) {
	    return adminList.stream().anyMatch(admin->admin.getAdminName().equals(adminName)&& admin.getAdminPassword().equals(adminPassword));
	}

  
}
