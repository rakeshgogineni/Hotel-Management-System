package com.riario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import com.riario.factory.PersonalDetailsFactory;
import com.riario.model.PersonalDetails;
import com.riario.persistence.PersonalDetailsDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * Test class for PersonalDetails.
 */
@RunWith(JMockit.class)
public class PersonalDetailsTest {
  /**
   * Tests the equals/hashcode methods of the guest class.
   */
  @Test
  public final void testPersonalDetails() {
    PersonalDetails personaldetails1 = new PersonalDetails(001, "Venkayya Babu", "Guntur", 77319, "venky@email.com",
        "venky", "v123");
    assertNotEquals(personaldetails1, null);
    PersonalDetails personaldetails2 = new PersonalDetails(001, "Venkayya Babu", "Guntur", 77319, "venky@email.com",
        "venky", "v123");
    assertEquals(personaldetails1.hashCode(), personaldetails2.hashCode());
    PersonalDetails personaldetails3 = new PersonalDetails(000, "Venkayya", "Andhra", 9977, "venkayya@gmail.com",
        "venkat", "New123");
    // guestId
    assertNotEquals(personaldetails2.getGuestId(), personaldetails3.getGuestId());
    assertEquals(personaldetails1.getGuestId(), personaldetails2.getGuestId());
    // guestName
    assertNotEquals(personaldetails2.getGuestName(), personaldetails3.getGuestName());
    assertEquals(personaldetails1.getGuestName(), personaldetails2.getGuestName());
    // Address
    assertNotEquals(personaldetails2.getAddress(), personaldetails3.getAddress());
    assertEquals(personaldetails1.getAddress(), personaldetails2.getAddress());
    // phone
    assertNotEquals(personaldetails2.getPhoneNo(), personaldetails3.getPhoneNo());
    assertEquals(personaldetails1.getPhoneNo(), personaldetails2.getPhoneNo());
    // email
    assertNotEquals(personaldetails2.getEmail(), personaldetails3.getEmail());
    assertEquals(personaldetails1.getEmail(), personaldetails2.getEmail());
    // username
    assertNotEquals(personaldetails2.getUsername(), personaldetails3.getUsername());
    assertEquals(personaldetails1.getUsername(), personaldetails2.getUsername());
    // password
    assertNotEquals(personaldetails2.getPassword(), personaldetails3.getPassword());
    assertEquals(personaldetails1.getPassword(), personaldetails2.getPassword());

    PersonalDetails personaldetails4 = new PersonalDetails();
    personaldetails4.setGuestId(010);
    personaldetails4.setGuestName("Giri");
    personaldetails4.setAddress("Andhra");
    personaldetails4.setPhoneNo(8465454);
    personaldetails4.setEmail("giri@email.com");
    personaldetails4.setUsername("Giri");
    personaldetails4.setPassword("New990");

    PersonalDetails personaldetails5 = new PersonalDetails(010, "Giri", "Andhra", 8465454, "giri@email.com", "Giri",
        "New990");
    assertEquals(personaldetails4.getGuestId(), personaldetails5.getGuestId());
    assertEquals(personaldetails4.getGuestName(), personaldetails5.getGuestName());
    assertEquals(personaldetails4.getAddress(), personaldetails5.getAddress());
    assertEquals(personaldetails4.getPhoneNo(), personaldetails5.getPhoneNo());
    assertEquals(personaldetails4.getEmail(), personaldetails5.getEmail());
    assertEquals(personaldetails4.getUsername(), personaldetails5.getUsername());
    assertEquals(personaldetails4.getPassword(), personaldetails5.getPassword());
    assertNotEquals(personaldetails4.toString(), personaldetails1.toString());
  }

  /**
   * Tests the equals/hashcode methods of the offer class.
   */
  @Test
  public final void testPersonalDetailsEquality() {
    PersonalDetails personaldetails0 = new PersonalDetails(001, "Venkayya Babu", "Guntur", 77319, "venky@email.com",
        "venky", "v123");
    PersonalDetails personaldetails1 = new PersonalDetails(001, "Venkayya Babu", "Guntur", 77319, "venky@email.com",
        "venky", "v123");
    PersonalDetails personaldetails2 = new PersonalDetails(002, "Venkayya Babu", "Guntur", 77319, "venky@email.com",
        "venky", "v123");
    PersonalDetails personaldetails3 = new PersonalDetails(002, "Venkayya", "Guntur", 77319, "venky@email.com", "venky",
        "v123");
    PersonalDetails personaldetails4 = new PersonalDetails(002, "Venkayya", "Andhra", 77319, "venky@email.com", "venky",
        "v123");
    PersonalDetails personaldetails5 = new PersonalDetails(002, "Venkayya", "Andhra", 7731956, "venky@email.com",
        "venky", "v123");
    PersonalDetails personaldetails6 = new PersonalDetails(002, "Venkayya", "Andhra", 7731956, "venkayya@email.com",
        "venky", "v123");
    PersonalDetails personaldetails7 = new PersonalDetails(002, "Venkayya", "Andhra", 7731956, "venkayya@email.com",
        "venkat", "v123");
    PersonalDetails personaldetails8 = new PersonalDetails(002, "Venkayya", "Andhra", 7731956, "venkayya@email.com",
        "venkat", "v456");
    assertNotEquals(personaldetails1, null);
    assertEquals(personaldetails1, personaldetails1);
    assertNotEquals(personaldetails1, new Object());
    assertNotEquals(personaldetails1, personaldetails2);
    assertNotEquals(personaldetails2, personaldetails3);
    assertNotEquals(personaldetails3, personaldetails4);
    assertNotEquals(personaldetails4, personaldetails5);
    assertNotEquals(personaldetails5, personaldetails6);
    assertNotEquals(personaldetails6, personaldetails7);
    assertNotEquals(personaldetails7, personaldetails8);
    assertEquals(personaldetails1, personaldetails0);
  }

  /**
   * tests that empty room list is handled correctly.
   *
   * @param pDao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final PersonalDetailsDAO pDao) {
    // hotelDAO interface
    // pdao mockobject...original object hotelDao
    new Expectations() {
      {
        // result = pDao.show();
        pDao.show();
        // invoke the show method which is in class HotelDao
        result = new ArrayList<PersonalDetails>();
        // empty array list
        // no database
      }
    };

    new MockUp<PersonalDetailsFactory>() {
      @Mock
      PersonalDetailsDAO dao() {
        return pDao;
      }
      // DB Connection
    };
    List<PersonalDetails> personaldetailsList = PersonalDetailsFactory.showPersonalDetails();
    assertEquals(0, personaldetailsList.size());
  }

  /**
   * Tests that a list with some roomdetails are handled correctly.
   *
   * @param pDao mocking the dao class
   */
  @Test
  public final void testListAllSoSome(@Mocked final PersonalDetailsDAO pDao) {
    final PersonalDetails personaldetails1 = new PersonalDetails(001, "Venkayya Babu", "Guntur", 77319,
        "venky@email.com", "venky", "v123");
    final PersonalDetails personaldetails2 = new PersonalDetails(000, "Venkayya", "Andhra", 9977, "venkayya@gmail.com",
        "venkat", "New123");
    final List<PersonalDetails> personaldetailsList = new ArrayList<PersonalDetails>();
    new Expectations() {
      {
        personaldetailsList.add(personaldetails1);
        personaldetailsList.add(personaldetails2);
        pDao.show();
        result = personaldetailsList;
      }
    };
    new MockUp<PersonalDetailsFactory>() {
      @Mock
      PersonalDetailsDAO dao() {
        return pDao;
      }

    };

    List<PersonalDetails> personaldetailsListNew = PersonalDetailsFactory.showPersonalDetails();
    final PersonalDetails personaldetails3 = new PersonalDetails(001, "Venkayya Babu", "Guntur", 77319,
        "venky@email.com", "venky", "v123");
    assertEquals(2, personaldetailsListNew.size());
    assertEquals(personaldetails3.getGuestId(), personaldetailsListNew.get(0).getGuestId());
  }

}
