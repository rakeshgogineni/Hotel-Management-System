package com.riario.persistence;

import java.util.List;

import com.riario.model.Hotel;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * HotelDAO class used to fetch data from data base.
 *
 * @author hexware
 */
public interface HotelDAO {
  /**
   * @return the all the hotel record.
   */
  @SqlQuery("Select * from hotel_details")
  @Mapper(HotelMapper.class)
  List<Hotel> show();

  /**
   * @return the specific offer record by offerId.
   * @param hotelId to initisalize offerid
   */
  @SqlQuery("Select * from Hotel where hotel_id = :hotelId")
  @Mapper(HotelMapper.class)
  Hotel getHotelById(@Bind("hotelId") int hotelId);

  /**
   * InsertQuery1 to store part of insert query.
   */
  String INSERTQUERY1 = "insert into hotel_details (HOTEL_ID,HOTEL_NAME,ADDRESS,PHONE,NO_OF_ROOM, DESCRIPTION)";
  /**
   * InsertQuery2 to store part of insert query.
   */
  String INSERTQUERY2 = "values(:hotelId,:hotelName,:address,:phone,:noOfRoom,:description)";

  /**
   * @param hotelId     to initialize hotelId.
   * @param hotelName   to initialize hotelName.
   * @param address     to initialize address.
   * @param phone       to initialize phone.
   * @param noOfRoom    to initialize no_of_room.
   * @param description to initialize description.
   * @return to return inserted rows.
   */
  @SqlUpdate(INSERTQUERY1 + INSERTQUERY2)
  int insertHotel(@Bind("hotelId") int hotelId, @Bind("hotelName") String hotelName, @Bind("address") String address,
      @Bind("phone") Long phone, @Bind("noOfRoom") int noOfRoom, @Bind("description") String description);

  /**
   * @param hotelId to initialize hotelId.
   * @return the no of offer record deleted. used to get details through
   *         constructor.
   */
  @SqlUpdate(" DELETE FROM Hotel_details WHERE Hotel_ID = :hotelId")
  int deleteHotel(@Bind("hotelId") int hotelId);

  /**
   * @param hotelName to initialize hotelName.
   * @param noOfRoom  to initialize noOfRoom.
   * @return the no of offer record deleted. used to get details through
   *         constructor.
   */
  @SqlUpdate("UPDATE HOTEL_DETAILS SET  NO_OF_ROOM = :noOfRoom WHERE HOTEL_NAME = :hotelName")
  int updateHotel(@Bind("hotelName") String hotelName, @Bind("noOfRoom") int noOfRoom);

}
