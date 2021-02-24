package com.hexaware.MLP269;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.MLP269.factory.TransactionDetailsFactory;
import com.hexaware.MLP269.model.TransactionDetails;
import com.hexaware.MLP269.persistence.TransactionDetailsDAO;

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
public class TransactionDetailsTest {
   /**
   * Tests the equals/hashcode methods of the offer class.
  */
  @Test
  public final void testWallet() {
    TransactionDetails wallet1 = new TransactionDetails(1, 1, 500, 200, 100);
    assertNotEquals(wallet1, null);
    TransactionDetails wallet2 = new TransactionDetails(1, 1, 500, 200, 100);
    assertEquals(wallet2.hashCode(), wallet1.hashCode());
    TransactionDetails wallet3 = new TransactionDetails();
    wallet3.setGuestId(2);
    wallet3.setWalletId(4);
    wallet3.setTransactionId(500);
    wallet3.setCredit(200);
    wallet3.setDebit(100);
    TransactionDetails wallet4 = new TransactionDetails(3, 2, 600, 200, 100);
    assertNotEquals(wallet3.getWalletId(), wallet4.getWalletId());
    assertEquals(wallet3.getCredit(), wallet4.getCredit());
    assertNotEquals(wallet3.getTransactionId(), wallet4.getTransactionId());
    assertEquals(wallet3.getDebit(), wallet4.getDebit());
    assertNotEquals(wallet3.getGuestId(), wallet4.getGuestId());
    assertEquals(wallet1.toString(), wallet2.toString());
  }
  /**
   * Tests the equals/hashcode methods of the offer class.
   */
  @Test
  public final void testWalletEquality() {
    TransactionDetails wallet0 = new TransactionDetails(100, 1, 10000, 5000, 2000);
    TransactionDetails wallet1 = new TransactionDetails(100, 1, 10000, 5000, 2000);
    TransactionDetails wallet2 = new TransactionDetails(101, 1, 10000, 5000, 2000);
    TransactionDetails wallet3 = new TransactionDetails(101, 2, 10000, 5000, 2000);
    TransactionDetails wallet4 = new TransactionDetails(101, 2, 11000, 5000, 2000);
    TransactionDetails wallet5 = new TransactionDetails(101, 2, 11000, 6000, 2000);
    TransactionDetails wallet6 = new TransactionDetails(101, 2, 11000, 6000, 1000);
    TransactionDetails wallet7 = new TransactionDetails(101, 0, 11000, 6000, 1000);

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
  public final void testListAllEmpty(@Mocked final TransactionDetailsDAO pDao) {
    new Expectations() {
      {
        // result = pDao.show();
        pDao.show();
        result = new ArrayList<TransactionDetails>();
      }
    };
    new MockUp<TransactionDetailsFactory>() {
      @Mock
      TransactionDetailsDAO dao() {
        return pDao;
      }
    };
    List<TransactionDetails> transactionList = TransactionDetailsFactory.showTransactions();
    assertEquals(0, transactionList.size());
  }
  /**
   * Tests that a list with some roomdetails are handled correctly.
   *
   * @param pDao mocking the dao class
   */
  @Test
  public final void testListAllSoSome(@Mocked final TransactionDetailsDAO pDao) {
    final TransactionDetails wallet1 = new TransactionDetails(1, 1, 500, 200, 100);
    final TransactionDetails wallet2 = new TransactionDetails(2, 2, 600, 200, 100);
    final List<TransactionDetails> walletList = new ArrayList<TransactionDetails>();
    new Expectations() {
      {
        walletList.add(wallet1);
        walletList.add(wallet2);
        pDao.show();
        result = walletList;
      }
    };
    new MockUp<TransactionDetailsFactory>() {
      @Mock
      TransactionDetailsDAO dao() {
        return pDao;
      }
    };
    List<TransactionDetails> walletListNew = TransactionDetailsFactory.showTransactions();
    final TransactionDetails wallet3 = new TransactionDetails(1, 2, 500, 200, 100);
    assertEquals(2, walletListNew.size());
    assertEquals(wallet3.getGuestId(), walletListNew.get(0).getGuestId(), 0.0F);
  }
}
