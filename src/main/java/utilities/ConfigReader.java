package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static String url;


    public ConfigReader() throws IOException {

        Properties prop = new Properties();
        InputStream input
                = new FileInputStream("src\\main\\resources\\project.properties");

        // load a properties file
        prop.load(input);

        // get the property value and print it out
        this.url = prop.getProperty("url");

    }

    public static String getUrl() {

        return url;
    }

}
