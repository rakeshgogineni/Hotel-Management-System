package com.hexaware.MLP269.factory;

import java.util.List;

import com.hexaware.MLP269.model.PersonalDetails;
import com.hexaware.MLP269.persistence.DbConnection;
import com.hexaware.MLP269.persistence.PersonalDetailsDAO;

/**
 * GuestFactory class used to fetch offer data from database.
 * @author hexware
 */
public class PersonalDetailsFactory {
  /**
   * Protected constructor.
   */
  protected PersonalDetailsFactory() {

  }

  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static PersonalDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(PersonalDetailsDAO.class);
  }

  /**
   * Call the data base connection.
   * @return the connection object.
   */
  public static List<PersonalDetails> showPersonalDetails() {
    PersonalDetailsDAO personaldetailsDAO = dao();
    return personaldetailsDAO.show();
  }
  /**
   * @param guestId to initialize the guest.
   * @return the guest object.
   */
  public static PersonalDetails getGuestById(final int guestId) {
    return dao().getGuestById(guestId);
  }

  /**
   * Call the data base connection.
   * @param personaldetails to initialize personaldetails.
   * @return the connection object.
   */

  public static int insertPersonalDetails(final PersonalDetails personaldetails) {
    PersonalDetailsDAO personaldetailsDAO = dao();
    int guestId = personaldetails.getGuestId();
    String guestName = personaldetails.getGuestName();
    String address = personaldetails.getAddress();
    Long phoneNo = personaldetails.getPhoneNo();
    String email = personaldetails.getEmail();
    String username = personaldetails.getUsername();
    String password = personaldetails.getPassword();
    int rowsInserted = personaldetailsDAO.insertPersonalDetails(guestId, guestName, address, phoneNo, email, username,
        password);
    return rowsInserted;
  }

  /**
   * Call the data base connection.
   * @param guestId to initialize guest.
   * @return the connection object.
   */

  public static int deletePersonalDetails(final int guestId) {
    PersonalDetailsDAO personaldetailsDAO = dao();
    return personaldetailsDAO.deletePersonalDetails(guestId);
  }

  /**
   * Call the data base connection.
   * @param personaldetails to initialize personaldetails.t.com
   * @return the connection object.
   */

  public static int updatePersonalDetails(final PersonalDetails personaldetails) {
    PersonalDetailsDAO personaldetailsDAO = dao();
    int guestId = personaldetails.getGuestId();
    String address = personaldetails.getAddress();
    Long phoneNo = personaldetails.getPhoneNo();
    int rowsUpdated = personaldetailsDAO.updatePersonalDetails(guestId, address, phoneNo);
    return rowsUpdated;
  }
}


