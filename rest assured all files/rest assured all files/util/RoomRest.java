package com.riario.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.riario.model.Room;
import com.riario.factory.RoomFactory;

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
