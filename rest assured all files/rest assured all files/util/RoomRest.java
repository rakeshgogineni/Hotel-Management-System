package com.hexaware.MLP269.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP269.model.Room;
import com.hexaware.MLP269.factory.RoomFactory;

/**
 * This class provides a REST interface for the Room entity.
 */
@Path("/room")
public class RoomRest {
  /**
   * Returns Room details.
   * @return the Room details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Room[] listRoom() {
    final Room[] room = RoomFactory.showRoom();
    return room;
  }
}
