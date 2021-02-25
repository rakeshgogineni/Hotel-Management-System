package com.riario.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.riario.model.RoomDetails;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * RoomDetailsMapper class used to fetch offer data from database.
 *
 * @author hexware
 */
public class RoomDetailsMapper implements ResultSetMapper<RoomDetails> {
  /**
   * @param index     the index
   * @param resultset the resultset
   * @param ctx       the context
   * @return the mapped customer object
   * @throws SQLException in case there is an error in fetching data from the
   *                      resultset
   */
  public final RoomDetails map(final int index, final ResultSet resultset, final StatementContext ctx)
      throws SQLException {

    // Populate the values from database table
    int roomNo = resultset.getInt("room_no");
    String roomType = resultset.getString("room_type");
    float roomCost = resultset.getFloat("room_cost");
    String checkinDate = resultset.getDate("CHECKIN_DATE").toString();
    String checkoutDate = resultset.getDate("CHECKOUT_DATE").toString();
    // Create an RoomDetails instance
    // RoomDetails roomDetails = new RoomDetails(roomNo, roomType, roomCost);
    RoomDetails roomDetails = new RoomDetails();
    roomDetails.setRoomNo(roomNo);
    roomDetails.setRoomType(roomType);
    roomDetails.setRoomCost(roomCost);
    roomDetails.setCheckinDate(checkinDate);
    roomDetails.setCheckoutDate(checkoutDate);


    // retrun the roomDetails instance
    return roomDetails;
  }

}
