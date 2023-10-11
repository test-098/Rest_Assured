package com.api_testing.Utils;

import org.json.JSONObject;

public class JSON_Values {
    JSONObject jsonObj;

    public Integer getIntValue(String response,String key){
        jsonObj= new JSONObject(response);
       return jsonObj.getInt(key);
    }

    public String getStringValue(String response,String key){
        jsonObj= new JSONObject(response);
        return jsonObj.getString(key);
    }

}
