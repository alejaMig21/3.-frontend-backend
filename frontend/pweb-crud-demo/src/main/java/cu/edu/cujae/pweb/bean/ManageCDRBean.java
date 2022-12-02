package cu.edu.cujae.pweb.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.CDRDto;
import cu.edu.cujae.pweb.service.CDRService;
import cu.edu.cujae.pweb.utils.JsfUtils;


// @Component //Le indica a spring es un componete registrado
// @ManagedBean
// @ViewScoped //Este es el alcance utilizado para trabajar con Ajax
// public class ManageCDRBean {
	
// 	private CDRDto CDRDto;
// 	private CDRDto selectedCDR;
// 	private List<CDRDto> cdrs;
	
// 	@Autowired
// 	private CDRService CDRService;
	
	
// 	public ManageCDRBean() {
		
// 	}
	
// 	//Esta anotacioon permite que se ejecute code luego de haberse ejecuta el constructor de la clase. 
// 	@PostConstruct
//     public void init() {
//     	cdrs = cdrs == null ? CDRService.getCDRs() : cdrs;
//     }
	
// 	//Se ejecuta al dar clic en el button Nuevo
// 	public void openNew() {
//         this.selectedCDR = new CDRDto();
//     }
	
// 	//Se ejecuta al dar clic en el button con el lapicito
// 	public void openForEdit() {
		
// 	}
	
// 	//Se ejecuta al dar clic en el button dentro del dialog para salvar o registrar al usuario
// 	public void saveCDR() {
//         if (this.selectedCDR.getCodCDR() == 0) {
//             this.selectedCDR.setCodCDR(Integer.parseInt(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9)));
//             this.selectedCDR.setNewRecord(true);
            
//             this.cdrs.add(this.selectedCDR);
//             JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_cdr_added"); //Este code permite mostrar un mensaje exitoso (FacesMessage.SEVERITY_INFO) obteniendo el mensage desde el fichero de recursos, con la llave message_user_added
//         }
//         else {
//             JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_cdr_edited");
//         }

//         PrimeFaces.current().executeScript("PF('manageCDRDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
//         PrimeFaces.current().ajax().update("form:dt-cdrs");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
//     }

// 	//Permite eliminar un usuario
//     public void deleteCDR() {
//     	try {
//     		this.cdrs.remove(this.selectedCDR);
//             this.selectedCDR = null;
//             JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_cdr_removed");
//             PrimeFaces.current().ajax().update("form:dt-cdrs");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
// 		} catch (Exception e) {
// 			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
// 		}
        
//     }
    
//     public CDRDto getCDRDto() {
// 		return CDRDto;
// 	}

// 	public void setCDRDto(CDRDto cDRDto) {
// 		CDRDto = cDRDto;
// 	}

// 	public CDRDto getSelectedCDR() {
// 		return selectedCDR;
// 	}

// 	public void setSelectedCDR(CDRDto selectedCDR) {
// 		this.selectedCDR = selectedCDR;
// 	}

// 	public List<CDRDto> getCdrs() {
// 		return cdrs;
// 	}

// 	public void setCdrs(List<CDRDto> cdrs) {
// 		this.cdrs = cdrs;
// 	}

// 	public CDRService getCDRService() {
// 		return CDRService;
// 	}

// 	public void setCDRService(CDRService cDRService) {
// 		CDRService = cDRService;
// 	}

// }



///------------------------------------------------------------------------------------
@Component
@ManagedBean
@ViewScoped
public class ManageCDRBean {

    private List<CDRDto> cdrs;
    private CDRDto selectedCDR;

    @Autowired
    private CDRService service;

    public ManageCDRBean() {

    }

    @PostConstruct
    public void init() {
        cdrs = service.getCDRs();
    }

    public void openNew() {
        this.selectedCDR = new CDRDto();
    }

    public void openForEdit() {

    }

    public void saveCDR() {
        if (this.selectedCDR.getCodCDR() == 0) {
            service.createCDR(selectedCDR);

            JsfUtils.addInfoMessageFromBundle("message_inserted_cdr");
        } else {
            service.updateCDR(selectedCDR);

            JsfUtils.addInfoMessageFromBundle("message_updated_cdr");
        }

        cdrs = service.getCDRs();

        PrimeFaces.current().executeScript("PF('manageCDRDialog').hide()");
        PrimeFaces.current().ajax().update("form:dt-cdrs");

    }

    public void deleteCDR() {

        service.deleteCDR(selectedCDR.getCodCDR());
        this.selectedCDR = null;

        cdrs = service.getCDRs();

        JsfUtils.addInfoMessageFromBundle("message_deleted_cdr");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-cdrs");

    }

    public List<CDRDto> getCDRs() {
        return this.cdrs;
    }

    public void setCDRs(List<CDRDto> cdrs) {
        this.cdrs = cdrs;
    }

    public CDRDto getSelectedCDR() {
        return this.selectedCDR;
    }

    public void setSelectedCDR(CDRDto selectedCDR) {
        this.selectedCDR = selectedCDR;
    }

    public CDRService getService() {
        return this.service;
    }

    public void setService(CDRService service) {
        this.service = service;
    }

}