package com.techproed.day04;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest02a {
    /*
       https://restful-booker.herokuapp.com/booking/1001 url'ine
accept type'i "application/json" olan GET request'i yolladigimda
gelen response'un
status kodunun 404 oldugunu
ve Response body'sinin "Not Found" icerdigini
ve Response body'sinin "API" icermedigini test edin
     */

    @Test
    public void test01(){

        String url="https://restful-booker.herokuapp.com/booking/1001";

        Response response=given().accept("application/json").when().get(url);

        response.prettyPrint();
        System.out.println("====================");

        response.then().statusCode(404);
        Assert.assertTrue(response.asString().contains("Not Found"));
        Assert.assertFalse(response.asString().contains("API"));



        Assert.assertEquals(404,response.getStatusCode());



    }
}
