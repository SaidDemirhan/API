package com.techproed.day14;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ReqresToken {

    //@Test
    public String tokenAl(){
        String url="https://reqres.in/api/login";

        HashMap<String,String> requestBody=new HashMap<String,String>();

        requestBody.put("email","eve.holt@reqres.in");
        requestBody.put("password","cityslicka");

        //System.out.println(requestBody);


        Response response=given().
                contentType(ContentType.JSON).
                body(requestBody).when().post(url);

        //response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();

        String token=jsonPath.getString("token");
        //System.out.println(token);

        return token;











    }
}
