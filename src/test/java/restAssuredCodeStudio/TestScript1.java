package restAssuredCodeStudio;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestScript1 {

	@Test
	public void toAccessGoogle() {
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(res.asString());
		System.out.println(res.statusCode());
	}
}
