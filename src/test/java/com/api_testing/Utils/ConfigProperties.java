package com.api_testing.Utils;

import resources.ExtentReportManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    Properties prop;
    FileInputStream in ;
    public ConfigProperties() {
       try {
           in = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
           prop = new Properties();
           prop.load(in);
       }catch (IOException e){
           ExtentReportManager.logFailureDetails(e.getMessage());
       }
    }

    public String getPropValue(String property){
        return prop.getProperty(property);
    }

    public boolean getPropBoolean(String property){
        return Boolean.parseBoolean(prop.getProperty(property));
    }
}
