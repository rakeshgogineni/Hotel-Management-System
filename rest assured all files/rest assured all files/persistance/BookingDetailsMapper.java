package com.hexaware.MLP269.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.MLP269.model.BookingDetails;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * BookingMapper class used to fetch booking data from database.
 *
 * @author hexware
 */
public class BookingDetailsMapper implements ResultSetMapper<BookingDetails> {
  /**
   * @param idx the index
   * @param rs  the resultset
   * @param ctx the context
   * @return the mapped customer object
   * @throws SQLException in case there is an error in fetching data from the
   *                      resultset
   */
  public final BookingDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {

    // Populate the values from database table
    /**
     * @return Booking
     */
    int guestId = rs.getInt("Guest_id");
    int roomId = rs.getInt("room_id");
    String checkinDate = rs.getDate("CHECKIN_DATE").toString();
    String checkoutDate = rs.getDate("CHECKOUT_DATE").toString();
    float amountPaid = rs.getFloat("AMOUNT_PAID");
    float amountPending = rs.getFloat("AMOUNT_Pending");
    String status = rs.getString("Status");
    int hotelId = rs.getInt("Hotel_Id");
    int bookingId = rs.getInt("Booking_id");
    BookingDetails booking = new BookingDetails();
    booking.setGuestId(guestId);
    booking.setRoomId(roomId);
    booking.setCheckinDate(checkinDate);
    booking.setCheckoutDate(checkoutDate);
    booking.setAmountPaid(amountPaid);
    booking.setAmountPending(amountPending);
    booking.setStatus(status);
    booking.setHotelId(hotelId);
    booking.setBookingId(bookingId);

    //return booking details instance
    return booking;

  }

}
