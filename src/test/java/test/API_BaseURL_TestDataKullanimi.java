package test;

import TestDataDeposu.JsonPlaceHolderTestData;
import baseURLDeposu.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class API_BaseURL_TestDataKullanimi extends JsonPlaceHolderBaseURL {

    @Test
    public void test01(){

        specJsonPlace.pathParam("pp1",22);


        JsonPlaceHolderTestData jsonPlaceHolder = new JsonPlaceHolderTestData();

        JSONObject expBody = jsonPlaceHolder.expectedDataOlustur();


        Response response = given().spec(specJsonPlace).when().get("{pp1}");


        JsonPath respJSPath = response.jsonPath();

       assertEquals(jsonPlaceHolder.basariliStatusKod,response.getStatusCode());

       assertEquals(expBody.getInt("userId"),respJSPath.getInt("userId"));
       assertEquals(expBody.getInt("id"),respJSPath.getInt("id"));
       assertEquals(expBody.getString("title"),respJSPath.getString("title"));
       assertEquals(expBody.getString("body"),respJSPath.getString("body"));






    }
}
