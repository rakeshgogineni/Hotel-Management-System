package com.riario.util;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.riario.factory.OfferFactory;
import com.riario.model.Offer;
//import com.riario.persistence.OfferDAO;

/**
 * This class provides a REST interface for the Offer entity.
 */
@Path("/offer")
public class OfferRest {
  /**
   * Returns Offer details.
   *
   * @return the Offer details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Offer> showOffers() {
    return OfferFactory.showOffer();
  }

  /**
   * Returns Offer details by offerId.
   *
   * @return the Offer details
   * @param offerId to initializze offerId
   */
  @GET
  @Path("/{offerId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Offer getOfferById(@PathParam("offerId") final int offerId) {
    final Offer offer = OfferFactory.getOfferById(offerId);
    if (offer == null) {
      throw new NotFoundException("Offer with offerId : " + offerId + " does not exist!");
    }
    return offer;
  }

  /**
   * Returns Offer details by offerId.
   *
   * @return the Offer details
   * @param offer to initializze offerId
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public static final int insertOffer(final Offer offer) {
    return OfferFactory.insertOffer(offer);
  }

  /**
   * Returns Offer details by offerId.
   * @return the Offer details
   * @param offerId to initializze offerId
   */
  @DELETE
  @Path("/{offerId}")
  @Produces(MediaType.APPLICATION_JSON)
  public static final int deleteOffer(@PathParam("offerId") final int offerId) {
    return OfferFactory.deleteOffer(offerId);
  }

  /**
   * Returns Offer details by offerId.
   *
   * @return the Offer details
   * @param offer to initializze offerId
   */
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final int update(final Offer offer) {
    System.out.println(offer);
    return OfferFactory.updateOffer(offer);
  }

}
