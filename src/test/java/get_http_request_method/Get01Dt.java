package get_http_request_method;

import org.junit.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Get01Dt {
    /*
        We use Gherkin Language to create test cases.
        gherkin Language has 4 main keywords; Given, When, Then, And
        Given : it is used for pre-requisites
        When : It is used for action
        Then : It is used for outputs
        And : It is used for multiple Given, When, Then
     */
    /*
                            Test Case
        Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User send Get Request to the URL
        Then
            HTTP Status Code should be 200
        And
            Content type should application/json
        And
            Status line should be like HTTP/1.1 200 OK

     */
    @Test
    public void get01(){

        //1. Step : Setting URL
        String url = "https://restful-booker.herokuapp.com/booking/3";

        //2. Step : Set the expected data

        //3. Step : Send Request and get response from API
        Response response = given().when().get(url);
        response.prettyPrint();

        //4. Step : Do assertion
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

    }
}

