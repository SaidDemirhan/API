package com.techproed.day04;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Alistirma {
    //        https://restful-booker.herokuapp.com/booking/10 url'ine bir GET
    //        request gonderdigimizde donen Response'un,
    //        status code'unun 200,
    //        ve content type'inin application/json; charset=utf-8,
    //        ve Server isimli Header'in degerinin Cowboy,
    //        ve status Line'in HTTP/1.1 200 OK
    //        ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.

    @Test
    public void test() throws InterruptedException {
        String url ="https://restful-booker.herokuapp.com/booking/10";

        Response response=given().accept("application/json").when().get(url);

        response.prettyPrint();

        response.then().statusCode(200);

        Assert.assertEquals("application/json; charset=utf-8",response.getContentType());

        System.out.println(response.getHeader(url));

        System.out.println("==============================");

        Assert.assertEquals("Cowboy",response.getHeader("url"));

        response.then().statusLine("HTTP/1.1 200 OK");

        response.then().wait(5000);

    }
}
