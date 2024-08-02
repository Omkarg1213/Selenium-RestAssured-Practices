package restAssuredCodeStudio;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class ValidateJSONResponseBodyTest {

	@Test
	public void toValidateJSONResponseBodyTest() {
		baseURI = "https://reqres.in/api";
		basePath = "/users?page=2";
		
		RequestSpecification requestSpecifcation = given();
		Response response = requestSpecifcation.get();
		
		ResponseBody responceBody = response.getBody();
		String responseString = responceBody.asString();
		
		System.out.println("Responce body:"+responseString);
		
		//Assert.assertEquals(responseString.contains("Janet"), true);
		
		JsonPath jsonPathView = responceBody.jsonPath();
		String actualData = jsonPathView.get("data[2].first_name");
		String expectedData = "Emma";
		
		Assert.assertEquals(actualData, expectedData,"Not Matched");
	}
}
