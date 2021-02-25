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

import com.riario.factory.RoomDetailsFactory;
import com.riario.model.RoomDetails;

/**
 * This class provides a REST interface for the room entity.
 */
@Path("/roomdetails")
public class RoomDetailsRest {
  /**
   * Returns room details.
   *
   * @return the room details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final List<RoomDetails> showRoomDetails() {
    return RoomDetailsFactory.showRoomDetails();
  }

  /**
   * @param roomNo initialize the roomNo
   * @return the room details
   */
  @GET
  @Path("/{roomNo}")
  @Produces(MediaType.APPLICATION_JSON)
  public final RoomDetails getRoomDetailsByRoomNo(@PathParam("roomNo") final int roomNo) {
    final RoomDetails roomDetails = RoomDetailsFactory.getRoomDetailsByRoomNo(roomNo);
    if (roomDetails == null) {
      throw new NotFoundException("Room Details with roomNo : " + roomNo + " does not exist!");
    }
    return roomDetails;
  }

  /**
   * Returns Room details by roomNo.
   *
   * @return the Room details
   * @param roomDetails to initializze roomNo
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public static final int insertRoomDetails(final RoomDetails roomDetails) {
    return RoomDetailsFactory.insertRoomDetails(roomDetails);
  }

  /**
   * Returns Room details by roomNo.
   *
   * @return the RoomDetails details
   * @param roomNo to initializze roomNo
   */
  @DELETE
  @Path("/{roomNo}")
  @Produces(MediaType.APPLICATION_JSON)
  public static final int deleteRoomDetails(@PathParam("roomNo") final int roomNo) {
    return RoomDetailsFactory.deleteRoomDetails(roomNo);
  }

  /**
   * Returns Room details by roomNo.
   *
   * @return the RoomDetails details
   * @param roomDetails to initializze roomDetails
   */

  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final int updateRoomDetails(final RoomDetails roomDetails) {
    System.out.println(roomDetails);
    return RoomDetailsFactory.updateRoomDetails(roomDetails);
  }
}
