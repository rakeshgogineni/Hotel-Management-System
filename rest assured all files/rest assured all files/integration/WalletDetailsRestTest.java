package com.riario.integration.test;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.net.URISyntaxException;

import com.jayway.restassured.http.ContentType;

import org.junit.Test;

public class WalletDetailsRestTest {
    
    @Test
    public void testWalletDetailsList() throws AssertionError, URISyntaxException{
        WalletDetails [] walletdetails = given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/walletdetails")).getBody().as(WalletDetails[].class);
    for(WalletDetails walletdetail : walletdetails)
    switch(walletdetail.getWalletId())
        {
            case 1:
              assertEquals(1, walletdetail.getWalletId());
              break;
            case 2:
              assertEquals(2, walletdetail.getWalletId());
              break;
            // case 3:
            //   assertEquals(103,personaldetails.getGuestId());
            //   break;
            default:
              fail("Unknown walletId"+ walletdetail.getWalletId());
              break;
        }
    }

    @Test
    	public void testWalletDetailsInvalidURL() throws AssertionError, URISyntaxException {
    		given().accept(ContentType.JSON).when()
    				.get(CommonUtil.getURI("/api/wallet_details")).then().assertThat().statusCode(404);
      }
    @Test
      public void testInsertWalletDetails() throws AssertionError, URISyntaxException {
        String result = given().accept(ContentType.JSON).contentType("application/json").body("{\"walletId\": \"3\",\"walletType\": \"Paytm wallet\",\"walletAmount\": \"7000\"}").when().post(CommonUtil.getURI("/api/walletdetails")).getBody().asString();
        System.out.println("testInsertWalletDetails Result :" + result);
        assertNotEquals("0", result);
        assertEquals("1", result);
      }
    @Test
      public void testDeleteWalletDetails() throws AssertionError, URISyntaxException{
        given().accept(ContentType.JSON).when().delete(CommonUtil.getURI("/api/walletdetails/1")).then().assertThat().statusCode(200);
      } 
      @Test
      public void testUpdateWalletDetails() throws AssertionError,URISyntaxException {
        String result = given().accept(ContentType.JSON).contentType("application/json")
        .body("{\"walletId\": \"2\",\"walletType\": \"Payzapp\",\"walletAmount\": \"400\"}").when().put(CommonUtil.getURI("/api/walletdetails")).getBody().asString();
        System.out.println("testUpdateWalletDetails Result : " + result);
        assertNotEquals("0", result);
        assertEquals("1", result);
      }
}



