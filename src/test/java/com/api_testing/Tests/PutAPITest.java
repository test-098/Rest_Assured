package com.api_testing.Tests;

import com.api_testing.BaseFile.BaseTest;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class PutAPITest extends BaseTest {

    @Test(testName ="PUT User Update", description="PUT API call to update all user details using Map")
    @Parameters("userID")
    public void putAPIMap(@Optional Integer userID, ITestContext context){
        ISuite suite=context.getSuite();
        if(userID == null)
            userID= (Integer) suite.getAttribute("id");
        requestSpecification.body(updateRequest.mapRequestBody(userID));
       response= requestSpecification
                .put("/users/"+userID)
                .then()
                .assertThat().statusCode(200)
                .body("id",greaterThanOrEqualTo(userID))
               .extract().response();
    }

    @Test(testName ="PUT User Update", description="PUT API call to update all user details using JSON")
    @Parameters("userID")
    public void putAPIJSON(@Optional Integer userID, ITestContext context){
        ISuite suite=context.getSuite();
        if(userID == null)
            userID= (Integer) suite.getAttribute("id");
        requestSpecification.body(updateRequest.jsonRequestBody(userID).toString());
        response=requestSpecification
                .put("/users/"+userID)
                .then()
                .assertThat().statusCode(200)
                .body("id",equalTo(userID))
                .extract().response();
    }


    @Test(testName ="PUT User Update", description="PUT API call to update all user details using String")
    @Parameters("userID")
    public void putAPIString(@Optional Integer userID, ITestContext context){
        ISuite suite=context.getSuite();
        if(userID == null)
            userID= (Integer) suite.getAttribute("id");
        requestSpecification.body(updateRequest.stringRequestBody(userID));
        response=requestSpecification
                .put("/users/"+userID)
                .then()
                .assertThat().statusCode(200)
                .body("id",equalTo(userID))
                .extract().response();
    }
}
