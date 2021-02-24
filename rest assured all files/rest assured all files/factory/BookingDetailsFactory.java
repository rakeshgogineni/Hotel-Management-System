package com.hexaware.MLP269.factory;

import java.util.List;

import com.hexaware.MLP269.model.BookingDetails;
import com.hexaware.MLP269.persistence.BookingDetailsDAO;
import com.hexaware.MLP269.persistence.DbConnection;

/**
 * HotelFactory class used to fetch offer data from database.
 *
 * @author hexware
 */
public class BookingDetailsFactory {
  /**
   * Protected constructor.
   */
  protected BookingDetailsFactory() {
  }

  /**
   * Call the data base connection.
   *
   * @return the connection object.
   */
  private static BookingDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(BookingDetailsDAO.class);
  }

  /**
   * Call the data base connection.
   *
   * @return the connection object.
   */
  public static List<BookingDetails> showBookingDetails() {
    BookingDetailsDAO bookingDetailsDAO = dao();
    return bookingDetailsDAO.show();
  }

  /**
   * Call the data base connection.
   *
   * @param bookingId to initialize offer.
   * @return the offer object.
   */
  public static BookingDetails getBookingDetailsById(final int bookingId) {
    return dao().getBookingDetailsById(bookingId);
  }

  /**
   * Call the data base connection.
   *
   * @param bookingDetails to initialize offer.
   * @return the connection object.
   */

  public static int insertBookingDetails(final BookingDetails bookingDetails) {
    BookingDetailsDAO bookingDetailsDAO = dao();
    return bookingDetailsDAO.insertBookingDetails(bookingDetails);
  }

  /**
   * Call the data base connection.
   *
   * @param bookingId to initialize bookingid.
   * @return the connection object.
   */
  public static int deleteBookingDetails(final int bookingId) {
    BookingDetailsDAO bookingdetailsDAO = dao();
    return bookingdetailsDAO.deleteBookingId(bookingId);
  }

  /**
   * Call the data base connection.
   *
   * @param bookingDetails to initialize
   * @return the connection object.
   */
  public static int updateBookingDetails(final BookingDetails bookingDetails) {
    BookingDetailsDAO bookingDetailsDAO = dao();
    String status = bookingDetails.getStatus();
    int bookingId = bookingDetails.getBookingId();
    return bookingDetailsDAO.updateBookingDetails(status, bookingId);
  }

}
