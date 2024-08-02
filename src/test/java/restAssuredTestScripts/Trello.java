package restAssuredTestScripts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Trello {
	String id;
@Test(enabled = true)
public void createBoard() {
	RestAssured.baseURI = "https://api.trello.com";
	
	Response rep = given().queryParam("name", "om").queryParam("key", "8ab92ce1820277b5769cb80d4cc7904e")
	.queryParam("token", "ATTAbfa498c027272fcfcade2a3359f55909ce060268bc45ff3a8f0bf659c8b219cf275CC8EA")
	.header("Content-Type", "application/xml").post("/1/boards/")
	.then().extract().response();
	
	String repJson = rep.asString();
	JsonPath js = new JsonPath(repJson);
    id = js.get("id");
	System.out.println(id);
	
}

@Test(enabled = false)
public void getBoard() {
	RestAssured.baseURI = "https://api.trello.com";
	
	given().queryParam("key", "8ab92ce1820277b5769cb80d4cc7904e")
	.queryParam("token", "ATTAbfa498c027272fcfcade2a3359f55909ce060268bc45ff3a8f0bf659c8b219cf275CC8EA")
	.header("Content-Type", "application/json").get("/1/boards/"+"65fc1beee1d3cc3848271092")
	.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
}

@Test(enabled = false)
public void delete() {
RestAssured.baseURI = "https://api.trello.com";
	
	given().queryParam("key", "8ab92ce1820277b5769cb80d4cc7904e")
	.queryParam("token", "ATTAbfa498c027272fcfcade2a3359f55909ce060268bc45ff3a8f0bf659c8b219cf275CC8EA")
	.header("Content-Type", "application/json").delete("/1/boards/"+id)
	.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
}
}
