package com.techproed.day5;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest03 {

     /*
    https://restful-booker.herokuapp.com/booking/7 url'ine
accept type'i "application/json" olan GET request'i yolladigimda
gelen response'un
status kodunun 200
"firstname": "Mary",
    "lastname": "Jones",
    "totalprice": 803,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2021-06-25",
        "checkout": "2021-07-08"

ve content type'inin "application/json"
ve firstname'in "Mary"
ve lastname'in "Jones"
ve checkin date'in 2018-10-07"
ve checkout date'in 2020-09-30 oldugunu test edin
     */

    @Test
    public void test01(){
        String url= "https://restful-booker.herokuapp.com/booking/7";

        Response response=given().
                accept("application/json").
                when().
                get(url);

        response.prettyPrint();



        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.equalTo("Susan")).
                body("lastname",Matchers.equalTo("Jackson")).
                body("totalprice",Matchers.equalTo(811)).
                body("depositpaid",Matchers.equalTo(true)).
                body("bookingdates.checkin",Matchers.equalTo("2021-08-11")).
                body("bookingdates.checkout",Matchers.equalTo("2021-10-18"));


    }
}
