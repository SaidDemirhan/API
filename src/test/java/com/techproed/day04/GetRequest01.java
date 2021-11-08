package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

//https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde donecek cevap(response) icin
//HTTP status kodunun 200
//Content Type'in Json
//Ve Status Line'in HTTP/1.1 200 OK
//Oldugunu test edin

    @Test
            public void test01() {

        //1 api testi yaparken ilk olarak url (endpoint) belirlenmeli

        String url = "https://restful-booker.herokuapp.com/booking/3";

        //2 beklenen sonuc (expected result) olusturulur.


        //Bu case de bizden body dogrulamasi istenmedigi icin simdilik beklenen sonuc olusturmaya gerek yok.

        //3 request gönderiyoruz.

        Response response=given().accept("application/json").when().get(url);

        response.prettyPrint();

        //4 actual result olusturuyoruz. (responce body ile)

        //responcse body ile ilgili islem yapmayacagimiz icin simdi olusturmayacagiz.

        //5 dogrulama yapiyoruz. (assertion)

        System.out.println("Status code: "+response.getStatusCode());
        System.out.println("Content type: "+response.getContentType());
        System.out.println("Status line: "+response.getStatusLine());
        System.out.println("=========================");
        System.out.println("Headers: "+response.getHeaders());
        System.out.println("=========================");

        //birinci yol

        Assert.assertEquals(200,response.getStatusCode());

        Assert.assertEquals("application/json; charset=utf-8",response.getContentType());

        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());

        System.out.println("=========================");

        //2. yol

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).//aceept ("application/json") da yazilabilir.
                statusLine("HTTP/1.1 200 OK");
    }
}
