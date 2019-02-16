package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static api.ApiEndpoints.AP_CAR_MODELS;
import static io.restassured.RestAssured.baseURI;

public class GetCitiesTest extends BaseApiTest {

    @Test(description = "Hitting AP Cities API, check if status code is 200")
    public void get_AP_cities_and_checking_if_status_code_200() {
        restApiExecutor
                .getCitiesDocsResponse().statusCode(200);

//        given().when().get(AP_CITIES)
//                .then().statusCode(200);
    }

    @Test(description = "GET available cities")
    public void get_city_name_from_the_arrayByIndex() {
        restApiExecutor.getCitiesDocsResponse().statusCode(200);


//        RestAssured.baseURI = AP_CITIES;
//        RequestSpecification httpRequest = RestAssured.given();
//        Response response = httpRequest.get(baseURI);
//        JsonPath jsonPathEvaluator = response.jsonPath();
//        String city = jsonPathEvaluator.get("response.docs[3].city");
//        System.out.println("City received from Response " + city);
//        Assert.assertEquals(city, "Agra", "Correct city name received in the Response");
    }

    @Test(description = "Test")
    public void executeGetRequestTest() {
        RestAssured.baseURI = AP_CAR_MODELS;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(baseURI);

        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");

////        Headers allHeaders = response.headers();
////        for(Header header : allHeaders)
////        {
////            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
////        }
//
        String contentType = response.getHeader("Content-Type");
        Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);

        String serverType = response.getHeader("Server");
        Assert.assertEquals(serverType /* actual value */, "nginx" /* expected value */);

        String contentEncoding = response.getHeader("Content-Encoding");
        Assert.assertEquals(contentEncoding /* actual value */, "gzip" /* expected value */);

        ResponseBody body = response.getBody();
        System.out.println("This is a body output " + body.asString() + " here is the end");
    }

//    @Test(description = "Post data")
//    public void postDataTest() {
//        RestAssured.baseURI = "http://www.carwale.com/v1/api/pq/";
//        RequestSpecification request = RestAssured.given();
//        JSONObject requestParams = new JSONObject();
//        requestParams.put("CarModelId", "1078");
//        requestParams.put("CarVersionId", "5626");
//
//        requestParams.put("CityId", "10");
//        requestParams.put("SourceId", "1");
//        requestParams.put("IsSponsoredCarShowed", "false");
//
//        request.header("Content-Type", "application/x-www-form-urlencoded");
//        request.body(requestParams.toJSONString());
//        Response response = request.post(baseURI);
//
//        int statusCode = response.get_AP_cities_and_status_code_200();
//        Assert.assertEquals(statusCode, 200);
//
//    }
}


