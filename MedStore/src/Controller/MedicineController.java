package Controller;

import java.util.List;
import Model.Medicine;
import Model.MedicineData;

public class MedicineController {
    MedicineData medicineData = new MedicineData();   
	public List<Medicine> showMedicines() {
		return medicineData.listOfMedicines();
	}
	public Medicine RequiredMedicine(String medName){
		return medicineData.selectedMedicine(medName);	
	}
    public void addToCartList(Medicine medicine) {
	    medicineData.addMedicineToCart(medicine);  
	    }
    public List<Medicine> returnAddToCartList() {
 	    return medicineData.returnAddMedicineToCartList();
     }
    public void addToPurchaseList(Medicine medicine) {
    	medicineData.addMedicineToPurchaseList(medicine);
    }
    public List<Medicine> returnPurchaseList(){
    	return medicineData.returnPurchaseList();
    }
    public List<Medicine> removeParticularMedicineFromCart(String removeMedicine){
    	return medicineData.removeParticularMedicine(removeMedicine);
    }
  
    
}
