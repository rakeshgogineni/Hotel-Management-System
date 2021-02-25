package com.riario.util;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.riario.factory.BookingDetailsFactory;
import com.riario.model.BookingDetails;

/**
 * This class provides a REST interface for the Offer entity.
 */
@Path("/bookingdetails")
public class BookingDetailsRest {
  /**
   * Returns Offer details.
   *
   * @return the Offer details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final List<BookingDetails> showBookingDetails() {
    return BookingDetailsFactory.showBookingDetails();
  }

  /**
   * Returns Offer details by offerId.
   *
   * @return the Offer details
   * @param bookingId to initializze offerId
   */
  @GET
  @Path("/{bookingId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final BookingDetails getBookingDetailsById(@PathParam("bookingId") final int bookingId) {
    final BookingDetails bdetails = BookingDetailsFactory.getBookingDetailsById(bookingId);
    if (bdetails == null) {
      throw new NotFoundException("BookingDetails with bookingId : " + bookingId + " does not exist!");
    }
    return bdetails;
  }
  /**
   * Returns Offer details by offerId.
   *
   * @return the Offer details
   * @param bookingdetails to initializze offerId
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public static final int insertBookingDetails(final BookingDetails bookingdetails) {
    return BookingDetailsFactory.insertBookingDetails(bookingdetails);
  }

  /**
   * Returns Offer details by offerId.
   *
   * @return the Offer details
   * @param bookingId to initializze offerId
   */
  @DELETE
  @Path("/{bookingId}")
  @Produces(MediaType.APPLICATION_JSON)
  public static final int deleteBookingDetails(@PathParam("bookingId") final int bookingId) {
    return BookingDetailsFactory.deleteBookingDetails(bookingId);
  }
    /**
   * Returns Offer details by offerId.
   *
   * @return the Offer details
   * @param bookingDetails to initializze offerId
   */
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final int updateBookingDetails(final BookingDetails bookingDetails) {
    System.out.println(bookingDetails);
    return BookingDetailsFactory.updateBookingDetails(bookingDetails);
  }
}
