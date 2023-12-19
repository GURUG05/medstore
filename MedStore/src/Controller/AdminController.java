package Controller;
import Model.AdminData;
import Model.MedicineData;

public class AdminController {
    AdminData adminData = new AdminData();
    MedicineData medicineData = new MedicineData();
	public boolean adminLogin(String adminName, String adminPassword) {
		return adminData.verifyAdmin(adminName, adminPassword);
	}
	public void addMedicine(String medicineName, String medicineCompany, String expiryDate, String availability) {
	   medicineData.addNewMedicine(medicineName,medicineCompany,expiryDate,availability);		
	}

}
