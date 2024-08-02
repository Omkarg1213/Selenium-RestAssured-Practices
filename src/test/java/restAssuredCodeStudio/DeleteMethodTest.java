package restAssuredCodeStudio;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.theInstance;

import org.testng.annotations.Test;

public class DeleteMethodTest {

	@Test
	public void toTestDeleteMethod() {
		String baseUrl = "https://reqres.in/api/users";
        int userId = 2; // 
        
       
        given()
            .pathParam("userId",userId)
        .when()
            .delete(baseUrl + "/{userId}")
        .then()
            .statusCode(204) 
            .log().all(); 
		  
	}
}
