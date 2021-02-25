package com.riario.model;

/**
 * RoomDetails class used to display menu information.
 *
 * @author hexware
 */
public class RoomDetails {

  private int roomNo;
  private String roomType;
  private float roomCost;
  private String checkinDate;
  private String checkoutDate;

  /**
   * Default Constructor.
   */
  public RoomDetails() {
  }

  /**
   * @param argroomNo       to initialize roomNo.
   * @param argroomType     to initialize roomType.
   * @param argroomCost     to initialize roomCost.
   * @param argcheckinDate  to initalize checkinDate.
   * @param argcheckoutDate to initalize checkoutDate. used to get details through
   *                        constructor.
   */
  public RoomDetails(final int argroomNo, final String argroomType, final float argroomCost,
      final String argcheckinDate, final String argcheckoutDate) {
    this.roomNo = argroomNo;
    this.roomType = argroomType;
    this.roomCost = argroomCost;
    this.checkinDate = argcheckinDate;
    this.checkoutDate = argcheckoutDate;
  }

  /**
   * @return this roomNo.
   */
  public final int getRoomNo() {
    return roomNo;
  }

  /**
   * @param argroomNo assigns the roomNo.
   */
  public final void setRoomNo(final int argroomNo) {
    this.roomNo = argroomNo;
  }

  /**
   * @return this roomType.
   */
  public final String getRoomType() {
    return roomType;
  }

  /**
   * @param argroomType assigns the roomType.
   */
  public final void setRoomType(final String argroomType) {
    this.roomType = argroomType;
  }

  /**
   * @return this roomCost.
   */
  public final float getRoomCost() {
    return roomCost;
  }

  /**
   * @param argroomCost assigns the roomCost.
   */
  public final void setRoomCost(final float argroomCost) {
    this.roomCost = argroomCost;
  }

  /**
   * @return this checkinDate.
   */
  public final String getCheckinDate() {
    return checkinDate;
  }

  /**
   * @param argcheckinDate assigns the checkinDate.
   */
  public final void setCheckinDate(final String argcheckinDate) {
    this.checkinDate = argcheckinDate;
  }

  /**
   * @return this checkoutDate.
   */
  public final String getCheckoutDate() {
    return checkoutDate;
  }

  /**
   * @param argcheckoutDate assigns the checkoutDate.
   */
  public final void setCheckoutDate(final String argcheckoutDate) {
    this.checkoutDate = argcheckoutDate;
  }

  @Override
  public final String toString() {
    return "RoomDetails [checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate + ", roomCost=" + roomCost
        + ", roomNo=" + roomNo + ", roomType=" + roomType + "]";
  }

  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    int value2 = 0;
    if (checkinDate != null) {
      value2 = checkinDate.hashCode();
    }
    result = prime * result + value2;
    int value3 = 0;
    if (checkoutDate != null) {
      value3 = checkoutDate.hashCode();
    }
    result = prime * result + value3;
    result = prime * result + Float.floatToIntBits(roomCost);
    result = prime * result + roomNo;
    int value1 = 0;
    if (roomType != null) {
      value1 = roomType.hashCode();
    }
    result = prime * result + value1;
    return result;
  }

  @Override
  public final boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    RoomDetails other = (RoomDetails) obj;
    if (checkinDate == null) {
      if (other.checkinDate != null) {
        return false;
      }
    } else if (!checkinDate.equals(other.checkinDate)) {
      return false;
    }
    if (checkoutDate == null) {
      if (other.checkoutDate != null) {
        return false;
      }
    } else if (!checkoutDate.equals(other.checkoutDate)) {
      return false;
    }
    if (Float.floatToIntBits(roomCost) != Float.floatToIntBits(other.roomCost)) {
      return false;
    }
    if (roomNo != other.roomNo) {
      return false;
    }
    if (roomType == null) {
      if (other.roomType != null) {
        return false;
      }
    } else if (!roomType.equals(other.roomType)) {
      return false;
    }
    return true;
  }

}
