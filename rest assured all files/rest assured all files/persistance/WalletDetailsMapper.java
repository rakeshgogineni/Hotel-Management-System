package com.hexaware.MLP269.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP269.model.WalletDetails;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * walletMapper class used to fetch offer data from database.
 *
 * @author hexware
 */
public class WalletDetailsMapper implements ResultSetMapper<WalletDetails> {
  /**
   * @param index     the index
   * @param resultSet the resultset
   * @param ctx       the context
   * @return the mapped customer object
   * @throws SQLException in case there is an error in fetching data from the
   *                      resultset
   */
  public final WalletDetails map(final int index, final ResultSet resultSet, final StatementContext ctx)
      throws SQLException {

    // Populate the values from database table
    int walletId = resultSet.getInt("WALLET_ID");
    String walletType = resultSet.getString("WALLET_TYPE");
    int walletAmount = resultSet.getInt("WALLET_AMOUNT");
    // Create an wallet instance
    // Wallet wallet = new wallet(walletId,wallettype,walletAmount,deposit
    // amount,withdrawal amount);
    WalletDetails walletDetails = new WalletDetails();
    walletDetails.setWalletId(walletId);
    walletDetails.setWalletType(walletType);
    walletDetails.setWalletAmount(walletAmount);

    // retrun the offer instance
    return walletDetails;
  }

}
