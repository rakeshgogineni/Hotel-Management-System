package com.hexaware.MLP269.util;

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

import com.hexaware.MLP269.factory.WalletDetailsFactory;
import com.hexaware.MLP269.model.WalletDetails;

/**
 * This class provides a REST interface for the transactionDetails entity.
 */
@Path("/walletdetails")
public class WalletDetailsRest {
  /**
   * Returns transactions details.
   *
   * @return the Transaction details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final List<WalletDetails> showWalletdDetails() {
    return WalletDetailsFactory.showWalletDetails();
  }

  /**
   * @param walletId to initialize guestId.
   * @return the personal details.
   */
  @GET
  @Path("/{walletId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final WalletDetails getWalletById(@PathParam("walletId") final int walletId) {
    final WalletDetails walletdetails = WalletDetailsFactory.getWalletById(walletId);
    if (walletdetails == null) {
      throw new NotFoundException("WalletDetails with wallettId : " + walletId + " does not exist!");
    }
    return walletdetails;
  }
      /**
   * Returns Offer details by offerId.
   *
   * @return the Wallet details
   * @param walletDetails to initializze offerId
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public static final int insertWalletDetails(final WalletDetails walletDetails) {
    return WalletDetailsFactory.insertWalletDetails(walletDetails);
  }
     /**
   * Returns Offer details by offerId.
   *
   * @return the Offer details
   * @param walletId to initializze offerId
   */
  @DELETE
  @Path("/{walletId}")
  @Produces(MediaType.APPLICATION_JSON)
  public static final int deleteWalletDetails(@PathParam("walletId") final int walletId) {
    return WalletDetailsFactory.deleteWalletDetails(walletId);
  }
    /**
   * @param walletDetails to initialize transactiondetails.
   * @return Personal Details.
   */
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final int updateWalletDetails(final WalletDetails walletDetails) {
    System.out.println(walletDetails);
    return WalletDetailsFactory.updateWalletDetails(walletDetails);
  }
}
