package com.hexaware.MLP269.util;

import java.util.List;
import java.util.Scanner;

import com.hexaware.MLP269.factory.BookingDetailsFactory;
import com.hexaware.MLP269.factory.HotelFactory;
import com.hexaware.MLP269.factory.OfferFactory;
import com.hexaware.MLP269.factory.RoomDetailsFactory;
import com.hexaware.MLP269.factory.RoomFactory;
import com.hexaware.MLP269.factory.TransactionDetailsFactory;
import com.hexaware.MLP269.factory.WalletDetailsFactory;
import com.hexaware.MLP269.model.BookingDetails;
import com.hexaware.MLP269.model.Hotel;
import com.hexaware.MLP269.factory.PersonalDetailsFactory;
import com.hexaware.MLP269.model.PersonalDetails;
import com.hexaware.MLP269.model.Room;
//import com.hexaware.MLP269.factory.RoomFactory;
// import com.hexaware.MLP269.model.Hotel;
import com.hexaware.MLP269.model.Offer;
import com.hexaware.MLP269.model.RoomDetails;
import com.hexaware.MLP269.model.TransactionDetails;
// import com.hexaware.MLP269.model.Room;
import com.hexaware.MLP269.model.WalletDetails;

/**
 * CliMain used as Client interface for java coading.
 *
 *
 * @author hexware
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  /**
   * mainRoom method used to display the option we had in the application.
   */
  private void mainRoom() {
    System.out.println("Hotel Management System");
    System.out.println("-----------------------");
    System.out.println("******************************************************************");
    System.out.println("1. Rooms");
    System.out.println("2. Offers");
    System.out.println("3. Hotel");
    System.out.println("4. Room Details");
    System.out.println("5. Personal Details");
    System.out.println("6. Wallet Details");
    System.out.println("7. Transaction Details");
    System.out.println("8. B>ooking Detail");
    System.out.println("******************************************************************");
    System.out.println("0. Exit");

    mainRoomDetails();
  }

  /**
   * mainRoomDetails method process the option selected from main menu.
   */
  private void mainRoomDetails() {
    try {
      System.out.println("Enter your choice:");
      int roomOption = option.nextInt();
      switch (roomOption) {
        case 1:
          showFullRoom();
          break;
        case 2:
          offerModule();
          break;
        case 3:
          hotelModule();
          break;
        case 4:
          roomModule();
          break;
        case 5:
          personalDetailsModule();
          break;
        case 6:
          walletModule();
          break;
        case 7:
          transactionModule();
          break;
        case 8:
          bookingModule();
          break;
        case 0:
          Runtime.getRuntime().halt(0);
          break;
        default:
          System.out.println("Choose your choice");
      }
    } catch (Exception e) {
      System.out.println(e);
      System.out.println("enter a valid value");
    }
    option.nextLine();
    mainRoom();
  }

  /**
   * showFullRoom method display the room details stored in database.
   */
  private void offerModule() {
    System.out.println("******************************************************************");
    System.out.println("1: Show Offers");
    System.out.println("2: Update Offers");
    System.out.println("3: Add Offers");
    System.out.println("4: Delete Offers");
    System.out.println("******************************************************************");
    int offerOption = option.nextInt();
    switch (offerOption) {
      case 1:
        showOffers();
        break;
      case 2:
        updateOffer();
        break;
      case 3:
        addOffer();
        break;
      case 4:
        deleteOffer();
        break;
      default:
        System.out.println("Enter your Option");
    }
  }

  /**
   * showFullRoom method display the room details stored in database.
   */
  private void hotelModule() {
    System.out.println("******************************************************************");
    System.out.println("1: Show Hotel");
    System.out.println("2: Update Hotel");
    System.out.println("3: Add Hotel");
    System.out.println("4: Delete Hotel");
    System.out.println("******************************************************************");
    int hotelOption = option.nextInt();
    switch (hotelOption) {
      case 1:
        showhoteldetails();
        break;
      case 2:
        updateHotel();
        break;
      case 3:
        addHotel();
        break;
      case 4:
        deleteHotel();
        break;
      default:
        System.out.println("Enter your choice");
    }
  }

  private void roomModule() {
    System.out.println("******************************************************************");
    System.out.println("1: Show Room Details");
    System.out.println("2: Update Room Details");
    System.out.println("3: Add Room Details");
    System.out.println("4: Delete Room Details");
    System.out.println("******************************************************************");
    int roomdetailOption = option.nextInt();
    switch (roomdetailOption) {
      case 1:
        showRoomDetails();
        break;
      case 2:
        updateRoomDetails();
        break;
      case 3:
        addRoomDetails();
        break;
      case 4:
        deleteRoomDetails();
        break;
      default:
        System.out.println("Enter your choice");
    }
  }

  private void personalDetailsModule() {
    System.out.println("******************************************************************");
    System.out.println("1: Show Personal Details");
    System.out.println("2: Update Personal Details");
    System.out.println("3: Add Personal Details");
    System.out.println("4: Delete Personal Details");
    System.out.println("******************************************************************");
    int pdetailOption = option.nextInt();
    switch (pdetailOption) {
      case 1:
        showPersonalDetails();
        break;
      case 2:
        updatePersonalDetails();
        break;
      case 3:
        insertPersonalDetails();
        break;
      case 4:
        deletePersonalDetails();
        break;
      default:
        System.out.println("Enter your choice");
    }
  }

  private void walletModule() {
    System.out.println("******************************************************************");
    System.out.println("1: Show Wallet Details");
    System.out.println("2: Update Wallet Details");
    System.out.println("3: Add Wallet Details");
    System.out.println("4: Delete Wallet Details");
    System.out.println("******************************************************************");
    int walletdetailOption = option.nextInt();
    switch (walletdetailOption) {
      case 1:
        showWalletDetails();
        break;
      case 2:
        updateWalletDetails();
        break;
      case 3:
        addWalletDetails();
        break;
      case 4:
        deleteWalletDetails();
        break;
      default:
        System.out.println("Enter your choice");
    }

  }

  private void transactionModule() {
    System.out.println("******************************************************************");
    System.out.println("1: Show Transaction Details");
    System.out.println("2: Update Transaction Details");
    System.out.println("3: Add Transaction Details");
    System.out.println("4: Delete Transaction Details");
    System.out.println("******************************************************************");
    int tdetailOption = option.nextInt();
    switch (tdetailOption) {
      case 1:
        showTransactions();
        break;
      case 2:
        updateTransactions();
        break;
      case 3:
        addTransactions();
        break;
      case 4:
        deleteTransactions();
        break;
      default:
        System.out.println("Enter your choice");
    }
  }

  private void bookingModule() {
    System.out.println("******************************************************************");
    System.out.println("1: Show Booking Details");
    System.out.println("2: Update Booking Details");
    System.out.println("3: Add Booking Details");
    System.out.println("4: Delete Booking Details");
    System.out.println("******************************************************************");
    int bdetailOption = option.nextInt();
    switch (bdetailOption) {
      case 1:
        showBookingDetail();
        break;
      case 2:
        updateBookingDetails();
        break;
      case 3:
        insertBookingDetails();
        break;
      case 4:
        deleteBookingDetails();
        break;
      default:
        System.out.println("Enter your choice");
    }
  }

  /**
   * showFullRoom method display the room details stored in database.
   */
  private void showFullRoom() {
    Room[] room = RoomFactory.showRoom();
    System.out.println("Room_Id");
    for (Room m : room) {
      System.out.println(m.getRoomNo());
    }
  }

  /**
   * showOffers method display the room details stored in database.
   */
  private void showOffers() {
    List<Offer> offersList = OfferFactory.showOffer();
    System.out.println(offersList);
  }

  /**
   * addOffer method display the room details stored in database.
   */
  private void addOffer() {
    int offerId;
    System.out.println("enter offerID");
    offerId = option.nextInt();
    System.out.println("Enter offer value");
    float offerValue;
    offerValue = option.nextFloat();
    System.out.println("enter offer Name");
    String offerName;
    offerName = option.next();
    offerName += option.nextLine();
    Offer offer = new Offer(offerId, offerName, offerValue);
    int rowsInserted = OfferFactory.insertOffer(offer);
    if (rowsInserted > 0) {
      System.out.println("Offer inserted successfully!");
    }
  }

  /**
   * method delete the offer details stored in database.
   */
  private void deleteOffer() {
    int rowsDeleted = OfferFactory.deleteOffer(4);
    if (rowsDeleted > 0) {
      System.out.println("Offer deleted !");
    }
  }

  /**
   * method Update the offer details stored in database.
   */
  private void updateOffer() {
    int offerId = 1;
    String offerName = "Feb fabulous offer";
    float offerValue = 350.0f;
    Offer offer = new Offer(offerId, offerName, offerValue);
    int rowsUpdated = OfferFactory.updateOffer(offer);
    if (rowsUpdated > 0) {
      System.out.println("Offer updated successfully");
    }
  }

  /**
   * showOffers method display the room details stored in database.
   */
  private void showhoteldetails() {
    List<Hotel> hotelList = HotelFactory.showHotel();
    System.out.println(hotelList);
  }

  /**
   * addHotel method display the Hotel details stored in database.
   */
  private void addHotel() {
    int hotelId = 4;
    String hotelName = "Hotel Shiva Palace";
    String address = "G Road, Lalpur Ranchi";
    long phone = 789548L;
    int noOfRoom = 25;
    String description = "3-star, City Centre Located";
    Hotel hotel = new Hotel(hotelId, hotelName, address, phone, noOfRoom, description);
    int rowsInserted = HotelFactory.insertHotel(hotel);
    if (rowsInserted > 0) {
      System.out.println("Hotel inserted successfully!");
    }
  }

  /**
   * method display the room details stored in database.
   */
  private void deleteHotel() {
    int rowsDeleted = HotelFactory.deleteHotel(4);
    if (rowsDeleted > 0) {
      System.out.println("Offer deleted successfully!");
    }
  }

  /**
   * method display the room details stored in database.
   */
  private void updateHotel() {
    Hotel hotel = new Hotel();
    hotel.setHotelName("hotel taj");
    hotel.setNoOfRoom(10);
    int rowUpdated = HotelFactory.updateHotel(hotel);

    if (rowUpdated > 0) {
      System.out.println("Hotel Updated");
    }

  }

  /**
   * showRoomDetails method display the room details stored in database.
   */
  private void showRoomDetails() {
    List<RoomDetails> roomDetailsList = RoomDetailsFactory.showRoomDetails();
    System.out.println(roomDetailsList);
  }

  /**
   * addRoomDetails method adds the room details in database.
   */
  private void addRoomDetails() {
    int roomNo = 106;
    String roomType = "ROAD VIEW";
    float roomCost = 3010;
    String checkinDate = "2016-10-06";
    String checkoutDate = "2016-10-08";

    RoomDetails roomDetails = new RoomDetails(roomNo, roomType, roomCost, checkinDate, checkoutDate);
    int rowsInserted = RoomDetailsFactory.insertRoomDetails(roomDetails);
    if (rowsInserted > 0) {
      System.out.println("Room Details inserted successfully!");
    }
  }

  /**
   * deleteRoomDetails method deletes the roomDetails details stored in database.
   */
  private void deleteRoomDetails() {
    int rowsDeleted = RoomDetailsFactory.deleteRoomDetails(106);
    if (rowsDeleted > 0) {
      System.out.println("Room Details deleted successfully!");
    }
  }

  /**
   * updateRoomDetails method updates the roomDetails details stored in database.
   */
  private void updateRoomDetails() {
    RoomDetails roomDetails = new RoomDetails();
    roomDetails.setRoomNo(102);
    roomDetails.setRoomCost(8000);
    int rowUpdated = RoomDetailsFactory.updateRoomDetails(roomDetails);
    if (rowUpdated > 0) {
      System.out.println("Room Details Updated");
    }
  }

  /**
   * showPersonalDetails method display the personaldetails stored in database.
   */
  private void showPersonalDetails() {
    List<PersonalDetails> personaldetailsList = PersonalDetailsFactory.showPersonalDetails();
    System.out.println(personaldetailsList);
  }

  /**
   * insertPersonalDetails method display the guest details stored in database.
   */
  private void insertPersonalDetails() {
    int guestId = 103;
    String guestName = "JOHN";
    String address = "BANGALORE";
    Long phoneNo = (long) 876541907;
    String email = "JOHN@EMAIL.COM";
    String username = "JOHN";
    String password = "JOHN123";
    PersonalDetails personaldetails = new PersonalDetails(guestId, guestName, address, phoneNo, email, username,
        password);
    int rowsInserted = PersonalDetailsFactory.insertPersonalDetails(personaldetails);
    if (rowsInserted > 0) {
      System.out.println("personal details inserted successfully!");

    }
  }

  /**
   * method delete the guest details stored in database.
   */

  private void deletePersonalDetails() {
    int rowsDeleted = PersonalDetailsFactory.deletePersonalDetails(103);
    if (rowsDeleted > 0) {
      System.out.println("Personal Details deleted successfully");
    }
  }

  /**
   * method Update the guest details stored in database.
   */
  private void updatePersonalDetails() {
    int guestId = 102;
    String address = "Kolkata";
    Long phoneNo = (long) 773195;
    PersonalDetails personaldetails = new PersonalDetails(guestId, address, phoneNo);
    int rowsUpdated = PersonalDetailsFactory.updatePersonalDetails(personaldetails);
    if (rowsUpdated > 0) {
      System.out.println("Guest updated successfully");
    }
  }

  /**
   * showWallet method display the walletdetails stored in database.
   */
  private void showWalletDetails() {
    List<WalletDetails> walletDetailsList = WalletDetailsFactory.showWalletDetails();
    System.out.println(walletDetailsList);
  }

  /**
   * addwalletdetails adds walletdetails.
   */
  private void addWalletDetails() {
    int walletId = 3;
    String walletType = "Paytm wallet";
    int walletAmount = 7000;
    WalletDetails walletDetails = new WalletDetails(walletId, walletType, walletAmount);
    int rowsInserted = WalletDetailsFactory.insertWalletDetails(walletDetails);
    if (rowsInserted > 0) {
      System.out.println("Offer inserted successfully!");
    }
  }

  /**
   * method delete the wallet details stored in database.
   */
  private void deleteWalletDetails() {
    int rowsDeleted = WalletDetailsFactory.deleteWalletDetails(3);
    if (rowsDeleted > 0) {
      System.out.println("Offer deleted successfully!");
    }
  }

  /**
   * method Update the wallet details stored in database.
   */
  private void updateWalletDetails() {
    int walletId = 2;
    String walletType = "Payzapp";
    int walletAmount = 400;
    WalletDetails offer = new WalletDetails(walletId, walletType, walletAmount);
    int rowsUpdated = WalletDetailsFactory.updateWalletDetails(offer);
    if (rowsUpdated > 0) {
      System.out.println("Offer updated successfully");
    }
  }

  /**
   * showTransactions method display the room details stored in database.
   */
  private void showTransactions() {
    List<TransactionDetails> transactionList = TransactionDetailsFactory.showTransactions();
    System.out.println(transactionList);
  }

  /**
   * addWallet method display the room details stored in database.
   */
  private void addTransactions() {
    int guestId = 103;
    int walletId = 3;
    int transactionId = 7000;
    int credit = 500;
    int debit = 200;
    TransactionDetails transactionDetails = new TransactionDetails(guestId, walletId, transactionId, credit, debit);
    int rowsInserted = TransactionDetailsFactory.insertTransactions(transactionDetails);
    if (rowsInserted > 0) {
      System.out.println("Transaction inserted successfully!");
    }
  }

  /**
   * method delete the offer details stored in database.
   */
  private void deleteTransactions() {
    int rowsDeleted = TransactionDetailsFactory.deleteTransactions(7000);
    if (rowsDeleted > 0) {
      System.out.println("Wallet deleted successfully!");
    }
  }

  /**
   * method Update the offer details stored in database.
   */
  private void updateTransactions() {
    int guestId = 102;
    int walletId = 2;
    int transactionId = 8432;
    int credit = 495;
    int debit = 600;
    TransactionDetails transactionDetails = new TransactionDetails(guestId, walletId, transactionId, credit, debit);
    int rowsUpdated = TransactionDetailsFactory.updateTransactions(transactionDetails);
    if (rowsUpdated > 0) {
      System.out.println("Transactions updated successfully");
    }
  }

  /**
   * showOffers method display the room details stored in database.
   */
  private void showBookingDetail() {
    List<BookingDetails> bookingdetailsList = BookingDetailsFactory.showBookingDetails();
    System.out.println(bookingdetailsList);
  }

  /**
   * insertBookingDetails method display the room details stored in database.
   */
  private void insertBookingDetails() {
    int bookingId = 303;
    int guestId = 203;
    int hotelId = 3;
    int roomId = 103;
    String checkinDate = "21-06-2020";
    String checkoutDate = "20-07-2020";
    int amountPaid = 2000;
    int amountPending = 700;
    String status = "Confirmed";
    BookingDetails b = new BookingDetails();
    b.setAmountPaid(amountPaid);
    b.setAmountPending(amountPending);
    b.setBookingId(bookingId);
    b.setCheckinDate(checkinDate);
    b.setCheckoutDate(checkoutDate);
    b.setGuestId(guestId);
    b.setHotelId(hotelId);
    b.setRoomId(roomId);
    b.setStatus(status);
    int rowsInserted = BookingDetailsFactory.insertBookingDetails(b);
    if (rowsInserted > 0) {
      System.out.println("booking added successfully!");
    }
  }

  /**
   * method display the deletebookingdetails stored in database.
   */
  private void deleteBookingDetails() {
    int rowsDeleted = BookingDetailsFactory.deleteBookingDetails(303);
    if (rowsDeleted > 0) {
      System.out.println("booking deleted successfully!");
    }
  }

  /**
   * method display the updatebookingdetails stored in database.
   */
  private void updateBookingDetails() {
    int bookingId = 2;
    String status = "Cancelled";
    BookingDetails b = new BookingDetails();
    b.setBookingId(bookingId);
    b.setStatus(status);
    int rowsUpdated = BookingDetailsFactory.updateBookingDetails(b);

    if (rowsUpdated > 0) {
      System.out.println("bookings updated successfully");
    }
  }

  /**
   * /** main method is the basic entry point for the application.
   *
   * @param args used to get the user input.
   */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainRoom();
  }
}