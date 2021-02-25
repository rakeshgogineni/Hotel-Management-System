package com.riario.factory;

import java.util.List;

import com.riario.model.TransactionDetails;
import com.riario.persistence.DbConnection;
import com.riario.persistence.TransactionDetailsDAO;

/**
 * transactionDetailFactory class used to fetch offer data from database.
 *
 * @author hexware
 */
public class TransactionDetailsFactory {
  /**
   * Protected constructor.
   */
  protected TransactionDetailsFactory() {
  }

  /**
   * Call the data base connection.
   *
   * @return the connection object.
   */
  private static TransactionDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(TransactionDetailsDAO.class);
  }

  /**
   * Call the data base connection.
   *
   * @return the connection object.
   */
  public static List<TransactionDetails> showTransactions() {
    TransactionDetailsDAO transactionDetailsDAO = dao();
    return transactionDetailsDAO.show();
  }
  /**
   * @param transactionId to initialize the guest.
   * @return the guest object.
   */
  public static TransactionDetails getTransactionById(final int transactionId) {
    return dao().getTransactionById(transactionId);
  }

  /**
   * Call the data base connection.
   * @param transactionDetails to initialize offer.
   * @return the connection object.
   */
  public static int insertTransactions(final TransactionDetails transactionDetails) {
    TransactionDetailsDAO transactionDetailsDAO = dao();
    int guestId = transactionDetails.getGuestId();
    int walletId = transactionDetails.getWalletId();
    int transactionId = transactionDetails.getTransactionId();
    int credit = transactionDetails.getCredit();
    int debit = transactionDetails.getDebit();
    int rowsInserted = transactionDetailsDAO.insertTransactions(guestId, walletId, transactionId, credit, debit);
    return rowsInserted;
  }

  /**
   * Call the data base connection.
   *
   * @param transactionId to initialize offer.
   * @return the connection object.
   */

  public static int deleteTransactions(final int transactionId) {
    TransactionDetailsDAO transactionDetailsDAO = dao();
    return transactionDetailsDAO.deleteTransactions(transactionId);
  };

  /**
   * Call the data base connection.
   *
   * @param transactionDetails to initialize offer.
   * @return the connection object.
   */

  public static int updateTransactions(final TransactionDetails transactionDetails) {
    TransactionDetailsDAO transactionDetailsDAO = dao();
    int guestId = transactionDetails.getGuestId();
    int walletId = transactionDetails.getWalletId();
    int transactionId = transactionDetails.getTransactionId();
    int credit = transactionDetails.getCredit();
    int debit = transactionDetails.getDebit();
    int rowsUpdated = transactionDetailsDAO.updateTransactions(guestId, walletId, transactionId, credit, debit);
    return rowsUpdated;
  }
}
