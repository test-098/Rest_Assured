package com.api_testing.Tests;

import com.api_testing.BaseFile.BaseTest;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class PostAPITest extends BaseTest {

    //Post API call with request body as hashmap
    @Test(testName ="POST User Detail", description="POST API call to create new user with Map")
    public void postAPIMap(ITestContext context){
        requestSpecification.body(requestData.mapRequestBody());
        response=requestSpecification
                        .post("/users")
                    .then()
                        .assertThat().statusCode(201)
                .extract().response();
        ISuite suite=context.getSuite();
        suite.setAttribute("id",jsonValues.getIntValue(response.getBody().asPrettyString(),"id"));
        System.out.println(context.getAttribute("id"));
    }

    //Post API call with request body build with JSON Object
    @Test(testName ="POST User Detail", description="POST API call to create new user with JSON")
    public void postAPIJson(ITestContext context){
        requestSpecification.body(requestData.jsonRequestBody().toString());
        response= requestSpecification
                    .post("/users")
                .then()
                    .assertThat().statusCode(201)
                .extract().response();
        ISuite suite=context.getSuite();
        suite.setAttribute("id",jsonValues.getIntValue(response.getBody().asPrettyString(),"id"));
        System.out.println(context.getAttribute("id"));
    }

    //Post API call with request body build with string
    @Test(testName ="POST User Detail", description="POST API call to create new user with String")
    public void postAPIString(ITestContext context){
        requestSpecification.body(requestData.stringRequestBody());
        response=requestSpecification
                    .post("/users")
                .then()
                    .log().all()
                    .assertThat().statusCode(201).extract().response();
        ISuite suite=context.getSuite();
        suite.setAttribute("id",jsonValues.getIntValue(response.getBody().asPrettyString(),"id"));
        System.out.println(context.getAttribute("id"));

    }

}
