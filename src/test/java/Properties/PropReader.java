package Properties;

import java.io.*;
import java.util.Properties;

public class PropReader {
    public static void main(String[] args) throws IOException {


//         get the location of properties file
        FileInputStream file = new FileInputStream( "src/test/resources/config/prop.properties");
//        loading the prop file
        Properties properties = new Properties();
        properties.load(file);

//        reading data from prop
        String url = properties.getProperty("baseUrl");
        System.out.println(url);


    }


    /*
    public static String propFilePath = "src/test/resources/config/prop.properties";
    public static String getProp(String key) throws IOException {
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir" + propFilePath));
            Properties properties = new Properties();
            properties.load(file);
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

     */







   private static String filepath = "src/test/resources/config/prop.properties";

//    public static String getProp(String key) {
//        try (InputStream inputStream = PropReader.class.getClassLoader().getResourceAsStream(filepath)) {
//            Properties pro = new Properties();
//            pro.load(inputStream);
//            return pro.getProperty(key);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
public static String getProp(String key) throws IOException {
    FileInputStream file = new FileInputStream( "src/test/resources/config/prop.properties");
    Properties properties = new Properties();
    properties.load(file);
    return properties.getProperty(key);

}




}
