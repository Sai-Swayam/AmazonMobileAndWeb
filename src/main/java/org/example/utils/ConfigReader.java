package org.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    /**
     * Util class to read properties from config.properties file
     */

    private static Properties properties;

    static {
        properties = new Properties();

        try {
            InputStream configInputStream = ConfigReader.class.getClassLoader()
                    .getResourceAsStream("config.properties");

            properties.load(configInputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Method to get the specific property
     *
     * @param property : Name of the property to be fetched
     */

    public static String getProperty(String property) {
        return properties.getProperty(property);
    }
}
