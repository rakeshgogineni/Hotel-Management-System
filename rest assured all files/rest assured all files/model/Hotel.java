package com.riario.model;

/**
 * Hotel class used to display menu information.
 *
 * @author hexware
 */
public class Hotel {
  private int hotelId;
  private String hotelName;
  private String address;
  private long phone;
  private int noOfRoom;
  private String description;

  /**
   * Default Constructor.
   */
  public Hotel() {
  }

  /**
   * @param arghotelId     to initialize hotelId.
   * @param arghotelName   to initialize hotelName.
   * @param argaddress     to initialize address.
   * @param argphone       to initialize phone.
   * @param argnoOfRoom    to initialize no_of_room.
   * @param argdescription to initialize decription. used to get details through
   *                       constructor.
   */
  public Hotel(final int arghotelId, final String arghotelName, final String argaddress, final long argphone,
      final int argnoOfRoom, final String argdescription) {
    this.hotelId = arghotelId;
    this.hotelName = arghotelName;
    this.address = argaddress;
    this.phone = argphone;
    this.noOfRoom = argnoOfRoom;
    this.description = argdescription;
  }

  /**
   * @return this hotelId.
   */
  public final int getHotelId() {
    return hotelId;
  }

  /**
   * @param arghotelId assigns this hotelId.
   */
  public final void setHotelId(final int arghotelId) {
    this.hotelId = arghotelId;
  }

  /**
   * @return this hotelName.
   */
  public final String getHotelName() {
    return hotelName;
  }

  /**
   * @param arghotelName assigns this hotelName.
   */
  public final void setHotelName(final String arghotelName) {
    this.hotelName = arghotelName;
  }

  /**
   * @return this address.
   */
  public final String getAddress() {
    return address;
  }

  /**
   * @param argaddress assigns this address.
   */
  public final void setAddress(final String argaddress) {
    this.address = argaddress;
  }

  /**
   * @return this phone.
   */
  public final long getPhone() {
    return phone;
  }

  /**
   * @param argphone assigns this phone.
   */
  public final void setPhone(final long argphone) {
    this.phone = argphone;
  }

  /**
   * @return this NoOfRoom.
   */
  public final int getNoOfRoom() {
    return noOfRoom;
  }

  /**
   * @param argnoOfRoom assigns this noOfROom.
   */
  public final void setNoOfRoom(final int argnoOfRoom) {
    this.noOfRoom = argnoOfRoom;
  }

  /**
   * @return this description.
   */
  public final String getDescription() {
    return description;
  }

  /**
   * @param argdescription assigns this description.
   */
  public final void setDescription(final String argdescription) {
    this.description = argdescription;
  }

  @Override
  public final String toString() {
    return "Hotel [address=" + address + ", description=" + description + ", hotelId=" + hotelId + ", hotelName="
        + hotelName + ", noOfRoom=" + noOfRoom + ", phone=" + phone + "]";
  }

  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    int val1 = 0;
    if (address != null) {
      val1 = address.hashCode();
    }
    result = prime * result + val1;
    int val2 = 0;
    if (description != null) {
      val2 = description.hashCode();
    }
    result = prime * result + val2;
    result = prime * result + hotelId;
    int val3 = 0;
    if (hotelName != null) {
      val3 = hotelName.hashCode();
    }
    result = prime * result + val3;
    result = prime * result + noOfRoom;
    result = prime * result + (int) (phone ^ (phone >>> 32));
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
    Hotel other = (Hotel) obj;
    if (address == null) {
      if (other.address != null) {
        return false;
      }
    } else if (!address.equals(other.address)) {
      return false;
    }
    if (description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!description.equals(other.description)) {
      return false;
    }
    if (hotelId != other.hotelId) {
      return false;
    }
    if (hotelName == null) {
      if (other.hotelName != null) {
        return false;
      }
    } else if (!hotelName.equals(other.hotelName)) {
      return false;
    }
    if (noOfRoom != other.noOfRoom) {
      return false;
    }
    if (phone != other.phone) {
      return false;
    }
    return true;
  }

}
