package cu.edu.cujae.backend.core.dto;

import java.time.LocalDate;
import java.sql.Date;
import java.sql.Timestamp;

public class VoterDto {

  private int numID;
  private String namVot;
  private String addressVot;
  private Date birthdayVot;
  private int cdr;
  private int vote;
  private String cause;

  public VoterDto() {
    super();
  }

  public VoterDto(int numID, String namVot, String addressVot, 
    Date birthdayVot, int cdr, int vote, String cause) {
    super();
    this.numID = numID;
    this.namVot = namVot;
    this.addressVot = addressVot;
    this.birthdayVot = birthdayVot;
    this.cdr = cdr;
    this.vote = vote;
    this.cause = cause;
  }

  public String getCause() {
    return cause;
  }

  public void setCause(String cause) {
    this.cause = cause;
  }

  public int getVote() {
    return vote;
  }

  public void setVote(int vote) {
    this.vote = vote;
  }

  public int getCdr() {
    return cdr;
  }

  public void setCdr(int cdr) {
    this.cdr = cdr;
  }

  public int getNumID() {
    return numID;
  }

  public void setNumID(int numID) {
    this.numID = numID;
  }

  public String getNamVot() {
    return namVot;
  }

  public void setNamVot(String namVot) {
    this.namVot = namVot;
  }

  public String getAddressVot() {
    return addressVot;
  }

  public void setAddressVot(String adrVot) {
    this.addressVot = adrVot;
  }

  // public LocalDate getBirthdayVot() {
  // return birthdayVot_.toLocalDateTime().toLocalDate();
  // }

  public Date getBirthdayVot() {
    return birthdayVot;
  }

  public void setBirthdayVot(Date dateVot) {
    this.birthdayVot = dateVot;
  }

}