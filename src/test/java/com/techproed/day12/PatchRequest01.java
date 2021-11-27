package com.techproed.day12;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PatchRequest01 extends JsonPlaceHolderTestBase {
    /*
     https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönderdiğimde
   {

      "title": "API calismaliyim"

     }
Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
{
 "userId": 10,
 "title": "API calismaliyim"
 "completed": true,
 "id": 198
}
     */

    @Test
    public void test(){

        //url olusturalim.

        spec01.pathParams("parametre1","todos",
                "parametre2",198);

        //expected ve request data olustur

        JsonPlaceHolderTestData testdata=new JsonPlaceHolderTestData();
        JSONObject requestData=testdata.setUpPatchRequestData();
        System.out.println(requestData);

        JSONObject expectedData=testdata.setUpPatchExpectedData();
        System.out.println(expectedData);

        Response response=given().
                contentType(ContentType.JSON).
                spec(spec01).
                auth().basic("admin","password123").
                body(requestData.toString()).
                when().
                patch("/{parametre1}/{parametre2}");

        //1. cözüm JsonPath yöntemi

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(expectedData.getInt("userId"),jsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.getString("title"),jsonPath.getString("title"));
        Assert.assertEquals(expectedData.getBoolean("completed"),jsonPath.getBoolean("completed"));
        Assert.assertEquals(expectedData.getInt("id"),jsonPath.getInt("id"));


        //2. cözüm Deserialization

        HashMap<String,Object> actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(expectedData.getInt("userId"),actualDataMap.get("userId"));
        Assert.assertEquals(expectedData.get("id"),actualDataMap.get("id"));
        Assert.assertEquals(expectedData.getBoolean("completed"),actualDataMap.get("completed"));
        Assert.assertEquals(expectedData.getString("title"),actualDataMap.get("title"));

    }


}
