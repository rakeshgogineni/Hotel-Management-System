package com.riario.factory;

import java.util.List;

import com.riario.model.RoomDetails;
import com.riario.persistence.DbConnection;
import com.riario.persistence.RoomDetailsDAO;

/**
 * OfferFactory class used to fetch offer data from database.
 *
 * @author hexware
 */
public class RoomDetailsFactory {
  /**
   * Protected constructor.
   */
  protected RoomDetailsFactory() {

  }

  /**
   * Call the data base connection.
   *
   * @return the connection object.
   */
  public static RoomDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(RoomDetailsDAO.class);
  }

  // public static RoomDetails[] showRoomDetails() {
  // RoomDetailsDAO roomDetailsDAO = dao();
  // List<RoomDetails> roomDetailsList = roomDetailsDAO.show();
  // return roomDetailsList.toArray(new RoomDetails[offerList.size()]);
  // }
  /**
   * Call the data base connection.
   *
   * @return the connection object.
   */
  public static List<RoomDetails> showRoomDetails() {
    RoomDetailsDAO roomDetailsDAO = dao();
    return roomDetailsDAO.show();
  }
  /**
   * Call the data base connection.
   *
   * @param roomNo to initialize roomDetails.
   * @return the roomDetails object.
   */
  public static RoomDetails getRoomDetailsByRoomNo(final int roomNo) {
    return dao().getRoomDetailsByRoomNo(roomNo);
  }

  /**
   * Call the data base connection.
   *
   * @param roomDetails to initialize roomDetails.
   * @return the connection object.
   */
  public static int insertRoomDetails(final RoomDetails roomDetails) {
    RoomDetailsDAO roomDetailsDAO = dao();
    int roomNo = roomDetails.getRoomNo();
    String roomType = roomDetails.getRoomType();
    float roomCost = roomDetails.getRoomCost();
    String checkinDate = roomDetails.getCheckinDate();
    String checkoutDate = roomDetails.getCheckoutDate();
    int rowsInserted = roomDetailsDAO.insertRoomDetails(roomNo, roomType, roomCost, checkinDate, checkoutDate);
    return rowsInserted;
  }

  /**
   * Call the data base connection.
   *
   * @param roomNo to initialize roomDetails.
   * @return the connection object.
   */
  public static int deleteRoomDetails(final int roomNo) {
    RoomDetailsDAO roomDetailsDAO = dao();
    return roomDetailsDAO.deleteRoomDetails(roomNo);
  }

  /**
   * Call the data base connection.
   *
   * @param roomDetails to initialize roomDetails.
   * @return the connection object.
   */
  public static int updateRoomDetails(final RoomDetails roomDetails) {
    RoomDetailsDAO roomDetailsDAO = dao();
    int roomNo = roomDetails.getRoomNo();
    float roomCost = roomDetails.getRoomCost();
    return roomDetailsDAO.updateRoomDetails(roomNo, roomCost);
  }
  // ProductDAO productDAO = dbi.onDemand(ProductDAO.class);
  // int rowsUpdated = productDAO.updateProduct(100, "START WITH WHY NOT?");
  // System.out.println("No of Rows Updated : " + rowsUpdated);

}

