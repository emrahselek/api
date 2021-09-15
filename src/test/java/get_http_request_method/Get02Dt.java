package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get02Dt extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/1001
        When
            Send a Get Request to the URL
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains “Not Found”
        And
            Response body does not contain “TechProEd”
        And
            Server is “Cowboy”
     */
    @Test
    public void get02(){
        //1. Step : Set the URL
        spec.pathParams("first","booking", "second",1001);

        //2. Step : Set the expected date

        //3. Step : Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4. Step : Do assertions
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
    }
}
