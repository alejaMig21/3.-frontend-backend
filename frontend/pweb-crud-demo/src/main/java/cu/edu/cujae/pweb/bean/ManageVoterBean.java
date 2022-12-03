package cu.edu.cujae.pweb.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
//import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.VoterDto;
import cu.edu.cujae.pweb.service.VoterService;
import cu.edu.cujae.pweb.utils.JsfUtils;


@Component
@ManagedBean
@ViewScoped
public class ManageVoterBean {

    private List<VoterDto> voters;
    private VoterDto selectedVoter;
    private String selectedCDRName;

    public String getSelectedCDRName() {
        return this.selectedCDRName;
    }

    public void setSelectedCDRName(String selectedCollegeName) {
        this.selectedCDRName = selectedCollegeName;
    }

    @Autowired
    private VoterService service;

    public ManageVoterBean() {

    }

    @PostConstruct
    public void init() {
        voters = service.getVoters();
    }

    public void openNew() {
        this.selectedVoter = new VoterDto();
    }

    public void openForEdit() {

    }

    public void saveCDR() {
        if (this.selectedVoter.getNumID() == 0) {
            service.createVoter(selectedVoter);

            JsfUtils.addInfoMessageFromBundle("message_inserted_voter");
        } else {
            service.updateVoter(selectedVoter);

            JsfUtils.addInfoMessageFromBundle("message_updated_voter");
        }

        voters = service.getVoters();

        PrimeFaces.current().executeScript("PF('manageVoterDialog').hide()");
        PrimeFaces.current().ajax().update("form:dt-voters");

    }

    public void deleteCDR() {

        service.deleteVoter(selectedVoter.getNumID());
        this.selectedVoter = null;

        voters = service.getVoters();

        JsfUtils.addInfoMessageFromBundle("message_deleted_voter");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-voters");

    }

    public List<VoterDto> getVoters() {
        return this.voters;
    }

    public void setVoters(List<VoterDto> voters) {
        this.voters = voters;
    }

    public VoterDto getSelectedVoter() {
        return this.selectedVoter;
    }

    public void setSelectedVoter(VoterDto selectedVoter) {
        this.selectedVoter = selectedVoter;
    }

    public VoterService getService() {
        return this.service;
    }

    public void setService(VoterService service) {
        this.service = service;
    }

}