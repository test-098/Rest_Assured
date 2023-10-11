package com.api_testing.RequestPayloads;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import java.util.*;

public class updateUserRequest {

    List<String> gender= Arrays.asList("Male","Female");
    List<String> status= Arrays.asList("Active","InActive");
    Random randomNum=new Random();
    public HashMap<String,Object> mapRequestBody(int userID){
        HashMap<String,Object> requestBody= new HashMap<>();
        requestBody.put("id",userID);
        requestBody.put("name", RandomStringUtils.randomAlphanumeric(5,10));
        requestBody.put("email", RandomStringUtils.randomAlphabetic(5)+"@wuz.com");
        requestBody.put("gender", gender.get(randomNum.nextInt(0,2)));
        requestBody.put("status", status.get(randomNum.nextInt(0,2)));
        return requestBody;
    }

    public JSONObject jsonRequestBody(int userID){
        JSONObject requestBody=new JSONObject();
        requestBody.put("id",userID);
        requestBody.put("name", RandomStringUtils.randomAlphanumeric(6,10));
        requestBody.put("email", RandomStringUtils.randomAlphabetic(6)+"@wuz.com");
        requestBody.put("gender", gender.get(randomNum.nextInt(0,2)));
        requestBody.put("status", status.get(randomNum.nextInt(0,2)));
        System.out.println(requestBody.toString());
        return requestBody;
    }

    public String stringRequestBody(int userID){
        String requestBody;
        requestBody = "{\"id\":\""+ userID +"\",\n"+
                "\"name\":\""+RandomStringUtils.randomAlphanumeric(6,10)+"\",\n" +
                "        \"email\":\""+RandomStringUtils.randomAlphabetic(6)+"@wuz.com\",\n" +
                "        \"gender\":\""+ gender.get(randomNum.nextInt(0,2))+"\",\n" +
                "        \"status\":\""+status.get(randomNum.nextInt(0,2))+"\"\n" +
                "    }";
        return requestBody;
    }

    public HashMap<String,Object> patchRequestBody(ArrayList<String> userDetails) {
        System.out.println(userDetails.toString());
        HashMap<String, Object> requestBody = new HashMap<>();
        for (String value : userDetails) {
            switch (value) {
                case "name":
                    requestBody.put("name", RandomStringUtils.randomAlphanumeric(5, 10));
                    break;
                case "email":
                    requestBody.put("email", RandomStringUtils.randomAlphanumeric(5, 10) + "@test.de");
                    break;
                case "gender":
                    requestBody.put("gender", gender.get(randomNum.nextInt(0, 2)));
                    break;
                case "status":
                    requestBody.put("status", status.get(randomNum.nextInt(0, 2)));
                    break;
            }

        }
        return requestBody;
    }

}
