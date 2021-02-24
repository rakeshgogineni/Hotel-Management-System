package com.hexaware.MLP269.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP269.model.Hotel;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * HotelMapper class used to fetch Hotel data from database.
 *
 * @author hexware
 */
public class HotelMapper implements ResultSetMapper<Hotel> {
  /**
   * @param index     the index
   * @param resultSet the resultset
   * @param ctx       the context
   * @return the mapped customer object
   * @throws SQLException in case there is an error in fetching data from the
   *                      resultset
   */
  public final Hotel map(final int index, final ResultSet resultSet, final StatementContext ctx) throws SQLException {
    // Populate the values from database table
    int hotelId = resultSet.getInt("HOTEL_ID");
    String hotelName = resultSet.getString("HOTEL_NAME");
    String address = resultSet.getString("ADDRESS");
    long phone = resultSet.getLong("PHONE");
    int noOfRoom = resultSet.getInt("NO_OF_ROOM");
    String description = resultSet.getString("DESCRIPTION");
    Hotel hotel = new Hotel();
    hotel.setHotelId(hotelId);
    hotel.setHotelName(hotelName);
    hotel.setAddress(address);
    hotel.setPhone(phone);
    hotel.setNoOfRoom(noOfRoom);
    hotel.setDescription(description);

    // retrun the offer instance
    return hotel;
  }

}
