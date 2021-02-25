package com.riario.factory;

import java.util.List;

import com.riario.model.Hotel;
import com.riario.persistence.DbConnection;
import com.riario.persistence.HotelDAO;

/**
 * HotelFactory class used to fetch offer data from database.
 *
 * @author hexware
 */
public class HotelFactory {
  /**
   * Protected constructor.
   */
  protected HotelFactory() {
  }

  /**
   * Call the data base connection.
   *
   * @return the connection object.
   */
  private static HotelDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(HotelDAO.class);
  }

  /**
   * Call the data base connection.
   *
   * @return the connection object.
   */
  public static List<Hotel> showHotel() {
    HotelDAO hotelDAO = dao();
    return hotelDAO.show();
  }

  /**
   * Call the data base connection.
   *
   * @param hotelId to initialize offer.
   * @return the offer object.
   */
  public static Hotel getHotelById(final int hotelId) {
    return dao().getHotelById(hotelId);
  }

  /**
   * Call the data base connection.
   *
   * @param hotel to initialize offer.
   * @return the connection object.
   */

  public static int insertHotel(final Hotel hotel) {
    HotelDAO hotelDAO = dao();
    int hotelId = hotel.getHotelId();
    String hotelName = hotel.getHotelName();
    String address = hotel.getAddress();
    Long phone = hotel.getPhone();
    int noOfRoom = hotel.getNoOfRoom();
    String description = hotel.getDescription();
    return hotelDAO.insertHotel(hotelId, hotelName, address, phone, noOfRoom, description);
  }

  /**
   * Call the data base connection.
   *
   * @param hotelId to initialize hotel.
   * @return the connection object.
   */
  public static int deleteHotel(final int hotelId) {
    HotelDAO hotelDAO = dao();
    return hotelDAO.deleteHotel(hotelId);
  }

  /**
   * Call the data base connection.
   *
   * @param hotel to initialize hotel.
   * @return the connection object.
   */
  public static int updateHotel(final Hotel hotel) {
    HotelDAO hotelDAO = dao();
    String hotelName = hotel.getHotelName();
    int noOfRoom = hotel.getNoOfRoom();
    return hotelDAO.updateHotel(hotelName, noOfRoom);
  }
}
