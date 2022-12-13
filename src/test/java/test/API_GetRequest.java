package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class API_GetRequest {


    @Test
    public void get01(){

        // 1- Request URL ve Body olustur

        String url = "https://jsonplaceholder.typicode.com/posts/44";

        // 2- Expected Data olustur

        JSONObject exBody = new JSONObject();

        exBody.put("userId",5);
        exBody.put("title","optio dolor molestias sit");

        //System.out.println(exBody);


        // 3- Responsu kaydet

        Response response = given().when().get(url);

        // response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON);

        JsonPath actBody = response.jsonPath();

        Assert.assertEquals(exBody.get("userId"),actBody.get("userId"));
        Assert.assertEquals(exBody.get("title"),actBody.get("title"));
    }

}
