package View;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Model.Medicine;
import Model.MedicineData;
import Controller.AdminController;
import Controller.MedicineController;
import Controller.UserController;

public class HomePage {
   MedicineController medicineController = new MedicineController();
   MedicineData medicineData = new MedicineData();
   UserController userController = new UserController();
   AdminController adminController = new AdminController();
   Scanner scanner = new Scanner(System.in);
   List <Medicine>updatedList   =new ArrayList<Medicine>();  
   List <Medicine>checkoutList  =new ArrayList<Medicine>(); 
   List <Medicine>addToCartList =new ArrayList<Medicine>();
 
   int confirmation;
   int userConfirmation;
   int medicineViewMoreConfirmation;
   int unpurchasedConfirmation;
   int checkoutConfirmation;
   int quitConfirmation;
   int stripsRequired;
   int verify;
   int paymentOption;
   int quit;
   int adminOption;
   String medName;
   String removeMedicine;
   String confirmPurchase;
   String particularMedicine;
   public void userOrAdmin() {
	   System.out.println("Are you an : /n 1)User /n 2)Admin /n");
	   verify= scanner.nextInt();
	   scanner.nextLine();
	   if(verify==1) {
		   listOfMedicines();
	   }
	   else if(verify==2) {
		   adminLogin();
	   }
	   else {
		   userOrAdmin();
	   }
   }
   
public void listOfMedicines(){
	   System.out.println("Welcome to OnlineMedicineStore ! \n The list of medicines we currently have are :");
	   medicineController.showMedicines().stream().forEach(System.out::println); 
	   System.out.println("Enter the name of the medicine you require ?\n");
	   medName = scanner.nextLine(); 
	   
	   Medicine medicine = medicineController.RequiredMedicine(medName);   
	   if(medicine==null) {
		   System.err.println("The medicine is currently not available!!");
		   System.out.println("Check out the list of medicines in the homePage :");
		   listOfMedicines();
	   }
	   else {
	   System.out.println("The Medicinedetails and Availability that  we got on your required tablet are  :\n   " +  medicine);	  	   
	   System.out.println("Do you want to : \n 1) Purchase \n 2) addToCart");
	   confirmation = scanner.nextInt();
	   scanner.nextLine();   
	       if(confirmation==1) {
		        medicineController.addToPurchaseList(medicine);     
		        System.out.println("Required number of strips of tablet ?");
		        stripsRequired =   scanner.nextInt();
		        scanner.nextLine();
		        System.err.println("User Requirement : ");
		        System.out.println("MedicineName:"+ medName +"\n" + "NumberofStripsRequired :" + stripsRequired);
		        System.err.println("To confirm your purchase, click 'OK' ");
		        confirmPurchase = scanner.nextLine();	        
		        if(confirmPurchase.equalsIgnoreCase("OK")) {  
		        	purchase();
		        }	    		       
		        else{
		            System.out.println("Invalid Input!!!");
		            listOfMedicines();
		        }		        		       
	       }
	       else if(confirmation==2) {
		         medicineController.addToCartList(medicine);	       
		         System.out.println("Medicine succesfully added to cart ! \n 1) View more medicines  \n 2) View cart");
		         medicineViewMoreConfirmation = scanner.nextInt();
		         scanner.nextLine();	         
		         if(medicineViewMoreConfirmation==1) {		            	   
		        	  listOfMedicines();
		          }
		         else if(medicineViewMoreConfirmation==2){
		              System.out.println("The unpurchased medicines in your cart are : \n");
		              addToCartList = medicineController.returnAddToCartList().stream().collect(Collectors.toList());
		              System.out.println(addToCartList);
		              System.out.println("Do you want to : \n 1) CheckOutAll \n 2) RemoveParticularMedicineFromCart 3) CheckoutParticularMedicine");
		              unpurchasedConfirmation = scanner.nextInt();   
		              scanner.nextLine();              
		              if(unpurchasedConfirmation==1) { 
		            	  checkoutList = medicineController.returnAddToCartList();
		            	  checkoutAllFromCart(checkoutList);
		            	  purchase();
		              }
		              else if(unpurchasedConfirmation==2){	            	 
		            	  System.out.println("Which medicine you want to remove ?\n");
		            	  medicineController.returnAddToCartList().stream().forEach(System.out::println);
		            	  System.out.println("Enter the medicine to be removed from the Cart :");
		            	  removeMedicine = scanner.nextLine();     	  
		            	  System.out.println("The "+ removeMedicine + " is removed from the cart \n The updated Cart is :");
		                  updatedList = medicineController.removeParticularMedicineFromCart(removeMedicine);
		                  if(updatedList.size()==0) {
		                    System.err.println("THE CART IS EMPTY!!!  ");
		                    System.out.println("Returning to homepage ");
		                    listOfMedicines();
		                  }
		                  else {
		                  System.out.println(updatedList);
		                  System.out.println("Do you want to checkout all of these items ? \n 1) YES \n 2) NO");
		                  checkoutConfirmation= scanner.nextInt();
		                  scanner.nextLine();
		                      if(checkoutConfirmation==1) {  //should be changed to updated list 
		                    	  checkoutList = updatedList;
		                    	  checkoutAllFromCart(checkoutList);
		                         
		                      }
		                      else if(checkoutConfirmation==2) {
		                	      System.out.println("Okay would you like to return to homepage or quit the app ? \1)Homepage ");
		                	      System.err.println("2)QUIT");
		                	      quitConfirmation = scanner.nextInt();
		                	      scanner.nextLine();
		                	      if(quitConfirmation==1) {
		                	    	  addToCartList = updatedList;
		                	    	  listOfMedicines();
		                	      }
		                	      else {
		                	    	  System.err.println("Thank youuuuuuuu!");
		                	    	  System.exit(0);
		                	      }	                	      
		                      }
		                 }		            	   
		             }
		              else if(unpurchasedConfirmation==3) {
		            	  System.out.println("Checkout the particular medicine and leave the rest of the medicines for future checkouts ");
		            	  System.err.println("CHECKOUT LIST :");
		            	  System.out.println(addToCartList);
		            	  System.out.println("Enter the medicine you want to checkout now :");
		            	  particularMedicine = scanner.nextLine();
		            	  medicineController.returnAddToCartList().stream().filter(checkout->checkout.getMedicineName().equalsIgnoreCase(particularMedicine)).forEach(System.out::println);
		            	  System.out.println("confirm checkout: /n 1)yes /n 2) no");
		            	  int particularCheckout = scanner.nextInt();
		            	  if(particularCheckout==1) {
		            		  purchase();
		            	  }
		            	  else {
		            		  listOfMedicines();
		            	  }
		            	 
		            	  System.out.println("Now your cart contians :");
		            	  List<Medicine> remainingItemList =  medicineController.returnAddToCartList().stream().filter(checkout->checkout. getMedicineName().equalsIgnoreCase(particularMedicine)==false).collect(Collectors.toList());
						  checkoutList = remainingItemList;
						  System.out.println(checkoutList);		            	   		        		 
		              }
		              else {
		            	  System.out.println("Invalid Input !!!");
		              }
	       }
	       else {
	     	        
	    	     System.out.println("invalid input");
	       }
	   }
	  } 
   } 
     public  void checkoutAllFromCart(List<Medicine>checkoutlist) {
	    System.out.println("Are you sure you want to checkout all of these items from cart ?");
	    checkoutlist.stream().forEach(System.out::println);
	    System.err.println("Enter 'checkout' to confirm checkout");
	    String check =scanner.nextLine();
	    if(check.equalsIgnoreCase("checkout")) {
	    	purchase();
	    }
	    
     }
	public void purchase() {  	
    	System.out.println("1) Existing user ? \n 2) New user ?");
    	userConfirmation = scanner.nextInt();
    	scanner.nextLine();
    	
        if(userConfirmation == 1) {
    		login();
        }
        else if(userConfirmation==2) {
          register();
        }
    }
         
      public void register() {
      	System.out.println("Enter Name: ");
  		String name = scanner.nextLine();
  		 
  		System.out.println("Enter emaild: ");
  		String emailid = scanner.nextLine();
  		 		 
  		System.out.println("Enter Phoneno: ");
  		String phoneno = scanner.nextLine();
  		 		 
  		System.out.println("Enter Address: ");
  		String address = scanner.nextLine();
  	 
  		System.out.println("Enter password : ");
  		String password=scanner.nextLine();
          
  		userController.saveUser(name,address,emailid,phoneno,password);  		
  		login();
  	}

  
      public void login() {
    	System.out.println("Enter your username and password to login :");
  		System.out.println("Enter UserName: ");
  		String userName = scanner.nextLine();
  		
  		System.out.println("Enter password: ");
  		String userPassword=scanner.nextLine();
  		if(userController.verifyUser(userName,userPassword)) {
  			afterLogin();
  		}
  		else 
  		{
  			System.out.println("username is not available so please register your account");
  			register();
  		}
  	}

	public void afterLogin() {
		System.out.println("user credentials correct !");
		System.out.println("Confirm your order :");
		System.out.println("MedicineName:"+ medName +"\n" + "NumberofStripsRequired :" + stripsRequired);
		System.err.println("Total cost of the medicines :"+ Math.random());
		System.out.println("Choose the payment option\n 1)UPI 2)COD 3)Bank Transfer");
		paymentOption = scanner.nextInt();
		scanner.nextLine();
		if(paymentOption==1) {
			System.out.println("Paid! Order Placed");
		}
		else if(paymentOption==2) {
			System.out.println("Order Placed! Pay after receiving the order");
		}
		else if(paymentOption==3) {
			System.out.println("Paid ! Order Placed");
		}
		else {
			afterLogin();
		}
	System.out.println("1)Redirect to HomePage /n 2) Quit");
	    quit = scanner.nextInt();
	    scanner.nextLine();
	    if(quit==1) {
	    	listOfMedicines();
	    }
	    else if(quit==2) {
	    	System.out.println("Thankyouuu ! Visit our store again! ");
	    	System.exit(0);
	    }
		
	}
	 public void adminLogin() {
		    System.out.println("Admin name :");
		    String adminName = scanner.nextLine();
		    System.out.println("Admin password :");
		    String adminPassword = scanner.nextLine();
		   if(adminController.adminLogin(adminName, adminPassword)) {
			   System.out.println("Admin credentials correct! logged in !");
			   afterAdminLogin();
		   }
		   else {
			   System.out.println("Incorrect credetials ! Enter your details again:");
			   
		   }
		  }

	private void afterAdminLogin() {
		System.out.println("Welcome Admin \n what would you like to do ?\n 1)view medicines \n 2)add new medicine \n 3) delete medicines that are out of stock \n ");	
		adminOption = scanner.nextInt();
		scanner.nextLine();
		if(adminOption==1) {
			listOfMedicines();
		}
		else if(adminOption==2) {
			System.out.println("Enter medicine name:");
			String medicineName = scanner.nextLine();
			System.out.println("Enter medicine company name:");
			String medicineCompany = scanner.nextLine();
			System.out.println("Enter medicine expiry date:");
		    String expiryDate = scanner.nextLine();
		    System.out.println("Enter medicine availability:");
		    String availability = scanner.nextLine();
		    
		    adminController.addMedicine(medicineName,medicineCompany,expiryDate,availability);
		    System.out.println("Medicine added successfully!");
		    
		    
		}
	}

  }












