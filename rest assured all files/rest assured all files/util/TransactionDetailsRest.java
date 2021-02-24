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

import com.hexaware.MLP269.factory.TransactionDetailsFactory;
import com.hexaware.MLP269.model.TransactionDetails;

/**
 * This class provides a REST interface for the transactionDetails entity.
 */
@Path("/transactiondetails")
public class TransactionDetailsRest {
  /**
   * Returns transactions details.
   *
   * @return the Transaction details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final List<TransactionDetails> showTransactions() {
    return TransactionDetailsFactory.showTransactions();
  }
  /**
   * @param transactionId to initialize guestId.
   * @return the personal details.
   */
  @GET
  @Path("/{transactionId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final TransactionDetails getTransactionById(@PathParam("transactionId") final int transactionId) {
    final TransactionDetails transactiondetails = TransactionDetailsFactory.getTransactionById(transactionId);
    if (transactiondetails == null) {
      throw new NotFoundException("TransactionDetails with transactionId : " + transactionId + " does not exist!");
    }
    return transactiondetails;
  }
    /**
   * Returns Offer details by offerId.
   *
   * @return the Transaction details
   * @param transactionDetails to initializze offerId
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public static final int insertTransaction(final TransactionDetails transactionDetails) {
    return TransactionDetailsFactory.insertTransactions(transactionDetails);
  }
   /**
   * Returns Offer details by transactionId.
   *
   * @return the Offer details
   * @param transactionId to initializze transactionId
   */
  @DELETE
  @Path("/{transactionId}")
  @Produces(MediaType.APPLICATION_JSON)
  public static final int deleteTransaction(@PathParam("transactionId") final int transactionId) {
    return TransactionDetailsFactory.deleteTransactions(transactionId);
  }
  /**
   * @param transactionDetails to initialize transactiondetails.
   * @return Personal Details.
   */
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final int updateTransaction(final TransactionDetails transactionDetails) {
    System.out.println(transactionDetails);
    return TransactionDetailsFactory.updateTransactions(transactionDetails);
  }
}
