package com.api_testing.Tests;

import com.api_testing.BaseFile.BaseTest;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DeleteAPITest extends BaseTest {

    @Parameters("userID")
    @Test(testName ="Delete User", description="Delete API call to get delete user details")
    public void deleteAPIUser(@Optional Integer userID, ITestContext context){
        ISuite suite=context.getSuite();
        if(userID == null)
            userID= (Integer) suite.getAttribute("id");
        response=requestSpecification
                .delete("/users/"+userID)
                .then()
                .statusCode(204).extract().response();
    }

}
