package com.riario.persistence;

import java.util.List;
import com.riario.model.WalletDetails;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * WalletDAO class used to fetch data from data base.
 *
 * @author hexware
 */
public interface WalletDetailsDAO {
  /**
   * @return the all the wallet record.
   */
  @SqlQuery("Select * from wallet_details")
  @Mapper(WalletDetailsMapper.class)
  List<WalletDetails> show();

  /**
   * @return the specific offer record by offerId.
   * @param walletId to initisalize offerid
   */
  @SqlQuery("Select * from Wallet_Details where wallet_Id = :walletId")
  @Mapper(WalletDetailsMapper.class)
  WalletDetails getWalletById(@Bind("walletId") int walletId);

  /**
   * store string part1.
   */
  String S1 = "insert into wallet_details (Wallet_Id, WALLET_TYPE, WALLET_AMOUNT)";
  /**
   * store string part2.
   */
  String S2 = "VALUES(:walletId,:walletType,:walletAmount)";

  /**
   * @param walletId     to initialize walletId
   * @param walletType   initialize walletType.
   * @param walletAmount initialize walletAmount
   * @return the no of updated offer record. used to get details through
   *         constructor.
   */
  @SqlUpdate(S1 + S2)
  int insertWallet(@Bind("walletId") int walletId, @Bind("walletType") String walletType,
      @Bind("walletAmount") int walletAmount);

  /**
   * @param walletId to initialize offerId.
   * @return the no of offer record deleted. used to get details through
   *         constructor.
   */
  @SqlUpdate(" DELETE FROM wallet_details WHERE Wallet_Id = :walletId")
  int deleteWallet(@Bind("walletId") int walletId);

  /**
   * query String1.
   */
  String K1 = "update wallet_details set Wallet_Amount = :walletAmount, ";
  /**
   * query String1.
   */
  String K2 = "Wallet_type = :walletType where Wallet_Id = :walletId";

  /**
   * @param walletId     to initialize walletId.
   * @param walletType   to initialize walletType.
   * @param walletAmount to initialize walletAmount.
   * @return the no of updated offer record. used to get details through
   *         constructor.
   */
  @SqlUpdate(K1 + K2)
  int updateWallet(@Bind("walletId") int walletId, @Bind("walletType") String walletType,
      @Bind("walletAmount") int walletAmount);
}
