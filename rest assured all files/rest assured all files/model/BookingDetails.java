package com.riario.model;

/**
 * Booking class used to display menu information.
 *
 * @author hexware
 */
public class BookingDetails {
  private int guestId;
  private int hotelId;
  private int roomId;
  private String checkinDate;
  private String checkoutDate;
  private float amountPaid;
  private float amountPending;
  private String status;
  private int bookingId;

  /**
   * Default Constructor.
   */
  public BookingDetails() {
  }

  /**
   * @param argguestId       to initialize guestId.
   * @param argroomId        to initialize roomId.
   * @param argcheckinDate   to initialize chechkinDate.
   * @param argcheckoutDate  to initialize checkoutDate.
   * @param argamountPaid    to initialize Amount Paid.
   * @param argamountPending to initialize Amount Pending.
   * @param argstatus        to initialize status of booking
   */
  public BookingDetails(final int argguestId, final int argroomId, final String argcheckinDate,
      final String argcheckoutDate, final float argamountPaid, final float argamountPending, final String argstatus) {
    this.guestId = argguestId;
    this.roomId = argroomId;
    this.checkinDate = argcheckinDate;
    this.checkoutDate = argcheckoutDate;
    this.amountPaid = argamountPaid;
    this.amountPending = argamountPending;
    this.status = argstatus;
  }

  /**
   * @return this guestId.
   */
  public final int getGuestId() {
    return guestId;
  }

  /**
   * @param argguestId assigns this hotelId.
   */
  public final void setGuestId(final int argguestId) {
    this.guestId = argguestId;
  }

  /**
   * @return this roomId.
   */

  public final int getRoomId() {
    return roomId;
  }

  /**
   * @param argroomId assigns this hotelId.
   */
  public final void setRoomId(final int argroomId) {
    this.roomId = argroomId;
  }

  /**
   * @return this checkin Date.
   */

  public final String getCheckinDate() {
    return checkinDate;
  }

  /**
   * @param argcheckinDate assigns this checkindate.
   */
  public final void setCheckinDate(final String argcheckinDate) {
    this.checkinDate = argcheckinDate;
  }

  /**
   * @return this checkout Date.
   */

  public final String getCheckoutDate() {
    return checkoutDate;
  }

  /**
   * @param argcheckoutDate assigns this checkoutdate.
   */

  public final void setCheckoutDate(final String argcheckoutDate) {
    this.checkoutDate = argcheckoutDate;
  }

  /**
   * @return this amountPaid.
   */

  public final float getAmountPaid() {
    return amountPaid;
  }

  /**
   * @param argamountPaid assigns this amountpaid.
   */

  public final void setAmountPaid(final float argamountPaid) {
    this.amountPaid = argamountPaid;
  }

  /**
   * @return this amountPending.
   */

  public final float getAmountPending() {
    return amountPending;
  }

  /**
   * @param argamountPending assigns this amountPending.
   */

  public final void setAmountPending(final float argamountPending) {
    this.amountPending = argamountPending;
  }

  /**
   * @return this status.
   */
  public final String getStatus() {
    return status;
  }

  /**
   * @param argstatus assigns this status.
   */

  public final void setStatus(final String argstatus) {
    this.status = argstatus;
  }

  /**
   * @return this status.
   */
  public final int getHotelId() {
    return hotelId;
  }

  /**
   * @param arghotelId assigns this status.
   */

  public final void setHotelId(final int arghotelId) {
    this.hotelId = arghotelId;
  }

  /**
   * @return this status.
   */
  public final int getBookingId() {
    return bookingId;
  }

  /**
   * @param argbookingId assigns this status.
   */
  public final void setBookingId(final int argbookingId) {
    this.bookingId = argbookingId;
  }

  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Float.floatToIntBits(amountPaid);
    result = prime * result + Float.floatToIntBits(amountPending);
    int val1 = 0;
    if (checkinDate != null) {
      val1 = checkinDate.hashCode();
    }
    result = prime * result + val1;
    int val2 = 0;
    if (checkoutDate != null) {
      val2 = checkoutDate.hashCode();
    }
    result = prime * result + val2;
    result = prime * result + guestId;
    result = prime * result + hotelId;
    result = prime * result + bookingId;
    result = prime * result + roomId;
    int val3 = 0;
    if (status != null) {
      val3 = status.hashCode();
    }
    result = prime * result + val3;
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
    BookingDetails other = (BookingDetails) obj;
    if (Float.floatToIntBits(amountPaid) != Float.floatToIntBits(other.amountPaid)) {
      return false;
    }
    if (Float.floatToIntBits(amountPending) != Float.floatToIntBits(other.amountPending)) {
      return false;
    }
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
    if (guestId != other.guestId) {
      return false;
    }
    if (roomId != other.roomId) {
      return false;
    }
    if (bookingId != other.bookingId) {
      return false;
    }
    if (hotelId != other.hotelId) {
      return false;
    }
    if (status == null) {
      if (other.status != null) {
        return false;
      }
    } else if (!status.equals(other.status)) {
      return false;
    }
    return true;
  }

  @Override
  public final String toString() {
    return "BookingDetails [amountPaid=" + amountPaid + ", amountPending=" + amountPending + ", checkinDate="
        + checkinDate + ", checkoutDate=" + checkoutDate + ", guestId=" + guestId + ", roomId=" + roomId + ", status="
        + status + "]";
  }

}
