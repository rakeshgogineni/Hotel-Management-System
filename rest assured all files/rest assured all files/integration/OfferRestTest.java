package com.riario.integration.test;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.net.URISyntaxException;

import com.jayway.restassured.http.ContentType;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.fail;

public class OfferRestTest {

  @Test
  public void testGetOffers() throws AssertionError, URISyntaxException {
    Offer[] offers = given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/offer")).getBody()
        .as(Offer[].class);
    for (Offer offer : offers)
      switch (offer.getOfferId()) {
        case 1:
          assertEquals(1, offer.getOfferId());
          break;
        /* case 2:
          assertEquals(2, offer.getOfferId());
          break; */
        // default:
        // fail("Unknown Offer Id" + offer.getOfferId());
        // break;
      }

  }

  @Test
  public void testGetOffersInvalidURL() throws AssertionError, URISyntaxException {
    given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/offers")).then().assertThat().statusCode(404);
  }

  @Test
  public void testInsertOffer() throws AssertionError, URISyntaxException {
    String result = given().accept(ContentType.JSON).contentType("application/json")
        .body("{\"offerId\": \"3\" , \"offerName\": \"FEB SALE OFFER\" , \"offerValue\": \"350\"}").when()
        .post(CommonUtil.getURI("/api/offer")).getBody().asString();
    System.out.println("testInsertOffer Result : " + result);
    assertNotEquals("0", result);
    assertEquals("1", result);
  }

  @Test
  public void testDeleteOffer() throws AssertionError, URISyntaxException {
    given().accept(ContentType.JSON).when().delete(CommonUtil.getURI("/api/offer/2")).then().assertThat()
        .statusCode(200);
  }
     
  @Test
  public void testUpdateOffer() throws AssertionError,URISyntaxException {
    String result = given().accept(ContentType.JSON).contentType("application/json")
     .body("{\"offerId\" : \"1\",\"offerName\" : \"Black Friday sale offer\",\"offerValue\" : \"300\"}").when().put(CommonUtil.getURI("/api/offer")).getBody().asString();
    System.out.println("Result is : " + result);
    assertNotEquals("0", result);
     }
}
