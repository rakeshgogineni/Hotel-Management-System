package com.riario.model;
import java.util.Objects;

/**
 * Room class used to display menu information.
 * @author hexware
 */
public class Room {
/**
 * roomNo to store roomNumber.
 */
  private int roomNo;
  /**
   * Default Constructor.
   */
  public Room() {

  }
/**
 * @param argRoomNo to initialize roomNo .
 * used to get details through constructor.
 */
  public Room(final int argRoomNo) {
    this.roomNo = argRoomNo;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Room room = (Room) obj;
    if (Objects.equals(roomNo, room.roomNo)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(roomNo);
  }
    /**
     * @return this roomNo.
     */
  public final int getRoomNo() {
    return roomNo;
  }
    /**
     * @param argRoomNo gets the roomNo.
     */
  public final void setRoomNo(final int argRoomNo) {
    this.roomNo = argRoomNo;
  }
}
