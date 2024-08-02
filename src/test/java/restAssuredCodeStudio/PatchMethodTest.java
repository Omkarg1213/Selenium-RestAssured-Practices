package restAssuredCodeStudio;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PatchMethodTest {

	@Test
	public void toTestPatchMethod() {
		String baseUrl = "https://reqres.in/api/users/";
		int id = 559;
		
		JSONObject jsonObjectUpdateData = new JSONObject();
		jsonObjectUpdateData.put("name", "Manju");
		jsonObjectUpdateData.put("job", "Accountant");
		
		given()
		  .baseUri(baseUrl+id)
		  .header("Content_Type","application/json")
		  .contentType(ContentType.JSON)
		  .body(jsonObjectUpdateData).
		when()
		   .patch().
		then()
		   .statusCode(200)
		   .log().all();
		   
		  
		  
	}
}
