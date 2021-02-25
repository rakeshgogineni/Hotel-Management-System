package com.riario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import com.riario.factory.HotelFactory;
import com.riario.model.Hotel;
import com.riario.persistence.HotelDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * Test class for Hotel.
 */
@RunWith(JMockit.class)
public class HotelTest {
  /**
   * Tests the equals/hashcode methods of the offer class.
   */
  @Test
  public final void testHotel() {
    Hotel hotel1 = new Hotel(100, "Hotel Taj", "Mumbai", 89087736, 10, "5 Star Luxury");
    assertNotEquals(hotel1, null);
    Hotel hotel2 = new Hotel(100, "Hotel Taj", "Mumbai", 89087736, 10, "5 Star Luxury");
    assertEquals(hotel1.hashCode(), hotel2.hashCode());
    Hotel hotel3 = new Hotel(101, "Hotel", "IN", 89087, 5, "5 star");
    // hotelId
    assertNotEquals(hotel2.getHotelId(), hotel3.getHotelId());
    assertEquals(hotel1.getHotelId(), hotel2.getHotelId());
    // hotelName
    assertNotEquals(hotel2.getHotelName(), hotel3.getHotelName());
    assertEquals(hotel1.getHotelName(), hotel2.getHotelName());
    // address
    assertNotEquals(hotel2.getAddress(), hotel3.getAddress());
    assertEquals(hotel1.getAddress(), hotel2.getAddress());
    // phone
    assertNotEquals(hotel2.getPhone(), hotel3.getPhone());
    assertEquals(hotel1.getPhone(), hotel2.getPhone());
    // noOfRooms
    assertNotEquals(hotel2.getNoOfRoom(), hotel3.getNoOfRoom());
    assertEquals(hotel1.getNoOfRoom(), hotel2.getNoOfRoom());
    // description
    assertNotEquals(hotel2.getDescription(), hotel3.getDescription());
    assertEquals(hotel1.getDescription(), hotel2.getDescription());
    Hotel hotel4 = new Hotel();
    hotel4.setHotelId(1);
    hotel4.setHotelName("H");
    hotel4.setAddress("India");
    hotel4.setPhone(9098766);
    hotel4.setNoOfRoom(100);
    hotel4.setDescription("Its a Hotel");
    Hotel hotel5 = new Hotel(1, "H", "India", 9098766, 100, "Its a Hotel");
    assertEquals(hotel4.getHotelId(), hotel5.getHotelId());
    assertEquals(hotel4.getHotelName(), hotel5.getHotelName());
    assertEquals(hotel4.getAddress(), hotel5.getAddress());
    assertEquals(hotel4.getPhone(), hotel5.getPhone());
    assertEquals(hotel4.getNoOfRoom(), hotel5.getNoOfRoom());
    assertEquals(hotel4.getDescription(), hotel5.getDescription());
    assertNotEquals(hotel4.toString(), hotel1.toString());
  }

  /**
   * Tests the equals/hashcode methods of the offer class.
   */
  @Test
  public final void testGuestEquality() {

    Hotel hotel0 = new Hotel(100, "Hotel Taj", "Mumbai", 89087736, 10, "5 Star Luxury");
    Hotel hotel1 = new Hotel(100, "Hotel Taj", "Mumbai", 89087736, 10, "5 Star Luxury");
    Hotel hotel2 = new Hotel(101, "Hotel Taj", "Mumbai", 89087736, 10, "5 Star Luxury");
    Hotel hotel3 = new Hotel(101, "Hotel", "Mumbai", 89087736, 10, "5 Star Luxury");
    Hotel hotel4 = new Hotel(101, "Hotel", "Navi Mumbai ", 89087736, 10, "5 Star Luxury");
    Hotel hotel5 = new Hotel(101, "Hotel", "Navi Mumbai ", 8077031, 10, "5 Star Luxury");
    Hotel hotel6 = new Hotel(101, "Hotel", "Navi Mumbai ", 8077031, 1, "5 Star Luxury");
    Hotel hotel7 = new Hotel(101, "Hotel", "Navi Mumbai ", 8077031, 1, "5 Star");
    Hotel hotel8 = new Hotel(101, "Hotel", null, 89087736, 10, "5 Star Luxury");
    Hotel hotel9 = new Hotel(100, "Hotel Taj", "Mumbai", 89087736, 10, null);
    Hotel hotel10 = new Hotel(101, null, "Mumbai", 89087736, 10, "5 Star Luxury");
    // Offer offer7 = new Offer(1001, "Aish", 250.0f);
    assertNotEquals(hotel1, null);
    assertEquals(hotel1, hotel1);
    assertNotEquals(hotel1, new Object());
    assertNotEquals(hotel1, hotel2);
    assertNotEquals(hotel2, hotel3);
    assertNotEquals(hotel3, hotel4);
    assertNotEquals(hotel4, hotel5);
    assertNotEquals(hotel5, hotel6);
    assertNotEquals(hotel6, hotel7);
    assertEquals(hotel1, hotel0);
    assertNotEquals(hotel8, hotel4);
    assertNotEquals(hotel9, hotel0);
    assertNotEquals(hotel10, hotel2);
  }

  /**
   * tests that empty room list is handled correctly.
   *
   * @param pDao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final HotelDAO pDao) {
    // hotelDAO interface
    // pdao mockobject...original object hotelDao
    new Expectations() {
      {
        // result = pDao.show();
        pDao.show();
        // invoke the show method which is in class HotelDao
        result = new ArrayList<Hotel>();
      }
    };
    new MockUp<HotelFactory>() {
      @Mock
      HotelDAO dao() {
        return pDao;
      }
      // DB Connection
    };
    List<Hotel> hotelList = HotelFactory.showHotel();
    assertEquals(0, hotelList.size());
  }

  /**
   * Tests that a list with some roomdetails are handled correctly.
   *
   * @param pDao mocking the dao class
   */
  @Test
  public final void testListAllSoSome(@Mocked final HotelDAO pDao) {
    final Hotel hotel1 = new Hotel(100, "Hotel Taj", "Mumbai", 89087736, 10, "5 Star Luxury");
    final Hotel hotel2 = new Hotel(101, "Hotel", "IN", 89087, 5, "5 star");
    final List<Hotel> hotelList = new ArrayList<Hotel>();
    new Expectations() {
      {
        hotelList.add(hotel1);
        hotelList.add(hotel2);
        pDao.show();
        result = hotelList;
      }
    };
    new MockUp<HotelFactory>() {
      @Mock
      HotelDAO dao() {
        return pDao;
      }

    };

    List<Hotel> hotelListNew = HotelFactory.showHotel();
    final Hotel hotel3 = new Hotel(100, "Hotel Taj", "Mumbai", 89087736, 10, "5 Star Luxury");
    assertEquals(2, hotelListNew.size());
    assertEquals(hotel3.getHotelId(), hotelListNew.get(0).getHotelId());
  }

}
