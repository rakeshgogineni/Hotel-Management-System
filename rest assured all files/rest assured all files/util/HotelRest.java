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

import com.hexaware.MLP269.factory.HotelFactory;
import com.hexaware.MLP269.model.Hotel;

/**
 * This class provides a REST interface for the Offer entity.
 */
@Path("/hotel")
public class HotelRest {
  /**
   * Returns Offer details.
   *
   * @return the Offer details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Hotel> showHotels() {
    return HotelFactory.showHotel();
  }

  /**
   * Returns Offer details by offerId.
   *
   * @return the Offer details
   * @param hotelId to initializze offerId
   */
  @GET
  @Path("/{hotelId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Hotel getHotelById(@PathParam("hotelId") final int hotelId) {
    final Hotel hotel = HotelFactory.getHotelById(hotelId);
    if (hotel == null) {
      throw new NotFoundException("Hotel with hotelId : " + hotelId + " does not exist!");
    }
    return hotel;
  }

  /**
   * Returns Offer details by offerId.
   *
   * @return the Offer details
   * @param hotel to initializze offerId
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public static final int insertOffer(final Hotel hotel) {
    return HotelFactory.insertHotel(hotel);
  }

  /**
   * Returns Offer details by offerId.
   *
   * @return the Offer details
   * @param hotelId to initializze offerId
   */
  @DELETE
  @Path("/{hotelId}")
  @Produces(MediaType.APPLICATION_JSON)
  public static final int deleteHotel(@PathParam("hotelId") final int hotelId) {
    return HotelFactory.deleteHotel(hotelId);
  }
    /**
   * Returns Offer details by offerId.
   *
   * @return the Offer details
   * @param hotel to initializze offerId
   */
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final int update(final Hotel hotel) {
    System.out.println(hotel);
    return HotelFactory.updateHotel(hotel);
  }

}
