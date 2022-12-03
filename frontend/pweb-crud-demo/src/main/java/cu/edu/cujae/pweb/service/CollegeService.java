package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.CollegeDto;

public interface CollegeService {
	List<CollegeDto> getColleges();
	CollegeDto getCollegeById(int id_college); // Originalmente era String
	void createCollege(CollegeDto cdr);
	void updateCollege(CollegeDto cdr);
	void deleteCollege(int id_college); // Originalmente era String
}
