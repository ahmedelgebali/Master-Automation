package Properties;

import java.io.*;
import java.util.Properties;

public class PropReader {
    public static void main(String[] args) throws IOException {


        //check properity
        FileInputStream file = new FileInputStream( "src/test/resources/config/prop.properties");
        Properties properties = new Properties();
        properties.load(file);
        String url = properties.getProperty("baseUrl");
        System.out.println(url);


    }


    public static String getProp(String key) throws IOException {
        String filepath = "src/test/resources/config/prop.properties";
        FileInputStream file = new FileInputStream(filepath);
        Properties properties = new Properties();
        properties.load(file);
        return properties.getProperty(key);
    }




}
