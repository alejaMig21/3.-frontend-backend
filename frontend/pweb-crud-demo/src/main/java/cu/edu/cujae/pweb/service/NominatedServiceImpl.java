package cu.edu.cujae.pweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.cujae.pweb.dto.NominatedDto;
import cu.edu.cujae.pweb.dto.RoleDto;

/* Esta anotiacioon le indica a spring que esta clase es un servicio y por tanto luego podr� inyectarse en otro lugar usando
 * @Autowired. En estas implementaciones luego se pondraan las llamadas al proyecto backend
 */
@Service
public class NominatedServiceImpl implements NominatedService{

	@Override
	public List<NominatedDto> getNominateds() {
		
		List<NominatedDto> nominateds = new ArrayList<>();
//		nominateds.add(new NominatedDto(, , , , , , , ));
//		nominateds.add(new NominatedDto(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "psuarez", "Perseo Suarez Tamyo", "sdfsd545", "psuarez@email.com", "69852147856", adminRole, false));
//		nominateds.add(new NominatedDto(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "scamejo", "Sandor Camejo Rayas", "343fsdfddds", "scamejo@email.com", "54785698547", adminRole, false));
//		nominateds.add(new NominatedDto(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "rcoas", "Ronaldo Coas Saldivar", "2w2ee22ww2", "rcoas@email.com", "36985214785", adminRole, false));
//		nominateds.add(new NominatedDto(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "hribas", "Hector Ribas Traki", "wwew443ewe", "hribas@email.com", "23698547852", adminRole, false));
//		nominateds.add(new NominatedDto(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "cestrada", "Camilo Estrada Lopez", "34hjhj3343k", "cestrada@email.com", "23698547412", adminRole, false));
//		nominateds.add(new NominatedDto(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "fromero", "Facundo Romero Ramen", "3www4ewwewe", "fromero@email.com", "85669854125", asesorRole, false));
//		nominateds.add(new NominatedDto(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "ptobal", "P�nfilo Tobal Madrid", "343sd3443wwe", "ptobal@email.com", "25147856325", asesorRole, false));
//		nominateds.add(new NominatedDto(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "imeri�o", "Ian Meri�o Sandival", "4weer4ewere", "imeri�o@email.com", "21254789632", allRoles, false));
//		nominateds.add(new NominatedDto(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "jpacheco", "Javier Pacheco Losada", "8555weweww", "jpacheco@email.com", "96582365147", allRoles, false));
		
		return nominateds;
	}

//	@Override
//	public NominatedDto getNominatedById(String userId) {
//		return getNominateds().stream().filter(r -> r.getId().equals(userId)).findFirst().get();
//	}

	@Override
	public void createNominated(NominatedDto user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNominated(NominatedDto user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNominated(String id) {
		// TODO Auto-generated method stub
		
	}
	
}
