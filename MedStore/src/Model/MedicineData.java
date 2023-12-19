package Model;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MedicineData {
    List<Medicine> medicineList  = new ArrayList<Medicine>();
    List<Medicine> addToCartList = new ArrayList<Medicine>();
    List<Medicine> purchaseList  = new ArrayList<Medicine>();
        {
    try(Scanner scanner = new Scanner(Paths.get("medicineList.txt"))){
    	while(scanner.hasNext()) {
    		
    	String medicineDetails = scanner.nextLine();
    	String medicineDetailsArray []= medicineDetails.split(",");
    	
    	String medicineName = medicineDetailsArray[0];
    	String medicineCompany = medicineDetailsArray[1];
        String expiryDate = medicineDetailsArray[2];
        String availability = medicineDetailsArray[3];
        
        medicineList.add(new Medicine(medicineName,medicineCompany,expiryDate,availability));
        
      }
    	scanner.close();
    }
    catch(Exception exception) {
       exception.printStackTrace();
    }
   }
       
    public List<Medicine> listOfMedicines(){
    	return medicineList;
    }   
    public Medicine selectedMedicine(String medName) {
    	return medicineList.stream().filter(medicine->medicine.getMedicineName().equalsIgnoreCase(medName)).findAny().orElse(null);   	
    }
    public void addMedicineToCart(Medicine medicine) {
    	addToCartList.add(medicine);
    }
    public List<Medicine> returnAddMedicineToCartList() {
    	return addToCartList;
    }
    public void addMedicineToPurchaseList(Medicine medicine) {
    	purchaseList.add(medicine);
    }
    public List<Medicine> returnPurchaseList() {
   	    return purchaseList;
   }
   public List<Medicine> removeParticularMedicine(String removeMedicine) {
         return addToCartList.stream().filter(medicine->medicine.getMedicineName().equalsIgnoreCase(removeMedicine)==false).collect(Collectors.toList());
         
    }
   public void addNewMedicine(String medicineName, String medicineCompany, String expiryDate, String availability) {
	 medicineList.add(new Medicine(medicineName, medicineCompany, expiryDate, availability));
	 try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("medicineList.txt"));
			for (Medicine medicine: medicineList) {
             writer.write(medicine.toString());
             writer.newLine(); 
         }
			writer.close();
	}
	 catch (IOException ioException) {
		   ioException.printStackTrace();
		}	
   }
   
   
}
