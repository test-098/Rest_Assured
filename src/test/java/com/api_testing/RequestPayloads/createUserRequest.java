package com.api_testing.RequestPayloads;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import java.util.*;

public class createUserRequest {
    List<String> gender= Arrays.asList("Male","Female");
    List<String> status= Arrays.asList("Active","InActive");
    Random randomNum=new Random();
    public HashMap<String,Object> mapRequestBody(){
        HashMap<String,Object> requestBody= new HashMap<>();
        requestBody.put("name", RandomStringUtils.randomAlphanumeric(5,10));
        requestBody.put("email", RandomStringUtils.randomAlphabetic(5)+"@wuz.com");
        requestBody.put("gender", gender.get(randomNum.nextInt(0,2)));
        requestBody.put("status", status.get(randomNum.nextInt(0,2)));
        return requestBody;
    }

    public JSONObject jsonRequestBody(){
        JSONObject requestBody=new JSONObject();
        requestBody.put("name", RandomStringUtils.randomAlphanumeric(5,10));
        requestBody.put("email", RandomStringUtils.randomAlphabetic(5)+"@wuz.com");
        requestBody.put("gender", gender.get(randomNum.nextInt(0,2)));
        requestBody.put("status", status.get(randomNum.nextInt(0,2)));
        return requestBody;
    }

    public String stringRequestBody(){
        String requestBody;
        requestBody = "{\"name\":\""+RandomStringUtils.randomAlphanumeric(5,10)+"\",\n" +
                "        \"email\":\""+RandomStringUtils.randomAlphabetic(5)+"@wuz.com\",\n" +
                "        \"gender\":\""+ gender.get(randomNum.nextInt(0,2))+"\",\n" +
                "        \"status\":\""+status.get(randomNum.nextInt(0,2))+"\"\n" +
                "    }";
        return requestBody;
    }

}
