package com.riario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import com.riario.factory.RoomDetailsFactory;
import com.riario.model.RoomDetails;
import com.riario.persistence.RoomDetailsDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * Test class for RoomDetails.
 */
@RunWith(JMockit.class)
public class RoomDetailsTest {
  /**
   * Tests the equals/hashcode methods of the roomDetails class.
   */
  @Test
  public final void testRoomDetails() {
    RoomDetails roomdetails1 = new RoomDetails(100, "View", 1000f, "2016-02-01", "2016-02-10");
    assertNotEquals(roomdetails1, null);
    RoomDetails roomdetails2 = new RoomDetails(100, "View", 1000f, "2016-02-01", "2016-02-10");
    assertEquals(roomdetails1.hashCode(), roomdetails2.hashCode());
    RoomDetails roomdetails3 = new RoomDetails(101, "Room", 1500f, "2016-01-04", "2016-01-11");
    // roomId
    assertNotEquals(roomdetails2.getRoomNo(), roomdetails3.getRoomNo());
    assertEquals(roomdetails1.getRoomNo(), roomdetails2.getRoomNo());
    // roomType
    assertNotEquals(roomdetails2.getRoomType(), roomdetails3.getRoomType());
    assertEquals(roomdetails1.getRoomType(), roomdetails2.getRoomType());
    // roomCost
    assertNotEquals(roomdetails2.getRoomCost(), roomdetails3.getRoomCost());
    assertEquals(roomdetails1.getRoomCost(), roomdetails2.getRoomCost(), 0.0f);
    // checkinDate
    assertNotEquals(roomdetails2.getCheckinDate(), roomdetails3.getCheckinDate());
    assertEquals(roomdetails1.getCheckinDate(), roomdetails2.getCheckinDate());
    // checkoutDate
    assertNotEquals(roomdetails2.getCheckoutDate(), roomdetails3.getCheckoutDate());
    assertEquals(roomdetails1.getCheckoutDate(), roomdetails2.getCheckoutDate());

    RoomDetails roomdetails4 = new RoomDetails();
    roomdetails4.setRoomNo(0);
    roomdetails4.setRoomType("RoomView");
    roomdetails4.setRoomCost(500.0f);
    roomdetails4.setCheckinDate("2016-01-01");
    roomdetails4.setCheckoutDate("2016-01-10");
    RoomDetails roomdetails5 = new RoomDetails(0, "RoomView", 500.0f, "2016-01-01", "2016-01-10");
    assertEquals(roomdetails4.getRoomNo(), roomdetails5.getRoomNo());
    assertEquals(roomdetails4.getRoomType(), roomdetails5.getRoomType());
    assertEquals(roomdetails4.getRoomCost(), roomdetails5.getRoomCost(), 0.0f);
    assertEquals(roomdetails4.getCheckinDate(), roomdetails5.getCheckinDate());
    assertEquals(roomdetails4.getCheckoutDate(), roomdetails5.getCheckoutDate());
    assertEquals(roomdetails4.toString(), roomdetails5.toString());
  }

  /**
   * Tests the equals/hashcode methods of the roomDetails class.
   */
  @Test
  public final void testRoomDetailsEquality() {
    RoomDetails roomdetails0 = new RoomDetails(100, "View", 1000f, "2016-02-01", "2016-02-10");
    RoomDetails roomdetails1 = new RoomDetails(100, "View", 1000f, "2016-02-01", "2016-02-10");
    RoomDetails roomdetails2 = new RoomDetails(101, "View", 1000f, "2016-02-01", "2016-02-10");
    RoomDetails roomdetails3 = new RoomDetails(101, "Room", 1000f, "2016-01-04", "2016-01-11");
    RoomDetails roomdetails4 = new RoomDetails(101, "Room", 1500f, "2016-01-04", "2016-01-11");
    RoomDetails roomdetails5 = new RoomDetails(101, null, 1500f, "2016-01-05", "2016-01-07");

    assertNotEquals(roomdetails1, null);
    assertEquals(roomdetails1, roomdetails1);
    assertNotEquals(roomdetails1, new Object());
    assertNotEquals(roomdetails1, roomdetails2);
    assertNotEquals(roomdetails2, roomdetails3);
    assertNotEquals(roomdetails3, roomdetails4);
    assertEquals(roomdetails0, roomdetails1);
    assertNotEquals(roomdetails5, roomdetails4);
  }

  /**
   * tests that empty room list is handled correctly.
   *
   * @param pDao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final RoomDetailsDAO pDao) {
    new Expectations() {
      {
        // result = pDao.show();
        pDao.show();
        result = new ArrayList<RoomDetails>();
      }
    };
    new MockUp<RoomDetailsFactory>() {
      @Mock
      RoomDetailsDAO dao() {
        return pDao;
      }

    };
    List<RoomDetails> roomDetailsList = RoomDetailsFactory.showRoomDetails();
    assertEquals(0, roomDetailsList.size());
  }

  /**
   * Tests that a list with some roomdetails are handled correctly.
   *
   * @param pDao mocking the dao class
   */
  @Test
  public final void testListAllSoSome(@Mocked final RoomDetailsDAO pDao) {
    final RoomDetails roomdetails1 = new RoomDetails(100, "View", 1000f, "2016-02-01", "2016-02-10");
    final RoomDetails roomdetails2 = new RoomDetails(101, "Room", 1500f, "2016-01-04", "2016-01-11");
    final List<RoomDetails> roomDetailsList = new ArrayList<RoomDetails>();
    new Expectations() {
      {
        roomDetailsList.add(roomdetails1);
        roomDetailsList.add(roomdetails2);
        pDao.show();
        result = roomDetailsList;
      }
    };
    new MockUp<RoomDetailsFactory>() {
      @Mock
      RoomDetailsDAO dao() {
        return pDao;
      }

    };

    List<RoomDetails> roomDetailsListNew = RoomDetailsFactory.showRoomDetails();
    final RoomDetails roomdetails3 = new RoomDetails(100, "View", 1000f, "2016-02-01", "2016-02-10");
    assertEquals(2, roomDetailsListNew.size());
    assertEquals(roomdetails3.getRoomNo(), roomDetailsListNew.get(0).getRoomNo());
  }

}
