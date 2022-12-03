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

import cu.edu.cujae.pweb.dto.NominatedDto;
import cu.edu.cujae.pweb.service.NominatedService;
import cu.edu.cujae.pweb.utils.JsfUtils;

@Component
@ManagedBean
@ViewScoped
public class ManageNominatedBean {

    private List<NominatedDto> nominateds;
    private NominatedDto selectedNominated;
    private String selectedMunicipalityName;
    
    public void setNominateds(List<NominatedDto> nominateds) {
        this.nominateds = nominateds;
    }

    public String getSelectedMunicipalityName() {
        return this.selectedMunicipalityName;
    }

    public void setSelectedMunicipalityName(String selectedMunicipalityName) {
        this.selectedMunicipalityName = selectedMunicipalityName;
    }

    @Autowired
    private NominatedService service;

    public ManageNominatedBean() {

    }

    @PostConstruct
    public void init() {
        nominateds = service.getNominateds();
    }

    public void openNew() {
        this.selectedNominated = new NominatedDto();
    }

    public void openForEdit() {

    }

    public void saveNominated() {
        if (this.selectedNominated.getIdNominated() == 0) {
            service.createNominated(selectedNominated);

            JsfUtils.addInfoMessageFromBundle("message_inserted_nominated");
        } else {
            service.updateNominated(selectedNominated);

            JsfUtils.addInfoMessageFromBundle("message_updated_nominated");
        }

        nominateds = service.getNominateds();

        PrimeFaces.current().executeScript("PF('manageNominatedDialog').hide()");
        PrimeFaces.current().ajax().update("form:dt-nominateds");

    }

    public void deleteNominated() {

        service.deleteNominated(selectedNominated.getIdNominated());
        this.selectedNominated = null;

        nominateds = service.getNominateds();

        JsfUtils.addInfoMessageFromBundle("message_deleted_nominated");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-nominateds");

    }

    public List<NominatedDto> getNominateds() {
        return this.nominateds;
    }

    public void setCdrs(List<NominatedDto> nominateds) {
        this.nominateds = nominateds;
    }

    public NominatedDto getSelectedNominated() {
        return this.selectedNominated;
    }

    public void setSelectedNominated(NominatedDto selectedNominated) {
        this.selectedNominated = selectedNominated;
    }

    public NominatedService getService() {
        return this.service;
    }

    public void setService(NominatedService service) {
        this.service = service;
    }

}