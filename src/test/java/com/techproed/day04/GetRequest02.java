package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest02 {
    /*
   https://restful-booker.herokuapp.com/booking url'ine
   accept type'i "application/json" olan GET request'i yolladigimda
   gelen response'un
   status kodunun 200
   content type'inin "application/json" oldugunu test edin

    */

    @Test
            public void test01(){


    String url= "https://restful-booker.herokuapp.com/booking";

    Response response= given().accept("application/json").when().get(url);

        System.out.println("Status code: "+response.statusCode());
        System.out.println("CT: "+response.contentType());
        System.out.println("=============================");

        response.prettyPrint();
        System.out.println("============================");

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        //2. yol

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("application/json; charset=utf-8",response.getContentType());
    }
}
