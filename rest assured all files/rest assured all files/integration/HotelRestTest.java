package com.riario.integration.test;

import java.net.URISyntaxException;

import com.jayway.restassured.http.ContentType;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

public class HotelRestTest {

  @Test
  public void testHotelList() throws AssertionError, URISyntaxException {
    Hotel[] hotels = given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/hotel")).getBody()
        .as(Hotel[].class);
    for (Hotel hotel : hotels)
      switch (hotel.getHotelId()) {
        case 1:
          assertEquals(1, hotel.getHotelId());
          break;
        case 2:
          assertEquals(2, hotel.getHotelId());
          break;
        case 3:
          assertEquals(3, hotel.getHotelId());
          break;
        // default:
        //   fail("Unknown Hotel Id" + hotel.getHotelId());
        //   break;
      }

  }

  @Test
  public void testHotelsInvalidURL() throws AssertionError, URISyntaxException {
    given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/hotell")).then().assertThat().statusCode(404);
  }
  

  @Test
  public void testInsertHotel() throws AssertionError, URISyntaxException {
    String result = given().accept(ContentType.JSON).contentType("application/json").body(
        "{\"hotelId\": \"2016\",\"hotelName\": \"Hotel Raddison\",\"address\": \"Gwalior\", \"phone\": \"9977825\",\"noOfRoom\": \"15\",\"description\": \"5-STAR LUXURY\"}")
        .when().post(CommonUtil.getURI("/api/hotel")).getBody().asString();
    System.out.println("testInsertOffer Result : " + result);
    assertNotEquals("0", result);
    assertEquals("1", result);
  }

  @Test
  public void testDeleteHotel() throws AssertionError, URISyntaxException {
    given().accept(ContentType.JSON).when().delete(CommonUtil.getURI("/api/hotel/100")).then().assertThat()
        .statusCode(200);
  }

  @Test
  public void testUpdateHotel() throws AssertionError,URISyntaxException {
    String result = given().accept(ContentType.JSON).contentType("application/json")
     .body("{\"hotelId\": \"3\",\"hotelName\": \"HOTEL MARIOT\",\"address\": \"JUHU RD, JUHU TARA, JUHU, MUMBAI, MAHARASHTRA\", \"phone\": \"78542588\",\"noOfRoom\": \"15\",\"description\": \"5-STAR VILLA\"}").when().put(CommonUtil.getURI("/api/hotel")).getBody().asString();
    System.out.println("Result is : " + result);
    assertNotEquals("0", result);
     }
  

}
