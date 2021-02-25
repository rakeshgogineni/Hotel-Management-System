package com.riario.integration.test;

import java.net.URISyntaxException;

import com.jayway.restassured.http.ContentType;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookingDetailsRestTest {
  @Test
  public void testGetBookingDetails() throws AssertionError, URISyntaxException {
    BookingDetails[] bdetails = given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/bookingdetails"))
        .getBody().as(BookingDetails[].class);
    for (BookingDetails bookingdetails : bdetails)
      switch (bookingdetails.getBookingId()) {
        case 1:
          assertEquals(1, bookingdetails.getBookingId());
          break;
        case 2:
          assertEquals(2, bookingdetails.getBookingId());
          break;
        // default:
        // fail("Unknown Booking Id" + bookingdetails.getBookingId());
        // break;
      }
  }

  @Test
  public void testGetBookingDetailsInvalidURL() throws AssertionError, URISyntaxException {
    given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/bookingdetail")).then().assertThat().statusCode(404);
  }

  @Test
  public void testInsertHotel() throws AssertionError, URISyntaxException {
    String result = given().accept(ContentType.JSON).contentType("application/json").body(
     "{\"guestId\": \"401\", \"hotelId\": \"400\", \"roomId\": \"401\", \"checkinDate\": \"2021-01-03\", \"checkoutDate\": \"2021-01-10\", \"amountPaid\": \"6000\", \"amountPending\": \"0\", \"status\": \"CONFIRMED\", \"bookingId\": \"3\"}")
        .when().post(CommonUtil.getURI("/api/bookingdetails")).getBody().asString();
    System.out.println("testInsertBooking Deatils Result : " + result);
    assertNotEquals("0", result);
    assertEquals("1", result);
  }
  
  @Test
  public void testDeleteHotel() throws AssertionError, URISyntaxException {
    given().accept(ContentType.JSON).when().delete(CommonUtil.getURI("/api/bookingdetails/2")).then().assertThat()
        .statusCode(200);
  }

  @Test
  public void testUpdateHotel() throws AssertionError,URISyntaxException {
    String result = given().accept(ContentType.JSON).contentType("application/json")
     .body("{\"guestId\": \"101\", \"hotelId\": \"1\", \"roomId\": \"103\", \"checkinDate\": \"2017-09-06\", \"checkoutDate\": \"2017-09-08\", \"amountPaid\": \"8500\", \"amountPending\": \"0\", \"status\": \"CANCELLED\", \"bookingId\": \"1\"}").when().put(CommonUtil.getURI("/api/bookingdetails")).getBody().asString();
    System.out.println("Result is : " + result);
    assertNotEquals("0", result);
    assertEquals("1", result);
    }
}
