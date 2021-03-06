package practice;

import base_urls.RestApiExampleUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class DummyGet02 extends RestApiExampleUrl {

        /*
         When
             I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employees
         Then
             HTTP Status Code should be 200
         And
             Content Type should be JSON
         And
            This user exists in the system
            {
            "id": 3,
            "employee_name": "Ashton Cox",
            "employee_salary": 86000,
            "employee_age": 66,
            "profile_image": ""
        },
     */
    @Test
    public void test02() {
        spec.pathParams("first", "api", "second", "v1", "third", "employees");
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        response.then().statusCode(200).contentType(ContentType.JSON)
                .body("data.id", hasItem(3),
                        "data.employee_name",hasItem("Ashton Cox"),"status",equalTo("success"));
    }

}
