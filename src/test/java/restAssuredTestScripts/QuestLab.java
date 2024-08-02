package restAssuredTestScripts;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QuestLab {

    public static void main(String[] args) {
        // Base URL
        String baseUrl = "https://api.questprotocol.xyz";

        // API key
        String apiKey = "k-601813c5-1a56-4355-b6d8-0448e4f345da"; // Replace with your actual API key

        // Secret key
        String secretKey = "s-50a78f90-a570-4a4e-bfa7-f4bf43358887e3ad5059-716c-41e6-bd42-00e466f440cd"; // Replace with your actual secret key

        // Set base URI
        RestAssured.baseURI = baseUrl;

        // Create request specification
        RequestSpecification request = RestAssured.given();

        // Add headers
        request.header("accept", "application/json");
        request.header("content-type", "application/json");
        request.header("Authorization", "Bearer " + apiKey); // Include API key
        request.header("X-Secret-Key", secretKey); // Include secret key

        // Send POST request to the login endpoint
        Response response = request.post("/api/users/wallet/login");

        // Print response body
        System.out.println(response.getBody().asString());
    }
}
