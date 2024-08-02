package restAssuredTestScripts;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenToCreateUser {
	
	 @DataProvider(name = "userData")
	    public Object[][] toCreateUserData() {
	        return new Object[][] {
	            {"morpheus", "leader"},
	            {"Omkar", "hacker"},
	            {"Razi", "warrior"}
	        };
	    }

	  @Test(dataProvider = "userData")
	   public void toCreateUser(String name, String job) {
       String baseUrl = "https://reqres.in/api/users";
        
        // Create user data using JSON object
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("job", job);

        // Send POST request to create a user
        given()
            .contentType("application/json")
            .body(requestBody.toString()) // Convert JSON object to string
        .when()
            .post(baseUrl)
        .then()
            .statusCode(201)  // Expecting a successful creation (status code 201)
            .log().all();  
	}
 
}
