package api;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BetikaUsers extends TestBase{

    final static String url = "https://fakerestapi.azurewebsites.net/api/v1/Users";

    public static void main (String args[]) {

        getResponseBody();
        getResponseStatusCode();
        verifyUser("User 6");
        countApiObjects();
    }
    public static void getResponseBody() {
        RestAssured.baseURI = url;
        given().when().get(RestAssured.baseURI).then().log().all();
    }

    public static void getResponseStatusCode() {
        int statusCode = given().when().get(RestAssured.baseURI).getStatusCode();

        System.out.println("This is the status code " + statusCode);

        Assert.assertEquals(statusCode, 200);
    }

    public static void verifyUser(String username) {
        ArrayList<String> response = given().when().get(RestAssured.baseURI).then().extract().path("userName");
        for (String userExists:response){
            if (userExists.equalsIgnoreCase(username)){
                System.out.println("Username " + username + " exists in response");
            }
        }
    }

    public static void countApiObjects() {
        Response response = given().when().get(RestAssured.baseURI);
        ArrayList<List> jsonList = response.jsonPath().get();

        System.out.println("The number of objects in the response is " + jsonList.size());

    }
}
