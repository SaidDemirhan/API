package com.techproed.testData;

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
}
