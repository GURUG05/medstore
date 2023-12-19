package Model;

public class Medicine {
    String medicineName;
	String medicineCompany;
    String expiryDate;
    String availability;
    
	public Medicine(String medicineName, String medicineCompany, String expiryDate, String availability) {
		super();
		this.medicineName = medicineName;
		this.medicineCompany = medicineCompany;
		this.expiryDate = expiryDate;
		this.availability = availability;
	}

    public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getMedicineCompany() {
		return medicineCompany;
	}
	public void setMedicineCompany(String medicineCompany) {
		this.medicineCompany = medicineCompany;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	@Override
	public String toString() {
		return "MedicineName=" + medicineName + ", MedicineCompany=" + medicineCompany + ", ExpiryDate="
				+ expiryDate + ", Availability=" + availability ;
	}

    
}
