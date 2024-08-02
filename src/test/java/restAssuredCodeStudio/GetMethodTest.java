package restAssuredCodeStudio;


import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class GetMethodTest {

	@Test(enabled = false)
	public void toTestGet() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println("Response Body: "+response.asString());
		System.out.println("Responce code: "+response.getStatusCode());
		System.out.println("Response Body: "+response.getBody().asString());
		System.out.println("Response Time (ms): " +response.getTime());
		System.out.println("Content-Type Header: " +response.getHeader("Content-Type"));
	
		int expectedCode = 200;
		int actualStatusCode = response.getStatusCode();
	
	    Assert.assertEquals(expectedCode, actualStatusCode,"Failed");
	}
	@Test
	public void toTest2Get() {
		   // Define the base URL
        String baseUrl = "https://reqres.in/api/users";
        // Set the base URI
        baseURI = baseUrl;
        int page = 2;
        
        // Given - Setting up the request with query parameters
        given()
            .queryParam("page", page)
        // When - Making the GET request
        .when()
            .get(baseUrl+page)
        // Then - Verifying the response
        .then()
            .statusCode(200) // Expecting status code 200
	        .log().all();
	}
}
