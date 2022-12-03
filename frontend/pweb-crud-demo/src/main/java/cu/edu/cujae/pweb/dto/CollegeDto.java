package cu.edu.cujae.pweb.dto;

//import java.util.ArrayList;

public class CollegeDto {
	
	private int id_college;
	private String nameCollege;
	private String address;
	private int district;
	private boolean newRecord;

	public int getId_college() {
		return this.id_college;
	}

	public void setId_college(int id_college) {
		this.id_college = id_college;
	}

	public String getNameCollege() {
		return this.nameCollege;
	}

	public void setNameCollege(String name_college) {
		this.nameCollege = name_college;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDistrict() {
		return this.district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	public boolean isNewRecord() {
		return this.newRecord;
	}

	public boolean getNewRecord() {
		return this.newRecord;
	}

	public void setNewRecord(boolean newRecord) {
		this.newRecord = newRecord;
	}

	public CollegeDto() {
		super();
	}

	public CollegeDto(int id_college, String name_college, String address, int district, boolean newRecord) {
		this.id_college = id_college;
		this.nameCollege = name_college;
		this.address = address;
		this.district = district;
		this.newRecord = newRecord;
	}
}