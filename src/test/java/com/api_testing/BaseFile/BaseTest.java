package com.api_testing.BaseFile;

import com.api_testing.RequestPayloads.createUserRequest;
import com.api_testing.RequestPayloads.updateUserRequest;
import com.api_testing.Utils.ConfigProperties;
import com.api_testing.Utils.JSON_Values;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.annotations.*;
import resources.ExtentReportManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class BaseTest {
    protected ConfigProperties prop=new ConfigProperties();
   protected RequestSpecBuilder builder;
   protected RequestSpecification requestSpecification;
   protected Response response;
    protected createUserRequest requestData=new createUserRequest();
    protected updateUserRequest updateRequest=new updateUserRequest();
    protected JSON_Values jsonValues=new JSON_Values();
    PrintStream log;File file;


    @BeforeMethod
        public void requestSetUp(Method method) throws FileNotFoundException {
            builder=new RequestSpecBuilder();
            builder.setBaseUri(prop.getPropValue("baseURI"));
            builder.setContentType(ContentType.JSON);
            builder.addHeader("Authorization","Bearer "+prop.getPropValue("AuthToken"));
            if(prop.getPropBoolean("TextFile")){
                file=new File(System.getProperty("user.dir")+"\\target\\RequestFiles");
                if(!file.exists())
                    file.mkdir();
                log=new PrintStream(new FileOutputStream(file.getPath()+"\\"+method.getName()+".txt"));
                builder.addFilter(RequestLoggingFilter.logRequestTo(log));
                builder.addFilter(ResponseLoggingFilter.logResponseTo(log));
            }
        requestSpecification=RestAssured.given().spec(builder.build());
    }

    @AfterMethod
    public void testReportLog(){
        QueryableRequestSpecification queryableRequestSpec= SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is " + queryableRequestSpec.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is " + queryableRequestSpec.getMethod());
        ExtentReportManager.logInfoDetails("Headers are ");
        ExtentReportManager.logHeaders(queryableRequestSpec.getHeaders().asList());
       if (!(queryableRequestSpec.getMethod().equalsIgnoreCase("GET") || queryableRequestSpec.getMethod().equalsIgnoreCase("DELETE"))){
           ExtentReportManager.logInfoDetails("Request body : ");
           ExtentReportManager.logJson(queryableRequestSpec.getBody());
       }

        ExtentReportManager.logInfoDetails("Status Code : "+response.statusCode());
        if (!queryableRequestSpec.getMethod().equalsIgnoreCase("DELETE")) {
            ExtentReportManager.logInfoDetails("Response : ");
            ExtentReportManager.logJson(response.getBody().prettyPrint());
        }
    }
}
