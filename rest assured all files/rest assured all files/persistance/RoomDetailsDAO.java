package com.hexaware.MLP269.persistence;

import java.util.List;

import com.hexaware.MLP269.model.RoomDetails;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * RoomDetailsDAO class used to fetch data from data base.
 *
 * @author hexware
 */
public interface RoomDetailsDAO {
  /**
   * @return the all the roomDetails record.
   */
  @SqlQuery("SELECT * FROM ROOM_DETAILS")
  @Mapper(RoomDetailsMapper.class)
  List<RoomDetails> show();

  /**
   * @return the specific roomDetails record by roomNo.
   * @param roomNo to initisalize roomNo
   */
  @SqlQuery("Select * from Room_Details where room_no = :roomNo")
  @Mapper(RoomDetailsMapper.class)
  RoomDetails getRoomDetailsByRoomNo(@Bind("roomNo") int roomNo);


  /**
   * InsertQuery1 to store part of insert query.
   */
  String INSERTQUERY1 = "insert into Room_Details(room_No,room_Type,room_Cost,checkin_date,checkout_date)";
  /**
   * InsertQuery2 to store part of insert query.
   */
  String INSERTQUERY2 = "values(:roomNo,:roomType,:roomCost,:checkinDate,:checkoutDate)";

  /**
   * @param roomNo       to initialize roomNo.
   * @param roomType     to initialize roomType.
   * @param roomCost     to initialize roomCost.
   * @param checkinDate  to initalize checkinDate.
   * @param checkoutDate to initalize checkoutDate.
   * @return the no of updated roomDetails record. used to get details through
   *         constructor.
   */

  @SqlUpdate(INSERTQUERY1 + INSERTQUERY2)
  int insertRoomDetails(@Bind("roomNo") int roomNo, @Bind("roomType") String roomType, @Bind("roomCost") float roomCost,
      @Bind("checkinDate") String checkinDate, @Bind("checkoutDate") String checkoutDate);

  /**
   * @param roomNo to initialize roomNo.
   * @return the no of roomDetails record deleted. used to get details through
   *         constructor.
   */
  @SqlUpdate(" DELETE FROM ROOM_DETAILS WHERE room_No = :roomNo")
  int deleteRoomDetails(@Bind("roomNo") int roomNo);

  /**
   * @param roomNo   to initialize roomNo.
   * @param roomCost to initialize roomCost.
   * @return the no of roomDetails record updated. used to get details through
   *         constructor.
   */
  @SqlUpdate("UPDATE ROOM_DETAILS SET  room_cost = :roomCost WHERE room_No = :roomNo")
  int updateRoomDetails(@Bind("roomNo") int roomNo, @Bind("roomCost") float roomCost);
}
