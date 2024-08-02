package restAssuredCodeStudio;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostMethodTest {
	@Test
	public void toTestPost() {
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("name","Omkar");
		jsonObject.put("job","QA");
		
		given()
		  .baseUri("https://reqres.in/api/users")
		  //.header("Content-Type","application/json")
		  .contentType(ContentType.JSON)
		  .body(jsonObject.toJSONString()).
		when()
		  .post().
		 then().statusCode(201);
	}
	
	
}
