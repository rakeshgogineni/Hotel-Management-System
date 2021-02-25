package com.riario.factory;

import com.riario.persistence.RoomDAO;
import com.riario.persistence.DbConnection;
import java.util.List;

import com.riario.model.Room;
/**
 * RoomFactory class used to fetch room data from database.
 * @author hexware
 */
public class RoomFactory {
  /**
   *  Protected constructor.
   */
  protected RoomFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static RoomDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(RoomDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of room object.
   */
  public static Room[] showRoom() {
    List<Room> room = dao().show();
    return room.toArray(new Room[room.size()]);
  }
}
