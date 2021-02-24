package com.hexaware.MLP269;

import com.hexaware.MLP269.persistence.RoomDAO;
import com.hexaware.MLP269.factory.RoomFactory;
import com.hexaware.MLP269.model.Room;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

/* import com.hexaware.MLP269.factory.RoomFactory;
import com.hexaware.MLP269.model.Room;
import com.hexaware.MLP269.persistence.RoomDAO; */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * Test class for Room.
 */
@RunWith(JMockit.class)
public class RoomTest {
  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

  /**
   * Tests the equals/hashcode methods of the room class.
   */
  @Test
  public final void testRoom() {
    // Room r = new Room();
    //Room r = new Room();
    Room r100 = new Room(100);
    Room r101 = new Room(101);
    assertNotEquals(r100, null);
    assertNotEquals(r101, null);
    assertEquals(r100.getRoomNo(), new Room(100).getRoomNo());
    r101.setRoomNo(100);
    assertNotEquals(r101, new Room(101));
    assertEquals(r100.hashCode(), new Room(100).hashCode());
    assertEquals(r100, new Room(100));
  }

  /**
   * tests that empty room list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final RoomDAO dao) {
    new Expectations() {
      {
        dao.show();
        result = new ArrayList<Room>();
      }
    };
    new MockUp<RoomFactory>() {
      @Mock
      RoomDAO dao() {
        return dao;
      }
    };
    Room[] me = RoomFactory.showRoom();
    assertEquals(0, me.length);
  }

  /**
   * Tests that a list with some roomdetails are handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final RoomDAO dao) {
    final Room r100 = new Room(100);
    final Room r101 = new Room(101);
    final ArrayList<Room> rn = new ArrayList<Room>();
    new Expectations() {
      {
        rn.add(r100);
        rn.add(r101);
        dao.show();
        result = rn;
      }
    };
    new MockUp<RoomFactory>() {
      @Mock
      RoomDAO dao() {
        return dao;
      }
    };
    Room[] rn1 = RoomFactory.showRoom();
    assertEquals(2, rn1.length);
    assertEquals(new Room(100).getRoomNo(), rn1[0].getRoomNo());
    assertEquals(new Room(101).getRoomNo(), rn1[1].getRoomNo());
  }
}

