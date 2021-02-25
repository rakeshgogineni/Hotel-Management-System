package com.riario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import com.riario.factory.WalletDetailsFactory;
import com.riario.model.WalletDetails;
import com.riario.persistence.WalletDetailsDAO;

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
public class WalletDetailsTest {
   /**
   * Tests the equals/hashcode methods of the offer class.
  */
  @Test
  public final void testWallet() {
    WalletDetails wallet1 = new WalletDetails(1, "Amazon wallet", 500);
    assertNotEquals(wallet1, null);
    WalletDetails wallet2 = new WalletDetails(1, "Amazon wallet", 500);
    assertEquals(wallet2.hashCode(), wallet1.hashCode());
    WalletDetails wallet3 = new WalletDetails();
    wallet3.setWalletId(2);
    wallet3.setWalletType("Payzapp");
    wallet3.setWalletAmount(500);
    WalletDetails wallet4 = new WalletDetails(3, "paytm wallet", 600);
    assertNotEquals(wallet3.getWalletType(), wallet4.getWalletType());
    assertNotEquals(wallet3.getWalletAmount(), wallet4.getWalletAmount());
    assertNotEquals(wallet3.getWalletId(), wallet4.getWalletId());
    assertEquals(wallet1.toString(), wallet2.toString());
  }
  /**
   * Tests the equals/hashcode methods of the offer class.
   */
  @Test
  public final void testWalletEquality() {
    WalletDetails wallet0 = new WalletDetails(100, "Paytm", 10000);
    WalletDetails wallet1 = new WalletDetails(100, "Paytm", 10000);
    WalletDetails wallet2 = new WalletDetails(101, "Paytm", 10000);
    WalletDetails wallet3 = new WalletDetails(101, "Phonepe", 10000);
    WalletDetails wallet4 = new WalletDetails(101, "Phonepe", 11000);
    WalletDetails wallet5 = new WalletDetails(101, "Phonepe", 12000);
    WalletDetails wallet6 = new WalletDetails(101, "Phonepe", 11000);
    WalletDetails wallet7 = new WalletDetails(101, null, 11000);

    assertNotEquals(wallet1, null);
    assertEquals(wallet1, wallet1);
    assertNotEquals(wallet1, new Object());
    assertNotEquals(wallet1, wallet2);
    assertNotEquals(wallet2, wallet3);
    assertNotEquals(wallet3, wallet4);
    assertNotEquals(wallet4, wallet5);
    assertNotEquals(wallet5, wallet6);
    assertEquals(wallet0, wallet1);
    assertNotEquals(wallet7, wallet6);
  }
   /**
   * tests that empty room list is handled correctly.
   *
   * @param pDao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final WalletDetailsDAO pDao) {
    new Expectations() {
      {
        // result = pDao.show();
        pDao.show();
        result = new ArrayList<WalletDetails>();
      }
    };
    new MockUp<WalletDetailsFactory>() {
      @Mock
      WalletDetailsDAO dao() {
        return pDao;
      }
    };
    List<WalletDetails> walletList = WalletDetailsFactory.showWalletDetails();
    assertEquals(0, walletList.size());
  }
  /**
   * Tests that a list with some roomdetails are handled correctly.
   *
   * @param pDao mocking the dao class
   */
  @Test
  public final void testListAllSoSome(@Mocked final WalletDetailsDAO pDao) {
    final WalletDetails wallet1 = new WalletDetails(1, "Amazon wallet", 500);
    final WalletDetails wallet2 = new WalletDetails(2, "paytm wallet", 600);
    final List<WalletDetails> walletDetailsList = new ArrayList<WalletDetails>();
    new Expectations() {
      {
        walletDetailsList.add(wallet1);
        walletDetailsList.add(wallet2);
        pDao.show();
        result = walletDetailsList;
      }
    };
    new MockUp<WalletDetailsFactory>() {
      @Mock
      WalletDetailsDAO dao() {
        return pDao;
      }
    };
    List<WalletDetails> walletDetailsListNew = WalletDetailsFactory.showWalletDetails();
    final WalletDetails wallet3 = new WalletDetails(1, "Amazon wallet", 500);
    assertEquals(2, walletDetailsListNew.size());
    assertEquals(wallet3.getWalletId(), walletDetailsListNew.get(0).getWalletId(), 0.0F);
  }
}
