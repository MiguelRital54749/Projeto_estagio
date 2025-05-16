package com.web.automation.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String readProjectConfiguration(String keyName) throws IOException {
        String value=null;
        try {
            FileReader file= new FileReader(new File("ConfigFiles/ProjectConfiguration.properties"));
            Properties readprop= new Properties();
            readprop.load(file);
            return readprop.getProperty(keyName).trim();
        } catch (Exception e) {
            e.printStackTrace();
            throw(new RuntimeException("****ERROR****: - Key with name"+ keyName +"does not exist"));
        }
    }

    public static String readElementConfiguration(String keyName) throws IOException {
        String value=null;
        try {
            FileReader file= new FileReader(new File("ElementLocators/Locators.properties"));
            Properties readprop= new Properties();
            readprop.load(file);
            return readprop.getProperty(keyName).trim();
        } catch(Exception e){
            e.printStackTrace();
            throw(new RuntimeException("****ERROR****: - Key with name"+ keyName +"does not exist"));
        }
    }
}
