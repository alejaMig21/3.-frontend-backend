package cu.edu.cujae.pweb.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.NominatedDto;
import cu.edu.cujae.pweb.dto.RoleDto;
import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.service.NominatedService;
import cu.edu.cujae.pweb.service.RoleService;
import cu.edu.cujae.pweb.service.UserService;
import cu.edu.cujae.pweb.utils.JsfUtils;


@Component //Le indica a spring es un componete registrado
@ManagedBean
@ViewScoped //Este es el alcance utilizado para trabajar con Ajax
public class ManageNominatedBean {
	
	private NominatedDto nominatedDto;
	

	private NominatedDto selectedNominated;
	private List<NominatedDto> nominateds;
//	private String ocupNomi;
//	private String profeNomi;
//	private String phoneNomi;
//	private String intgRNomi;
//	private String biogDataNomi;
//	private int idNominated; 
//	private int idVoter; 
//	private int processE;
//	private int cantVotes;
	
	@Autowired
	private NominatedService nominatedService;
	
	
	public ManageNominatedBean() {
		
	}
	
	//Esta anotacioon permite que se ejecute code luego de haberse ejecuta el constructor de la clase. 
//	@PostConstruct
    public void init() {
    	nominateds = nominateds == null ? nominatedService.getNominateds() : nominateds;
    }
	
	//Se ejecuta al dar clic en el button Nuevo
	public void openNew() {
        this.selectedNominated = new NominatedDto();
    }
	
	//Se ejecuta al dar clic en el button con el lapicito
	public void openForEdit() {
		
	}
	
	//Se ejecuta al dar clic en el button dentro del dialog para salvar o registrar al usuario
	public void saveNominated() {
        if (((Integer)this.selectedNominated.getIdNominated()).toString() == null) {
            this.selectedNominated.setIdNominated(Integer.parseInt(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9)));
            this.selectedNominated.setNewRecord(true);
            
            this.nominateds.add(this.selectedNominated);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_nominated_added"); //Este code permite mostrar un mensaje exitoso (FacesMessage.SEVERITY_INFO) obteniendo el mensage desde el fichero de recursos, con la llave message_user_added
        }
        else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_nominated_edited");
        }

        PrimeFaces.current().executeScript("PF('manageNominatedDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
        PrimeFaces.current().ajax().update("form:dt-nominateds");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
    }

	//Permite eliminar un usuario
    public void deleteNominated() {
    	try {
    		this.nominateds.remove(this.selectedNominated);
            this.selectedNominated = null;
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_nominated_removed");
            PrimeFaces.current().ajax().update("form:dt-nominateds");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
		} catch (Exception e) {
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
		}
        
    }
    
    public NominatedDto getNominatedDto() {
		return nominatedDto;
	}

	public void setNominatedDto(NominatedDto nominatedDto) {
		this.nominatedDto = nominatedDto;
	}

	public NominatedDto getSelectedNominated() {
		return selectedNominated;
	}

	public void setSelectedNominated(NominatedDto selectedNominated) {
		this.selectedNominated = selectedNominated;
	}

	public List<NominatedDto> getNominateds() {
		return nominateds;
	}

	public void setNominateds(List<NominatedDto> nominateds) {
		this.nominateds = nominateds;
	}

//	public String getOcupNomi() {
//		return ocupNomi;
//	}
//
//	public void setOcupNomi(String ocupNomi) {
//		this.ocupNomi = ocupNomi;
//	}
//
//	public String getProfeNomi() {
//		return profeNomi;
//	}
//
//	public void setProfeNomi(String profeNomi) {
//		this.profeNomi = profeNomi;
//	}
//
//	public String getPhoneNomi() {
//		return phoneNomi;
//	}
//
//	public void setPhoneNomi(String phoneNomi) {
//		this.phoneNomi = phoneNomi;
//	}
//
//	public String getIntgRNomi() {
//		return intgRNomi;
//	}
//
//	public void setIntgRNomi(String intgRNomi) {
//		this.intgRNomi = intgRNomi;
//	}
//
//	public String getBiogDataNomi() {
//		return biogDataNomi;
//	}
//
//	public void setBiogDataNomi(String biogDataNomi) {
//		this.biogDataNomi = biogDataNomi;
//	}
//
//	public int getIdNominated() {
//		return idNominated;
//	}
//
//	public void setIdNominated(int idNominated) {
//		this.idNominated = idNominated;
//	}
//
//	public int getIdVoter() {
//		return idVoter;
//	}
//
//	public void setIdVoter(int idVoter) {
//		this.idVoter = idVoter;
//	}
//
//	public int getProcessE() {
//		return processE;
//	}
//
//	public void setProcessE(int processE) {
//		this.processE = processE;
//	}
//
//	public int getCantVotes() {
//		return cantVotes;
//	}
//
//	public void setCantVotes(int cantVotes) {
//		this.cantVotes = cantVotes;
//	}
//
//	public NominatedService getNominatedService() {
//		return nominatedService;
//	}
//
//	public void setNominatedService(NominatedService nominatedService) {
//		this.nominatedService = nominatedService;
//	}

}
