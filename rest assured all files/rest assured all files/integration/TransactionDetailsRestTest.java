package com.riario.integration.test;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.net.URISyntaxException;

import com.jayway.restassured.http.ContentType;

import org.junit.Test;

public class TransactionDetailsRestTest {
    
    @Test
    public void testPersonDetailsList() throws AssertionError, URISyntaxException{
        TransactionDetails [] transactiondetails = given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/transactiondetails")).getBody().as(TransactionDetails[].class);
    for(TransactionDetails transactiondetail : transactiondetails)
    switch(transactiondetail.getTransactionId())
        {
            case 8431:
              assertEquals(8431, transactiondetail.getTransactionId());
              break;
            case 8432:
              assertEquals(8432, transactiondetail.getTransactionId());
              break;
            // case 3:
            //   assertEquals(103,personaldetails.getGuestId());
            //   break;
            /* default:
              fail("Unknown transactionId"+ transactiondetail.getTransactionId());
              break; */
        }
    }
    @Test
    	public void testtransactionDetailsInvalidURL() throws AssertionError, URISyntaxException {
    		given().accept(ContentType.JSON).when()
    				.get(CommonUtil.getURI("/api/transaction_details")).then().assertThat().statusCode(404);
      }
    @Test
    public void testInsertTransaction() throws AssertionError, URISyntaxException {
      String result = given().accept(ContentType.JSON).contentType("application/json").body("{\"guestId\": \"103\",\"walletId\": \"3\",\"transactionId\": \"7000\",\"credit\": \"500\",\"debit\": \"200\"}").when().post(CommonUtil.getURI("/api/transactiondetails")).getBody().asString();
      System.out.println("testInsertTransaction Result :" + result);
      assertNotEquals("0", result);
      assertEquals("1", result);
    }
    @Test
    public void testDeleteTransaction() throws AssertionError, URISyntaxException{
      given().accept(ContentType.JSON).when().delete(CommonUtil.getURI("/api/transactiondetails/8431")).then().assertThat().statusCode(200);
    } 
    @Test
    public void testUpdateTransactionalDetails() throws AssertionError,URISyntaxException {
      String result = given().accept(ContentType.JSON).contentType("application/json")
      .body("{\"guestId\": \"102\",\"walletId\": \"2\",\"transactionId\": \"8432\",\"credit\": \"495\",\"debit\": \"600\"}").when().put(CommonUtil.getURI("/api/transactiondetails")).getBody().asString();
      System.out.println("testUpdateTransactionalDetails Result : " + result);
      assertNotEquals("0", result);
      assertEquals("1", result);
    }
}



