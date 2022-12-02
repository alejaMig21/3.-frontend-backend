package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.NominatedDto;

public interface NominatedService {
	List<NominatedDto> getNominateds();
	//NominatedDto getNominatedById(String userId);
	void createNominated(NominatedDto user);
	void updateNominated(NominatedDto user);
	void deleteNominated(String id);
}
