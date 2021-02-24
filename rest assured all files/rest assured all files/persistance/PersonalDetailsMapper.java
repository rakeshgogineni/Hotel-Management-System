package com.hexaware.MLP269.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP269.model.PersonalDetails;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * PersonalDetailsMapper class used to fetch offer data from database.
 *
 * @author hexware
 */
public class PersonalDetailsMapper implements ResultSetMapper<PersonalDetails> {
  /**
   * @param index     the index
   * @param resultSet the resultset
   * @param ctx       the context
   * @return the mapped customer object
   * @throws SQLException in case there is an error in fetching data from the
   *                      resultset
   */
  public final PersonalDetails map(final int index, final ResultSet resultSet, final StatementContext ctx)
      throws SQLException {

    // Populate the values from database table
    int guestId = resultSet.getInt("guest_Id");
    String guestName = resultSet.getString("guest_Name");
    String address = resultSet.getString("address");
    long phoneNo = resultSet.getLong("phoneNo");
    String email = resultSet.getString("email");
    String username = resultSet.getString("username");
    String password = resultSet.getString("password");
    // Create an PersonalDetails instance
    // Guest guest = new Offer(offerId, offerName, offerValue);
    PersonalDetails personaldetails = new PersonalDetails();
    personaldetails.setGuestId(guestId);
    personaldetails.setGuestName(guestName);
    personaldetails.setAddress(address);
    personaldetails.setPhoneNo(phoneNo);
    personaldetails.setEmail(email);
    personaldetails.setUsername(username);
    personaldetails.setPassword(password);

    // retrun the guest instance
    return personaldetails;
  }
}
