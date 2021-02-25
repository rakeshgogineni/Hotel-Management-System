package com.riario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import com.riario.factory.OfferFactory;
import com.riario.model.Offer;
import com.riario.persistence.OfferDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * Test class for Offer.
 */
@RunWith(JMockit.class)
public class OfferTest {
  /**
   * Tests the equals/hashcode methods of the offer class.
   */
  @Test
  public final void testOffer() {
    // Create an Offer and test for nullability
    Offer offer1 = new Offer(100, "Aishwarya", 250.0f);
    assertNotEquals(offer1, null);
    // Two offers have equal values
    Offer offer2 = new Offer(100, "Aishwarya", 250.0f);
    assertEquals(offer1.hashCode(), offer2.hashCode());
    // Check for offer name
    Offer offer3 = new Offer(1001, "Aish", 500.0f);
    // Compare two offers for values.
    assertNotEquals(offer2.getOfferName(), offer3.getOfferName());
    assertEquals(offer1.getOfferName(), offer2.getOfferName());
    // offerId
    assertNotEquals(offer2.getOfferId(), offer3.getOfferId());
    assertEquals(offer1.getOfferId(), offer2.getOfferId());
    // offerValue
    assertNotEquals(offer2.getOfferValue(), offer3.getOfferValue());
    assertEquals(offer1.getOfferValue(), offer2.getOfferValue(), 0.0f);
    Offer offer4 = new Offer();
    offer4.setOfferId(1);
    offer4.setOfferName("Republic Day Offer");
    offer4.setOfferValue(500.50f);
    Offer offer5 = new Offer(1, "Republic Day Offer", 500.50f);
    assertEquals(offer4.getOfferId(), offer5.getOfferId());
    assertEquals(offer4.getOfferName(), offer5.getOfferName());
    assertEquals(offer4.getOfferValue(), offer5.getOfferValue(), 0.0f);
    assertNotEquals(offer4.toString(), offer1.toString());
  }

  /**
   * Tests the equals/hashcode methods of the offer class.
   */
  @Test
  public final void testOfferEquality() {
    // Create an Offer and test for nullability
    Offer offer1 = new Offer(100, "Aishwarya", 250.0f);
    Offer offer2 = new Offer(1001, "Aishwarya", 250.0f);
    Offer offer3 = new Offer(1001, "Aish", 250.0f);
    Offer offer4 = new Offer(1001, "Aish", 2500.0f);
    Offer offer5 = new Offer(1001, null, 2500.0f);
    Offer offer6 = new Offer(100, "Aishwarya", 250.0f);
    //Offer offer7 = new Offer(1001, "Aish", 250.0f);
    assertNotEquals(offer1, null);
    assertEquals(offer1, offer1);
    assertNotEquals(offer1, new Object());
    assertNotEquals(offer1, offer2);
    assertNotEquals(offer2, offer3);
    assertNotEquals(offer3, offer4);
    assertNotEquals(offer5, offer4);
    assertEquals(offer1, offer6);
  }

  /**
   * tests that empty room list is handled correctly.
   *
   * @param pDao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final OfferDAO pDao) {
    new Expectations() {
      {
        // result = pDao.show();
        pDao.show();
        result = new ArrayList<Offer>();
      }
    };
    new MockUp<OfferFactory>() {
      @Mock
      OfferDAO dao() {
        return pDao;
      }

    };
    List<Offer> offersList = OfferFactory.showOffer();
    assertEquals(0, offersList.size());
  }

  /**
   * Tests that a list with some roomdetails are handled correctly.
   *
   * @param pDao mocking the dao class
   */
  @Test
  public final void testListAllSoSome(@Mocked final OfferDAO pDao) {
    final Offer offer1 = new Offer(100, "Aishwarya", 250.0f);
    final Offer offer2 = new Offer(101, "Aish", 500.0f);
    final List<Offer> offersList = new ArrayList<Offer>();
    new Expectations() {
      {
        offersList.add(offer1);
        offersList.add(offer2);
        pDao.show();
        result = offersList;
      }
    };
    new MockUp<OfferFactory>() {
      @Mock
      OfferDAO dao() {
        return pDao;
      }

    };

    List<Offer> offersListNew = OfferFactory.showOffer();
    final Offer offer3 = new Offer(100, "Aishwarya", 250.0f);
    assertEquals(2, offersListNew.size());
    assertEquals(offer3.getOfferValue(), offersListNew.get(0).getOfferValue(), 0.0F);
  }
}
