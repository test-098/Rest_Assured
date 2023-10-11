package com.api_testing.Tests;

import com.api_testing.BaseFile.BaseTest;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.*;
import static org.hamcrest.Matchers.*;

public class GetAPITest extends BaseTest {

    @Test(testName ="GET All Users", description="Get API call to get all user details")
    public void getAPIUsers(){
        requestSpecification
                .get("/users")
                .then()
                       .statusCode(200)
                       .log().ifValidationFails()
                       .extract().response();

    }

    @Parameters("userID")
    @Test(testName ="GET User Details", description="Get API call to get specified user details")
    public void getAPIUser(@Optional Integer userID, ITestContext context){
       ISuite suite=context.getSuite();
       if(userID == null)
           userID= (Integer) suite.getAttribute("id");
      response=requestSpecification
                         .get("/users/"+userID)
                    .then()
                        .statusCode(200).extract().response();
    }

    @Parameters("userID")
    @Test(testName ="GET User Posts Details", description="Get API call to get specified user posts details")
    public void getAPIUserPosts(@Optional Integer userID, ITestContext context){
        ISuite suite=context.getSuite();
        if(userID == null)
            userID= (Integer) suite.getAttribute("id");
        response=requestSpecification
                .get("/users/{userID}/posts",userID)
                .then()
                .statusCode(200).extract().response();
    }

}
