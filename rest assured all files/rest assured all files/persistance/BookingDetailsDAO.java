package com.hexaware.MLP269.persistence;

import java.util.List;

import com.hexaware.MLP269.model.BookingDetails;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * BookingDetailsDAO class used to fetch data from data base.
 *
 * @author hexware
 */
public interface BookingDetailsDAO {
  /**
   * @return the all the hotel record.
   */
  @SqlQuery("SELECT * FROM BOOKING_DETAILS")
  @Mapper(BookingDetailsMapper.class)
  List<BookingDetails> show();

  /**
   * @return the specific offer record by offerId.
   * @param bookingId to initisalize offerid
   */
  @SqlQuery("Select * from Booking_Details where booking_id = :bookingId")
  @Mapper(BookingDetailsMapper.class)
  BookingDetails getBookingDetailsById(@Bind("bookingId") int bookingId);

  /**
   * InsertQuery to store part of insert query.
   */
  String INSERTQUERY = "insert into BOOKING_DETAILS ";
  /**
   * InsertQuery1 to store part of insert query.
   */
  String INSERTQUERY1 = "(GUEST_ID, HOTEL_ID,ROOM_ID,Booking_ID, CHECKIN_DATE, CHECKOUT_DATE,";
  /**
   * InsertQuery2 to store part of insert query.
   */
  String INSERTQUERY2 = "AMOUNT_PAID,  AMOUNT_PENDING, STATUS)";
  /**
   * InsertQuery3 to store part of insert query.
   */
  String INSERTQUERY3 = "values(:guestId,:hotelId,:roomId,:bookingId,:checkinDate,:checkoutDate,";
  /**
   * InsertQuery4 to store part of insert query.
   */
  String INSERTQUERY4 = ":amountPaid,:amountPending,:status)";

  /**
   * @return to return inserted rows.
   * @param bookingDetails for booking details
   */
  @SqlUpdate(INSERTQUERY + INSERTQUERY1 + INSERTQUERY2 + INSERTQUERY3 + INSERTQUERY4)
  int insertBookingDetails(@BindBean BookingDetails bookingDetails);

  /**
   * @return to return deleted rows.
   * @param bookingId to initialize bookingId
   */
  @SqlUpdate("Delete from Booking_Details where booking_Id = :bookingId")
  int deleteBookingId(@Bind("bookingId") int bookingId);

  /**
   * @param status    to initialize status.
   * @param bookingId to initialize bookingid.
   * @return the no of offer record deleted. used to get details through
   *         constructor.
   */
  @SqlUpdate("UPDATE Booking_Details SET  status = :status WHERE booking_Id = :bookingId")
  int updateBookingDetails(@Bind("status") String status, @Bind("bookingId") int bookingId);
}
