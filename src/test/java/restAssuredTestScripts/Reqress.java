package restAssuredTestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.junit.experimental.theories.suppliers.TestedOn;

import static io.restassured.RestAssured.*;

public class Reqress {
	@Test(enabled = false)
	public void getListOfUsers() {
	//	https://reqres.in/api/users?page=2
	given()
	.get("https://reqres.in/api/users?page=2")
	.then()
	.statusCode(200).log().all();
	
	}
	
	@Test(enabled = false)
	public void toCheckAssertion() {
		//  https://reqres.in/api/users/2
		Response rep = RestAssured.get("https://reqres.in/api/users");
	    System.out.println(rep.body());
	    int status = rep.getStatusCode();
	    Assert.assertEquals(status, 200);
	}
	
	@Test(enabled = false)
	public void getSingleUser() {
//		given().get("https://reqres.in/api/users/2").then().statusCode(200).body("data.id", equalTo(2)).log().all();
//		given().get("https://reqres.in/api/users/3").then().statusCode(200).body("data.id", equalTo(3)).log().all();
//		given().get("https://reqres.in/api/users/4").then().statusCode(200).body("data.id", equalTo(4)).log().all();
//		given().get("https://reqres.in/api/users/5").then().statusCode(200).body("data.id", equalTo(5)).log().all();
//		given().get("https://reqres.in/api/users/6").then().statusCode(200).body("data.id", equalTo(6)).log().all();
//		given().get("https://reqres.in/api/users/7").then().statusCode(200).body("data.id", equalTo(7)).log().all();
		given().get("https://reqres.in/api/users/2").then().statusCode(200).body("data.id", equalTo(2)).log().all();
		
		//given().get("https://reqres.in/api/users/2").then().statusCode(200).body("email", equalTo("janet.weaver@reqres.in")).log().all();
//		given().get("https://reqres.in/api/users/7").then().statusCode(200).body("data.id", equalTo(7)).log().all();
//		given().get("https://reqres.in/api/users/7").then().statusCode(200).body("data.id", equalTo(7)).log().all();
//		given().get("https://reqres.in/api/users/7").then().statusCode(200).body("data.id", equalTo(7)).log().all();
		
	}
	
	@Test(enabled = false)
	public void singleUserNOTFound() {
		given()
        .get("https://reqres.in/api/users/23")
    .then()
        .statusCode(404)
        .body(equalTo("{}"))
        .log().all();
	}
	
	@Test(enabled = false)
	public void toCreateUser() {
String baseUrl = "https://reqres.in/api/users";
        
        // Create user data using JSON object
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "leader");

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
 
	@Test(enabled = false)
	public void toUpdate() {
		 String baseUrl = "https://reqres.in/api/users";
	        int userId = 2; // Specify the ID of the user you want to update
	        
	        // Create updated user data using JSON object
	        JSONObject updatedRequestBody = new JSONObject();
	        updatedRequestBody.put("name", "Omkar G");
	        updatedRequestBody.put("job", "SDET");

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
	@Test(enabled = false)
	public void toDeleteUser() {
		 String baseUrl = "https://reqres.in/api/users";
	        int userId = 2; // 
	        
	       
	        given()
	            .pathParam("userId", userId)
	        .when()
	            .delete(baseUrl + "/{userId}")
	        .then()
	            .statusCode(204) 
	            .log().all();   
	}
	
	@Test(enabled = false)
	public void toRegister() {
		String baseUrl = "https://reqres.in/api/register";

        // Create user registration data using JSON object
        JSONObject registrationData = new JSONObject();
        registrationData.put("email", "eve.holt@reqres.in");
        registrationData.put("password", "pistol");

        // Send POST request to register a new user
        given()
            .contentType("application/json")
            .body(registrationData.toString()) // Convert JSON object to string
        .when()
            .post(baseUrl)
        .then()
            .statusCode(200)  // Expecting a successful registration (status code 200)
            .log().all();  
		
	}
	
	@Test(enabled = false)
	public void toRegisterUnsuccessFull() {
		 String baseUrl = "https://reqres.in/api/register";

	        // Create user registration data using JSON object
	        JSONObject registrationData = new JSONObject();
	        // Missing email in registration data
	        registrationData.put("password", "password");

	        // Send POST request to register a new user
	        Response response = given()
	                                .contentType("application/json")
	                                .body(registrationData.toString()) // Convert JSON object to string
	                            .when()
	                                .post(baseUrl);

	        // Handle the response
	        if (response.getStatusCode() == 200) {
	            System.out.println("User registered successfully!");
	        } else {
	            System.out.println("Registration failed with status code: " + response.getStatusCode());
	            System.out.println(response.getBody().asString());
	}        
}
	@Test(enabled = false)
	public void toLogin() {
		String baseUrl = "https://reqres.in/api/login";

        // Create user registration data using JSON object
        JSONObject loginData = new JSONObject();
        loginData.put("email", "eve.holt@reqres.in");
        loginData.put("password", "pistol");

        // Send POST request to register a new user
        given()
            .contentType("application/json")
            .body(loginData.toString()) // Convert JSON object to string
        .when()
            .post(baseUrl)
        .then()
            .statusCode(200)  // Expecting a successful registration (status code 200)
            .log().all();  
		
	}	
	@Test(enabled = false)
	public void tologinUnsuccessFull() {
		 String baseUrl = "https://reqres.in/api/register";

	        // Create user registration data using JSON object
	        JSONObject loginData = new JSONObject();
	        // Missing email in registration data
	        loginData.put("password", "password");

	        // Send POST request to register a new user
	        Response response = given()
	                                .contentType("application/json")
	                                .body(loginData.toString()) // Convert JSON object to string
	                            .when()
	                                .post(baseUrl);

	        // Handle the response
	        if (response.getStatusCode() == 200) {
	            System.out.println("User registered successfully!");
	        } else {
	            System.out.println("Login failed with status code: " + response.getStatusCode());
	            System.out.println(response.getBody().asString());
	}    
}
	@Test(enabled = true)
	public void toGetDelayInResponse() {
		given()
        .get("https://reqres.in/api/users?delay=3")
    .then()
        .statusCode(200)
        .log().all();
	}
}