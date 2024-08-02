package restAssuredTestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TrelloRevision {
	String id;
	
	@Test(enabled = true)
	public void toCreateBoard() {
		///1/boards/{id}/labels?name={name}&color={color}&key=APIKey&token=APIToken
		RestAssured.baseURI = "https://api.trello.com";
		
		given().queryParam("name", "omkaar").queryParam("key", "8ab92ce1820277b5769cb80d4cc7904e")
		.queryParam("token", "ATTAbfa498c027272fcfcade2a3359f55909ce060268bc45ff3a8f0bf659c8b219cf275CC8EA")
		.header("Content-Type", "application/xml").post("/1/boards/")
		.then().log().all();
	}
	
	@Test(enabled = false)
	public void toGetBoard() {
	RestAssured.baseURI = "https://api.trello.com";
		
		Response rep =given().queryParam("key", "8ab92ce1820277b5769cb80d4cc7904e")
		.queryParam("token", "ATTAbfa498c027272fcfcade2a3359f55909ce060268bc45ff3a8f0bf659c8b219cf275CC8EA")
		.header("Content-Type","application/xml").get("/1/boards/"+"id")
		.then().assertThat().statusCode(200).extract().response();
		
		String repJson = rep.asString();
		JsonPath js = new JsonPath(repJson);
	    id = js.get("id");
		System.out.println(id);
	}

	@Test(enabled = false)
	
	public void toDeleteBoard() {
RestAssured.baseURI = "https://api.trello.com";
		
		given().queryParam("key", "8ab92ce1820277b5769cb80d4cc7904e")
		.queryParam("token", "ATTAbfa498c027272fcfcade2a3359f55909ce060268bc45ff3a8f0bf659c8b219cf275CC8EA")
		.header("Content-Type", "application/xml").delete("/1/boards/"+"id")
		.then().assertThat().statusCode(200);
	}
}
