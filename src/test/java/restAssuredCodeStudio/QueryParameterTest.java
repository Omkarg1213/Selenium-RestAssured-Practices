package restAssuredCodeStudio;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QueryParameterTest {

	@Test
	public void toQueryParameterTest() {
		baseURI = "https://reqres.in";
		basePath = "/api/users";
		
		RequestSpecification requestSpecifcation = given();
		requestSpecifcation.baseUri(baseURI);
		requestSpecifcation.basePath(basePath);
		requestSpecifcation.queryParam("page", 2).queryParam("id", 10);
		
		Response response = requestSpecifcation.get();
		
		ResponseBody responceBody = response.getBody();
		String responseString = responceBody.asString();
		
		System.out.println("Responce body:"+responseString);
		
		//Assert.assertEquals(responseString.contains("Janet"), true);
		
		JsonPath jsonPathView = responceBody.jsonPath();
		String actualData = jsonPathView.get("data.first_name");
		String expectedData = "Byron";
		
		Assert.assertEquals(actualData, expectedData,"Not Matched");
	}
}
