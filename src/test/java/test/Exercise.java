package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Exercise {

    @Test
    public void test01(){

        String url = "https://automationexercise.com/api/productsList";


        Response response = given().when().get(url);

        response
                .then()
                .assertThat()
               .statusCode(200);

        response.prettyPrint();
    }
}
