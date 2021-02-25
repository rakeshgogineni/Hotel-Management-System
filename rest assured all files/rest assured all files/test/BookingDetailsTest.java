package com.riario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import com.riario.factory.BookingDetailsFactory;
import com.riario.model.BookingDetails;
import com.riario.persistence.BookingDetailsDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
/**
 * Test Class for Booking Details.
 */
@RunWith(JMockit.class)
public class BookingDetailsTest {
  /**
   * Tests the equals/hashcode methods of the offer class.
   */
  @Test
  public final void testBookingDetails() {
    BookingDetails bookingdetails1 = new BookingDetails(111, 100, "2019-10-06", "2019-10-06", 8000, 1000, "Confirmed");
    assertNotEquals(bookingdetails1, null);
    BookingDetails bookingdetails2 = new BookingDetails(111, 100, "2019-10-06", "2019-10-06", 8000, 1000, "Confirmed");
    assertEquals(bookingdetails1.hashCode(), bookingdetails2.hashCode());
    BookingDetails bookingdetails3 = new BookingDetails(1, 2, "2021-10-06", "2021-10-06", 9000, 500, "Cancelled");
    // guestId
    assertNotEquals(bookingdetails2.getGuestId(), bookingdetails3.getGuestId());
    assertEquals(bookingdetails1.getGuestId(), bookingdetails2.getGuestId());
    // roomId
    assertNotEquals(bookingdetails2.getRoomId(), bookingdetails3.getGuestId());
    assertEquals(bookingdetails1.getRoomId(), bookingdetails2.getRoomId());
    // checkindate
    assertNotEquals(bookingdetails2.getCheckinDate(), bookingdetails3.getCheckinDate());
    assertEquals(bookingdetails1.getCheckinDate(), bookingdetails2.getCheckinDate());
    // checkoutdate
    assertNotEquals(bookingdetails2.getCheckoutDate(), bookingdetails3.getCheckoutDate());
    assertEquals(bookingdetails1.getCheckoutDate(), bookingdetails2.getCheckoutDate());
    // amoount pending
    assertNotEquals(bookingdetails2.getAmountPending(), bookingdetails3.getAmountPending(), 0.0f);
    assertEquals(bookingdetails1.getAmountPending(), bookingdetails2.getAmountPending(), 0.0f);
    // amountPaid
    assertNotEquals(bookingdetails2.getAmountPaid(), bookingdetails3.getAmountPaid(), 0.0f);
    assertEquals(bookingdetails1.getAmountPaid(), bookingdetails2.getAmountPaid(), 0.0f);
    // status
    assertNotEquals(bookingdetails2.getStatus(), bookingdetails3.getStatus());
    assertEquals(bookingdetails1.getStatus(), bookingdetails2.getStatus());
    // constructor
    BookingDetails bookingdetails4 = new BookingDetails();
    bookingdetails4.setGuestId(1);
    bookingdetails4.setHotelId(2);
    bookingdetails4.setRoomId(3);
    bookingdetails4.setBookingId(4);
    bookingdetails4.setCheckinDate("2021-01-03");
    bookingdetails4.setCheckoutDate("2021-01-06");
    bookingdetails4.setAmountPending(1000);
    bookingdetails4.setAmountPaid(9000);
    bookingdetails4.setStatus("Confirmed");
    BookingDetails bdetails5 = new BookingDetails(1, 3, "2021-01-03", "2021-01-06", 9000, 1000, "Confirmed");
    assertEquals(bookingdetails4.getGuestId(), bdetails5.getGuestId());
    assertEquals(bookingdetails4.getRoomId(), bdetails5.getRoomId());
    assertEquals(bookingdetails4.getCheckinDate(), bdetails5.getCheckinDate());
    assertEquals(bookingdetails4.getCheckoutDate(), bdetails5.getCheckoutDate());
    assertEquals(bookingdetails4.getAmountPaid(), bdetails5.getAmountPaid(), 0.0f);
    assertEquals(bookingdetails4.getAmountPending(), bdetails5.getAmountPending(), 0.0f);
    assertEquals(bookingdetails4.getStatus(), bdetails5.getStatus());
    assertNotEquals(bookingdetails4.toString(), bookingdetails1.toString());
  }
    /**
   * tests that empty room list is handled correctly.
   *
   * @param pDao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final BookingDetailsDAO pDao) {
    // hotelDAO interface
    // pdao mockobject...original object hotelDao
    new Expectations() {
      {
        // result = pDao.show();
        pDao.show();
        // invoke the show method which is in class HotelDao
        result = new ArrayList<BookingDetails>();
      }
    };
    new MockUp<BookingDetailsFactory>() {
      @Mock
      BookingDetailsDAO dao() {
        return pDao;
      }
      // DB Connection
    };
    List<BookingDetails> bookDetailsList = BookingDetailsFactory.showBookingDetails();
    assertEquals(0, bookDetailsList.size());
  }

  /**
   * Tests that a list with some roomdetails are handled correctly.
   *
   * @param pDao mocking the dao class
   */
  @Test
  public final void testListAllSoSome(@Mocked final BookingDetailsDAO pDao) {
    final BookingDetails bdetails1 = new BookingDetails(1, 10, "2019-10-06", "2019-10-06", 800, 100, "Confirmed");
    final BookingDetails bdetails2 = new BookingDetails(1, 3, "2021-01-03", "2021-01-06", 9000, 1000, "Confirmed");
    final List<BookingDetails> bookingDetailsList = new ArrayList<BookingDetails>();
    new Expectations() {
      {
        bookingDetailsList.add(bdetails1);
        bookingDetailsList.add(bdetails2);
        pDao.show();
        result = bookingDetailsList;
      }
    };
    new MockUp<BookingDetailsFactory>() {
      @Mock
      BookingDetailsDAO dao() {
        return pDao;
      }

    };

    List<BookingDetails> bdListNew = BookingDetailsFactory.showBookingDetails();
    final  BookingDetails bdetails3 = new BookingDetails(1, 10, "2019-10-06", "2019-10-06", 800, 100, "Confirmed");
    assertEquals(2, bdListNew.size());
    assertEquals(bdetails3.getGuestId(), bdListNew.get(0).getGuestId());
  }

}
