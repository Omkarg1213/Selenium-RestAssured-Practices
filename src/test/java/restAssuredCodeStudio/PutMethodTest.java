package restAssuredCodeStudio;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutMethodTest {

	@Test
	public void toTestPut() {
		String baseUrl = "https://reqres.in/api/users/";
	    int id = 559;
	    
	    JSONObject jsonUpdateData = new JSONObject();
	    jsonUpdateData.put("name", "Manju");
	    jsonUpdateData.put("job", "Kuri kayuvudu");
	
	    given()
	       .baseUri(baseUrl+id)
	       .header("Content-Type","application/json")
	       .contentType(ContentType.JSON)
	       .body(jsonUpdateData.toJSONString()).
	    when()
	       .put().
	    then()
	       .statusCode(200)
	       .log().all();
	    
	}
}
