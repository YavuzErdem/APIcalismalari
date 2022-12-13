package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Exercise2 {


    @Test
    public void test02(){
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();

        reqBody.put("email","yvzerdem06@gmail.com");
        reqBody.put("password",23);
        reqBody.put("KAPINUMARASI",88);

        JSONObject expBody = new JSONObject();

        expBody.put("email","yvzerdem06@gmail.com");
        expBody.put("password",23);
        expBody.put("KAPINUMARASI",88);
        Response response =given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .post(url);

        response
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
               .statusCode(201);

        response.prettyPrint();

        JsonPath actBody = response.jsonPath();

        Assert.assertEquals(expBody.get("email"),actBody.get("email"));
        Assert.assertEquals(expBody.get("password"),actBody.get("password"));
        Assert.assertEquals(expBody.get("KAPINUMARASI"),actBody.get("KAPINUMARASI"));








    }

}





