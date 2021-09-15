package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get06 extends HerOkuAppBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/5
    When
        User send a GET request to the URL
    Then
        HTTP Status Code should be 200
    And
        response content type is “application/json”
    And
        response body should be like;
        { "firstname": "Sally",
        "lastname": "Jackson",
        "totalprice": 111,
        "depositpaid": false,
        "bookingdates": { "checkin": "2017-05-23",
                            "checkout":"2019-07-02" }
        }
     */
    @Test
    public void get06(){
        //1. Step : Set the URL

        spec.pathParams("first","booking","second",5);
        //2. Step : Set the expected data

        //3. Step : Send the request get the data

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4. Step : Do Assertion
        //1.Way :
//        response.
//                then().assertThat().statusCode(200).
//                contentType(ContentType.JSON).
//                body("firstname",equalTo("Mary"),
//                        "lastname", equalTo("Jackson"),
//                        "totalprice", equalTo(333),
//                        "depositpaid", equalTo(false),
//                        "bookingdates.checkin", equalTo("2020-01-03"),
//                        "bookingdates.checkout", equalTo("2021-05-16"),
//                        "additionalneeds",equalTo("Breakfast"));

        //2.Way : Use JsonPath. JsonPath is a class and it has many useful methods to navigate inside the Json Data
        response.
                then().assertThat().statusCode(200).
                contentType(ContentType.JSON);

        //Create JsonPath object from response object
        JsonPath json = response.jsonPath();
        assertEquals ("First name is not matching","Sally", json.getString("firstname"));
        assertEquals ("Last name is not matching","Smith", json.getString("lastname"));
        assertEquals ("Total Price is not matching",224, json.getInt("totalprice"));
        assertEquals ("Deposit Paid value is not matching",true, json.getBoolean("depositpaid"));
        assertEquals ("Checkin date is not matching","2021-04-12", json.getString("bookingdates.checkin"));
        assertEquals ("Checkout date is not matching","2021-05-07", json.getString("bookingdates.checkout"));
    }
}
