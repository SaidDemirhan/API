package com.techproed.day06;

import com.techproed.testBase.HerokuAppTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest07 extends HerokuAppTestBase {
    //https://restful-booker.herokuapp.com/booking/ url’ine bir request yolladigimda
    //        HTTP Status Code’unun 200
    //        ve response content type’inin “application/JSON” oldugunu
    //            ve response body’sinin asagidaki gibi oldugunu test edin
    //               {
    //    "firstname": "Sally",
    //    "lastname": "Wilson",
    //    "totalprice": 753,
    //    "depositpaid": true,
    //    "bookingdates": {
    //        "checkin": "2020-10-31",
    //        "checkout": "2021-06-26"
    //    },
    //    "additionalneeds": "Breakfast"
    //}
    //

    @Test
    public void test(){
        spec02.pathParams("parametre1","booking",
                "parametre2",2);

        Response response=given()
                .accept("application/json")
                .spec(spec02)
                .when()
                .get("/{parametre1}/{parametre2}");

        //Assert.assertEquals(200,response.getStatusCode());
        //veya
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        JsonPath jsonPath=response.jsonPath();

        Assert.assertEquals("Sally",jsonPath.getString("firstname"));
        Assert.assertEquals("Wilson",jsonPath.getString("lastname"));
        Assert.assertEquals(753,jsonPath.getInt("totalprice"));
        Assert.assertEquals(true,jsonPath.getBoolean("depositpaid"));
        Assert.assertEquals("2020-10-31",jsonPath.getString("bookingdates.checkin"));
        Assert.assertEquals("2021-06-26",jsonPath.getString("bookingdates.checkout."));


    }

}
