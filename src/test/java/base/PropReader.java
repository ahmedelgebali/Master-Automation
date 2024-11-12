package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropReader {
   private static String filepath = "src/test/resources/properties.properties";

    public static String getProp(String key) throws IOException {
        FileInputStream inputStream = new FileInputStream(filepath);
        Properties properties = new Properties();
        properties.load(inputStream);

       return properties.get(key).toString();

    }



}
