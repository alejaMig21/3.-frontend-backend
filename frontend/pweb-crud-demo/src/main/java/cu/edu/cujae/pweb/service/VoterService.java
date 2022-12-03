package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.VoterDto;

public interface VoterService {
	List<VoterDto> getVoters();
	VoterDto getVoterById(int userId);
	void createVoter(VoterDto user);
	void updateVoter(VoterDto user);
	void deleteVoter(int id);
}
