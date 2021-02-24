package com.hexaware.MLP269.factory;

import java.util.List;

import com.hexaware.MLP269.model.Offer;
import com.hexaware.MLP269.persistence.DbConnection;
import com.hexaware.MLP269.persistence.OfferDAO;

/**
 * OfferFactory class used to fetch offer data from database.
 *
 * @author hexware
 */
public class OfferFactory {
  /**
   * Protected constructor.
   */
  protected OfferFactory() {

  }

  /**
   * Call the data base connection.
   *
   * @return the connection object.
   */
  private static OfferDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OfferDAO.class);
  }

  /**
   * Call the data base connection.
   *
   * @return the connection object.
   */
  public static List<Offer> showOffer() {
    OfferDAO offerDAO = dao();
    return offerDAO.show();
  }

  /**
   * Call the data base connection.
   *
   * @param offerId to initialize offer.
   * @return the offer object.
   */
  public static Offer getOfferById(final int offerId) {
    return dao().getOfferById(offerId);
  }

  /**
   * Call the data base connection.
   *
   * @param offer to initialize offer.
   * @return the connection object.
   */

  public static int insertOffer(final Offer offer) {
    OfferDAO offerDAO = dao();
    int offerId = offer.getOfferId();
    String offerName = offer.getOfferName();
    float offerValue = offer.getOfferValue();
    return offerDAO.insertOffer(offerId, offerName, offerValue);
  }
  /**
   * Call the data base connection.
   *
   * @param offer to initialize offer.
   * @return the connection object.
   */
  public static int updateOffer(final Offer offer) {
    OfferDAO offerDAO = dao();
    int offerId = offer.getOfferId();
    String offerName = offer.getOfferName();
    float offerValue = offer.getOfferValue();
    return offerDAO.updateOffers(offerId, offerName, offerValue);
  }

  /**
   * Call the data base connection.
   *
   * @param offerId to initialize offer.
   * @return the connection object.
   */

  public static int deleteOffer(final int offerId) {
    OfferDAO offerDAO = dao();
    return offerDAO.deleteOffer(offerId);
  }
}
