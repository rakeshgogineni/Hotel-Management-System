package com.hexaware.MLP269.util;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.MLP269.factory.PersonalDetailsFactory;
import com.hexaware.MLP269.model.PersonalDetails;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;


/**
 * This class provides a REST interface for the guest entity.
 */
@Path("/personaldetails")
public class PersonalDetailsRest {
  /**
   * Returns PersonalDetails details.
   * @return the PersonalDetails details.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final List<PersonalDetails> showPersonalDetails() {
    return PersonalDetailsFactory.showPersonalDetails();
  }
  /**
   * @param guestId to initialize guestId.
   * @return the personal details.
   */
  @GET
  @Path("/{guestId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final PersonalDetails getGuestById(@PathParam("guestId") final int guestId) {
    final PersonalDetails personaldetails = PersonalDetailsFactory.getGuestById(guestId);
    if (personaldetails == null) {
      throw new NotFoundException("PersonalDetails with guestId : " + guestId + " does not exist!");
    }
    return personaldetails;
  }
  /**
   * Returns Offer details by offerId.
   * @return the Offer details
   * @param personaldetails to initializze offerId
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public static final int insertPersonalDetails(final PersonalDetails personaldetails) {
    return PersonalDetailsFactory.insertPersonalDetails(personaldetails);
  }
  /**
   * @param guestId to initializze offerId
   * @return Offer details
   */
  @DELETE
  @Path("/{guestId}")
  @Produces(MediaType.APPLICATION_JSON)
  public static final int deletePersonalDetails(@PathParam("guestId") final int guestId) {
    return PersonalDetailsFactory.deletePersonalDetails(guestId);
  }
  /**
   * @param personaldetails to initialize personaldetails.
   * @return Personal Details.
   */
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final int updatePersonalDetails(final PersonalDetails personaldetails) {
    System.out.println(personaldetails);
    return PersonalDetailsFactory.updatePersonalDetails(personaldetails);
  }
}





