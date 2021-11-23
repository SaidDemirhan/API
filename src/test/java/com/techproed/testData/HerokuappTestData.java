package com.techproed.testData;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.HashMap;

public class HerokuappTestData {
    /*
    {
    "firstname": "Susan",
    "lastname": "Ericsson",
    "totalprice": 521,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2015-03-05",
        "checkout": "2019-08-18"
    }
}
     */
    public HashMap<String, Object> setupTestData(){
        HashMap<String,Object> bookingdates=new HashMap<String,Object>();
        bookingdates.put("checkin","2015-03-05");
        bookingdates.put("checkout","2019-08-18");

        HashMap<String,Object> expectedData=new HashMap<String,Object>();
        expectedData.put("firstname", "Susan");
        expectedData.put("lastname", "Ericsson");
        expectedData.put("totalprice", 521);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingdates);

        return expectedData;
    }

    public JSONObject setUpTestAndRequestData(){

        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin","2021-01-05");
        bookingdates.put("checkout","2021-01-10");

        JSONObject expectedRequest =new JSONObject();
        expectedRequest.put("firstname","Batch30");
        expectedRequest.put("lastname","bitti");
        expectedRequest.put("totalprice",123);
        expectedRequest.put("depositpaid",false);
        expectedRequest.put("bookingdates",bookingdates);
        return expectedRequest;






    }
}
