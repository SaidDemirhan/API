package com.techproed.day04;

import io.restassured.response.Response;
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

        //4 actual result olusturuyoruz. (responce body ile)


        //5 dogrulama yapiyoruz. (assertion)

        response.prettyPrint();
    }
}
