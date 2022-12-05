package cu.edu.cujae.backend.service;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.tomcat.websocket.server.UriTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import cu.edu.cujae.backend.core.dto.VoterDto;
import cu.edu.cujae.backend.core.service.VoterService;

@Service
public class VoterServiceImpl implements VoterService {

   @Autowired
   private JdbcTemplate jdbcTemplate;

   public VoterDto createNewDto(ResultSet resultSet) throws SQLException {
      int numID = resultSet.getInt(1);
      String namVot = resultSet.getString(2); 
      String addressVot = resultSet.getString(4);
      /*Local*/Date birthdayVot = resultSet.getDate(3)/*.toLocalDate()*/;
      String cause = resultSet.getString(5);
      int cdr = resultSet.getInt(6);
      int vote = resultSet.getInt(7);  	

      return new VoterDto(numID, namVot, addressVot, birthdayVot, cdr, vote, cause);
   }

   @Override
   public List<VoterDto> listVoters() throws SQLException { // Aparentemente esta funcion ya esta
      List<VoterDto> list = new ArrayList<>();

      //String function = "{?= call select_all_nominateds()}";
      //String function = "{?= call SELECT * FROM voters}";
      String function = "{?= call read_list_voter()}";

      Connection connection = jdbcTemplate.getDataSource().getConnection();
      connection.setAutoCommit(false);
      CallableStatement statement = connection.prepareCall(function);
      statement.registerOutParameter(1, Types.OTHER);
      statement.execute();

      ResultSet resultSet = (ResultSet) statement.getObject(1);

      while (resultSet.next()) {
         VoterDto dto = createNewDto(resultSet);
         list.add(dto);
      }

      return list;
   }

   @Override
   public VoterDto getVoterById(int voterId) throws SQLException {
	   VoterDto voter = null;

      PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(
                "SELECT * FROM voter where id_voter = ?");

      pstmt.setInt(1, voterId);

      ResultSet resultSet = pstmt.executeQuery();

      while (resultSet.next()) {
         voter = createNewDto(resultSet);
      }

      return voter;
   }

   @Override
   public void createVoter(VoterDto voter) throws SQLException { // Originalmente aqui no se creaba el ID
        String function = "{call create_voter_(?,?,?,?)}";

        CallableStatement statement = jdbcTemplate.getDataSource().getConnection().prepareCall(function);
        statement.setString(1, voter.getNamVot());
        statement.setDate(2, voter.getBirthdayVot());
        statement.setString(3, voter.getAddressVot());
        statement.setInt(4, voter.getCdr());
        statement.execute();
   }

  @Override
  public void updateVoter(VoterDto voter) throws SQLException { // Originalmente este metodo actualizaba ademas de los valores del Dto su ID tambien
     String function = "{call update_voter(?,?,?,?,?)}";

     CallableStatement statement = jdbcTemplate.getDataSource().getConnection().prepareCall(function);
     statement.setInt(1, voter.getNumID());
     statement.setString(2, voter.getNamVot());     
     statement.setDate(3, voter.getBirthdayVot());
     statement.setString(4, voter.getAddressVot());
     statement.setInt(5, voter.getCdr());
     statement.execute();

  }

   @Override
   public void deleteVoter(int voterId) throws SQLException {
      String function = "{call delete_voter(?)}";

      CallableStatement statement = jdbcTemplate.getDataSource().getConnection().prepareCall(function);
      statement.setInt(1, voterId);
      statement.execute();

   }

   @Override
   public int getIdByName(String voterName) throws SQLException {
      VoterDto voter = null;

      try (Connection connection = jdbcTemplate.getDataSource().getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT * FROM voter where name = ?");

            pstmt.setString(1, voterName);

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                int id_voter = resultSet.getInt(1);

                voter = new VoterDto();
                voter.setNumID(id_voter);
            }
      }

      return voter.getNumID();
   }
}