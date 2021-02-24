package com.hexaware.MLP269.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP269.model.TransactionDetails;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * walletMapper class used to fetch offer data from database.
 *
 * @author hexware
 */
public class TransactionDetailsMapper implements ResultSetMapper<TransactionDetails> {
  /**
   * @param index     the index
   * @param resultSet the resultset
   * @param ctx       the context
   * @return the mapped customer object
   * @throws SQLException in case there is an error in fetching data from the
   *                      resultset
   */
  public final TransactionDetails map(final int index, final ResultSet resultSet, final StatementContext ctx)
  throws SQLException {

    // Populate the values from database table
    int guestId = resultSet.getInt("GUEST_ID");
    int walletId = resultSet.getInt("WALLET_ID");
    int transactionId = resultSet.getInt("TRANSACTION_ID");
    int credit = resultSet.getInt("credit");
    int debit = resultSet.getInt("debit");
    // Create an wallet instance
    // Wallet wallet = new wallet(guestId,walletId,TransactionId,deposit amount,withdrawal amount);
    TransactionDetails transactionDetails = new TransactionDetails();
    transactionDetails.setGuestId(guestId);
    transactionDetails.setWalletId(walletId);
    transactionDetails.setTransactionId(transactionId);
    transactionDetails.setCredit(credit);
    transactionDetails.setDebit(debit);

    // retrun the offer instance
    return transactionDetails;
  }

}

