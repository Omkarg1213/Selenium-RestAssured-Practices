package restAssuredCodeStudio;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class ValidateResponceTest {

	@Test(enabled = false)
	public void toValidateResponce() {
		baseURI = "https://reqres.in/api/users?page=19";
		RequestSpecification requestSpecification = given();
		Response response = requestSpecification.get();
		int statusCode = response.getStatusCode();
		String statusLine = response.getStatusLine();
		
		Assert.assertEquals(statusCode, 200);
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	public void toValidateResponce_BDD() {
		given().
		when()
		  .get("https://reqres.in/api/users?page=19").
		then()
		  .statusCode(200)
		  .statusLine("HTTP/1.1 200 OK")
		  .log().all();

	}
}
