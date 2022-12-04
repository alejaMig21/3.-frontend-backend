package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.NominatedDto;

public interface NominatedService {
	List<NominatedDto> getNominateds();
	NominatedDto getNominatedById(int idNominated);
	int getIdByName(String nameNominated);
	void createNominated(NominatedDto nominated);
	void updateNominated(NominatedDto nominated);
	void deleteNominated(int idNominated);
}
