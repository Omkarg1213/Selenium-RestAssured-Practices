package restAssuredCodeStudio;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.Headers;
import io.restassured.http.Header;
import static io.restassured.RestAssured.given;
import org.testng.Assert;

public class ValidateHeaderTest {

    @Test
    public void toValidateHeaderTest() {
        // Given - Setting up the base URI and base path
        RestAssured.baseURI = "https://reqres.in/api";
        String basePath = "/users?page=2";

        // When - Sending the GET request
        RequestSpecification requestSpecification = given();
        Response response = requestSpecification.get(basePath);

        // Then - Verifying the content type header
        String expectedContentType = "application/json; charset=utf-8";
        String actualContentType = response.header("Content-Type");
        Assert.assertEquals(actualContentType, expectedContentType, "Content-Type header is incorrect");

        // Then - Verifying all headers
        Headers allHeaders = response.headers();
        for (Header header : allHeaders) {
            System.out.println(header.getName() + ": " + header.getValue());
            
            // Assert each header here
            switch (header.getName()) {
                case "Date":
                    // Example assertion for the "Date" header
                    Assert.assertNotNull(header.getValue(), "Mon, 25 Mar 2024 09:43:40 GMT");
                    break;
                case "Server":
                    // Example assertion for the "Server" header
                    Assert.assertTrue(header.getValue().contains("cloudflare"), "Server header value does not contain 'nginx'");
                    break;
                case "Content-Encoding":
                    // Example assertion for the "Content-Encoding" header
                    Assert.assertEquals(header.getValue(), "gzip", "Content-Encoding header is not 'gzip'");
                    break;
               
                default:
                    break;
            }
        }
    }
}
