package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RestApiExampleUrl {
    protected RequestSpecification spec;
    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/").build();
    }
}

