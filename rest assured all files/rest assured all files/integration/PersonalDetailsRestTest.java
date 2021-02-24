package com.hexaware.MLP269.integration.test;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.net.URISyntaxException;

import com.jayway.restassured.http.ContentType;

import org.junit.Test;

public class PersonalDetailsRestTest {
    
    @Test
    public void testPersonDetailsList() throws AssertionError, URISyntaxException{
        PersonalDetails [] personaldetails = given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/personaldetails")).getBody().as(PersonalDetails[].class);
    for(PersonalDetails personaldetail : personaldetails)
    switch(personaldetail.getGuestId())
        {
            case 101:
              assertEquals(101, personaldetail.getGuestId());
              break;
            case 102:
              assertEquals(102, personaldetail.getGuestId());
              break;
            case 103:
              assertEquals(103,personaldetail.getGuestId());
              break;
            case 401:
              assertEquals(401,personaldetail.getGuestId());
              break;
            case 104:
              assertEquals(104,personaldetail.getGuestId());
              break;
            default:
              fail("Unknown GuestId"+ personaldetail.getGuestId());
              break;
            /* default:
              fail("Unknown GuestId"+ personaldetail.getGuestId());
              break; */
        }
    }

    @Test
    	public void testPersonalDetailsInvalidURL() throws AssertionError, URISyntaxException {
    		given().accept(ContentType.JSON).when()
    				.get(CommonUtil.getURI("/api/personal_details")).then().assertThat().statusCode(404);
      }
      
    @Test
      public void testInsertPersonalDetails() throws AssertionError, URISyntaxException {
        String result = given().accept(ContentType.JSON).contentType("application/json").body("{\"guestId\": \"104\",\"guestName\": \"JOHN\",\"address\": \"BANGALORE\",\"phoneNo\": \"876541907\",\"email\": \"JOHN@EMAIL.COM\",\"username\": \"JOHN\",\"password\": \"JOHN123\"}").when().post(CommonUtil.getURI("/api/personaldetails")).getBody().asString();
        System.out.println("testInsertPersonalDetails Result : " + result);
        assertNotEquals("0", result);
        assertEquals("1", result);
      }
    @Test
      public void testDeletePersonalDetails() throws AssertionError, URISyntaxException{
        given().accept(ContentType.JSON).when().delete(CommonUtil.getURI("/api/personaldetails/107")).then().assertThat().statusCode(200);
      }
    @Test
    public void testUpdatePersonalDetails() throws AssertionError,URISyntaxException {
      String result = given().accept(ContentType.JSON).contentType("application/json")
      .body("{\"guestId\" : \"102\",\"address\" : \"Kolkata\",\"phoneNo\" : \"773195\"}").when().put(CommonUtil.getURI("/api/personaldetails")).getBody().asString();
      System.out.println("testUpdatePersonalDetails Result : " + result);
      assertNotEquals("0", result);
      assertEquals("1", result);
    }
}





