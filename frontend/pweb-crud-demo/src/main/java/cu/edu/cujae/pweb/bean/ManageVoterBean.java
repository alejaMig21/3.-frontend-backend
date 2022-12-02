package cu.edu.cujae.pweb.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

//import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.CDRDto;
import cu.edu.cujae.pweb.dto.VoterDto;
import cu.edu.cujae.pweb.service.VoterService;
import cu.edu.cujae.pweb.utils.JsfUtils;


@Component //Le indica a spring es un componete registrado
@ManagedBean
@ViewScoped //Este es el alcance utilizado para trabajar con Ajax
public class ManageVoterBean {
	
//	private UserDto userDto;
//	private UserDto selectedUser;
//	private List<UserDto> users;
//	private Long[] selectedRoles;
	
	private VoterDto voterDto;
	

	private VoterDto selectedVoter;
	private List<VoterDto> voters;
	//hay que eliminar esta linea cuando se haga el CDR
	
//	private int numID;
//	private String namVot;
//	private String adressVot;
//	private Timestamp birthdayVot;
//	private int cdr;
//	private int vote;
//	private String cause;
//	private boolean newRecord;
	

	@Autowired
	private VoterService voterService;
	
	
	public ManageVoterBean() {
		
	}
	
	//Esta anotacioon permite que se ejecute code luego de haberse ejecuta el constructor de la clase. 
//	@PostConstruct
    public void init() {
    	voters = voters == null ? voterService.getVoters() : voters;
    }
	
	//Se ejecuta al dar clic en el button Nuevo
	public void openNew() {
        this.selectedVoter = new VoterDto();
    }
	
	//Se ejecuta al dar clic en el button con el lapicito
	public void openForEdit() {
		
	}
	
	//Se ejecuta al dar clic en el button dentro del dialog para salvar o registrar al usuario
	public void saveVoter() {
        if (this.selectedVoter.getNumID() == 0) {
            this.selectedVoter.setNumID(Integer.parseInt(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9)));
            this.selectedVoter.setNewRecord(true);
            
            this.voters.add(this.selectedVoter);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_nominated_added"); //Este code permite mostrar un mensaje exitoso (FacesMessage.SEVERITY_INFO) obteniendo el mensage desde el fichero de recursos, con la llave message_user_added
        }
        else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_nominated_edited");
        }

        PrimeFaces.current().executeScript("PF('manageVoterDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
        PrimeFaces.current().ajax().update("form:dt-voters");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
    }

	//Permite eliminar un usuario
    public void deleteVoter() {
    	try {
    		this.voters.remove(this.selectedVoter);
            this.selectedVoter = null;
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_voter_removed");
            PrimeFaces.current().ajax().update("form:dt-voters");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
		} catch (Exception e) {
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
		}
        
    }
    
    public VoterDto getVoterDto() {
		return voterDto;
	}

	public void setVoterDto(VoterDto voterDto) {
		this.voterDto = voterDto;
	}

	public VoterDto getSelectedVoter() {
		return selectedVoter;
	}

	public void setSelectedVoter(VoterDto selectedVoter) {
		this.selectedVoter = selectedVoter;
	}

	public List<VoterDto> getVoters() {
		return voters;
	}

	public void setVoters(List<VoterDto> voters) {
		this.voters = voters;
	}
	
//	public int getNumID() {
//		return numID;
//	}
//
//	public void setNumID(int numID) {
//		this.numID = numID;
//	}
//
//	public String getNamVot() {
//		return namVot;
//	}
//
//	public void setNamVot(String namVot) {
//		this.namVot = namVot;
//	}
//
//	public String getAdressVot() {
//		return adressVot;
//	}
//
//	public void setAdressVot(String adressVot) {
//		this.adressVot = adressVot;
//	}
//
//	public Timestamp getBirthdayVot() {
//		return birthdayVot;
//	}
//
//	public void setBirthdayVot(Timestamp birthdayVot) {
//		this.birthdayVot = birthdayVot;
//	}
//
//	public int getCdr() {
//		return cdr;
//	}
//
//	public void setCdr(int cdr) {
//		this.cdr = cdr;
//	}
//
//	public int getVote() {
//		return vote;
//	}
//
//	public void setVote(int vote) {
//		this.vote = vote;
//	}
//
//	public String getCause() {
//		return cause;
//	}
//
//	public void setCause(String cause) {
//		this.cause = cause;
//	}
//
//	public boolean isNewRecord() {
//		return newRecord;
//	}
//
//	public void setNewRecord(boolean newRecord) {
//		this.newRecord = newRecord;
//	}

	public VoterService getVoterService() {
		return voterService;
	}

	public void setVoterService(VoterService voterService) {
		this.voterService = voterService;
	}
	

}
