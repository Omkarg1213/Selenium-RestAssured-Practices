package restAssuredTestScripts;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class CryptoWallet {
String link = "https://crypto-wallet-server.mock.beeceptor.com";
	@Test
	
	public void toRegisterUser() {
	    RestAssured.baseURI = link;
	    String requestBody = "{ \"username\": \"user123\", \"password\": \"securepassword\", \"email\": \"user@example.com\" }";
	    
	    given()
	        .header("Content-Type", "application/json")
	        .body(requestBody)
	        .post("/api/v1/register")
	        .then()
	        .log().all().assertThat().statusCode(200);
	}
	
	@Test
	public void toLoginUser() {
	    RestAssured.baseURI = link;
	    String requestBody = "{ \"username\": \"user123\", \"password\": \"securepassword\"}";
	    
	    given()
	        .header("Content-Type", "application/json")
	        .body(requestBody)
	        .post("/api/v1/login")
	        .then()
	        .log().all()
	        .assertThat()
	        .statusCode(200);
	}
	
	@Test
	public void toRetrieveBalance() {
	    RestAssured.baseURI = link;
	    given()
	        .get("/api/v1/balance")
	        .then()
	        .log().all()
	        .assertThat()
	        .statusCode(200);
	}
	
	@Test
	public void toListAllTransactions() {
	    RestAssured.baseURI = link;
	    given()
	        .get("/api/v1/transactions")
	        .then()
	        .log().all()
	        .assertThat()
	        .statusCode(200);
	}
	
    @Test
	
	public void toTransferToTranspient() {
	    RestAssured.baseURI = link;
	    String requestBody = "{\r\n"
	    		+ "  \"recipient_address\": \"0x1234567890ABCDEF\",\r\n"
	    		+ "  \"amount\": 5.0,\r\n"
	    		+ "  \"currency\": \"ETH\"\r\n"
	    		+ "}";
	    
	    given()
	        .header("Content-Type", "application/json")
	        .body(requestBody)
	        .post("/api/v1/transactions")
	        .then()
	        .log().all().assertThat().statusCode(200);
	}
	
    @Test

    public void toCalculateTransaction_fee() {
       RestAssured.baseURI = link;
       String requestBody = "{\r\n"
    		+ "  \"amount\": 2.5,\r\n"
    		+ "  \"currency\": \"BTC\",\r\n"
    		+ "  \"recipient_address\": \"0x1234567890ABCDEF\"\r\n"
    		+ "}";
    
       given()
          .header("Content-Type", "application/json")
          .body(requestBody)
          .post("/api/v1/transaction_fee")
          .then()
          .log().all().assertThat().statusCode(200);
       }

      @Test
      public void toListAvailableExchange_rates() {
         RestAssured.baseURI = link;
         given()
           .get("/api/v1/exchange_rates")
           .then()
           .log().all()
           .assertThat()
           .statusCode(200);
     }

}
