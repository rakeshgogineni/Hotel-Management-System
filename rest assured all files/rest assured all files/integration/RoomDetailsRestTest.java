package com.hexaware.MLP269.integration.test;

import java.net.URISyntaxException;

import com.jayway.restassured.http.ContentType;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.fail;

public class RoomDetailsRestTest {

  @Test
  public void testGetRoomDetails() throws AssertionError, URISyntaxException {
    RoomDetails[] roomDetails = given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/roomdetails"))
        .getBody().as(RoomDetails[].class);
    for (RoomDetails roomDetail : roomDetails)
      switch (roomDetail.getRoomNo()) {
        case 101:
          assertEquals(101, roomDetail.getRoomNo());
          break;
        case 102:
          assertEquals(102, roomDetail.getRoomNo());
          break;
        case 103:
          assertEquals(103, roomDetail.getRoomNo());
          break;
        case 104:
          assertEquals(104, roomDetail.getRoomNo());
          break;
        case 105:
          assertEquals(105, roomDetail.getRoomNo());
          break;
        // default:
        // fail("Unknown Room Number" + roomDetail.getRoomNo());
        // break;
      }

  }

  @Test
  public void testGetRoomDetailsInvalidURL() throws AssertionError, URISyntaxException {
    given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/roomdetails/3")).then().assertThat()
        .statusCode(404);
  }

  @Test
  public void testInsertRoomDetails() throws AssertionError, URISyntaxException {
    String result = given().accept(ContentType.JSON).contentType("application/json").body(
        "{\"roomNo\": \"106\",\"roomType\": \"VALLEY VIEW\",\"roomCost\": \"6050\",\"checkinDate\": \"2016-10-02\",\"checkoutDate\": \"2016-10-08\"}")
        .when().post(CommonUtil.getURI("/api/roomdetails")).getBody().asString();
    System.out.println("testInsertRoomDetails Result : " + result);
    assertNotEquals("0", result);
    assertEquals("1", result);
  }

  @Test
  public void testDeleteRoomDetails() throws AssertionError, URISyntaxException {
    given().accept(ContentType.JSON).when().delete(CommonUtil.getURI("/api/roomdetails/105")).then().assertThat()
        .statusCode(200);
  }

  @Test
  public void testUpdateRoomDetails() throws AssertionError, URISyntaxException {
    String result = given().accept(ContentType.JSON).contentType("application/json")
        .body("{\"roomNo\" : \"102\",\"roomType\" : \"River View\",\"roomCost\" : \"8000\",\"checkinDate\" : \"2016-10-06\",\"checkoutDate\" : \"2016-10-08\"}").when()
        .put(CommonUtil.getURI("/api/roomdetails")).getBody().asString();
    System.out.println("Result is : " + result);
    assertNotEquals("0", result);
  }
}
