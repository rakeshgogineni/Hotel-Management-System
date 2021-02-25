package com.riario.persistence;

import java.util.List;

import com.riario.model.PersonalDetails;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * PersonalDetailsDAO class used to fetch data from data base.
 *
 * @author hexware
 */
public interface PersonalDetailsDAO {
  /**
   * @return the all the personaldetails record.
   */
  @SqlQuery("Select * from PERSONAL_DETAILS")
  @Mapper(PersonalDetailsMapper.class)
  List<PersonalDetails> show();

  /**
   * @return the specific offer record by offerId.
   * @param guestId to initisalize offerid
   */
  @SqlQuery("Select * from Personal_Details where guest_Id = :guestId")
  @Mapper(PersonalDetailsMapper.class)
  PersonalDetails getGuestById(@Bind("guestId") int guestId);

  /**
   * InsertQuery1 to store part of insert query.
   */
  String INSERTQUERY1 = "insert into Personal_Details (guest_Id,guest_Name,address,phoneNo,email,username,password)";
  /**
   * InsertQuery2 to store part of insert query.
   */
  String INSERTQUERY2 = "values(:guestId,:guestName,:address,:phoneNo,:email,:username,:password)";

  /**
   * @param guestId   to initialize guestId.
   * @param guestName to initialize guestName.
   * @param address   to initialize address.
   * @param phoneNo   to initialize phoneNo.
   * @param email     to initialize email.
   * @param username  to initialize username.
   * @param password  to initialize password.
   * @return the no of updated guest record. used to get details through
   *         constructor.
   */

  @SqlUpdate(INSERTQUERY1 + INSERTQUERY2)
  int insertPersonalDetails(@Bind("guestId") int guestId, @Bind("guestName") String guestName,
      @Bind("address") String address, @Bind("phoneNo") Long phoneNo, @Bind("email") String email,
      @Bind("username") String username, @Bind("password") String password);

  /**
   * @param guestId to initialize guestId.
   * @return the no of personaldetails record deleted. used to get details through
   *         constructor.
   */
  @SqlUpdate(" Delete from Personal_Details where guest_Id = :guestId")
  int deletePersonalDetails(@Bind("guestId") int guestId);

  /**
   * updateQuery1 to store part of update query.
   */
  String UPDATEQUERY1 = "Update Personal_Details set address = :address,phoneNo = :phoneNo ";

  /**
   * updateQuery2 to store part of update query.
   */
  String UPDATEQUERY2 = "where guest_Id = :guestId";

  /**
   * @param guestId to initialize guestId.
   * @param address to initialize address.
   * @param phoneNo to initialize phoneNo.
   * @return the no of updated offer record. used to get details through
   *         constructor.
   */
  @SqlUpdate(UPDATEQUERY1 + UPDATEQUERY2)
  int updatePersonalDetails(@Bind("guestId") int guestId, @Bind("address") String address,
      @Bind("phoneNo") Long phoneNo);

}

