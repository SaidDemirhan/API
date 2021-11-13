package com.techproed.day06;

import com.techproed.testBase.DummyTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest08 extends DummyTestBase {
    //http://dummy.restapiexample.com/api/v1/employees url’inde bulunan
    //   1) Butun calisanlarin isimlerini consola yazdıralim
    //   2) 3. calisan kisinin ismini konsola yazdıralim
    //   3) Ilk 5 calisanin adini konsola yazdiralim
    //   4) En son calisanin adini konsola yazdiralim
    @Test
    public void test(){
        spec03.pathParams("parametre1","employees");

        Response response=given()
                .accept("application/json")
                .spec(spec03)
                .when()
                .get("/{parametre1}");

        response.prettyPrint();
        //Hepsini yazdirir.

        JsonPath jsonPath=response.jsonPath();
        System.out.println(jsonPath.getList("data.employee_name"));
        //string olarak da yazdirir.
        //System.out.println(jsonPath.getString("data.employee_name"));




        System.out.println(jsonPath.getString("data[2].employee_name"));

        //veya

        System.out.println(jsonPath.getString("data.employee_name[2]"));
        //2. yi yazdi

        System.out.println(jsonPath.getString("data.employee_name[0,1,2,3,4]"));
        //ilk 5 i yazdi

        System.out.println(jsonPath.getString("data.employee_name[-1]"));
        //sonuncuyu yazdi

        //Assert edersek:

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.employee_name", hasSize(24));
        //24 veri var

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("Ashton Cox",jsonPath.getString("data[2].employee_name"));
        Assert.assertEquals("Doris Wilder",jsonPath.getString("data.employee_name[-1]"));
    }

}
