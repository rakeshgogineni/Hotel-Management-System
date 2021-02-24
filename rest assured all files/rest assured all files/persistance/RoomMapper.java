package com.hexaware.MLP269.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP269.model.Room;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * RoomMapper class used to fetch room data from database.
 * @author hexware
 */
public class RoomMapper implements ResultSetMapper<Room> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Room map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Room
       */
    return new Room(rs.getInt("ROOM_NO"));
  }
}
