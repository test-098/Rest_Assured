package com.api_testing.Tests;

import com.api_testing.BaseFile.BaseTest;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.*;

public class PatchAPITest extends BaseTest {

    @DataProvider(name="patchAPIData")
    public Object[][] patchAPIData(ITestContext context){
        ISuite suite=context.getSuite();
        return new Object[][]
                {
                        { suite.getAttribute("id"), new ArrayList<String>(Arrays.asList("email", "gender"))}
                };
    }


    @Test(testName ="PATCH User Update", description="PATCH API call to update user details", dataProvider ="patchAPIData")
    public void patchAPI(Integer userID, ArrayList<String> userDetails){
        requestSpecification.body(updateRequest.patchRequestBody(userDetails));
       response= requestSpecification
                .patch("/users/"+userID)
                .then()
                .assertThat().statusCode(200)
               .extract().response();
    }


    @Test(testName ="PATCH User Update", description="PATCH API call to update user details")
    @Parameters({"userID","detailsUpdate"})
    public void patchAPIParam(@Optional Integer userID, String values, ITestContext context){
        ISuite suite=context.getSuite();
        if(userID==null)
            userID= (Integer) suite.getAttribute("id");
        ArrayList<String> updateValues=new ArrayList<>(Arrays.asList(values.split(";")));
        requestSpecification.body(updateRequest.patchRequestBody(updateValues));
        response= requestSpecification
                .patch("/users/"+userID)
                .then()
                .assertThat().statusCode(200)
                .extract().response();
    }


}
