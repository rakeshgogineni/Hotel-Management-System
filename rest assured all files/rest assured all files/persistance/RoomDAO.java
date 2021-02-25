package com.riario.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.riario.model.Room;
/**
 * RoomDAO class used to fetch data from data base.
 * @author hexware
 */
public interface RoomDAO {
    /**
     * @return the all the Room record.
     */
  @SqlQuery("Select * from Room")
    @Mapper(RoomMapper.class)
    List<Room> show();
}
