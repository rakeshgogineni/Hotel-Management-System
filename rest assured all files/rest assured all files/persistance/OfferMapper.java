package com.riario.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.riario.model.Offer;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * OfferMapper class used to fetch offer data from database.
 *
 * @author hexware
 */
public class OfferMapper implements ResultSetMapper<Offer> {
  /**
   * @param index     the index
   * @param resultSet the resultset
   * @param ctx       the context
   * @return the mapped customer object
   * @throws SQLException in case there is an error in fetching data from the
   *                      resultset
   */
  public final Offer map(final int index, final ResultSet resultSet, final StatementContext ctx) throws SQLException {

    // Populate the values from database table
    int offerId = resultSet.getInt("OFFER_ID");
    String offerName = resultSet.getString("OFFER_NAME");
    float offerValue = resultSet.getFloat("OFFER_Value");
    Offer offer = new Offer();
    offer.setOfferId(offerId);
    offer.setOfferName(offerName);
    offer.setOfferValue(offerValue);

    // retrun the offer instance
    return offer;
  }

}
