package com.aprende.web.lib;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesVault {
    static private InputStream inputStreamProp;
    static private Properties prop;

    public static String getProp(String key)   {

        try {
            prop = new  Properties();
            inputStreamProp =   new FileInputStream("src/test/java/resources/cucumber.properties");
            prop.load(inputStreamProp);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                inputStreamProp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop.getProperty(key);

    }
}
