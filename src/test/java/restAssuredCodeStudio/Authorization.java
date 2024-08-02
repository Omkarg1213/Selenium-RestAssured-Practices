package restAssuredCodeStudio;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization {

	@Test
	public void toAuthorizationTest() {
		//https://postman-echo.com/basic-auth
		baseURI = "https://postman-echo.com" ;
		basePath = "/basic-auth";
		
		RequestSpecification requestSpecification = given();
		requestSpecification.baseUri(baseURI);
		requestSpecification.basePath(basePath);
		
		Response response = requestSpecification.auth().basic("postman", "password").get();
		
		System.out.println("Responce:"+response.getStatusLine());
		
	}
}
