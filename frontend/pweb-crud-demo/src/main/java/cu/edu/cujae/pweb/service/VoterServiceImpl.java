package cu.edu.cujae.pweb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import cu.edu.cujae.pweb.dto.VoterDto;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;

@Service
public class VoterServiceImpl implements VoterService{

	@Autowired
	private RestService restService;

	@Override
	public List<VoterDto> getVoters() {
		
		List<VoterDto> cdrList = new ArrayList<VoterDto>();
	    try {
	    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<VoterDto> apiRestMapper = new ApiRestMapper<>();
		    String response = (String)restService.GET("/api/v1/voters/", params, String.class).getBody();
		    cdrList = apiRestMapper.mapList(response, VoterDto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cdrList;
	}

	// @Override
	// public CDRDto getCDRById(int userId) { // Originalmente era String
	// 	return getCDRs().stream().filter(r -> r.getId().equals(userId)).findFirst().get();
	// }

	@Override
    public VoterDto getVoterById(int idVoter) {
        VoterDto cdr = null;

        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<VoterDto> apiRestMapper = new ApiRestMapper<>();

            UriTemplate template = new UriTemplate("/api/v1/voters/" + "{idVoter}");
            String uri = template.expand(idVoter).toString();
            String response = (String) restService.GET(uri, params, String.class).getBody();
            cdr = apiRestMapper.mapOne(response, VoterDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cdr;
    }

	@Override
	public void createVoter(VoterDto voter) {
		// TODO Auto-generated method stub
		restService.POST("/api/v1/voters/" + "", voter, String.class).getBody();
	}

	@Override
	public void updateVoter(VoterDto voter) {
		// TODO Auto-generated method stub
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        restService.PUT("/api/v1/voters/" + "", params, voter, String.class).getBody();
	}

	@Override
	public void deleteVoter(int idVoter) { // Originalmente era String
		// TODO Auto-generated method stub
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        UriTemplate template = new UriTemplate("/api/v1/voters/" + "{idVoter}");
        String uri = template.expand(idVoter).toString();
        restService.DELETE(uri, params, String.class, null).getBody();
	}
	
}