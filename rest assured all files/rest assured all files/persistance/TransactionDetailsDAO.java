package com.hexaware.MLP269.persistence;

import java.util.List;

import com.hexaware.MLP269.model.TransactionDetails;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * WalletDAO class used to fetch data from data base.
 *
 * @author hexware
 */
public interface TransactionDetailsDAO {
    /**
     * @return the all the wallet record.
     */
  @SqlQuery("Select * from Transaction_details")
  @Mapper(TransactionDetailsMapper.class)
  List<TransactionDetails> show();
  /**
   * @return the specific offer record by offerId.
   * @param transactionId to initisalize offerid
   */
  @SqlQuery("Select * from Transaction_details where transaction_Id = :transactionId")
  @Mapper(TransactionDetailsMapper.class)
  TransactionDetails getTransactionById(@Bind("transactionId") int transactionId);
     /**
     * store string part1.
     */
  String S1 = "insert into Transaction_details (GUEST_ID, WALLET_ID, TRANSACTION_ID, credit, debit)";
     /**
     * store string part2.
     */
  String S2 = "VALUES(:guestId,:walletId,:transactionId,:credit,:debit)";
    /**
     * @param guestId          to initialize guestID
     * @param walletId       initialize walletId.
     * @param transactionId     initialize transactionId
     * @param credit    initialize credit.
     * @param debit initialize withdrawAmount.
     * @return the no of updated offer record. used to get details through
     *         constructor.
     */
  @SqlUpdate(S1 + S2)
  int insertTransactions(@Bind("guestId") int guestId, @Bind("walletId") int walletId,
          @Bind("transactionId") int transactionId,
          @Bind("credit") int credit, @Bind("debit") int debit);
   /**
   * @param transactionId to initialize offerId.
   * @return the no of offer record deleted. used to get details through
   *         constructor.
   */
  @SqlUpdate(" DELETE FROM Transaction_details WHERE TRANSACTION_ID = :transactionId")
  int deleteTransactions(@Bind("transactionId") int transactionId);
  /**
   * query String1.
   */
  String K1 = "update Transaction_details set guest_Id = :guestId, WALLET_ID = :walletId,";
  /**
   * query String2.
   */
  String K2 = " credit = :credit, debit = :debit WHERE transaction_Id =:transactionId";
    /**
   * @param guestId    to initialize guestId.
   * @param walletId  to initialize walletId.
   * @param transactionId to initialize transactionId.
   * @param credit to initialize credit.
   * @param debit to initialize debit.
   * @return the no of updated offer record. used to get details through
   *         constructor.
   */
  @SqlUpdate(K1 + K2)
  int updateTransactions(@Bind("guestId") int guestId, @Bind("walletId") int walletId,
      @Bind("transactionId") int transactionId, @Bind("credit") int credit,
      @Bind("debit") int debit);
}

