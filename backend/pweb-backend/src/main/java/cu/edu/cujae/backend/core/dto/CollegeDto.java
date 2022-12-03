package cu.edu.cujae.backend.core.dto;

public class CollegeDto {
	
	private int id_college;
	private String nameCollege;
	private String address;
	private int district;

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

	public CollegeDto() {
		super();
	}

	public CollegeDto(int id_college, String name_college, String address, int district) {
		this.id_college = id_college;
		this.nameCollege = name_college;
		this.address = address;
		this.district = district;
	}
}