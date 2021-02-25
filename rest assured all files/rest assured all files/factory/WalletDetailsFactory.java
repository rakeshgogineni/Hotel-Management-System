package com.riario.factory;

import java.util.List;

import com.riario.model.WalletDetails;
import com.riario.persistence.DbConnection;
import com.riario.persistence.WalletDetailsDAO;

/**
 * WalletFactory class used to fetch offer data from database.
 *
 * @author hexware
 */
public class WalletDetailsFactory {
    /**
     * Protected constructor.
     */
  protected WalletDetailsFactory() {
  }

    /**
     * Call the data base connection.
     *
     * @return the connection object.
     */
  private static WalletDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(WalletDetailsDAO.class);
  }
  /**
   * Call the data base connection.
   *
   * @return the connection object.
   */
  public static List<WalletDetails> showWalletDetails() {
    WalletDetailsDAO walletDetailsDAO = dao();
    return walletDetailsDAO.show();
  }
  /**
   * @param walletId to initialize the guest.
   * @return the guest object.
   */
  public static WalletDetails getWalletById(final int walletId) {
    return dao().getWalletById(walletId);
  }
  /**
   * Call the data base connection.
   * @param walletDetails to initialize offer.
   * @return the connection object.
   */
  public static int insertWalletDetails(final WalletDetails walletDetails) {
    WalletDetailsDAO walletDetailsDAO = dao();
    int walletId = walletDetails.getWalletId();
    String walletType = walletDetails.getWalletType();
    int walletAmount = walletDetails.getWalletAmount();
    int rowsInserted = walletDetailsDAO.insertWallet(walletId, walletType, walletAmount);
    return rowsInserted;
  }
    /**
   * Call the data base connection.
   * @param walletId to initialize offer.
   * @return the connection object.
   */

  public static int deleteWalletDetails(final int walletId) {
    WalletDetailsDAO walletDetailsDAO = dao();
    return walletDetailsDAO.deleteWallet(walletId);
  };
    /**
   * Call the data base connection.
   * @param walletDetails to initialize offer.
   * @return the connection object.
   */

  public static int updateWalletDetails(final WalletDetails walletDetails) {
    WalletDetailsDAO walletDetailsDAO = dao();
    int walletId = walletDetails.getWalletId();
    String walletType = walletDetails.getWalletType();
    int walletAmount = walletDetails.getWalletAmount();
    int rowsUpdated = walletDetailsDAO.updateWallet(walletId, walletType, walletAmount);
    return rowsUpdated;
  }
}

