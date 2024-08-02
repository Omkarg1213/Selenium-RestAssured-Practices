package restAssuredTestScripts;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenToUpdateUser {
	
	@DataProvider(name = "toUpdateData")
	public Object[][] toUpdateData(){
		return new Object[][] {
            {"Omya", "leader",919},
            {"Om", "hacker",894},
            {"Omki", "warrior",458}
        };
	}
	@Test(dataProvider = "toUpdateData", enabled = true)
	public void toUpdate(String name, String job,int userId ) {
		 String baseUrl = "https://reqres.in/api/users";
	        
	        // Create updated user data using JSON object
	        JSONObject updatedRequestBody = new JSONObject();
	        updatedRequestBody.put("name", name);
	        updatedRequestBody.put("job", job);

	        // Send PUT request to update a user
	        given()
	            .contentType("application/json")
	            .pathParam("userId", userId)
	            .body(updatedRequestBody.toString()) // Convert JSON object to string
	        .when()
	            .put(baseUrl + "/{userId}")
	        .then()
	            .statusCode(200)  // Expecting a successful update (status code 200)
	            .log().all();  
	}
	
	@Test(dataProvider = "toUpdateData", enabled = false)
	public void toDeleteUser(String name, String job,int userId) {
		 String baseUrl = "https://reqres.in/api/users"; 
	        
	       
	        given()
	            .pathParam("userId", userId)
	        .when()
	            .delete(baseUrl + "/{userId}")
	        .then()
	            .statusCode(204) 
	            .log().all();   
	}
}
